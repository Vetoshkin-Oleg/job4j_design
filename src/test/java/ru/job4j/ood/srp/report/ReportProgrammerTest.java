package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportProgrammerTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("BBB", now, now, 100);
        Employee worker2 = new Employee("CCC", now, now, 300);
        Employee worker3 = new Employee("AAA", now, now, 200);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        String delimiter = ",";
        Report engine = new ReportProgrammer(store, parser, delimiter);
        String expect = "Name" + delimiter + "Hired" + delimiter + "Fired" + delimiter + "Salary" + delimiter
                + System.lineSeparator()
                + worker1.getName() + delimiter + parser.parse(worker1.getHired()) + delimiter
                + parser.parse(worker1.getFired()) + delimiter + worker1.getSalary() + delimiter
                + System.lineSeparator()
                + worker2.getName() + delimiter + parser.parse(worker2.getHired()) + delimiter
                + parser.parse(worker2.getFired()) + delimiter + worker2.getSalary() + delimiter
                + System.lineSeparator()
                + worker3.getName() + delimiter + parser.parse(worker3.getHired()) + delimiter
                + parser.parse(worker3.getFired()) + delimiter + worker3.getSalary() + delimiter
                + System.lineSeparator();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}