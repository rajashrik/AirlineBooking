package com.airline;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rajashrk on 8/11/17.
 */
public class RateCalculator {

    public Double getPrice(Flight flight, String classType, Integer numberOfSeatsToBook) {
        return flight.getBasePrice(classType) * numberOfSeatsToBook;
    }


    public Map<String, Double> getPriceMap(List<Flight> flights, String classType, int numberOfSeats) {
        Map<String, Double> priceMap = flights.stream().collect(Collectors.toMap(Flight::getNumber, flight -> getPrice(flight,classType,numberOfSeats)));
        return priceMap;
    }

}
