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
        EqualsVerifier.forExamples(Exabyte.valueOf(0), Exabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Exbibyte.valueOf(0), Exbibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Gibibyte.valueOf(0), Gibibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Gigabyte.valueOf(0), Gigabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Kibibyte.valueOf(0), Kibibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Kilobyte.valueOf(0), Kilobyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Mebibyte.valueOf(0), Mebibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Megabyte.valueOf(0), Megabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Pebibyte.valueOf(0), Pebibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Petabyte.valueOf(0), Petabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Tebibyte.valueOf(0), Tebibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Terabyte.valueOf(0), Terabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Yobibyte.valueOf(0), Yobibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Yottabyte.valueOf(0), Yottabyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Zebibyte.valueOf(0), Zebibyte.valueOf(1)).verify();
        EqualsVerifier.forExamples(Zettabyte.valueOf(0), Zettabyte.valueOf(1)).verify();
    }

}
