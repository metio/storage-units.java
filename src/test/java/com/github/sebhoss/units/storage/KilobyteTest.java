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

}
