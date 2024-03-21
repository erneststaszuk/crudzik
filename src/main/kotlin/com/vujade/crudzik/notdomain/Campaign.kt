package com.vujade.crudzik.notdomain

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.vujade.crudzik.event.Event
import com.vujade.crudzik.event.EventHandler
import org.slf4j.LoggerFactory
import org.springframework.data.annotation.Id
import org.springframework.data.domain.AfterDomainEventPublication
import org.springframework.data.domain.DomainEvents
import org.springframework.data.relational.core.mapping.Table
import org.springframework.transaction.interceptor.TransactionAspectSupport
import java.time.LocalDate
import java.util.UUID


@Table("campaign")
data class Campaign(
  @Id val id: UUID?,
  val accountId: UUID,
  val name: String,
  val dateStart: LocalDate,
  val dateEnd: LocalDate
) {
  init {
    assert(name.isNotBlank()) { "Field `name` cannot be blank" }
    assert(!dateStart.isBefore(LocalDate.now())) { "Field `dateStart` cannot be in the past" }
    assert(dateEnd.isAfter(dateStart)) { "Field `dateEnd` must be after `dateStart`" }
  }

  @DomainEvents
  fun domainEvents(): Collection<Event> {
    val campaigChangedEvent =
      Event(
        type = "CampaignChanged",
        topic = "campaign-changed",
        event = """
          {
            "id": "$id",
            "accountId": "$accountId",
            "name": "$name",
            "dateStart": "$dateStart",
            "dateEnd": "$dateEnd"
          }
        """.trimIndent()
      )

    log.info("Publishing event in transaction ${TransactionAspectSupport.currentTransactionStatus().hashCode()}")

    return listOf(campaigChangedEvent)
  }

  companion object {
    val log = LoggerFactory.getLogger(Campaign::class.java)
  }
}
