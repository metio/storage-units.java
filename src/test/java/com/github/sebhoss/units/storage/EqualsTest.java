/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test for toString() implementations of the storage units.
 */
@SuppressWarnings({ "nls", "static-method" })
public class EqualsTest {

    /**
     * Checks that {@link Kilobyte} and {@link Megabyte} can be compared to each other using the equals() method.
     */
    @Test
    public void shouldEqualsKiloAndMegabyte() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final boolean equals = kilo.equals(mega);

        // Then
        Assert.assertTrue("50 Bytes should always be equal to 50 Bytes, no matter the representation.", equals);
    }

}
