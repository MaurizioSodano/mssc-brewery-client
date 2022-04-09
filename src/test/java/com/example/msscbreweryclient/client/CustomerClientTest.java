package com.example.msscbreweryclient.client;

import com.example.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto beerDto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDto beerDto =CustomerDto.builder().name("Pippo").build();

        var uri=client.saveCustomer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto beerDto =CustomerDto.builder().name("Pippo").build();
        client.updateCustomer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}