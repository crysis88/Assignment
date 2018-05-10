package com.assignment.repository;

import com.assignment.model.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class EmployeeRepository {


    public Employee getEmployee(int id) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession()) {
            Employee employee = session.selectOne("com.assignment.model.Employee.selectEmployee", id);
            return employee;
        } finally {
        }
    }

    public List<Employee> getAllEmployee() {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession()) {
            return session.selectList("com.assignment.model.Employee.selectAllEmployee");
        } finally {
        }
    }


    public Employee updateEmployee(Employee employee) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession()) {
            int count = session.update("com.assignment.model.Employee.updateEmployee", employee);
            if (count > 0) {
                return session.selectOne("com.assignment.model.Employee.selectEmployee", employee.getId());
            } else {
                return null;
            }
        } finally {
        }
    }

    public void deleteEmployee(int id) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession(true)) {
            session.delete("com.assignment.model.Employee.deleteEmployee", id);
        } finally {
        }
    }

    public Employee addEmployee(Employee employee) {
        try (SqlSession session = DatabaseUtility.getSessionFactory().openSession(true)) {
            HashMap<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("id", employee.getId());
            parameterMap.put("name", employee.getName());
            parameterMap.put("designation", employee.getDesignation());

            int count = session.insert("com.assignment.model.Employee.insertEmployee", parameterMap);
            if (count > 0) {
                return session.selectOne("com.assignment.model.Employee.selectEmployee", employee.getId());
            } else {
                return null;
            }
        } finally {
        }
    }

}
