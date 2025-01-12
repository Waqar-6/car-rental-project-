package com.w_farooq_group.vehicle.mapper;

import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.vehicle.dto.VanDto;
import com.w_farooq_group.vehicle.entity.Car;
import com.w_farooq_group.vehicle.entity.Van;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleMapperTest {


    @DisplayName("mapToCarDtoTest")
    @Test
    public void testMapToCarDto_whenCarEntity_shouldReturnCardDtoObject () {

        // Arrange
        UUID id = UUID.randomUUID();
        Car car = new Car(id , "BMW", "5 series", "bmw22 pff", "petrol", 120.20, true, (byte)2, "SEDAN");

        // Act
        CarDto carDto = VehicleMapper.mapToCarDto(car, new CarDto());

        // Assert
        assertEquals(car.getBrand(), carDto.getBrand(), () -> message("Brand", car.getBrand(), carDto.getBrand()));
        assertEquals(car.getModel(), carDto.getModel(), () -> message("Modal", car.getBrand(), carDto.getBrand()));
        assertEquals(car.getReg(), carDto.getReg() , () -> message("Reg", car.getBrand(), carDto.getBrand()));
        assertEquals(car.getNumDoors(), carDto.getNumDoors() , () -> message("NumDoors", car.getBrand(), carDto.getBrand()));
        assertEquals(car.getClassCategory(), carDto.getClassCategory() ,() -> message("Class Category", car.getBrand(), carDto.getBrand()));
    }

    @DisplayName("mapToVanDtoTest")
    @Test
    public void testMapToVanDto_whenVanEntity_shouldReturnVanDtoObject () {

        // Arrange
        UUID id = UUID.randomUUID();
        Van van = new Van(id, "Vauxhall", "Vivaro", "WM20 JDH", "Disel", 178.20, true, true, 120);

        // Act
        VanDto vanDto = VehicleMapper.mapToVanDto(van, new VanDto());

        // Assert
        assertEquals(van.getBrand(), vanDto.getBrand(), () -> message("Brand", van.getBrand(), vanDto.getBrand()));
        assertEquals(van.getModel(), vanDto.getModel(), () -> message("Modal", van.getBrand(), vanDto.getBrand()));
        assertEquals(van.getReg(), vanDto.getReg() , () -> message("Reg", van.getBrand(), vanDto.getBrand()));
        assertEquals(van.isHasTailLift(), vanDto.isHasTailLift() , () -> message("tail lift", van.isHasTailLift(), vanDto.isHasTailLift()));
        assertEquals(van.getWeightLimit(), vanDto.getWeightLimit() , () -> message("tail lift", van.getWeightLimit(), vanDto.getWeightLimit()));
    }

    private <T> String message (String testFor, T expectedResult, T actualResult) {
        return "test failed for " + testFor +   " as actual result : " + actualResult + " does not equal expected result : " + expectedResult;
    }

}
