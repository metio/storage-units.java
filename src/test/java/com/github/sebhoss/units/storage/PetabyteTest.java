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
 * Tests for Petabytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class PetabyteTest {

    /**
     * Checks that a new {@link Petabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Petabyte unit;

        // When
        unit = new Petabyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Petabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Petabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Petabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.petabyte(1);

        // Then
        Assert.assertTrue("The symbol for petabyte should be 'PB'.", unit.toString().endsWith("PB"));
    }

    /**
     * Checks that {@link Petabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.petabyte(1);

        // Then
        Assert.assertTrue("One petabyte should be interpreted as '1.00' petabytes.", unit.toString().startsWith("1.00"));
    }

    /**
     * Checks that {@link Petabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Petabyte first = StorageUnits.petabyte(1);

        // When
        final Petabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Petabyte unit = StorageUnits.petabyte(1);

        // When
        unit = unit.add(StorageUnits.petabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 petabytes should be '2.00 PB'.", "2.00 PB", unit.toString());
    }

    /**
     * Checks that {@link Petabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Petabyte first = StorageUnits.petabyte(1);

        // When
        final Petabyte second = first.add(StorageUnits.petabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Petabyte unit = StorageUnits.petabyte(1);

        // When
        unit = unit.add(StorageUnits.petabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 PB' + '1.00 PB' should be '2.00 PB'.", "2.00 PB", unit.toString());
    }

    /**
     * Checks that {@link Petabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Petabyte first = StorageUnits.petabyte(1);

        // When
        final Petabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Petabyte unit = StorageUnits.petabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 PB' / 5 should be '0.20 PB'.", "0.20 PB", unit.toString());
    }

    /**
     * Checks that {@link Petabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Petabyte first = StorageUnits.petabyte(1);

        // When
        final Petabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Petabyte unit = StorageUnits.petabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 PB' and 5 should be '5.00 PB'.", "5.00 PB", unit.toString());
    }

    /**
     * Checks that {@link Petabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Petabyte first = StorageUnits.petabyte(10);

        // When
        final Petabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Petabyte unit = StorageUnits.petabyte(10);

        // When
        unit = unit.subtract(StorageUnits.petabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 petabytes and 1 petabyte should be '9.00 PB'.", "9.00 PB",
                unit.toString());
    }

    /**
     * Checks that {@link Petabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Petabyte first = StorageUnits.petabyte(10);

        // When
        final Petabyte second = first.subtract(StorageUnits.petabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Petabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Petabyte unit = StorageUnits.petabyte(10);

        // When
        unit = unit.subtract(StorageUnits.petabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 PB' and '1.00 PB' should be '9.00 PB'.", "9.00 PB",
                unit.toString());
    }

}
