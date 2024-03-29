package com.efostach.ata.model;

public class Flight {
    private Integer id;
    private String startDate;
    private String endDate;
    private Integer soldSeatsCount;
    private Integer aircraftId;
    private Integer routeId;

    public Flight() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getSoldSeatsCount() {
        return soldSeatsCount;
    }

    public void setSoldSeatsCount(Integer soldSeatsCount) {
        this.soldSeatsCount = soldSeatsCount;
    }

    public Integer getAircrafrId() {
        return aircraftId;
    }

    public void setAircrafrId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routId) {
        this.routeId = routId;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(startDate).append(",")
                .append(endDate).append(",")
                .append(soldSeatsCount).append(",")
                .append(aircraftId).append(",")
                .append(routeId)
                .append("\n").toString();
    }

}
