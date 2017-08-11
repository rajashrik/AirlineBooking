package com.airline;

/**
 * Created by rajashrk on 8/11/17.
 */
public class TravelClass {
    private ClassType classType;
    private Integer availableSeats;
    private Integer totalSeats;
    private Double basePrice;

    public TravelClass(ClassType classType, Integer totalSeats, Double basePrice) {
        this.classType = classType;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
        this.availableSeats = totalSeats;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public  boolean bookSeat(Integer numberOfSeats) {
        if(canBookSeats(numberOfSeats)) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }

    private boolean canBookSeats(Integer numberOfSeats) {
        return availableSeats >=  numberOfSeats;
    }

}
