package org.example;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int currentCapacity;
    private int totalCapacity;

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.totalCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return totalCapacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void addPassenger(Passenger passenger) throws Exception {
        if (this.currentCapacity == totalCapacity) {
            throw new Exception("Package reached it's capacity");
        }
        this.passengers.add(passenger);
        this.currentCapacity++;
    }

    @Override
    public String toString() {
        return "TravelPackage{" +
                "name='" + name + '\'' +
                ", passengerCapacity=" + totalCapacity +
                ", destinations=" + destinations +
                ", passengers=" + passengers +
                '}';
    }
}
