package com.efostach.ata.model;

import java.util.Date;

public class Ticket {
    private int ticketNumber;
    private String from;
    private String to;
    private String seatNumber;
    private String aircraft;
    private Date date;
    private TicketClass ticketClass;

    public Ticket(int ticketNumber,
                  String from,
                  String to,
                  String seatNumber,
                  String aircraft,
                  Date date,
                  TicketClass ticketClass) {
        this.ticketNumber = ticketNumber;
        this.from = from;
        this.to = to;
        this.seatNumber = seatNumber;
        this.aircraft = aircraft;
        this.date = date;
        this.ticketClass = ticketClass;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }
}
