package com.epam.Task1.Aircraft;

import java.util.Objects;

public class EmbraerPlane extends  Plane{

    private  final  int FUEL_COST_COEFFICIENT = 11;
    private  final  int SERVICE_COEFFICIENT = 5;
    private  final  String PLANE_NAME = "Embraer ";
    private  final  int DEFAULT_LIFTING_CAPACITY = 150000;
    private  final  int DEFAULT_AVERAGE_SPEED = 800;
    private  final double MAINTENANCE_RATIO = 0.07;

    public EmbraerPlane (int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = DEFAULT_LIFTING_CAPACITY;
        averageSpeed = DEFAULT_AVERAGE_SPEED;
    }
    public EmbraerPlane(int range, int seats, int consumption, int modelNumber, int lifting, int speed){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = lifting;
        averageSpeed = speed;
    }

    @Override
    public  int computeFlightCost(int distance, double taxesСoefficient ) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesСoefficient+MAINTENANCE_RATIO));
        return resultCost/seatsNumber;
    }

    @Override
    protected int getFuelCost(){
        return  FUEL_COST_COEFFICIENT *fuelConsumption;
    }
    @Override
    protected   int getServiceCost(){
        return  SERVICE_COEFFICIENT *seatsNumber;
    }

    @Override
    public   String toString() {
        String planeName =   PLANE_NAME + Integer.toString(planeModelNumber);
        return  planeName;
    }

    @Override
    public  int hashCode(){
        return Objects.hashCode(this);
    }
    @Override
    public  boolean equals(Object object){
        if(object == this){
            return  true;
        }
        if(object == null ||
            !(object instanceof  EmbraerPlane)){
            return  false;
        }
        EmbraerPlane embraerPlane = (EmbraerPlane) object;
        boolean result = this.planeModelNumber == embraerPlane.planeModelNumber &&
                         this.seatsNumber == embraerPlane.seatsNumber &&
                         this.liftingCapacity == embraerPlane.liftingCapacity &&
                         this.rangeOfFlight == embraerPlane.rangeOfFlight;
        return  result;
    }

}
