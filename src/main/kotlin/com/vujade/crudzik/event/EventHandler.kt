package com.vujade.crudzik.event

import com.vujade.crudzik.adapter.db.EventRepository
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.interceptor.TransactionAspectSupport

@Component
class EventHandler(
  private val repository: EventRepository
) {
  @EventListener
  fun saveEvent(event: Event) {
    log.info("Saving event in transaction ${TransactionAspectSupport.currentTransactionStatus().hashCode()}")
    repository.save(event)
  }

  companion object {
    val log = LoggerFactory.getLogger(EventHandler::class.java)
  }
}