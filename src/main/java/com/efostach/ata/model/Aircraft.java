package com.efostach.ata.model;

public class Aircraft {
    private Integer id;
    private String name;
    private String model;
    private Integer countBusinessSeatsInRow;
    private Integer countBusinessRows;
    private Integer countEconomSeatsInRow;
    private Integer countEconomRows;

    public Aircraft() {
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name).append(",")
                .append(model).append(",")
                .append(countBusinessSeatsInRow).append(",")
                .append(countBusinessRows).append(",")
                .append(countEconomSeatsInRow).append(",")
                .append(countEconomRows)
                .append("\n").toString();
    }
}
