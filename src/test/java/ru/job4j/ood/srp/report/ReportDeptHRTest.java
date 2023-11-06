package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportDeptHRTest {

    @Test
    public void whenNameIsDifferentAndSalaryIsDifferent() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("CCC", now, now, 100);
        Employee worker2 = new Employee("AAA", now, now, 200);
        Employee worker3 = new Employee("BBB", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportDeptHR(store);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker3.getName() + " "
                + worker3.getSalary()
                + System.lineSeparator()
                + worker2.getName() + " "
                + worker2.getSalary()
                + System.lineSeparator()
                + worker1.getName() + " "
                + worker1.getSalary()
                + System.lineSeparator();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }

    @Test
    public void whenNameIsDifferentAndSalaryIsEqual() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("BBB", now, now, 100);
        Employee worker2 = new Employee("BBB", now, now, 200);
        Employee worker3 = new Employee("AAA", now, now, 200);
        Employee worker6 = new Employee("EEE", now, now, 200);
        Employee worker4 = new Employee("DDD", now, now, 200);
        Employee worker5 = new Employee("CCC", now, now, 300);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        store.add(worker5);
        store.add(worker6);
        Report engine = new ReportDeptHR(store);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker5.getName() + " "
                + worker5.getSalary()
                + System.lineSeparator()
                + worker3.getName() + " "
                + worker3.getSalary()
                + System.lineSeparator()
                + worker2.getName() + " "
                + worker2.getSalary()
                + System.lineSeparator()
                + worker4.getName() + " "
                + worker4.getSalary()
                + System.lineSeparator()
                + worker6.getName() + " "
                + worker6.getSalary()
                + System.lineSeparator()
                + worker1.getName() + " "
                + worker1.getSalary()
                + System.lineSeparator();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}