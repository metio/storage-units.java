/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.nullanalysis.Nullsafe;
import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Terabytes.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class TerabyteTest {

    /**
     * Checks that a new {@link Terabyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Terabyte unit;

        // When
        unit = new Terabyte(Nullsafe.nullsafe(BigInteger.valueOf(1000)));

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

}
