package com.airline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by rajashrk on 8/10/17.
 */
public class SearchDetailsTest {

    private String from;
    private String to;
    private Calendar departureDate;

    @Before
    public void setUp() throws Exception {
        from = "Pune";
        to = "Hyderabad";
        departureDate = new GregorianCalendar(2017, 1, 1, 0, 0, 0);
    }

    @Test
    public void shouldSetDateCorrectFromStringDate() throws Exception {
        SearchDetails details = new SearchDetails();
        details.setDepartureDate("2017-09-10");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Assert.assertEquals(dateFormat.format(details.getDepartureDate().getTime()),"20170910");
    }
}
