package dk.megel.dollop;

import dk.megel.dollop.config.I18nConfig;
import dk.megel.dollop.model.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Import;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = DollopService.class)
@Import(I18nConfig.class)
public class DollopServiceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void testGetInfo_da() {
        DollopService service = getService();

        Info infoObject = service.getInfo(new Locale("da"));
        assertTrue(infoObject.getMessage().startsWith("Dette er et test info objekt"));
    }

    @Test
    void testGetInfo_default() {
        DollopService service = getService();

        Info infoObject = service.getInfo(Locale.US);
        assertTrue(infoObject.getMessage().startsWith("This is a test info object"));
    }

    @Test
    void testGetInfo_unknown_locale() {
        DollopService service = getService();

        Info infoObject = service.getInfo(new Locale("blablabla"));
        assertTrue(infoObject.getMessage().startsWith("This is a test info object"));
    }

    DollopService getService() {
        return new DollopService(messageSource);
    }
}
