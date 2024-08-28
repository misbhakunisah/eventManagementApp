package org.jsp.ems.repo;

import java.util.List;

import org.jsp.ems.entity.Event;
import org.jsp.ems.util.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer>{

	List<Event> findByStatus(EventStatus upComing);

}
