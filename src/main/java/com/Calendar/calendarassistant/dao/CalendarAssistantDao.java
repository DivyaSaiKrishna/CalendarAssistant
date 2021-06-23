package com.Calendar.calendarassistant.dao;

import com.Calendar.calendarassistant.dao.model.AvailableAppointment;
import org.springframework.data.repository.CrudRepository;

public interface CalendarAssistantDao extends CrudRepository<AvailableAppointment,String> {

}
