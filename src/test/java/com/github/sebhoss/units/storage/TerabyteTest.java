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
 * Tests for Terabytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class TerabyteTest {

    /**
     * Checks that a new {@link Terabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Terabyte unit;

        // When
        unit = new Terabyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Terabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Terabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Terabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.terabyte(1);

        // Then
        Assert.assertTrue("The symbol for terabyte should be 'TB'.", unit.toString().endsWith("TB"));
    }

    /**
     * Checks that {@link Terabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.terabyte(1);

        // Then
        Assert.assertTrue("One terabyte should be interpreted as '1.00' terabytes.", unit.toString().startsWith("1.00"));
    }

    /**
     * Checks that {@link Terabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.add(StorageUnits.terabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 terabytes should be '2.00 TB'.", "2.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.add(StorageUnits.terabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.add(StorageUnits.terabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 TB' + '1.00 TB' should be '2.00 TB'.", "2.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 TB' / 5 should be '0.20 TB'.", "0.20 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 TB' and 5 should be '5.00 TB'.", "5.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Terabyte first = StorageUnits.terabyte(10);

        // When
        final Terabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Terabyte unit = StorageUnits.terabyte(10);

        // When
        unit = unit.subtract(StorageUnits.terabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 terabytes and 1 terabyte should be '9.00 TB'.", "9.00 TB",
                unit.toString());
    }

    /**
     * Checks that {@link Terabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Terabyte first = StorageUnits.terabyte(10);

        // When
        final Terabyte second = first.subtract(StorageUnits.terabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Terabyte unit = StorageUnits.terabyte(10);

        // When
        unit = unit.subtract(StorageUnits.terabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 TB' and '1.00 TB' should be '9.00 TB'.", "9.00 TB",
                unit.toString());
    }

}
