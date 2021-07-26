package com.epam.Task1.Airline;

import com.epam.Task1.Aircrafts.Plane;
import com.epam.Task1.Aircrafts.PlaneComparator;

import java.util.ArrayList;

public class AirlineLogic {
    private  final double TAXES= 0.23;
    private  Airline airline;

    public AirlineLogic(Airline airlineInit){
        airline = airlineInit;
    }

    public  void  printPlanesList(){
        if (airline == null){
           return;
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
        if(airlinePlanes == null){
            return;
        }
        System.out.println("Company planes list");
        System.out.println("|_____________________________________________________|");
        System.out.println("| Plane name       | Range of flight | Number of seats|");
        System.out.println("|_____________________________________________________|");

        for (Plane plane:
                airlinePlanes) {
            System.out.printf("|%18s|%17s|%16d|\n",plane.toString(),plane.rangeOfFlight,plane.seatsNumber);
        }
        System.out.println("|_____________________________________________________|");
    }

    public  void  sortListByRange(){
        if (airline == null){
           return;                               
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
        if(airlinePlanes == null) {
            return;
        }
        airlinePlanes.sort(new PlaneComparator());
    }

    public  String  findPlanesByFuelConsumption(int startValue, int endValue){
        if (airline == null){
           return "";
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
        if(airlinePlanes == null){
            return "";
        }
        String result = "Planes: \n";
        boolean planesNotFound = false;
        for (Plane plane:
                airlinePlanes) {
            if (plane.fuelConsumption >= startValue
                    && plane.fuelConsumption <= endValue){
                result+=String.format("%18s\n",plane.toString());
                planesNotFound = true;
            }
        }

        if (!planesNotFound){
            result = "Not found";
        }
        return  result;
    }

    public  String  findCheapestPlane(int distance){
        if (airline == null){
           return "";
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
        if(airlinePlanes == null){
            return "";
        }
        String result = "";
        Plane cheapestPlane = null;
        int cheapestPrice = Integer.MAX_VALUE;
        for (Plane plane:
                airlinePlanes) {
            if (plane.computeFligthCost(distance,TAXES) < cheapestPrice){
                cheapestPrice = plane.computeFligthCost(distance,TAXES);
                cheapestPlane = plane;
            }
        }
        if (cheapestPlane != null){
            result = "The cheapest price for this flight is " + cheapestPrice+" on " + cheapestPlane.toString();
            System.out.println();
        }else {
             result = "Error, not found";
        }
        return  result;
    }

    public int computeOverallSeats(){
        if (airline == null){
           return 0;
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
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
        if (airline == null){
           return 0;
        }
        ArrayList<Plane> airlinePlanes = airline.airlinePlanes;
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

}
