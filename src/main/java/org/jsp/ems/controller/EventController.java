package org.jsp.ems.controller;

import org.jsp.ems.entity.Event;
import org.jsp.ems.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
//@RequestMapping(value= {"/events","/e","/eve"})
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService service;
	
	@Operation(summary="To create the Event",description="This API will accept the RequestBody of Event entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode="200",description="Entity Saved successfully"),@ApiResponse(responseCode="400",description="Unable to save Enity..")})
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody Event event){
		return service.saveEvent(event);
	}
	
	@Operation(summary="To Fetch All the Events",description="This API will fetch all the Event available in the database table..")
	@ApiResponses({@ApiResponse(responseCode="200",description="All Events Found successfully"),@ApiResponse(responseCode="400",description="No Event Found")})
	@GetMapping
	public ResponseEntity<?> findAllEvents(){
		return service.findAllEvents();
	}
	
	@Operation(summary="To change the status into OnGoing",description="This API will change the EventStatus into ON_GOING")
	@ApiResponses({@ApiResponse(responseCode="200",description="Changed EventStatus Successfully"),@ApiResponse(responseCode="400",description="Unable to Change The EventStatus")})
	@PatchMapping("/ongoing/{id}")
	public ResponseEntity<?> findAllOnGoingEvent(@PathVariable int id){
		return service.setStatusOnGoingEvent(id);
	}
	
	@Operation(summary="To change the status into Completed",description="This API will change the EventStatus into COMPLETED")
	@ApiResponses({@ApiResponse(responseCode="200",description="Changed EventStatus Successfully"),@ApiResponse(responseCode="400",description="Unable to Change The EventStatus")})
	@PatchMapping("/completed/{id}")
	public ResponseEntity<?> findAllCompletedEvent(@PathVariable int id){
		return service.setStatusCompletedEvent(id);
	}
	
	@Operation(summary="To Fetch All the ON_GOING Events",description="This API will fetch all ON_GOING the Event available in the database table..")
	@ApiResponses({@ApiResponse(responseCode="200",description="All ON_GOING Events Found successfully"),@ApiResponse(responseCode="400",description="No ON_GOING Event Found")})
	@GetMapping("/ongoing")
	public ResponseEntity<?> findAllOnGoingEvent(){
		return service.findAllOnGoingEvent();
	}
	
	@Operation(summary="To Fetch All the UP_COMING Events",description="This API will fetch all UP_COMING the Event available in the database table..")
	@ApiResponses({@ApiResponse(responseCode="200",description="All UP_COMING Events Found successfully"),@ApiResponse(responseCode="400",description="No UP_COMING Event Found")})
	@GetMapping("/upcoming")
	public ResponseEntity<?> findAllUpComingEvent(){
		return service.findAllUpComingEvent();
	}
	
	@Operation(summary="To Fetch All the COMPLETED Events",description="This API will fetch all COMPLETED the Event available in the database table..")
	@ApiResponses({@ApiResponse(responseCode="200",description="All COMPLETED Events Found successfully"),@ApiResponse(responseCode="400",description="No COMPLETED Event Found")})
	@GetMapping("/completed")
	public ResponseEntity<?> findAllCompletedEvent(){
		return service.findAllCompletedEvent();
	}
}
