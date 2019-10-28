package com.efostach.ata.model;

public class Aircraft {
    private Integer id;
    private String modelName;
    private int economySeatsCount;
    private int businessSeatsCount;

    public Aircraft() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getEconomySeatsCount() {
        return economySeatsCount;
    }

    public void setEconomySeatsCount(int economySeatsCount) {
        this.economySeatsCount = economySeatsCount;
    }

    public int getBusinessSeatsCount() {
        return businessSeatsCount;
    }

    public void setBusinessSeatsCount(int businessSeatsCount) {
        this.businessSeatsCount = businessSeatsCount;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(modelName).append(",")
                .append(economySeatsCount).append(",")
                .append(businessSeatsCount)
                .append("\n").toString();
    }
}
