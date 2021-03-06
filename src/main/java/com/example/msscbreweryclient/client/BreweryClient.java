package com.example.msscbreweryclient.client;

import com.example.msscbreweryclient.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {
    private final String BEER_PATH_V1="/api/v1/beer/";
    private final RestTemplate restTemplate;

    private String apihost;
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apihost+BEER_PATH_V1+beerId.toString(),BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return  restTemplate.postForLocation(apihost+BEER_PATH_V1,beerDto);
    }

    public void updateBeer(UUID beerId, BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1+beerId.toString(),beerDto);
    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost+BEER_PATH_V1+beerId.toString());
    }
}
