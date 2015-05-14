package com.company.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sasha on 4/28/15.
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BORN_DATE")
    private Date born;
    public Employee() {

    }
    public Employee( String name, String lastname, Date born) {
        this.name = name;
        this.lastname = lastname;
        this.born = born;
    }

    public long getId() {
        return id;
    }


    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", born=" + born +
                "}\n";
    }
}
