package com.Calendar.calendarassistant.dao.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;

@Data
@Entity
@Table(name = "appointments")
@TypeDef(name = "hstore", typeClass = PostgreSQLHStoreType.class)
public class AvailableAppointment {
	
	@Id
	String empId;
	
	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	/**
	 * @return the availableSlots
	 */
	public Map<String, String> getAvailableSlots() {
		return availableSlots;
	}

	/**
	 * @param availableSlots the availableSlots to set
	 */
	public void setAvailableSlots(Map<String, String> availableSlots) {
		this.availableSlots = availableSlots;
	}

	@Type(type = "hstore")
    @Column(columnDefinition = "hstore")
	Map<String , String> availableSlots;
	

}
