package com.example.employee_bonus.employee_bonus.config;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class CustomLocalDateDeserializer extends JsonDeserializer<LocalDate> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH);

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText();
        // Capitalize the first letter of the month
        if (date.length() >= 3) {
            date = date.substring(0, 1).toUpperCase() + date.substring(1).toLowerCase();
        }
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IOException("Failed to parse LocalDate: " + date, e);
        }
    }
}

