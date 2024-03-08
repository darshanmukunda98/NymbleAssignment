package org.example;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private long number;
    private double balance;
    public enum MembershipType{
        GOLD,
        PREMIUM,
        STANDARD
    }
    private MembershipType membershipType;
    private List<Activity> activities;

    public Passenger(String name, long number, MembershipType membershipType) {
        this.name = name;
        this.number = number;
        this.membershipType = membershipType;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public long getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public MembershipType getType() {
        return membershipType;
    }
    public List<Activity> getActivities(){
        return activities;
    }
    public void addActivity(Activity activity){
        activities.add(activity);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", balance=" + balance +
                '}';
    }
}
