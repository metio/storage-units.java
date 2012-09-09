/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests for Kilobytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class KilobyteTest {

    /**
     * Checks that a new {@link Kilobyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Kilobyte unit;

        // When
        unit = new Kilobyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Kilobyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateKilobyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kilobyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Kilobyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kilobyte.valueOf(1000);

        // Then
        Assert.assertTrue("The symbol for kilobyte should be 'kB'.", unit.toString().endsWith("kB"));
    }

    /**
     * Checks that {@link Kilobyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kilobyte.valueOf(1000);

        // Then
        Assert.assertTrue("1000 bytes should be interpreted as '1.00' kilobytes.", unit.toString().startsWith("1.00"));
    }

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
