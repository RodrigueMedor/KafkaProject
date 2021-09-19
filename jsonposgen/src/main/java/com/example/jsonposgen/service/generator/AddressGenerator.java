package com.example.jsonposgen.service.generator;

import com.example.jsonposgen.domain.DeliveryAddress;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
public class AddressGenerator {
    private final Random random;
    private final DeliveryAddress[] deliveryAddresses;

    public AddressGenerator(){
        final String DATAFILE = "src/main/resources/data/address.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper =  new ObjectMapper();
        try{
            deliveryAddresses = mapper.readValue(new File(DATAFILE), DeliveryAddress[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex(){
        return random.nextInt(100);
    }

    public DeliveryAddress getNextAddress(){
        return deliveryAddresses[getIndex()];
    }
}
