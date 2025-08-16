package com.example.demo.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PassengerService {

    private static Set<String> allowed = Set.of("Alice", "John", "Priya");

    public Set<String> allowList() {
        return allowed;
    }

    public boolean isValidPassenger(final String passengerName) {
        if (StringUtils.isBlank(passengerName)) return false;
        return allowed.contains(passengerName);
    }
}
