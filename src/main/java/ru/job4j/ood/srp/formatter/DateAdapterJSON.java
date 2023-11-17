package ru.job4j.ood.srp.formatter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAdapterJSON implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(formatter.format(calendar.getTime()));
    }

    @Override
    public Calendar deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = formatter.parse(String.valueOf(jsonElement));
            calendar.setTime(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return calendar;
    }
}
