/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import org.junit.Assert;
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

}
