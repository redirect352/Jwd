package com.epam.Task1.Aircraft;

public class BoeingPlane extends  Plane{
    private  final  int FUEL_COST_COEFFICIENT = 10;
    private  final  int SERVICE_COEFFICIENT = 3;
    private  final  String PLANE_NAME = "Boeing ";
    private  final  int DEFAULT_LIFTING_CAPACITY = 130000;
    private  final  int DEFAULT_AVERAGE_SPEED = 850;
    private  final double MAINTENANCE_RATIO = 0.1;


    public BoeingPlane(int range, int seats, int consumption, int modelNumber){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = DEFAULT_LIFTING_CAPACITY;
        averageSpeed = DEFAULT_AVERAGE_SPEED;
    }
    public BoeingPlane(int range, int seats, int consumption, int modelNumber, int lifting, int speed){
        super(range,seats,consumption,modelNumber);
        liftingCapacity = lifting;
        averageSpeed = speed;
    }

    @Override
    public  int computeFlightCost(int distance, double taxesCoefficient ) {
        int resultCost = this.computeBaseCost(distance,this.seatsNumber);
        resultCost = (int)(resultCost*(1+taxesCoefficient+MAINTENANCE_RATIO ));
        return resultCost/seatsNumber;
    }
    @Override
    protected int getFuelCost(){
        return  FUEL_COST_COEFFICIENT*fuelConsumption;
    }
    @Override
    protected   int getServiceCost(){
        return  SERVICE_COEFFICIENT *seatsNumber;
    }

    @Override
    public   String toString() {
        String planeName = PLANE_NAME + Integer.toString(planeModelNumber);
        return  planeName;
    }


}
