package com.company;

import com.company.application.ApplicationService;
import com.company.configuration.JavaConfig;
import com.company.domain.Employee;
import com.company.domain.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	// write your code here
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        EmployeeRepository repository = (EmployeeRepository) context.getBean("repository");

//        repository.createEmployee(new Employee("NAME","LAST NAME",new Date()));
//        repository.createEmployee(new Employee("ENAME","LAST NAME",new Date()));
//        repository.createEmployee(new Employee("ENAME","LAST NAME",new Date()));
//        repository.createEmployee(new Employee("ENAME2","LAST NAME",new Date()));
//        repository.createEmployee(new Employee("ENAME3","LAST NAME",new Date()));

        ApplicationService applicationService = (ApplicationService)context.getBean("service");
        List list =applicationService.getAllEmployeesWithRepeatedNames();
        System.out.println(list);
    }
}
