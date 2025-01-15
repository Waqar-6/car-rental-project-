package com.w_farooq_group.vehicle.mapper;

import com.w_farooq_group.vehicle.dto.CarDto;
import com.w_farooq_group.vehicle.dto.VanDto;
import com.w_farooq_group.vehicle.entity.Car;
import com.w_farooq_group.vehicle.entity.Van;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertCarDtoEquals(car, carDto);

    }

    @DisplayName("mapToVanDtoTest")
    @Test
    public void testMapToVanDto_whenVanEntity_shouldReturnVanDtoObject () {

        // Arrange
        UUID id = UUID.randomUUID();
        Van van = new Van(id, "Vauxhall", "Vivaro", "WM20 JDH", "Diesel", 178.20, true, true, 120);

        // Act
        VanDto vanDto = VehicleMapper.mapToVanDto(van, new VanDto());

        // Assert
        assertVanDtoEquals(van, vanDto);
    }

    @DisplayName("mapToCar")
    @Test
    public void testMapToCar_whenCarDto_shouldReturnCarObject () {
        // Arrange
        CarDto carDto = new CarDto(null, "BMW", "5 series", "bmw22 pff", "petrol", 120.20, true, (byte)2, "SEDAN");
        // Act

        Car car = VehicleMapper.mapToCar(carDto, new Car());
        // Assert
        assertCarEquals(carDto, car);
    }

    private void assertCarDtoEquals (Car expected, CarDto actual) {
        assertEquals(expected.getBrand(), actual.getBrand(), () -> message("Brand", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getModel(), actual.getModel(), () -> message("Modal", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getReg(), actual.getReg() , () -> message("Reg", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getNumDoors(), actual.getNumDoors() , () -> message("NumDoors", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getClassCategory(), actual.getClassCategory() ,() -> message("Class Category", expected.getBrand(), actual.getBrand()));
    }

    private void assertVanDtoEquals (Van expected, VanDto actual) {
        assertEquals(expected.getBrand(), actual.getBrand(), () -> message("Brand", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getModel(), actual.getModel(), () -> message("Modal", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getReg(), actual.getReg() , () -> message("Reg", expected.getReg(), actual.getReg()));
        assertTrue(actual.isAvailable(), () -> message("Availability", true, actual.isAvailable()));
        assertTrue(actual.isHasTailLift(), () -> message("Tail Lift", expected.isHasTailLift(), actual.isHasTailLift()));
        assertEquals(expected.getWeightLimit(), actual.getWeightLimit() , () -> message("tail lift", expected.getWeightLimit(), actual.getWeightLimit()));
    }


    private void assertCarEquals (CarDto expected, Car actual) {
        assertEquals(expected.getBrand(), actual.getBrand(), () -> message("Brand", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getModel(), actual.getModel(), () -> message("Modal", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getReg(), actual.getReg() , () -> message("Reg", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getNumDoors(), actual.getNumDoors() , () -> message("NumDoors", expected.getBrand(), actual.getBrand()));
        assertEquals(expected.getClassCategory(), actual.getClassCategory() ,() -> message("Class Category", expected.getBrand(), actual.getBrand()));
    }

    private <T> String message (String testFor, T expectedResult, T actualResult) {
        return "test failed for " + testFor +   " as actual result : " + actualResult + " does not equal expected result : " + expectedResult;
    }

}
