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
 * Tests for Yobibytes.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class YobibyteTest {

    /**
     * Checks that a new {@link Yobibyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Yobibyte unit;

        // When
        unit = new Yobibyte(Nullsafe.nullsafe(BigInteger.valueOf(1000)));

        // Then
        Assert.assertNotNull(unit);
    }

    /**
     * Checks that {@link Yobibyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateYobibyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Yobibyte.valueOf(1000);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Yobibyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.yobibyte(1);

        // Then
        Assert.assertTrue("The symbol for yobibyte should be 'YiB'.", unit.toString().endsWith("YiB"));
    }

    /**
     * Checks that {@link Yobibyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = StorageUnits.yobibyte(1);

        // Then
        Assert.assertTrue("One yobibyte should be interpreted as '1.00' yobibytes.",
                unit.toString().startsWith("1.00"));
    }

}
