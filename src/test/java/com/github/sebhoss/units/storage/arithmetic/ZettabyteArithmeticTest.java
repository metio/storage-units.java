/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.units.storage.StorageUnit;
import com.github.sebhoss.units.storage.StorageUnits;
import com.github.sebhoss.units.storage.Zettabyte;

/**
 * Tests for arithmetic operations with {@link Zettabyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class ZettabyteArithmeticTest {

    /**
     * Checks that {@link Zettabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.add(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 zettabyte and 1 exabyte should be ~ '1.00 ZB'.", "1.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.add(StorageUnits.zettabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.add(StorageUnits.zettabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 ZB' + '1.00 ZB' should be '2.00 ZB'.", "2.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 ZB' / 5 should be '0.20 ZB'.", "0.20 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 ZB' and 5 should be '5.00 ZB'.", "5.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(10);

        // When
        final Zettabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.subtract(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 1 zettabytes and 1 exabytes should not be noticeable.", "1.00 ZB",
                unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(10);

        // When
        final Zettabyte second = first.subtract(StorageUnits.zettabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(10);

        // When
        unit = unit.subtract(StorageUnits.zettabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 ZB' and '1.00 ZB' should be '9.00 ZB'.", "9.00 ZB",
                unit.toString());
    }

}
