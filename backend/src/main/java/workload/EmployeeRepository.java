package workload;

import models.Employee;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository extends Repository<Employee, Long> {
}
