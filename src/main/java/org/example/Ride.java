package org.example;

public class Ride {

    public RideCategory rideCategory;
    public double distance;
    public int time;

    public Ride(RideCategory rideCategory, double distance, int time) {
        this.rideCategory = rideCategory;
        this.distance = distance;
        this.time = time;

    }

    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }
}
