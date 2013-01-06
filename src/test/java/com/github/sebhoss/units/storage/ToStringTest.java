/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for toString() implementations of the storage units.
 */
@SuppressWarnings({ "nls", "static-method" })
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
