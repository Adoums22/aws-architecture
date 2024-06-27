package com.example.cdansoprapizza.dtos;

public class ClientStatsDto {

    private String clientName;
    private Integer nbCourse;
    private Double distanceTotal;

    // Getters and Setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getNbCourse() {
        return nbCourse;
    }

    public void setNbCourse(Integer nbCourse) {
        this.nbCourse = nbCourse;
    }

    public Double getDistanceTotal() {
        return distanceTotal;
    }

    public void setDistanceTotal(Double distanceTotal) {
        this.distanceTotal = distanceTotal;
    }
}
