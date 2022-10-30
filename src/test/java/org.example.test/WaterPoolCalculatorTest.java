package org.example.test;

import org.example.WaterPoolCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WaterPoolCalculatorTest {

    @Test
    public void calculateWaterWithIncreasingHeightLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        //WHEN
        long result = waterPoolCalculator.calculateWaterAmount(landscape);

        //THEN
        assertEquals(0, result);
    }

    @Test
    public void calculateWaterWithDecreasingHeightLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        //WHEN
        long result = waterPoolCalculator.calculateWaterAmount(landscape);

        //THEN
        assertEquals(0, result);
    }

    @Test
    public void calculateWaterUsingPlateLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {5, 5, 5, 5, 5, 5, 5};

        //WHEN
        long result = waterPoolCalculator.calculateWaterAmount(landscape);

        //THEN
        assertEquals(0, result);
    }

    @Test
    public void calculateWaterUsingOneElementLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {5};

        //WHEN
        long result = waterPoolCalculator.calculateWaterAmount(landscape);

        //THEN
        assertEquals(0, result);
    }

    @Test
    public void calculateWaterWithNormalLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};

        //WHEN
        long result = waterPoolCalculator.calculateWaterAmount(landscape);

        //THEN
        assertEquals(9, result);
    }

    @Test
    public void calculateWaterUsingLandscapeWithIncorrectValue() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {1, 2, 3, -1, 3, 2, 1};

        //THEN
        assertThrows(IllegalArgumentException.class, () -> waterPoolCalculator.calculateWaterAmount(landscape));
    }

    @Test
    public void calculateWaterUsingEmptyLandscape() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {};

        //THEN
        assertThrows(IllegalArgumentException.class, () -> waterPoolCalculator.calculateWaterAmount(landscape));
    }

    @Test
    public void calculateWaterUsingNull() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = null;

        //THEN
        assertThrows(IllegalArgumentException.class, () -> waterPoolCalculator.calculateWaterAmount(landscape));
    }

    @Test
    public void calculateWaterUsingOverLimitNumberOfElement() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = new int[WaterPoolCalculator.MAX_NUMBER_OF_ELEMENTS + 1];

        //THEN
        assertThrows(IllegalArgumentException.class, () -> waterPoolCalculator.calculateWaterAmount(landscape));
    }

    @Test
    public void calculateWaterUsingOverLimitHeightOfElement() {
        //GIVEN
        WaterPoolCalculator waterPoolCalculator = new WaterPoolCalculator();
        int[] landscape = {WaterPoolCalculator.MAX_HEIGHT + 1};

        //THEN
        assertThrows(IllegalArgumentException.class, () -> waterPoolCalculator.calculateWaterAmount(landscape));
    }

}
