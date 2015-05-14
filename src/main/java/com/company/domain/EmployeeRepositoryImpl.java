package com.company.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sasha on 5/14/15.
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Autowired
    SessionFactory sessionFactory;

    public EmployeeRepositoryImpl() {
    }


    public EmployeeRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Transactional
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }
    @Transactional
    public void createEmployee(List<Employee> employee) {
        for(Employee e:employee)sessionFactory.getCurrentSession().save(e);
    }
    @Transactional
    public Employee getEmployee(long id) {
        return (Employee)  sessionFactory.getCurrentSession().get(Employee.class,id);
    }

    @Transactional
    public void editEmployee(Employee updatedEntity) {
        sessionFactory.getCurrentSession().update(updatedEntity);
    }

    @Transactional
    public void removeEmployee(Employee updatedEntity) {
        sessionFactory.getCurrentSession().delete(updatedEntity);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery( "FROM Employee" ).list();
    }
}
