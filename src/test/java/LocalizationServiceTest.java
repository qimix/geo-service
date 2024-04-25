import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    @Test
    public void localizationServiceTest() {
        String expected = "Добро пожаловать";
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(location.getCountry());
        Assert.assertEquals(expected, actual);
    }

}
