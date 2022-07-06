package org.example;

import java.util.Objects;

public class InvoiceSummary {

    private double totalFare;
    private int numOfRides;
    private double averageFare;


    public InvoiceSummary(double totalFare, int numOfRides, double averageFare) {
        this.totalFare = totalFare;
        this.numOfRides = numOfRides;
        this.averageFare = this.totalFare / numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.totalFare, totalFare) == 0 && numOfRides == that.numOfRides && Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalFare, numOfRides, averageFare);
    }
}
