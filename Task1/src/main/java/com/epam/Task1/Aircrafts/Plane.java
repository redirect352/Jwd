package com.epam.Task1.Aircrafts;

public abstract class  Plane{

    public Plane (int range, int seats, int consumption, int modelNumber){
        this.rangeOfFlight = range;
        this.seatsNumber = seats;
        this.fuelConsumption = consumption;
        this.planeModelNumber = modelNumber;
    }


    public  int liftingCapacity;
    public  int rangeOfFlight;
    public  int seatsNumber;
    public  int fuelConsumption;
    public  int planeModelNumber = 0;

    protected   int averageSpeed = 800;

    public abstract int computeFligthCost(int distance, double taxesCoefficient );

    protected  int computeBaseCost(int distance,int passengerCount){
        int resultCost = distance/averageSpeed*fuelConsumption*getFuelCost()+ passengerCount*getServiceCost ();
        return resultCost;
    }

    protected abstract  int getFuelCost();
    protected  abstract  int getServiceCost();

    public  abstract String getPlaneName();



}
