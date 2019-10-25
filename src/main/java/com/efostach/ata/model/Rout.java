package com.efostach.ata.model;

public class Rout {
    private Integer id;
    private String from;
    private String to;
    private String aircraftId;
    private String flightNumber;

    public Rout() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(String aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(from).append(",")
                .append(to).append(",")
                .append(aircraftId).append(",")
                .append(flightNumber)
                .append("\n").toString();
    }
}
