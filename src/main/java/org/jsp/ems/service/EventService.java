package org.jsp.ems.service;

import org.jsp.ems.entity.Event;
import org.springframework.http.ResponseEntity;

public interface EventService {

	ResponseEntity<?> saveEvent(Event event);

	ResponseEntity<?> findAllEvents();

	ResponseEntity<?> findAllOnGoingEvent();

	ResponseEntity<?> setStatusOnGoingEvent(int id);

	ResponseEntity<?> setStatusCompletedEvent(int id);

	ResponseEntity<?> findAllUpComingEvent();

	ResponseEntity<?> findAllCompletedEvent();
   
}
