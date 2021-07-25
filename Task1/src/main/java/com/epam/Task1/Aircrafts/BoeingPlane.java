package com.epam.Task1.Aircrafts;

public class BoeingPlane extends  Plane{

    public BoeingPlane(int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = 130000;
        averageSpeed = 850;
    }

    @Override
    public  int computeFligthCost(int distance, double taxesCoefficient ) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesCoefficient+0.10));
        return resultCost/seatsNumber;
    }
    @Override
    protected int getFuelCost(){
        return  150;
    }
    @Override
    protected   int getServiceCost(){
        return  30;
    }

    @Override
    public   String getPlaneName() {
        String planeName = "Boeing " + Integer.toString(planeModelNumber);
        return  planeName;
    }


}
