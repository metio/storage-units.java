/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for toString() implementations of the storage units.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
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
