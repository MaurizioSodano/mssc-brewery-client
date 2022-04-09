package com.example.msscbreweryclient.client;

import com.example.msscbreweryclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveBeer() {
        BeerDto beerDto =BeerDto.builder().id(UUID.randomUUID()).beerName("Corona").build();

        var uri=client.saveBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto =BeerDto.builder().id(UUID.randomUUID()).beerName("Corona").build();
        client.updateBeer(beerDto.getId(),beerDto);
    }
}