package ru.skypro.lessons.springboot.weblibrary.pojo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesWithSalaryGreaterThan(int salary);
    @Query("SELECT e FROM Employee e")
    List<Employee> findAllEmployees();
    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2)")
    List<Employee> findEmployeesWithHighestSalary();
    @Query("SELECT e FROM Employee e WHERE e.position = ?1")
    List<Employee> findEmployeesByPosition(String position);
    @Query(value = "SELECT * FROM Employee ORDER BY id LIMIT ?1, ?2", nativeQuery = true)
    List<Employee> findEmployeesByPage(int offset, int pageSize);
}
