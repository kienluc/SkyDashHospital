package com.dht.formatter;

import com.dht.pojo.Role;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class RoleFormatter implements Formatter<Role> {
    @Override
    public Role parse(String s, Locale locale) throws ParseException {
        Role role = new Role();
        role.setId(Integer.parseInt(s));
        return role;
    }

    @Override
    public String print(Role role, Locale locale) {
        return role.getRole();
    }
}
