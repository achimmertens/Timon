package de.firma.client;

import de.firma.model.Employee;
import org.springframework.web.client.RestTemplate;

public class SimplestGetPOJOExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);

        if (list != null) {
            for (Employee e : list) {
                System.out.println("Employee: " + e.getEmpNo() + " - " + e.getEmpName());
            }
        }
    }
}
