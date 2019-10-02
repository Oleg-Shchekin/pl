package com.os.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    private static final String LOCAL_PHONE_REGEX = "380(\\d{9})";

    /**
     * This static method checks if the entered phone number matches the regular expression
     *
     * @param enteredPhone
     * @return boolean
     */

    public static boolean isPhoneUkrLocal(String enteredPhone) {
        Pattern phonePattern = Pattern.compile(LOCAL_PHONE_REGEX);
        Matcher phoneMatcher = phonePattern.matcher(enteredPhone);
        return phoneMatcher.find();
    }

    /**
     * Returns the regular expression for local phone matcher
     *
     * @return the regEx for local phone matcher
     */

    public static String getLocalPhoneRegex() {
        return LOCAL_PHONE_REGEX;
    }
}
