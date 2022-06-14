package de.firma.client;

import de.firma.model.Account;
import de.firma.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class my_Post_postForObject_Example {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";
    static final String URL_CREATE_ACCOUNT = "http://raspi:9200/api/account";
    public static void main(String[] args) {


        Account newAccount = new Account("28","Karl Toffel","ktoffl","2022-06-14T06:26:01.489+00:00");


        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.ALL_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentLength(173);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpEntity<Account> requestBody = new HttpEntity<>(newAccount, headers);

        // Send request with POST method.
        Account a = restTemplate.postForObject(URL_CREATE_ACCOUNT, requestBody, Account.class);

        if (a != null && a.getId() != null) {

            System.out.println("Account created: " + a.getId());
        } else {
            System.out.println("Something error!");
        }

    }

}
