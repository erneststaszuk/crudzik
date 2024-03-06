package com.vujade.crudzik.config

import com.vujade.crudzik.notdomain.Campaign
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class EntityIdGenerator: BeforeConvertCallback<Campaign> {
  override fun onBeforeConvert(entity: Campaign): Campaign {
    return if (entity.id == null) {
      entity.copy(id = UUID.randomUUID())
    } else {
      entity
    }
  }
}