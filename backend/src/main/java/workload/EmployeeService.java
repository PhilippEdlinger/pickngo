package workload;

import models.Employee;

import javax.inject.Inject;
import java.util.List;

public class EmployeeService {
    @Inject
    EmployeeRepository repo;

    public List<Employee> findAll() {
        return repo.findAll().list();
    }


    public Employee findById(Long employeeId) {
        return repo.findById(employeeId);
    }

    public Employee updateET(Employee employee) {
        return repo.updateET(employee);
    }
}
