package com.Calendar.calendarassistant.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.Calendar.calendarassistant.service.CalenderAssistantService;

@Path("/appointment")
public class CalenderAssistantResource {
	
	@Autowired
	CalenderAssistantService calendarAssistantService;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/test")
	public Object getTest(@RequestBody Map<String,String> data) {
	    
		return data;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAvailableSlots")
	public Object getSlotData(@RequestBody Map<String,String> data) {
		ArrayList<String> empList = new ArrayList<String>(
				Arrays.asList(data.get("empid1"), data.get("empid2")));

		return calendarAssistantService.getAvailableSlots(empList);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/setMeeting")
	public Object setSlotData(@RequestBody Map<String,Object> data) {

		return calendarAssistantService.setMeetingForEmployee(data);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getConflits")
	public Object getSlotData(@RequestBody String meetingTime) {

		return calendarAssistantService.getAllMeetingConflicts(meetingTime);

	}
}
