package com.dht.formatter;

import com.dht.pojo.Department;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DepartmentFormatter implements Formatter<Department> {
    @Override
    public Department parse(String s, Locale locale) throws ParseException {
        Department department = new Department();
        department.setId(s);
        return department;
    }

    @Override
    public String print(Department department, Locale locale) {
        return department.getName();
    }
}
