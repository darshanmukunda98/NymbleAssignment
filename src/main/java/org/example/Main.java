package org.example;


import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Destination goa = new Destination("Goa");
        Activity music = new Activity("Music","Playing music", 100.0, 10, goa);
        Activity drawing = new Activity("Drawing","Drawing scenery", 200.0, 10, goa);
        Activity photography = new Activity("Photography","Outdoor Photography", 300.0, 10, goa);
        Activity reading = new Activity("Reading","Reading classic books", 400.0, 10, goa);
        Activity sports = new Activity("Sports","Playing football", 500.0, 10, goa);

        Destination pondicherry = new Destination("Pondicherry");
        Activity surfing =new Activity("Surfing", "Learning to surf on the beach", 150.0, 10, pondicherry);
        Activity yoga = new Activity("Yoga", "Morning yoga sessions by the sea", 250.0, 10, pondicherry);
        Activity boatRide = new Activity("Boat Ride", "Scenic boat ride along the coast", 350.0, 10, pondicherry);
        Activity beachVolleyball = new Activity("Beach Volleyball", "Fun games of beach volleyball", 450.0, 10, pondicherry);
        Activity goaCuisine = new Activity("Goa Cuisine", "Cooking classes for Goan cuisine", 550.0, 10, pondicherry);


        Passenger darshan = new Passenger("Darshan", 111, Passenger.MembershipType.GOLD);
        darshan.setBalance(500);
        Passenger sandeep = new Passenger("Sandeep", 222, Passenger.MembershipType.PREMIUM);
        sandeep.setBalance(1000);
        Passenger akash = new Passenger("Akash", 333, Passenger.MembershipType.STANDARD);
        akash.setBalance(1500);

        TravelPackage travelPackage = new TravelPackage("Goa Pondicherry Package",10);
        travelPackage.addDestination(goa);
        travelPackage.addDestination(pondicherry);
        travelPackage.addPassenger(darshan);
        travelPackage.addPassenger(sandeep);

        darshan.addActivity(music);
        darshan.addActivity(drawing);

        sandeep.addActivity(surfing);
        sandeep.addActivity(boatRide);
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
    private static void printItinerary(TravelPackage travelPackage){
        System.out.println("Package Name: "+ travelPackage.getName());
        for(Destination destination : travelPackage.getDestinations()){
            System.out.println("Destination: "+destination.getName());
            for(Activity activity : destination.getActivities()){
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }
    private static void printPassengerList(TravelPackage travelPackage){
        System.out.println("Package Name: "+travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("Passenger Name: " + passenger.getName() + ", Passenger Number: " +
                    passenger.getNumber());
        }
    }
    private static void printPassengerDetails(Passenger passenger){
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getNumber());
        if (passenger.getType() == Passenger.MembershipType.STANDARD || passenger.getType() == Passenger.MembershipType.GOLD) {
            System.out.println("Balance: " + passenger.getBalance());
        }
        System.out.println("Activities Signed Up For:");
        for (Activity activity : passenger.getActivities()) {
            System.out.println("Activity: " + activity.getName() + ", Destination: " +
                    activity.getDestination().getName() + ", Price: " + calculatePrice(passenger, activity));
        }
    }
    private static double calculatePrice(Passenger passenger, Activity activity) {
        if (passenger.getType() == Passenger.MembershipType.PREMIUM) {
            return 0;
        } else if (passenger.getType() == Passenger.MembershipType.STANDARD) {
            return activity.getCost();
        } else {
            double discountedPrice = activity.getCost() * 0.9;
            if (passenger.getBalance() >= discountedPrice) {
                return discountedPrice;
            } else {
                return 0;
            }
        }
    }
    public static void printAvailableActivities(TravelPackage travelPackage) {
        System.out.println("Activities with Available Spaces:");
        Map<String, Integer> availableSpaces = new HashMap<>();
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                int signedUpPassengers = 0;
                for (Passenger passenger : travelPackage.getPassengers()) {
                    if (passenger.getActivities().contains(activity)) {
                        signedUpPassengers++;
                    }
                }
                int availableSpacesCount = activity.getCapacity() - signedUpPassengers;
                if (availableSpacesCount > 0) {
                    availableSpaces.put(activity.getName(), availableSpacesCount);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : availableSpaces.entrySet()) {
            System.out.println("Activity: " + entry.getKey() + ", Available Spaces: " + entry.getValue());
        }
    }

}