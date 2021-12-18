package ru.gb.gbrest.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class ManufacturerDtoTest {

    @Autowired
    ObjectMapper objectMapper;

    private ManufacturerDto manufacturerDto;

    @BeforeEach
    void setUp() {
        manufacturerDto = ManufacturerDto.builder()
                .id(1L)
                .name("Test Company")
                .build();
    }

    @Test
    void testSerializeDto() throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(manufacturerDto);
        System.out.println(json);
    }

    @Test
    void testDeserializeDto() throws JsonProcessingException {
        String json = "{\"manufacturerId\":1,\"name\":\"Test Company\"}";

        ManufacturerDto testManufacturerDto = objectMapper.readValue(json, ManufacturerDto.class);
        System.out.println(testManufacturerDto);
    }
}