package com.vujade.crudzik.notdomain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
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
  @Version val version: Long,
)
