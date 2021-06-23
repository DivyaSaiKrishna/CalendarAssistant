package com.Calendar.calendarassistant.service;

import java.util.*;

import com.Calendar.calendarassistant.dao.model.ConflictsOutputModel;
import com.Calendar.calendarassistant.Exceptions.AppointmentException;
import com.Calendar.calendarassistant.dao.model.ScheduleMeetingModel;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Calendar.calendarassistant.dao.CalendarAssistantDao;
import com.Calendar.calendarassistant.dao.model.AvailableAppointment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class CalenderAssistantService {
	private static final String getNotAvaibleEmpIds = "select emp_id from  appointments where available_slots->";
	private static final String endGetNotAvaibleEmpIds = "='Not Available';";

	@Autowired
	CalendarAssistantDao calendarAssist;

	@PersistenceContext
	private EntityManager em;
	
	public Object getAvailableSlots(List<String> empList){
		List<String> slotsAvailable = new ArrayList();
		List<AvailableAppointment> slotData = (List<AvailableAppointment>) calendarAssist.findAllById(empList);
		
		AvailableAppointment empSlot1 = slotData.get(0); 
		AvailableAppointment empSlot2 = slotData.get(1); 
		
		Map<String,String> empSlotMap1 = empSlot1.getAvailableSlots();
		Map<String,String> empSlotMap2 = empSlot2.getAvailableSlots();
		
		Collection<String> empSlotKeys1 = empSlotMap1.keySet();
		try {
			for (String str : empSlotKeys1) {
				if (empSlotMap2.containsKey(str) &&
						empSlotMap2.get(str).equals("Available")) {
					slotsAvailable.add(str);
				}
			}
			return slotsAvailable;
		}catch (Exception e){
			throw new AppointmentException(e.toString());
		}
	}

	public Object getAllMeetingConflicts(String meetingTime){
		List<String> conflistsList = new ArrayList();
		try{
			if(meetingTime!=null) {
					Query q = (Query) em.createNativeQuery(getNotAvaibleEmpIds+meetingTime+endGetNotAvaibleEmpIds);
				 	conflistsList = q.getResultList();
			}
			if(!conflistsList.isEmpty()){
				ConflictsOutputModel conflictsOutputModel = new ConflictsOutputModel();
				conflictsOutputModel.setUsersIds(conflistsList);
				return conflictsOutputModel;
			}
			return "No Conflits";
		}catch (Exception e){
				throw new AppointmentException(e.toString());
		}
	}

	public Object setMeetingForEmployee(Map<String, Object> data){
		AvailableAppointment setSlot = new AvailableAppointment();
		ScheduleMeetingModel scheduleMeetingModel = new ScheduleMeetingModel();
		List<AvailableAppointment> slotData = new ArrayList<>();
		List<String> empList = new ArrayList<>();
		try{
			if(!data.isEmpty()){
				setSlot.setEmpId((String) data.get("EmpId"));
				setSlot.setAvailableSlots((Map<String, String>)data.get("Slots"));
				calendarAssist.save(setSlot);
				empList.add((String) data.get("EmpId"));
				slotData = (List<AvailableAppointment>) calendarAssist.findAllById(empList);
				scheduleMeetingModel.setMeetingSlots(slotData);
			}
			return scheduleMeetingModel;
		}catch (Exception e) {
			throw new AppointmentException(e.toString());
		}
	}

	
	

}
