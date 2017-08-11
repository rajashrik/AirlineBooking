package com.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by rajashrk on 8/11/17.
 */
public class RateCalculatorTest {

    private Plane plane;
    private Calendar departure;
    List<Flight> flights = new ArrayList<Flight>();
    Flight flight1;
    Flight flight2;
    Flight flight3;
    SearchDetails searchDetails;


    @Before
    public void setUp() throws Exception {
        plane = new Plane("Airbus A319 V2",70);
        departure = new GregorianCalendar(2017,0,1,1,2,3);

        List<TravelClass> travelClassesList = new ArrayList<TravelClass>();
        TravelClass travelClassEconomy = new TravelClass(ClassType.ECONOMY,10,6000.0);
        TravelClass travelClassBusiness = new TravelClass(ClassType.BUSINESS,10,13000.0);
        TravelClass travelClassFirst = new TravelClass(ClassType.FIRST,10,20000.0);
        travelClassesList.add(travelClassBusiness);
        travelClassesList.add(travelClassEconomy);
        travelClassesList.add(travelClassFirst);

        flight1 = new Flight("Pune", "Kolkata",plane,"F1",departure,departure,travelClassesList);
        flight2 = new Flight("Pune", "Kolkata",plane,"F2",departure,departure,travelClassesList);
        flight3 = new Flight("Hyderabad", "Nashik",plane,"F3",departure,departure,travelClassesList);

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);

        searchDetails = new SearchDetails();
        searchDetails.setTo("Kolkata");
        searchDetails.setFrom("Pune");
        searchDetails.setDepartureDate("2017-01-01");
        searchDetails.setNumberOfPassengers(10);
        searchDetails.setClassType("Economy");
    }

    @Test
    public void shouldReturnCorrectPrice() throws Exception {
        Double expectedValueForEconomyClass = 12000.0;
        Double expectedValueForBusinessClass = 26000.0;
        Double expectedValueForFirstClass = 40000.0;
        Assert.assertEquals(expectedValueForEconomyClass,new RateCalculator().getPrice(flight1,"Economy",2));
        Assert.assertEquals(expectedValueForBusinessClass,new RateCalculator().getPrice(flight1,"business",2));
        Assert.assertEquals(expectedValueForFirstClass,new RateCalculator().getPrice(flight1,"first",2));
    }


    @Test
    public void shouldReturnCorrectPriceMap() throws Exception {
        Double expectedFlightPriceValue = 12000.0;
        Map<String, Double> priceMap = new RateCalculator().getPriceMap(flights, "Economy", 2);
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F1"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F2"));
        Assert.assertEquals(expectedFlightPriceValue, priceMap.get("F3"));
    }
}
