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
 * Tests for Megabytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class MegabyteTest {

    /**
     * Checks that a new {@link Megabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Megabyte unit;

        // When
        unit = new Megabyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Megabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Megabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Megabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.megabyte(1);

        // Then
        Assert.assertTrue("The symbol for megabyte should be 'MB'.", unit.toString().endsWith("MB"));
    }

    /**
     * Checks that {@link Megabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.megabyte(1);

        // Then
        Assert.assertTrue("One megabyte should be interpreted as '1.00' megabytes.", unit.toString().startsWith("1.00"));
    }

    /**
     * Checks that {@link Megabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Megabyte first = StorageUnits.megabyte(1);

        // When
        final Megabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Megabyte unit = StorageUnits.megabyte(1);

        // When
        unit = unit.add(StorageUnits.megabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 megabytes should be '2.00 MB'.", "2.00 MB", unit.toString());
    }

    /**
     * Checks that {@link Megabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Megabyte first = StorageUnits.megabyte(1);

        // When
        final Megabyte second = first.add(StorageUnits.megabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Megabyte unit = StorageUnits.megabyte(1);

        // When
        unit = unit.add(StorageUnits.megabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 MB' + '1.00 MB' should be '2.00 MB'.", "2.00 MB", unit.toString());
    }

    /**
     * Checks that {@link Megabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Megabyte first = StorageUnits.megabyte(1);

        // When
        final Megabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Megabyte unit = StorageUnits.megabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 MB' / 5 should be '0.20 MB'.", "0.20 MB", unit.toString());
    }

    /**
     * Checks that {@link Megabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Megabyte first = StorageUnits.megabyte(1);

        // When
        final Megabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Megabyte unit = StorageUnits.megabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 MB' and 5 should be '5.00 MB'.", "5.00 MB", unit.toString());
    }

    /**
     * Checks that {@link Megabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Megabyte first = StorageUnits.megabyte(10);

        // When
        final Megabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Megabyte unit = StorageUnits.megabyte(10);

        // When
        unit = unit.subtract(StorageUnits.megabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 megabytes and 1 megabyte should be '9.00 MB'.", "9.00 MB",
                unit.toString());
    }

    /**
     * Checks that {@link Megabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Megabyte first = StorageUnits.megabyte(10);

        // When
        final Megabyte second = first.subtract(StorageUnits.megabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Megabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Megabyte unit = StorageUnits.megabyte(10);

        // When
        unit = unit.subtract(StorageUnits.megabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 MB' and '1.00 MB' should be '9.00 MB'.", "9.00 MB",
                unit.toString());
    }

}
