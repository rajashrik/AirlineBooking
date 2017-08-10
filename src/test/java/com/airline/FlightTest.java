package com.airline;

import java.util.Calendar;
import java.util.GregorianCalendar;

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

    @Before
    public void setUp() throws Exception {
        source = "Pune";
        destination = "Kolkata";
        plane = new Plane("Airbus A319 V2",70);
        departure = new GregorianCalendar(2017,0,1,1,2,3);
    }

    @Test
    public void shouldHaveSourceAndDestination() throws Exception {
        Flight flight = new Flight(source,destination,plane,"F12",departure,departure);
        Assert.assertEquals(flight.getDestination(),"Kolkata");
        Assert.assertEquals(flight.getSource(),"Pune");
    }

}
