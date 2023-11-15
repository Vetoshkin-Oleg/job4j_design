package ru.job4j.ood.srp.formatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Calendar> {

    private static final String CUSTOM_FORMAT_STRING = "dd:MM:yyyy HH:mm";

    @Override
    public String marshal(Calendar v) {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v.getTime());
    }

    @Override
    public Calendar unmarshal(String v) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(CUSTOM_FORMAT_STRING);
        Date date = sdf.parse(v);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}