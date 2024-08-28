package org.jsp.ems.dao;

import org.jsp.ems.entity.Event;
import java.util.List;
import java.util.Optional;

public interface EventDao {

	Event saveEvent(Event event);

	List<Event> findAllEvents();

	Optional<Event> findEventById(int id);

	List<Event> findEventByEventStatusAsUpComing();

}
