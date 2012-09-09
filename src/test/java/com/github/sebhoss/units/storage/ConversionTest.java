/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests for conversions between units.
 */
@SuppressWarnings({ "nls", "static-method" })
public class ConversionTest {

    /**
     * Checks that {@link StorageUnit#asMegabyte()} converts a kilobyte into a megabyte.
     */
    @Test
    public void shouldConvertKilobyteToMegabyte() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(1);

        // When
        final Megabyte mega = kilo.asMegabyte();

        // Then
        Assert.assertEquals("Both units should represent the same amount of storage.", kilo.inByte(), mega.inByte());
    }

    /**
     * Checks that {@link StorageUnit#asMegabyte()} does not return <code>null</code>.
     */
    @Test
    public void shouldNotReturnNullForMegabyteConversion() {
        // Given
        final StorageUnit<?> unit = StorageUnits.metricValueOf(1);

        // When
        final Megabyte megabyte = unit.asMegabyte();

        // Then
        Assert.assertNotNull("The converted megabyte should never be NULL.", megabyte);
    }

}
