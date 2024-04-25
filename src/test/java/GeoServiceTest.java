import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceTest {
    @Test
    public void geoServiceTest(){
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("172.0.32.11");
        Assert.assertEquals(expected.getCountry(), actual.getCountry());
    }
}
