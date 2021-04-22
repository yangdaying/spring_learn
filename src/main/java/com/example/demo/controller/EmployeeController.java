package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    @PostMapping("/saveEMP")
    public Employee one(@RequestBody Employee employee){
        logger.info("print employee info");
        logger.info("employee 's info ->{}",employee.toString());
        Employee newEmp = new Employee();
        newEmp.setId(snowflakeIdWorker.nextId());
        newEmp.setName(employee.getName());
        newEmp.setRole(employee.getRole());
        logger.info("newEmp 's info ->{}",newEmp.toString());
        return employeeService.save(newEmp);

    }

    @GetMapping("/getOneById/{id}")
    public Employee getOneById(@PathVariable Long id){

        logger.info("start getOne");
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        logger.info("getHostAddress_"+inetAddress.getHostAddress());
        logger.info("getAddress_"+inetAddress.getAddress());
        logger.info("getHostName_"+inetAddress.getHostName());
        logger.info("getCanonicalHostName_"+inetAddress.getCanonicalHostName());
        return employeeService.findOneByid(id);
    };

    @DeleteMapping("/deleteOneById/{id}")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteByid(id);
    }


    @RequestMapping("/getIndex")
    public String getSomething(){

        return "index";
    }

}
