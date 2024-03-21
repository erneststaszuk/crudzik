package com.vujade.crudzik.adapter.db

import com.vujade.crudzik.event.Event
import com.vujade.crudzik.notdomain.Campaign
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.webmvc.RepositoryRestController
import java.util.UUID

@RepositoryRestController
interface EventRepository: CrudRepository<Event, UUID>, PagingAndSortingRepository<Event, UUID>
