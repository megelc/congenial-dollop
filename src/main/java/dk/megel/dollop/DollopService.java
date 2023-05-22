package dk.megel.dollop;

import dk.megel.dollop.model.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DollopService {

    private final MessageSource messageSource;

    public Info getInfo(Locale locale) {
        return new Info(String.format("%s %s", messageSource.getMessage("msg.info.description",null, locale), Instant.now().toString()));
    }
}
