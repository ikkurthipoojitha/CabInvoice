package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideUser {

    Map<String, ArrayList<Ride>> rideusers;

    public RideUser() {
        rideusers = new HashMap<String, ArrayList<Ride>>();
    }

    public void addRide(String userId, Ride[] ride) {
        ArrayList<Ride> ridesList = this.rideusers.get(userId);
        if (ridesList == null) {
            this.rideusers.put(userId, new ArrayList<Ride>(Arrays.asList(ride)));
        }
    }

    public Ride[] getRides(String userId) {
        return this.rideusers.get(userId).toArray(new Ride[0]);
    }
}
