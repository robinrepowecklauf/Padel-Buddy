package com.danielkarlkvist.padelbuddy;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GameTests {
    @Test
    public void getDate(){
        Date date = new Date();
        System.out.println(date.toString());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM hh:mm");
        String formattedDate = df.format(date);
        System.out.println(formattedDate);
    }
}
