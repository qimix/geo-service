import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {
    @Test
    public void testLocalizationService() {
        Country country = Mockito.mock(Country.class);
        Mockito.when(Country.RUSSIA).thenReturn(Country.RUSSIA);

        Location location = Mockito.mock(Location.class);
        Mockito.when(location).thenReturn(location);
        Mockito.when(location.getCountry()).thenReturn(Country.RUSSIA);

        Map<String, String> headers = Mockito.mock(HashMap.class);
        Mockito.when(headers.get("IP_ADDRESS_HEADER")).thenReturn("172.0.32.11");

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(headers.get(headers.get("IP_ADDRESS_HEADER")))).thenReturn(location);

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService,localizationService);
        messageSender.send(headers);
    }
}
