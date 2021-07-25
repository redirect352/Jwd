package com.epam.Task1.Airline;

import com.epam.Task1.Aircrafts.Plane;
import com.epam.Task1.Aircrafts.PlanesComparator;

import java.util.ArrayList;

public class Airline {
    private  ArrayList<Plane> airlinePlanes;
    private double taxes = 0.23;

    public  Airline(){
        airlinePlanes = new ArrayList<Plane>();
    }

    public  void  printPlanesList(){
        if(airlinePlanes == null){
            return;
        }
        System.out.println("Company planes list");
        System.out.println("|_____________________________________________________|");
        System.out.println("| Plane name       | Range of flight | Number of seats|");
        System.out.println("|_____________________________________________________|");

        for (Plane plane:
             airlinePlanes) {
            System.out.printf("|%18s|%17s|%16d|\n",plane.getPlaneName(),plane.rangeOfFlight,plane.seatsNumber);
        }
        System.out.println("|_____________________________________________________|");
    }

    public  void  sortListByRange(){
        if(airlinePlanes == null){
            return;
        }
        airlinePlanes.sort(new PlanesComparator());
    }

    public  void  findPlanesByFuelConsumption(int startValue, int endValue){
        if(airlinePlanes == null){
            return;
        }
        boolean planesNotFound = false;
        for (Plane plane:
             airlinePlanes) {
            if (plane.fuelConsumption >= startValue
                && plane.fuelConsumption <= endValue){
                if(!planesNotFound){
                    planesNotFound = true;
                    System.out.println("Planes: ");
                }
                System.out.printf("%18s\n",plane.getPlaneName());
            }
        }

        if (!planesNotFound){
            System.out.println("Not found");
        }
    }

    public  void  findCheapestPlane(int distance){
        if(airlinePlanes == null){
            return;
        }
        Plane cheapestPlane = null;
        int cheapestPrice = Integer.MAX_VALUE;
        for (Plane plane:
             airlinePlanes) {
            if (plane.computeFligthCost(distance,taxes) < cheapestPrice){
                cheapestPrice = plane.computeFligthCost(distance,taxes);
                cheapestPlane = plane;
            }
        }
        if (cheapestPlane != null){
            System.out.println("The cheapest price for this fligth is " + cheapestPrice+" on " + cheapestPlane.getPlaneName());
        }else {
            System.out.println("Error, not found");
        }


    }

    public int computeOverallSeats(){
        if(airlinePlanes == null){
            return 0;
        }
        int result = 0;

        for (Plane plane:
                airlinePlanes) {
            result+=plane.seatsNumber;
        }
        return  result;
    }

    public int computeOverallCapacity(){
        if(airlinePlanes == null){
            return 0;
        }
        int result = 0;

        for (Plane plane:
                airlinePlanes) {
            result+=plane.liftingCapacity;
        }
        return  result;
    }

    public void addPlane(Plane plane){
        if(airlinePlanes == null){
            return;
        }
        airlinePlanes.add(plane);
    }

    public void  clearPlanes(){
        if(airlinePlanes == null){
            return;
        }
        airlinePlanes.clear();
    }

}
