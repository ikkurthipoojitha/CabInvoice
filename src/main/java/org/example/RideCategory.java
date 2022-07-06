package org.example;

public enum RideCategory implements InvoiceService {

        PREMIUM(15.0, 2, 20.0), REGULAR(10.0, 1, 5.0);

        private final double COST_PER_KM ;
        private final double COST_PER_MIN;
        private final double MINIMUM_FARE;
         RideCategory(double COST_PER_KM, int COST_PER_MIN,double MINIMUM_FARE){
            this.COST_PER_KM = COST_PER_KM;
            this.COST_PER_MIN = COST_PER_MIN;
            this.MINIMUM_FARE = MINIMUM_FARE;
        }


        @Override
        public double calculateCategoryFare(double distance, int time){
        double totalFare = (distance * COST_PER_KM) + (time * COST_PER_MIN) ;
        if (totalFare < MINIMUM_FARE){
            totalFare = MINIMUM_FARE;
        }
        return totalFare;
    }

}


    


