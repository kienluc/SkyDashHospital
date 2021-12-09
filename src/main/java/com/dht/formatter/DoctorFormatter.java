package com.dht.formatter;

import com.dht.pojo.Doctor;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DoctorFormatter implements Formatter<Doctor> {
    @Override
    public Doctor parse(String s, Locale locale) throws ParseException {
        Doctor d = new Doctor();
        d.setId(s);
        return d;
    }

    @Override
    public String print(Doctor doctor, Locale locale) {
        return doctor.getName();
    }
}
