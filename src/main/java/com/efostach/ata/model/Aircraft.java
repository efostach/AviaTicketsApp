package com.efostach.ata.model;

public class Aircraft {
    private Integer id;
    private String modelName;
    private Integer economySeatsCount;
    private Integer businessSeatsCount;

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

    public Integer getEconomySeatsCount() {
        return economySeatsCount;
    }

    public void setEconomySeatsCount(Integer economySeatsCount) {
        this.economySeatsCount = economySeatsCount;
    }

    public Integer getBusinessSeatsCount() {
        return businessSeatsCount;
    }

    public void setBusinessSeatsCount(Integer businessSeatsCount) {
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
