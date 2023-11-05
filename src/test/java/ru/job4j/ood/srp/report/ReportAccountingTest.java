package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportAccountingTest {

    @Test
    void generateAccountingEuroToRub() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100D);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportAccounting(store, parser, new InMemoryCurrencyConverter(),
                Currency.EUR, Currency.RUB);
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + worker.getName() + " "
                + parser.parse(worker.getHired()) + " "
                + parser.parse(worker.getFired()) + " "
                + "9849.0"
                + System.lineSeparator();
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}