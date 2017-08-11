package com.airline;

/**
 * Created by rajashrk on 8/11/17.
 */
public class TravelClass {
    private ClassType classType;
    private Integer availableSeats;
    private Integer totalSeats;

    public TravelClass(ClassType classType, Integer totalSeats) {
        this.classType = classType;
        this.availableSeats = totalSeats;
        this.totalSeats = totalSeats;
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
