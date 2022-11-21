package workload;

import models.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EmployeeService {
    @Inject
    EmployeeRepository repo;

    /**
     * get all employees
     * @return return a list of all employees
     */
    public List<Employee> findAll() {
        return repo.findAll().list();
    }

    /**
     * get an employee by id
     * @param employeeId id of the employee
     * @return returns the desired employee
     */
    public Employee findById(Long employeeId) {
        return repo.findById(employeeId);
    }

    /**
     * updates an employee entity
     * @param employee to be updated employee object
     * @return returns the updated employee object
     */
    public Employee updateET(Employee employee) {
        return repo.updateET(employee);
    }
}
