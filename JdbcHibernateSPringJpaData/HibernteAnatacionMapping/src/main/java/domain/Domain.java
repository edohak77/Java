package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AddressRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vserdiuk on 2/5/17.
 */
public class Domain {

    public static void main( String[] args ) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AddressRepository addressRepository = context.getBean(AddressRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);

        Address address = new Address();
        address.setId(1L);
        address.setCountry("AM");
        address.setCity("Yerevan");
        address.setStreet("Vilnyus street 1");
        address.setPostCode("12345");


        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Eduard");
        employee.setLastName("Hakobyan");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1977, Calendar.MARCH, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setId(1L);
        project.setTitle("1111");

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

//        addressService.add(address);
//        employeeService.add(employee);
//        projectService.add(project);

//        Address a = addressService.getById(1L);
//        System.out.println(a);

        addressRepository.save(address);
        employeeRepository.save(employee);
        projectRepository.save(project);

        List<Employee>employeeList = employeeRepository.findAll();

        System.out.println("-----findAll()--------");
        for (Employee e:employeeList) {
            System.out.println(e);
        }
//        System.out.println("-----findOne()--------");
//        Employee employee1 = employeeRepository.findOne(1L);

//        System.out.println("-----findByLastName()--------");
//        System.out.println(employeeRepository.fiindByLastName("Hakobyan"));


//        System.out.println("-----findByFirstNameAndLastName()--------");
//        System.out.println(employeeRepository.findByFirstNameAndLastName("Eduard", "Hakobyan"));

        System.out.println("-------findById-----------");
        System.out.println(employeeRepository.findById(1L));
        HibernateUtil.shutdown();
    }

}
