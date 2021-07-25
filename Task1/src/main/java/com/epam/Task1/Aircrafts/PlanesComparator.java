package com.epam.Task1.Aircrafts;

import java.util.Comparator;

public class PlanesComparator implements Comparator<Plane> {
    public int compare(Plane a, Plane b){

       if (a.rangeOfFlight>b.rangeOfFlight){
           return 1;
       }else  if (a.rangeOfFlight == b.rangeOfFlight){
           return 0;
       }else{
           return  -1;
       }
    }
}
