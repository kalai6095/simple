package com.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class Ticket implements Serializable {

    private long ticketNo; // to be auto generated.
    private String busNo;
    private String busName;
    private String journeyDate;
    private String fromStation;
    private String toStation;
    private double fare;
    private double totalFare;
    private Date bookedOn;
    private List<PassengerDetails> passengerDetail; // to capture list of passenger details

    public long getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(long ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public Date getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(Date bookedOn) {
        this.bookedOn = bookedOn;
    }

    public List<PassengerDetails> getPassengerDetail() {
        return passengerDetail;
    }

    public void setPassengerDetail(List<PassengerDetails> passengerDetail) {
        this.passengerDetail = passengerDetail;
    }
}