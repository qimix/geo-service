package ru.netology.geo;

import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

public class GeoServiceImplTest {
    @Test
    public void geoServiceTest(){
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("172.0.32.11");
        Assert.assertEquals(expected.getCountry(), actual.getCountry());
    }
}