package com.Calendar.calendarassistant;

import com.Calendar.calendarassistant.dao.CalendarAssistantDao;
import com.Calendar.calendarassistant.dao.model.AvailableAppointment;
import com.Calendar.calendarassistant.service.CalenderAssistantService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
class CalendarAssistantApplicationTests {

	@MockBean
	CalendarAssistantDao calendarAssist;

	@MockBean
	CalenderAssistantService calenderAssistantService;

	Map<String, String> availableSlots = new HashMap<>();

	public void setAvailableSlot() {
		availableSlots.put("7:30-8:00", "Available");
		availableSlots.put("8:00-8:30", "Not Available");
	}

	@Test
	public void getAppointmenttest(){
		List<String> empList = new ArrayList<>();
		List<AvailableAppointment> slotData = new ArrayList<>();
		empList.add("emp1");
		empList.add("emp2");
		AvailableAppointment availableAppointment = new AvailableAppointment();
		AvailableAppointment availableAppointment1 = new AvailableAppointment();
		setAvailableSlot();
		availableAppointment.setAvailableSlots(availableSlots);
		availableAppointment.setEmpId("emp1");
		availableAppointment1.setAvailableSlots(availableSlots);
		availableAppointment1.setEmpId("emp2");
		slotData.add(availableAppointment);
		slotData.add(availableAppointment1);

		when(calendarAssist.findAllById(empList)).thenReturn(slotData);
		calenderAssistantService.getAvailableSlots(empList);
	}



}
