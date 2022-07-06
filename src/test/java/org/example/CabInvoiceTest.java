package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceTest {

    CabInvoice cabInvoice;
    @Test
    public void givenDistance_whenchecked_shouldReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double distance = 2.5;
        int time = 2;
        double totalFare = cabInvoice.calculateFare(distance,time);
        Assertions.assertEquals(27, totalFare);
    }

    @Test
    public void givenDistance_whenchecked_shouldReturnMinimumFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double distance = 0.2;
        int time = 1;
        double totalFare = cabInvoice.calculateFare(distance,time);
        Assertions.assertEquals(5, totalFare);
    }

    @Test
     public void givenRides_whenChecked_shouldReturnAggregateFare(){

        Ride[] rides = {new Ride(3, 4), new Ride(6, 9), new Ride(0.1, 1)};
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.aggregateFare(rides);
        Assertions.assertEquals(108.0, fare);
    }


    @Test
    public void givenMultipleRides_WhenChecked_shouldReturnInvoice(){
        CabInvoice cabInvoice = new CabInvoice();

    }

    @Test
    public void givenMultipleRide_whenChecked_shouldReturnInvoice() {
        Ride[] rides = {
                new Ride(RideCategory.REGULAR, 2, 5),
                new Ride(RideCategory.REGULAR, 0.1, 1)
        };
        InvoiceSummary summary = cabInvoice.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2, 15);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIDAndRides_whenChecked_shouldReturnInvoiceSummary() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(RideCategory.REGULAR, 2.0, 5),
                new Ride(RideCategory.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(RideCategory.REGULAR, 3.0, 5),
                new Ride(RideCategory.REGULAR, 0.1, 1)
        };
        rideBook.put("abc", rides);
        rideBook.put("defg", rides1);
        String userID = "abc";
        InvoiceSummary summary = cabInvoice.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30, 2, 15);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenRegularPremiumRideRate_whenChecked_shouldReturnTotalFare() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(RideCategory.PREMIUM, 2.0, 5),
                new Ride(RideCategory.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(RideCategory.PREMIUM, 3.0, 5),
                new Ride(RideCategory.REGULAR, 0.1, 1)
        };
        rideBook.put("abc", rides);
        rideBook.put("defg", rides1);
        String userID = "defg";
        InvoiceSummary summary = cabInvoice.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(60, 2, 30);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

}
