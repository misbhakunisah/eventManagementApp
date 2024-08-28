package org.jsp.ems.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.ems.dao.EventDao;
import org.jsp.ems.entity.Event;
import org.jsp.ems.repo.EventRepository;
import org.jsp.ems.util.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	private EventRepository repo;
	
	@Override
	public Event saveEvent(Event event) {
		return repo.save(event);
	}

	@Override
	public List<Event> findAllEvents() {
		return repo.findAll();
	}

	@Override
	public Optional<Event> findEventById(int id) {
		return repo.findById(id);
	}

	@Override
	public List<Event> findEventByEventStatusAsUpComing() {
		return repo.findByStatus(EventStatus.UP_COMING);
	}

}
