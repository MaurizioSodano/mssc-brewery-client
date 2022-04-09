package com.example.msscbreweryclient.client;

import com.example.msscbreweryclient.model.CustomerDto;
import com.example.msscbreweryclient.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {
    private final String CUSTOMER_PATH_V1 ="/api/v1/customer/";
    private final RestTemplate restTemplate;

    private String apihost;
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(apihost+ CUSTOMER_PATH_V1 +uuid.toString(),CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto) {
        return  restTemplate.postForLocation(apihost+ CUSTOMER_PATH_V1,customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto beerDto){
        restTemplate.put(apihost+ CUSTOMER_PATH_V1 +uuid.toString(),beerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost+ CUSTOMER_PATH_V1 +uuid.toString());
    }
}
