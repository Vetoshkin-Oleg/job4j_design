package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportDeptHR implements Report {

    private final Store store;

    public ReportDeptHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = sortedEmployees(store, filter);
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static List<Employee> sortedEmployees(Store store, Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        return employees.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
    }
}