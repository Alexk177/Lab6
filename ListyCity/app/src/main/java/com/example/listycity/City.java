package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private final String city;
    private final String province;
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }
    public String getCityName() {
        return this.city;
    }
    public String getProvinceName() {
        return this.province;
    }
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}