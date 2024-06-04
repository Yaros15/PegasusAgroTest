package com.example.pegasusagrotest.service;

import com.example.pegasusagrotest.dto.LocationCarDTO;

import java.text.DecimalFormat;

public class NMEA0183ProtocolFileService {

    private static final String GPS_SATELLITE = "$GPGGA";
    private static final String GROUND_SPEED = "VTG";
    private static final String COMMA_SEPARATOR = ",";
    private static final int ID_SUBSTRING_SATELLITE = 0;
    private static final int ID_SUBSTRING_LAT = 2;
    private static final int ID_SUBSTRING_LON = 4;
    private static final int ID_SUBSTRING_SPEED = 7;
    private static final int EARTH_RADIUS = 6371;

    private LocationCarDTO locationCar;
    private DecimalFormat decimalFormat;
    private double pathTraveled;

    public NMEA0183ProtocolFileService() {
        locationCar = new LocationCarDTO();
        decimalFormat = new DecimalFormat("#,###");
    }

    public void connectRouteUsingCoordinatesFromFile(String line){

        String[] currentLine = line.split(COMMA_SEPARATOR);
        if(currentLine[ID_SUBSTRING_SATELLITE].equals(GPS_SATELLITE)) {

            locationCar.setCurrentDegreesLat(currentLine[ID_SUBSTRING_LAT]);
            locationCar.setCurrentDegreesLon(currentLine[ID_SUBSTRING_LON]);

            if((locationCar.getLastDegreesLat() == 0) || (locationCar.getLastDegreesLon() == 0)){
                locationCar.setLastDegreesLat(locationCar.getCurrentDegreesLat());
                locationCar.setLastDegreesLon(locationCar.getCurrentDegreesLon());
            }

            pathTraveled = calculateDistance(locationCar.getLastDegreesLat(),
                            locationCar.getLastDegreesLon(), locationCar.getCurrentDegreesLat(),
                            locationCar.getCurrentDegreesLon());

            System.out.println("DegreesLat " + locationCar.getCurrentDegreesLat() + " "
                    + "DegreesLon " + locationCar.getCurrentDegreesLon() + " "
                    + "LastDegreesLat " + locationCar.getLastDegreesLat() + " "
                    + "LastDegreesLon " + locationCar.getLastDegreesLon());

        } else if(currentLine[ID_SUBSTRING_SATELLITE].contains(GROUND_SPEED)){
            double speed = Double.parseDouble(currentLine[ID_SUBSTRING_SPEED]);
            if(speed != 0){
                locationCar.setTotalDistanceTraveled(pathTraveled);
                System.out.println(pathTraveled + " Total " + locationCar.getTotalDistanceTraveled());
            }
        }
    }

    // Аппроксимация равноугольного расстояния
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

        return distance;
    }

    public double carHasPassedWay(){
        return locationCar.getTotalDistanceTraveled();
    }

}
