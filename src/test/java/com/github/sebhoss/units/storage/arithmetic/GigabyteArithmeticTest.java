/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.units.storage.Gigabyte;
import com.github.sebhoss.units.storage.StorageUnit;
import com.github.sebhoss.units.storage.StorageUnits;

/**
 * Tests for arithmetic operations with {@link Gigabyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class GigabyteArithmeticTest {

    /**
     * Checks that {@link Gigabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(1);

        // When
        final Gigabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(1);

        // When
        unit = unit.add(StorageUnits.gigabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 gigabytes should be '2.00 GB'.", "2.00 GB", unit.toString());
    }

    /**
     * Checks that {@link Gigabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(1);

        // When
        final Gigabyte second = first.add(StorageUnits.gigabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(1);

        // When
        unit = unit.add(StorageUnits.gigabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 GB' + '1.00 GB' should be '2.00 GB'.", "2.00 GB", unit.toString());
    }

    /**
     * Checks that {@link Gigabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(1);

        // When
        final Gigabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 GB' / 5 should be '0.20 GB'.", "0.20 GB", unit.toString());
    }

    /**
     * Checks that {@link Gigabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(1);

        // When
        final Gigabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 GB' and 5 should be '5.00 GB'.", "5.00 GB", unit.toString());
    }

    /**
     * Checks that {@link Gigabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(10);

        // When
        final Gigabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(10);

        // When
        unit = unit.subtract(StorageUnits.gigabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 gigabytes and 1 gigabyte should be '9.00 GB'.", "9.00 GB",
                unit.toString());
    }

    /**
     * Checks that {@link Gigabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Gigabyte first = StorageUnits.gigabyte(10);

        // When
        final Gigabyte second = first.subtract(StorageUnits.gigabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Gigabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Gigabyte unit = StorageUnits.gigabyte(10);

        // When
        unit = unit.subtract(StorageUnits.gigabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 GB' and '1.00 GB' should be '9.00 GB'.", "9.00 GB",
                unit.toString());
    }

}
