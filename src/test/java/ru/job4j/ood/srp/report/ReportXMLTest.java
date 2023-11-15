package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportXMLTest {

    @Test
    public void whenXMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("AAA", now, now, 200);
        Employee worker2 = new Employee("BBB", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportXML(store, parser);
        String expect = String.format("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employee>
                                <name>%s</name>
                                <hired>%s</hired>
                                <fired>%s</fired>
                                <salary>%s</salary>
                            </employee>
                            <employee>
                                <name>%s</name>
                                <hired>%s</hired>
                                <fired>%s</fired>
                                <salary>%s</salary>
                            </employee>
                        </employees>
                        """,
                worker1.getName(), parser.parse(worker1.getHired()), parser.parse(worker1.getFired()), worker1.getSalary(),
                worker2.getName(), parser.parse(worker2.getHired()), parser.parse(worker2.getFired()), worker2.getSalary());
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}