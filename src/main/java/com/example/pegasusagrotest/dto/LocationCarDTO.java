package com.example.pegasusagrotest.dto;

public class LocationCarDTO {

    private double currentDegreesLat;
    private double currentDegreesLon;
    private double lastDegreesLat;
    private double lastDegreesLon;
    private double totalDistanceTraveled;


    public double getCurrentDegreesLat() {
        return currentDegreesLat;
    }

    public double getCurrentDegreesLon() {
        return currentDegreesLon;
    }

    public double getLastDegreesLat() {
        return lastDegreesLat;
    }

    public double getLastDegreesLon() {
        return lastDegreesLon;
    }

    public void setCurrentDegreesLat(String lat) {
        setLastDegreesLat(currentDegreesLat);
        double currentDegreesLat = convertStringToNumericDegrees(lat);
        this.currentDegreesLat = currentDegreesLat;
    }

    public void setCurrentDegreesLon(String lon) {
        setLastDegreesLon(currentDegreesLon);
        double currentDegreesLon = convertStringToNumericDegrees(lon);
        this.currentDegreesLon = currentDegreesLon;
    }

    public void setLastDegreesLat(double lastDegreesLat) {
        this.lastDegreesLat = lastDegreesLat;
    }

    public void setLastDegreesLon(double lastDegreesLon) {
        this.lastDegreesLon = lastDegreesLon;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    public void setTotalDistanceTraveled(double totalDistanceTraveled) {
        this.totalDistanceTraveled += totalDistanceTraveled;
    }

    public Double convertStringToNumericDegrees(String coordinates){
        double degree, minutes;

        degree = Double.parseDouble(coordinates.substring(0,2));
        minutes = Double.parseDouble(coordinates.substring(2));

        return degree + (minutes / 60);
    }

}
