package com.skillstorm.flight.beans;

import java.util.Objects;

public class Flight {

	private int id;
	private String airline;
	private int flightNumber;
	private String departureCity;
	private String departureDate;
	private String departureGate;
	private String arrivalCity;
	private String arrivalDate;
	private String arrivalGate;
	
	
	public Flight() {
		super();
	}
	
	public Flight(int id, String airline, int flightNumber, String departureCity, String departureDate,
			String departureGate, String arrivalCity, String arrivalDate, String arrivalGate) {
		super();
		this.id = id;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.departureGate = departureGate;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
		this.arrivalGate = arrivalGate;
	}
	
	// remember to test if we can work it without this
	public Flight(String airline, int flightNumber, String departureCity, String departureDate, String departureGate,
			String arrivalCity, String arrivalDate, String arrivalGate) {
		super();
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.departureCity = departureCity;
		this.departureDate = departureDate;
		this.departureGate = departureGate;
		this.arrivalCity = arrivalCity;
		this.arrivalDate = arrivalDate;
		this.arrivalGate = arrivalGate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureGate() {
		return departureGate;
	}
	public void setDepartureGate(String departureGate) {
		this.departureGate = departureGate;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalGate() {
		return arrivalGate;
	}
	public void setArrivalGate(String arrivalGate) {
		this.arrivalGate = arrivalGate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(airline, arrivalCity, arrivalDate, arrivalGate, departureCity, departureDate, departureGate,
				flightNumber, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(airline, other.airline) && Objects.equals(arrivalCity, other.arrivalCity)
				&& Objects.equals(arrivalDate, other.arrivalDate) && Objects.equals(arrivalGate, other.arrivalGate)
				&& Objects.equals(departureCity, other.departureCity)
				&& Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(departureGate, other.departureGate) && flightNumber == other.flightNumber
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", flightNumber=" + flightNumber + ", departureCity="
				+ departureCity + ", departureDate=" + departureDate + ", departureGate=" + departureGate
				+ ", arrivalCity=" + arrivalCity + ", arrivalDate=" + arrivalDate + ", arrivalGate=" + arrivalGate
				+ "]";
	} 
	
	
	
	
	
	
	
}

