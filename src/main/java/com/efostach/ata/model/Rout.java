package com.efostach.ata.model;

public class Rout {
    private Integer id;
    private String from;
    private String to;

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

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(from).append(",")
                .append(to)
                .append("\n").toString();
    }
}
