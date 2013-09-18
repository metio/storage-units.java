/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.CompilerWarnings;
import com.github.sebhoss.common.annotation.Nullsafe;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Zettabytes.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class ZettabyteTest {

    /**
     * Checks that a new {@link Zettabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Zettabyte unit;

        // When
        unit = new Zettabyte(Nullsafe.nullsafe(BigInteger.valueOf(1000)));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Zettabyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateMegabyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Zettabyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Zettabyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.zettabyte(1);

        // Then
        Assert.assertTrue("The symbol for zettabyte should be 'ZB'.", unit.toString().endsWith("ZB"));
    }

    /**
     * Checks that {@link Zettabyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.zettabyte(1);

        // Then
        Assert.assertTrue("One zettabyte should be interpreted as '1.00' zettabytes.",
                unit.toString().startsWith("1.00"));
    }

}
