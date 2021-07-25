package com.epam.Task1.Aircrafts;

public class EmbraerPlane extends  Plane{

    public EmbraerPlane (int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = 100000;
        averageSpeed = 750;
    }

    @Override
    public  int computeFligthCost(int distance, double taxesСoefficient ) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesСoefficient+0.07));
        return resultCost/seatsNumber;
    }

    @Override
    protected int getFuelCost(){
        return  180;
    }

    @Override
    protected   int getServiceCost(){
        return  10;
    }

    @Override
    public   String getPlaneName() {
        String planeName = "Embraer " + Integer.toString(planeModelNumber);
        return  planeName;
    }
}
