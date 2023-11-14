package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Marshaller marshaller;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            String xml;
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employee, writer);
                xml = writer.getBuffer().toString();
            } catch (IOException | JAXBException e) {
                throw new RuntimeException(e);
            }
            text.append(xml);
        }
        System.out.print(text);
        return text.toString();
    }
}