package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list.");
        }
        cities.add(city);
    }

    /**
     * Checks if a given city exists in the list
     *
     * @param city city to search for
     * @return true if the city is in the list otherwise false
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes a city from the list if present
     *
     * @param city city to remove
     * @throws IllegalArgumentException if the city is not found in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found in the list.");
        }
    }
    public int countCities() {
        return cities.size();
    }
    public List<City> getCities() {
        List<City> copy = new ArrayList<>(cities);
        Collections.sort(copy);
        return copy;
    }
}

