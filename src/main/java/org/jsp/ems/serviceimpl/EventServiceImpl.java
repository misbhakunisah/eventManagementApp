package org.jsp.ems.serviceimpl;

import java.time.LocalDateTime;

import org.jsp.ems.dao.EventDao;
import org.jsp.ems.entity.Event;
import org.jsp.ems.exception.InvalidEventIdException;
import org.jsp.ems.exception.NoCompletedEventFoundException;
import org.jsp.ems.exception.NoEventFoundException;
import org.jsp.ems.exception.NoOnGoingEventFoundException;
import org.jsp.ems.exception.NoUpComingEventFoundException;
import org.jsp.ems.responsestructure.ResponseStructure;
import org.jsp.ems.service.EventService;
import org.jsp.ems.util.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDao dao;

	@Override
	public ResponseEntity<?> saveEvent(Event event) {
		event.setStatus(EventStatus.UP_COMING);
		Event dbEvent = dao.saveEvent(event);
		int yyyy = Integer.parseInt(event.getFromDateTime().toString().substring(0, 4));
		int mm = Integer.parseInt(event.getFromDateTime().toString().substring(5, 7));
		int dd = Integer.parseInt(event.getFromDateTime().toString().substring(8, 10));
		int hh = Integer.parseInt(event.getFromDateTime().toString().substring(11, 13));
		int mins = Integer.parseInt(event.getFromDateTime().toString().substring(14));

		event.setFromDateTime(LocalDateTime.of(yyyy, mm, dd, hh, mins));

		int yyyy1 = Integer.parseInt(event.getFromDateTime().toString().substring(0, 4));
		int mm1 = Integer.parseInt(event.getFromDateTime().toString().substring(5, 7));
		int dd1 = Integer.parseInt(event.getFromDateTime().toString().substring(8, 10));
		int hh1 = Integer.parseInt(event.getFromDateTime().toString().substring(11, 13));
		int mins1 = Integer.parseInt(event.getFromDateTime().toString().substring(14));

		event.setToDateTime(LocalDateTime.of(yyyy1, mm1, dd1, hh1, mins1));

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Event Saved Successfully").body(dbEvent).build());
	}

	@Override
	public ResponseEntity<?> findAllEvents() {
		List<Event> ul = dao.findAllEvents();
		if (ul.isEmpty())
			throw NoEventFoundException.builder().message("No Event Present in Databases table").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All Events found Successfully").body(ul).build());

	}

	@Override
	public ResponseEntity<?> findAllOnGoingEvent() {
        List<Event> ul=dao.findAllEvents();
        if (ul.isEmpty())
			throw NoEventFoundException.builder().message("No Event Present in Databases table").build();
        ArrayList<Event> event=new ArrayList<>();
        for(Event e: ul) {
        		if(e.getStatus().toString().equalsIgnoreCase("ON_GOING")) {
            		event.add(e);
            	}
        }
        if(event.isEmpty()) {
        		throw NoOnGoingEventFoundException.builder().message("No OnGoing Event Present in Databases table").build();
        }
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All OnGoing events found successfully").body(event).build());
	}

	@Override
	public ResponseEntity<?> setStatusOnGoingEvent(int id) {
		Optional<Event> optional=dao.findEventById(id);
		if(optional.isEmpty())
			throw InvalidEventIdException.builder().message("Invalid Event Id").build();
		Event event=optional.get();
		event.setStatus(EventStatus.ON_GOING);
		Event dbevent=dao.saveEvent(event); 
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Changed the status to ON_GOING successfully").body(dbevent).build());
	}

	@Override
	public ResponseEntity<?> setStatusCompletedEvent(int id) {
		Optional<Event> optional=dao.findEventById(id);
		if(optional.isEmpty())
			throw InvalidEventIdException.builder().message("Invalid Event Id").build();
		Event event=optional.get();
		event.setStatus(EventStatus.COMPLETED);
		Event dbevent=dao.saveEvent(event); 
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Changed the status to COMPLETED successfully").body(dbevent).build());
	}

	@Override
	public ResponseEntity<?> findAllUpComingEvent() {
		List<Event> events=dao.findEventByEventStatusAsUpComing();
//		 List<Event> ul=dao.findAllEvents();
//	        if (ul.isEmpty())
//				throw NoEventFoundException.builder().message("No Event Present in Databases table").build();
//	        ArrayList<Event> events=new ArrayList<>();
//	        for(Event e: ul) {
//	        		if(e.getStatus().toString().equalsIgnoreCase("UP_COMING")) {
////	        			if(e.getStatus()==EventStatus.UP_COMING)
//	            		event.add(e);
//	            	}
//	        }
//	        if(event.isEmpty()) {
//	        		throw NoUpComingEventFoundException.builder().message("No UP_COMING Event Present in Databases table").build();
//	        }
			return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
					.message("All UP_COMING events found successfully").body(events).build());

	}

	@Override
	public ResponseEntity<?> findAllCompletedEvent() {
		List<Event> ul=dao.findAllEvents();
        if (ul.isEmpty())
			throw NoEventFoundException.builder().message("No Event Present in Databases table").build();
        ArrayList<Event> event=new ArrayList<>();
        for(Event e: ul) {
        		if(e.getStatus().toString().equalsIgnoreCase("COMPLETED")) {
            		event.add(e);
            	}
        }
        if(event.isEmpty()) {
        		throw NoCompletedEventFoundException.builder().message("No COMPLETED Event Present in Databases table").build();
        }
		return  ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("All COMPLETED events found successfully").body(event).build());
	}

}

