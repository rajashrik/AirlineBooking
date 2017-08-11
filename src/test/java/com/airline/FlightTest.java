package com.airline;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rajashrk on 8/10/17.
 */
public class FlightTest {
    private String source;
    private String destination;
    private Plane plane;
    private Calendar departure;
    private TravelClass travelClassEconomy;
    private TravelClass travelClassBusiness;
    private TravelClass travelClassFirst;
    private List<TravelClass> travelClassesList = new ArrayList<TravelClass>();

    @Before
    public void setUp() throws Exception {
        source = "Pune";
        destination = "Kolkata";
        plane = new Plane("Airbus A319 V2",70);
        departure = new GregorianCalendar(2017,0,1,1,2,3);
        travelClassEconomy = new TravelClass(ClassType.ECONOMY,10);
        travelClassBusiness = new TravelClass(ClassType.BUSINESS,10);
        travelClassFirst = new TravelClass(ClassType.FIRST,10);
        travelClassesList.add(travelClassBusiness);
        travelClassesList.add(travelClassEconomy);
        travelClassesList.add(travelClassFirst);
    }

    @Test
    public void shouldHaveSourceAndDestination() throws Exception {
        Flight flight = new Flight(source,destination,plane,"F12",departure,departure, travelClassesList);
        Assert.assertEquals("Kolkata", flight.getDestination());
        Assert.assertEquals("Pune", flight.getSource());
    }

    @Test
    public void shouldReturnTrueIfFlightCanBeBooked() throws Exception {
        boolean expected = true;
        Flight flight = new Flight(source,destination,plane,"F12",departure,departure, travelClassesList);
        Assert.assertEquals(expected, flight.bookFlight(ClassType.ECONOMY.toString(),10));
    }

    @Test
    public void shouldReturnFalseIfFlightCannotBeBooked() throws Exception {
        boolean expected = false;
        Flight flight = new Flight(source,destination,plane,"F12",departure,departure, travelClassesList);
        Assert.assertEquals(expected, flight.bookFlight(ClassType.ECONOMY.toString(),12));
    }
}
