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
    }

}
