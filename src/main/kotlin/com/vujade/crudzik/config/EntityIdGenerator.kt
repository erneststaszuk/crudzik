package com.vujade.crudzik.config

import com.vujade.crudzik.event.Event
import com.vujade.crudzik.notdomain.Campaign
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class CampaignEntityIdGenerator: BeforeConvertCallback<Campaign> {
  override fun onBeforeConvert(entity: Campaign): Campaign {
    return if (entity.id == null) {
      entity.copy(id = UUID.randomUUID())
    } else {
      entity
    }
  }
}

@Component
class EventEntityIdGenerator: BeforeConvertCallback<Event> {
  override fun onBeforeConvert(entity: Event): Event {
    return if (entity.id == null) {
      entity.copy(id = UUID.randomUUID())
    } else {
      entity
    }
  }
}
