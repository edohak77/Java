package repository;

import entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query(value = "select * from Employee where FIRST_NAME=?1 and LAST_NAME=?2",nativeQuery = true)
//    Employee findByFirstNameAndLastName(String firstName, String lastName);
//
//    Employee fiindByLastName(String lastName);
//
//    Employee findOne(long l);
}
