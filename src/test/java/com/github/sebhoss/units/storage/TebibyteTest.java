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
 * Tests for Tebibytes.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class TebibyteTest {

    /**
     * Checks that a new {@link Tebibyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Tebibyte unit;

        // When
        unit = new Tebibyte(Nullsafe.nullsafe(BigInteger.valueOf(1024)));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Tebibyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateTebibyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Tebibyte.valueOf(1024);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Tebibyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.tebibyte(1);

        // Then
        Assert.assertTrue("The symbol for tebibyte should be 'TiB'.", unit.toString().endsWith("TiB"));
    }

    /**
     * Checks that {@link Tebibyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.tebibyte(1);

        // Then
        Assert.assertTrue("One tebibyte should be interpreted as '1.00' tebibytes.", unit.toString().startsWith("1.00"));
    }

}
