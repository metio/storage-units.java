/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import com.github.sebhoss.units.storage.Kilobyte;
import com.github.sebhoss.units.storage.StorageUnit;

/**
 * Tests for arithmetic operations with {@link Kilobyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class KilobyteArithmeticTest {

    /**
     * Checks that {@link Kilobyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.add(1000);

        // Then
        Assert.assertEquals("The sum of 1000 + 1000 bytes should be '2.00 kB'.", "2.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.add(Kilobyte.valueOf(1000));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.add(Kilobyte.valueOf(1000));

        // Then
        Assert.assertEquals("The sum of '1.00 kB' + '1.00 kB' should be '2.00 kB'.", "2.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 kB' / 5 should be '0.20 kB'.", "0.20 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 kB' and 5 should be '5.00 kB'.", "5.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.subtract(100);

        // Then
        Assert.assertEquals("The difference between 1000 bytes and 100 bytes should be '0.90 kB'.", "0.90 kB",
                unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.subtract(Kilobyte.valueOf(1000));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.subtract(Kilobyte.valueOf(100));

        // Then
        Assert.assertEquals("The difference between '1.00 kB' and '0.10 kB' should be '0.90 kB'.", "0.90 kB",
                unit.toString());
    }

}
