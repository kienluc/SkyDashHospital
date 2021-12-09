package com.dht.formatter;

import com.dht.pojo.Shift;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ShiftFormatter implements Formatter<Shift> {

    @Override
    public Shift parse(String s, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Shift shift, Locale locale) {
        return null;
    }
}
