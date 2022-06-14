package de.firma.client;

import org.springframework.web.client.RestTemplate;

public class SimplestGetExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";
    //static final String URL_EMPLOYEES = "https://swapi.dev/api/people/1/";



    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);

        System.out.println(result);
    }
}
