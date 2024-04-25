import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTestLangUs {
    @Test
    public void testLocalizationService() {
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(Country.USA);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-real-ip", "96.44.183.149");

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(headers.get("x-real-ip"))).thenReturn(location);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headers);
        Assert.assertEquals("Welcome", actual);
    }
}

