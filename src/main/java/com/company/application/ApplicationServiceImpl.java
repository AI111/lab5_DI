package com.company.application;

import com.company.domain.Employee;
import com.company.domain.EmployeeRepository;
import com.company.domain.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sasha on 4/28/15.
 */
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    EmployeeRepository repository;

    public int concatUserName3() {
        int count=0;
        List<Employee> list= repository.getAllEmployees();
        for(Employee employee:list){
            if(employee.getName().startsWith("E")){
                employee.setName(employee.getName()+"_3");
                repository.editEmployee(employee);
                count++;
            }
        }
        return count;
    }

    public List<Employee> getAllEmployeesWithRepeatedNames() {
        //полная хуйня
        //но мозг уже отрубился
        List<Employee> answer = new ArrayList<Employee>();
        List<Employee> list = repository.getAllEmployees();
        boolean[] aded = new boolean[list.size()];
        boolean repeat=false;
        Arrays.fill(aded,false);
        for (int i = 0; i < list.size() ; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i!=j&&!aded[i]&&list.get(i).getName().equals(list.get(j).getName())){
                    if(!repeat)answer.add(list.get(i));
                    repeat=true;
                    answer.add(list.get(j));
                    aded[j]=true;

                }
            }
            repeat =false;
        }
        return answer;
    }
}
