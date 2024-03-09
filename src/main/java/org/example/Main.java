package org.example;


import java.util.HashMap;
import java.util.Map;

import static org.example.TravelPackageService.*;

public class Main {


    public static void main(String[] args) {
        Destination goa = new Destination("Goa");
        Activity music = new Activity("Music","Playing music", 100.0, 10, goa);
        Activity drawing = new Activity("Drawing","Drawing scenery", 200.0, 10, goa);
        Activity photography = new Activity("Photography","Outdoor Photography", 300.0, 10, goa);
        Activity reading = new Activity("Reading","Reading classic books", 400.0, 10, goa);
        Activity sports = new Activity("Sports","Playing football", 500.0, 10, goa);
        goa.addActivities(music);
        goa.addActivities(drawing);

        Destination pondicherry = new Destination("Pondicherry");
        Activity surfing =new Activity("Surfing", "Learning to surf on the beach", 150.0, 10, pondicherry);
        Activity yoga = new Activity("Yoga", "Morning yoga sessions by the sea", 250.0, 10, pondicherry);
        Activity boatRide = new Activity("Boat Ride", "Scenic boat ride along the coast", 350.0, 10, pondicherry);
        Activity beachVolleyball = new Activity("Beach Volleyball", "Fun games of beach volleyball", 450.0, 10, pondicherry);
        Activity goaCuisine = new Activity("Goa Cuisine", "Cooking classes for Goan cuisine", 550.0, 10, pondicherry);
        pondicherry.addActivities(surfing);
        pondicherry.addActivities(boatRide);



        Passenger darshan = new Passenger("Darshan", 111, Passenger.MembershipType.GOLD);
        darshan.setBalance(500);
        Passenger sandeep = new Passenger("Sandeep", 222, Passenger.MembershipType.PREMIUM);
        sandeep.setBalance(1000);
        Passenger akash = new Passenger("Akash", 333, Passenger.MembershipType.STANDARD);
        akash.setBalance(1500);

        TravelPackage travelPackage = new TravelPackage("Goa Pondicherry Package",10);
        travelPackage.addDestination(goa);
        travelPackage.addDestination(pondicherry);
        try {
            travelPackage.addPassenger(sandeep);
            travelPackage.addPassenger(darshan);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            darshan.addActivity(music);
            darshan.addActivity(drawing);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            sandeep.addActivity(surfing);
            sandeep.addActivity(boatRide);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("*************************************");
        /**
         1. Print itinerary of the travel package including:
         a. travel package name,
         b. destinations and details of the activities available at each destination, like name, cost, capacity and description
         */
        printItinerary(travelPackage);
        System.out.println("*************************************");
        /**
         * 2. Print the passenger list of the travel package including:
         * a. package name,
         * b. passenger capacity,
         * c. number of passengers currently enrolled and
         * d. name and number of each passenger
         */
        printPassengerList(travelPackage);
        System.out.println("*************************************");
        /**
         * 3. Print the details of an individual passenger including their
         * 	a. name,
         * 	b. passenger number,
         * 	c. balance (if applicable),
         * 	d. list of each activity they have signed up for,
         * 	including the destination the at which the activity is taking place and the price the passenger
         */
        for (Passenger passenger : travelPackage.getPassengers()) {
            printPassengerDetails(passenger);
        }
        System.out.println("***************************************");

        /**
         * 4. Print the details of all the activities that still have spaces available, including how many spaces are available.
         */
        printAvailableActivities(travelPackage);

    }

}