package org.example;


import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Activity> goaPackageActivities = List.of(
                new Activity("Music","Playing music", 100.0, 10),
                new Activity("Drawing","Drawing scenery", 200.0, 20),
                new Activity("Photography","Outdoor Photography", 300.0, 30),
                new Activity("Reading","Reading classic books", 400.0, 40),
                new Activity("Sports","Playing football", 500.0, 50));

        List<Activity> pondicherryPackageActivities = List.of(
                new Activity("Surfing", "Learning to surf on the beach", 150.0, 15),
                new Activity("Yoga", "Morning yoga sessions by the sea", 250.0, 25),
                new Activity("Boat Ride", "Scenic boat ride along the coast", 350.0, 35),
                new Activity("Beach Volleyball", "Fun games of beach volleyball", 450.0, 45),
                new Activity("Goa Cuisine", "Cooking classes for Goan cuisine", 550.0, 55));

        Destination goa = new Destination("Goa", goaPackageActivities);
        Destination pondicherry = new Destination("Pondicherry", pondicherryPackageActivities);

        Passenger darshan = new Passenger("Darshan", 111, 1000.0);
        Passenger sandeep = new Passenger("Sandeep", 222, 2000.0);

        TravelPackage travelPackage = new TravelPackage("Goa Pondicherry Package",
                10,
                List.of(goa, pondicherry),
                List.of(darshan, sandeep));
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
}