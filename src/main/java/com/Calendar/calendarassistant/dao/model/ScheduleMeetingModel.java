package com.Calendar.calendarassistant.dao.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleMeetingModel {
    private List<AvailableAppointment> meetingSlots = new ArrayList<>();
}
