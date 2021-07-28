package com.epam.Task1.Aircraft;

public class AirbusPlane extends  Plane{
    private  final  int FUEL_COST_COEFFICIENT = 9;
    private  final  int SERVICE_COEFFICIENT = 4;
    private  final  String PLANE_NAME = "Airbus ";
    private  final  int DEFAULT_LIFTING_CAPACITY = 150000;
    private  final  int DEFAULT_AVERAGE_SPEED = 800;



    public AirbusPlane(int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = DEFAULT_LIFTING_CAPACITY;
        averageSpeed = DEFAULT_AVERAGE_SPEED;
    }
    public AirbusPlane(int range, int seats, int consumption, int modelNumber, int lifting, int speed){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = lifting;
        averageSpeed = speed;
    }

    @Override
    public  int computeFlightCost(int distance, double taxesСoefficient) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesСoefficient));
        return resultCost/seatsNumber;
    }
    @Override
    protected int getFuelCost(){
        return  FUEL_COST_COEFFICIENT *fuelConsumption;
    }
    @Override
    protected   int getServiceCost(){
        return  SERVICE_COEFFICIENT*seatsNumber;
    }

    @Override
    public   String toString() {
        String planeName = PLANE_NAME + Integer.toString(planeModelNumber);
        return  planeName;
    }

}
