package com.efostach.ata.model;

public class Ticket {
    private int ticketNumber;
    private String from;
    private String to;
    private String seatNumber;
    private String aircraft;
    private String date;
    private TicketClass ticketClass;

    public Ticket() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(ticketNumber).append(",")
                .append(from).append(",")
                .append(to).append(",")
                .append(seatNumber).append(",")
                .append(aircraft).append(",")
                .append(date).append(",")
                .append(ticketClass)
                .append("\n").toString();
    }
}
