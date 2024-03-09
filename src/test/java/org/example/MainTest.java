package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    public void testCalculatePricePremiumPassenger() {
        Passenger passenger = new Passenger("John", 1, Passenger.MembershipType.PREMIUM);
        Destination destination = new Destination("Destination");
        Activity activity = new Activity("Activity", "Description", 100, 5, destination);
        double price = TravelPackageService.calculatePrice(passenger, activity);
        assertEquals(0, price, 0.001); // Expected price for premium passenger is 0
    }

    @Test
    public void testCalculatePriceStandardPassenger() {
        Passenger passenger = new Passenger("Alice", 2, Passenger.MembershipType.STANDARD);
        Destination destination = new Destination("Destination");
        Activity activity = new Activity("Activity", "Description", 100, 5, destination);
        double price = TravelPackageService.calculatePrice(passenger, activity);
        assertEquals(100, price, 0.001); // Expected price for standard passenger is activity cost
    }

    @Test
    public void testCalculatePriceGoldPassengerWithSufficientBalance() {
        Passenger passenger = new Passenger("Bob", 3, Passenger.MembershipType.GOLD);
        passenger.setBalance(200); // Set balance more than discounted price
        Destination destination = new Destination("Destination");
        Activity activity = new Activity("Activity", "Description", 100, 5, destination);
        double price = TravelPackageService.calculatePrice(passenger, activity);
        assertEquals(90, price, 0.001); // Expected price for gold passenger with discount applied
    }

    @Test
    public void testCalculatePriceGoldPassengerWithInsufficientBalance() {
        Passenger passenger = new Passenger("Charlie", 4, Passenger.MembershipType.GOLD);
        passenger.setBalance(50); // Set balance less than discounted price
        Destination destination = new Destination("Destination");
        Activity activity = new Activity("Activity", "Description", 100, 5, destination);
        double price = TravelPackageService.calculatePrice(passenger, activity);
        assertEquals(0, price, 0.001); // Expected price for gold passenger with insufficient balance is 0
    }
}