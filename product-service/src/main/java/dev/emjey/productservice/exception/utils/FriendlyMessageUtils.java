package dev.emjey.productservice.exception.utils;

import dev.emjey.productservice.enums.Language;
import dev.emjey.productservice.exception.enums.IFriendlyMessageCode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
@UtilityClass
public class FriendlyMessageUtils {

    private static final String RESOURCE_BUNDLE_NAME = "FriendlyMessage";
    private static final String SPECIAL_CHARACTER = "__";

    public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode) {
        String messageKey = "";
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode;
            return resourceBundle.getString(messageKey);
        } catch (MissingResourceException missingResourceException) {
            log.error("Friendly message not found for key {}", messageKey, missingResourceException);
            return null;
        }
    }
}
