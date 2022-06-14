package de.firma.controller;

import java.util.List;

import de.firma.dao.EmployeeDAO;
import de.firma.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
    public class RESTController {

        @Autowired
        private EmployeeDAO employeeDAO ;

        @RequestMapping("/")
        @ResponseBody
        public String welcome() {
            return "Welcome to RestTemplate Example.";
        }

        // READ
        @RequestMapping(value = "/employees", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE, //
                        MediaType.APPLICATION_XML_VALUE})
        @ResponseBody
        public List<Employee> getEmployees() {
            List<Employee> list = employeeDAO.getAllEmployees();
            return list;
        }

        // READ
        @RequestMapping(value = "/employee/{empNo}", //
                method = RequestMethod.GET, //
                produces = { MediaType.APPLICATION_JSON_VALUE, //
                        MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public Employee getEmployee(@PathVariable("empNo") String empNo) {
            return employeeDAO.getEmployee(empNo);
        }

        // CREATE
        @RequestMapping(value = "/employee", //
                method = RequestMethod.POST, //
                consumes = {MediaType.APPLICATION_XML_VALUE}, //
                produces = { MediaType.APPLICATION_JSON_VALUE, //
                        MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public Employee addEmployee(@RequestBody Employee emp) {

            System.out.println("(Service Side) Creating employee: " + emp.getEmpNo());

            return employeeDAO.addEmployee(emp);
        }

        // UPDATE
        @RequestMapping(value = "/employee", //
                method = RequestMethod.PUT, //
                produces = { MediaType.APPLICATION_JSON_VALUE, //
                        MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public Employee updateEmployee(@RequestBody Employee emp) {

            System.out.println("(Service Side) Editing employee: " + emp.getEmpNo());

            return employeeDAO.updateEmployee(emp);
        }

        // DELETE
        @RequestMapping(value = "/employee/{empNo}", //
                method = RequestMethod.DELETE, //
                produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
        @ResponseBody
        public void deleteEmployee(@PathVariable("empNo") String empNo) {

            System.out.println("(Service Side) Deleting employee: " + empNo);

            employeeDAO.deleteEmployee(empNo);
        }

    }
