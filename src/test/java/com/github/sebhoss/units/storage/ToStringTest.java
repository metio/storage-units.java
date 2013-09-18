/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import com.github.sebhoss.common.annotation.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for toString() implementations of the storage units.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class ToStringTest {

    /**
     * 
     */
    @Test
    public void shouldPrintTerabyte() {
        // Given
        final Terabyte unit = StorageUnits.terabyte(2);

        // When
        final String representation = unit.toString();

        // Then
        Assert.assertEquals("2.00 TB", representation);
    }

    /**
     * 
     */
    @Test
    public void shouldPrintGigabyte() {
        // Given
        final Gigabyte unit = StorageUnits.gigabyte(1).add(StorageUnits.megabyte(200));

        // When
        final String representation = unit.toString();

        // Then
        Assert.assertEquals("1.20 GB", representation);
    }

    /**
     * 
     */
    @Test
    public void shouldPrintPetabyte() {
        // Given
        final Petabyte unit = StorageUnits.petabyte(1).subtract(StorageUnits.terabyte(250));

        // When
        final String representation = unit.toString();

        // Then
        Assert.assertEquals("0.75 PB", representation);
    }

}
