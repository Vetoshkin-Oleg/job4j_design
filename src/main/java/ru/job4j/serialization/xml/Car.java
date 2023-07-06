package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Car {
    public static void main(String[] args) throws Exception {
        Porsche porsche = new Porsche(true, 2497,
                "Gasoline", new Engine("MDJ.UA, MDJ.UB, MDP.HB"),
                new String[] {"Horizontally opposed, 4-cylinder", "Turbine"});
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Porsche.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(porsche, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            Porsche result = (Porsche) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}