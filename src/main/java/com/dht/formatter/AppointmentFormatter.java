package com.dht.formatter;

import com.dht.pojo.Appointment;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AppointmentFormatter implements Formatter<Appointment> {
    @Override
    public Appointment parse(String s, Locale locale) throws ParseException {
        Appointment a = new Appointment();
        a.setId(Integer.parseInt(s));
        return a;
    }

    @Override
    public String print(Appointment appointment, Locale locale) {
        return appointment.getName();
    }
}
