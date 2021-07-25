package com.epam.Task1.Aircrafts;

public class AirbusPlane extends  Plane{

    public AirbusPlane(int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = 150000;
        averageSpeed = 800;
    }

    @Override
    public  int computeFligthCost(int distance, double taxesСoefficient) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesСoefficient));
        return resultCost/seatsNumber;
    }
    @Override
    protected int getFuelCost(){
        return  210;
    }
    @Override
    protected   int getServiceCost(){
        return  20;
    }

    @Override
    public   String getPlaneName() {
        String planeName = "Airbus " + Integer.toString(planeModelNumber);
        return  planeName;
    }

}
