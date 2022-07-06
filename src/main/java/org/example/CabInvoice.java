package org.example;

import java.util.Map;

public class CabInvoice {

    final static double COST_PER_KM = 10;
    final static double COST_PER_MIN = 1;
    final static double MINIMUM_FARE = 5;
    public double calculateFare(double distance, int time){
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MIN) ;
        if (totalFare < MINIMUM_FARE){
            totalFare = MINIMUM_FARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.rideCategory.calculateCategoryFare(ride.distance, ride.time);
        }
        double averageFare = totalFare / rides.length;
        return new InvoiceSummary(totalFare, rides.length, averageFare);
    }


    public double aggregateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride:rides){
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }
    
    public InvoiceSummary calculateFare(String userID, Map<String, Ride[]> bookRide) {
        InvoiceSummary totalFare = calculateFare(bookRide.get(userID));
        return totalFare;
    }
}
