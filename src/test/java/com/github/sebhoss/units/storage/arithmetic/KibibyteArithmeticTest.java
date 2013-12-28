/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage.arithmetic;

import com.github.sebhoss.units.storage.Kibibyte;
import com.github.sebhoss.units.storage.StorageUnit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for arithmetic operations with {@link Kibibyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class KibibyteArithmeticTest {

    /**
     * Checks that {@link Kibibyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.add(1024);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.add(1024);

        // Then
        Assert.assertEquals("The sum of 1024 + 1024 bytes should be '2.00 KiB'.", "2.00 KiB", unit.toString());
    }

    /**
     * Checks that {@link Kibibyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.add(Kibibyte.valueOf(1024));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.add(Kibibyte.valueOf(1024));

        // Then
        Assert.assertEquals("The sum of '1.00 KiB' + '1.00 KiB' should be '2.00 KiB'.", "2.00 KiB", unit.toString());
    }

    /**
     * Checks that {@link Kibibyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 KiB' / 5 should be '0.20 KiB'.", "0.20 KiB", unit.toString());
    }

    /**
     * Checks that {@link Kibibyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 KiB' and 5 should be '5.00 KiB'.", "5.00 KiB", unit.toString());
    }

    /**
     * Checks that {@link Kibibyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.subtract(1024);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.subtract(100);

        // Then
        Assert.assertEquals("The difference between 1024 bytes and 100 bytes should be '0.90 KiB'.", "0.90 KiB",
                unit.toString());
    }

    /**
     * Checks that {@link Kibibyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Kibibyte first = Kibibyte.valueOf(1024);

        // When
        final Kibibyte second = first.subtract(Kibibyte.valueOf(1024));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kibibyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Kibibyte unit = Kibibyte.valueOf(1024);

        // When
        unit = unit.subtract(Kibibyte.valueOf(100));

        // Then
        Assert.assertEquals("The difference between '1.00 KiB' and '0.10 KiB' should be '0.90 KiB'.", "0.90 KiB",
                unit.toString());
    }

}
