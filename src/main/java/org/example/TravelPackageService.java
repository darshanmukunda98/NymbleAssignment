package org.example;

import java.util.HashMap;
import java.util.Map;

public class TravelPackageService {


    static void printItinerary(TravelPackage travelPackage){
        System.out.println("Package Name: "+ travelPackage.getName());
        for(Destination destination : travelPackage.getDestinations()){
            System.out.println("Destination: "+destination.getName());
            for(Activity activity : destination.getActivities()){
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }
    static void printPassengerList(TravelPackage travelPackage){
        System.out.println("Package Name: "+travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.println("Passenger Name: " + passenger.getName() + ", Passenger Number: " +
                    passenger.getNumber());
        }
    }

    static void printPassengerDetails(Passenger passenger){
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
    static double calculatePrice(Passenger passenger, Activity activity) {
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
