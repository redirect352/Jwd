package com.epam.Task1.Aircraft;

import java.util.Comparator;

public class PlaneComparator implements Comparator<Plane> {
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
