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
 * Tests for Yottabytes.
 */
@SuppressWarnings({ "static-method", "nls" })
public class YottabyteTest {

    /**
     * Checks that a new {@link Yottabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Yottabyte unit;

        // When
        unit = new Yottabyte(BigInteger.valueOf(1000));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Yottabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Yottabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Yottabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.yottabyte(1);

        // Then
        Assert.assertTrue("The symbol for yottabyte should be 'YB'.", unit.toString().endsWith("YB"));
    }

    /**
     * Checks that {@link Yottabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.yottabyte(1);

        // Then
        Assert.assertTrue("One yottabyte should be interpreted as '1.00' yottabytes.",
                unit.toString().startsWith("1.00"));
    }

}
