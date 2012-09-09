/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test for compareTo() implementations of the storage units.
 */
@SuppressWarnings({ "nls", "static-method" })
public class ComparisonTest {

    /**
     * Checks that {@link Kilobyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndKibi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
