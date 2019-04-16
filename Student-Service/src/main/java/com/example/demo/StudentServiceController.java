package com.example.demo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
 
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Саша", "Каморов");
        lst.add(std);
        std = new Student("Игорь", "Смирнов ");
        lst.add(std);
 
        schooDB.put("SchoolNumber1", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Виктор", "Сидоров");
        lst.add(std);
        std = new Student("Миша", "Соболев");
        lst.add(std);
 
        schooDB.put("SchoolNumber2", lst);
 
    }
 
    @RequestMapping(value = "/School/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname) {
        System.out.println("Извлечение студента из " + schoolname);
 
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
}