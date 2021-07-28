package com.epam.Task1.Airline;

import com.epam.Task1.Aircraft.Plane;

import java.util.ArrayList;

public class Airline {
    protected ArrayList<Plane> airlinePlanes;

    public Airline(){
        airlinePlanes = new ArrayList<Plane>();
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
