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
 * Tests for Exabytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class ExabyteTest {

    /**
     * Checks that a new {@link Exabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Exabyte unit;

        // When
        unit = new Exabyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Exabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Exabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Exabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.exabyte(1);

        // Then
        Assert.assertTrue("The symbol for exabyte should be 'EB'.", unit.toString().endsWith("EB"));
    }

    /**
     * Checks that {@link Exabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.exabyte(1);

        // Then
        Assert.assertTrue("One exabyte should be interpreted as '1.00' exabytes.", unit.toString().startsWith("1.00"));
    }

    /**
     * Checks that {@link Exabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Exabyte first = StorageUnits.exabyte(1);

        // When
        final Exabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Exabyte unit = StorageUnits.exabyte(1);

        // When
        unit = unit.add(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 exabytes should be '2.00 EB'.", "2.00 EB", unit.toString());
    }

    /**
     * Checks that {@link Exabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Exabyte first = StorageUnits.exabyte(1);

        // When
        final Exabyte second = first.add(StorageUnits.exabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Exabyte unit = StorageUnits.exabyte(1);

        // When
        unit = unit.add(StorageUnits.exabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 EB' + '1.00 EB' should be '2.00 EB'.", "2.00 EB", unit.toString());
    }

    /**
     * Checks that {@link Exabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Exabyte first = StorageUnits.exabyte(1);

        // When
        final Exabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Exabyte unit = StorageUnits.exabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 EB' / 5 should be '0.20 EB'.", "0.20 EB", unit.toString());
    }

    /**
     * Checks that {@link Exabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Exabyte first = StorageUnits.exabyte(1);

        // When
        final Exabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Exabyte unit = StorageUnits.exabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 EB' and 5 should be '5.00 EB'.", "5.00 EB", unit.toString());
    }

    /**
     * Checks that {@link Exabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Exabyte first = StorageUnits.exabyte(10);

        // When
        final Exabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Exabyte unit = StorageUnits.exabyte(10);

        // When
        unit = unit.subtract(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 exabytes and 1 exabyte should be '9.00 EB'.", "9.00 EB",
                unit.toString());
    }

    /**
     * Checks that {@link Exabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Exabyte first = StorageUnits.exabyte(10);

        // When
        final Exabyte second = first.subtract(StorageUnits.exabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Exabyte unit = StorageUnits.exabyte(10);

        // When
        unit = unit.subtract(StorageUnits.exabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 EB' and '1.00 EB' should be '9.00 EB'.", "9.00 EB",
                unit.toString());
    }

}
