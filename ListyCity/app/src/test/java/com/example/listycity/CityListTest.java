package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });

    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCityTrueWithSameObject() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testHasCityTrueWithEqualDifferentObject() {
        CityList cityList = mockCityList();
        City sameData = new City("Edmonton", "Alberta"); // different object, same fields
        assertTrue(cityList.hasCity(sameData));
    }

    @Test
    void testHasCityFalse() {
        CityList cityList = mockCityList();
        assertFalse(cityList.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDeleteRemovesCity() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));

        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    void testDeleteThrowsIfNotFound() {
        CityList cityList = mockCityList();
        assertThrows(IllegalArgumentException.class, () ->
                cityList.delete(new City("Calgary", "Alberta"))
        );
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
    }
}
