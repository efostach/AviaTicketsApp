package com.efostach.ata.model;

public class Ticket {
    private Integer ticketNumber;
    private String firstName;
    private String lastName;
    private Integer flightId;
    private String seatNumber;
    private SeatClass seatClass;
    private TicketStatus status;

    public Ticket() {
        this.ticketNumber = null;
        this.firstName = null;
        this.lastName = null;
        this.flightId = null;
        this.seatNumber = null;
        this.seatClass = null;
        this.status = null;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(ticketNumber).append(",")
                .append(firstName).append(",")
                .append(lastName).append(",")
                .append(seatNumber).append(",")
                .append(flightId).append(",")
                .append(seatClass).append(",")
                .append(status)
                .append("\n").toString();
    }
}
