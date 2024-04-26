package ru.netology.i18n;

import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

public class LocalizationServiceImplTest {
    @Test
    public void localizationServiceTest() {
        String expected = "Добро пожаловать";
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);
        Assert.assertEquals(expected, actual);
    }
}