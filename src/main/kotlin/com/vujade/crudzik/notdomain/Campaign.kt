package com.vujade.crudzik.notdomain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.UUID

@Table("campaign")
data class Campaign(
  @Id val id: UUID?,
  val accountId: UUID,
  val name: String,
  val dateStart: LocalDate,
  val dateEnd: LocalDate,
) {
  init {
    assert(name.isNotBlank()) { "Field `name` cannot be blank" }
    assert(!dateStart.isBefore(LocalDate.now())) { "Field `dateStart` cannot be in the past" }
    assert(dateEnd.isAfter(dateStart)) { "Field `dateEnd` must be after `dateStart`" }
  }
}
