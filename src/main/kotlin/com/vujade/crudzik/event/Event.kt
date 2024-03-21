package com.vujade.crudzik.event

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table
data class Event(
  @Id val id: UUID? = null,
  val type: String,
  val topic: String,
  val event: String
)
