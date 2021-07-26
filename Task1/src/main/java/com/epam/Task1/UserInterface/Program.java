package com.epam.Task1.UserInterface;

import com.epam.Task1.Aircrafts.AirbusPlane;
import com.epam.Task1.Aircrafts.BoeingPlane;
import com.epam.Task1.Aircrafts.EmbraerPlane;
import com.epam.Task1.Airline.Airline;
import com.epam.Task1.Airline.AirlineLogic;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Airline airline = new Airline();
        airline.addPlane(new AirbusPlane(7000, 285, 10,232));
        airline.addPlane(new BoeingPlane(8000, 5220, 8,747));
        airline.addPlane(new BoeingPlane(10000, 180, 7,767));
        airline.addPlane(new EmbraerPlane(6000, 250, 11,321));
        AirlineLogic airlineLogic = new AirlineLogic(airline);
        Scanner in = new Scanner(System.in);
        int menuOption = -1;

        printInterface();
        do{
            menuOption = in.nextInt();
            switch (menuOption){
                case 1:
                    airlineLogic.printPlanesList();
                    break;
                case 2:
                    airlineLogic.sortListByRange();
                    airlineLogic.printPlanesList();
                    break;
                case 3:
                    System.out.println("Input minimal fuel consumption: ");
                    int minConsumption = in.nextInt();
                    System.out.println("Input maximal fuel consumption: ");
                    int maxConsumption = in.nextInt();
                    System.out.println(airlineLogic.findPlanesByFuelConsumption(minConsumption,maxConsumption));
                    break;
                case 4:
                    System.out.println("Input distance: ");
                    int distance = in.nextInt();
                    System.out.println(airlineLogic.findCheapestPlane(distance));
                    break;
                case 5:
                    System.out.println("Closing Program...");
                    break;
                default:
                    System.out.println("No such option");
                    break;
            }
        }while (menuOption!=5);



    }

    public  static  void printInterface(){
        System.out.println("1 - print planes list");
        System.out.println("2 - sort planes list by range of flight");
        System.out.println("3 - find plane list by fuel consumption");
        System.out.println("4 - find the cheapest plane");
        System.out.println("5 - Exit");



    }

}
