/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import com.github.sebhoss.warnings.CompilerWarnings;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

/**
 * Test for equals() implementations of the storage units.
 */
@SuppressWarnings({ CompilerWarnings.STATIC_METHOD })
public class EqualsTest {

    /**
     * Checks that storage units implement equals() correctly.
     */
    @Test
    public void shouldImplementEqualsContract() {
        EqualsVerifier.forClass(StorageUnit.class).verify();
        EqualsVerifier.forClass(Exabyte.class).verify();
        EqualsVerifier.forClass(Exbibyte.class).verify();
        EqualsVerifier.forClass(Gibibyte.class).verify();
        EqualsVerifier.forClass(Gigabyte.class).verify();
        EqualsVerifier.forClass(Kibibyte.class).verify();
        EqualsVerifier.forClass(Kilobyte.class).verify();
        EqualsVerifier.forClass(Mebibyte.class).verify();
        EqualsVerifier.forClass(Megabyte.class).verify();
        EqualsVerifier.forClass(Pebibyte.class).verify();
        EqualsVerifier.forClass(Petabyte.class).verify();
        EqualsVerifier.forClass(Tebibyte.class).verify();
        EqualsVerifier.forClass(Terabyte.class).verify();
        EqualsVerifier.forClass(Yobibyte.class).verify();
        EqualsVerifier.forClass(Yottabyte.class).verify();
        EqualsVerifier.forClass(Zebibyte.class).verify();
        EqualsVerifier.forClass(Zettabyte.class).verify();
    }

}
