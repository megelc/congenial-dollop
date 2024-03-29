package dk.megel.dollop;

import dk.megel.dollop.model.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DollopController {

    private final DollopService service;

    @GetMapping("/info")
    public Info getInfo(@RequestHeader(value = "Accept-Language", required = false) String localeString) {
        Locale locale = new Locale(localeString);
        return service.getInfo(locale);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        log.info("Controller started");
    }
}
