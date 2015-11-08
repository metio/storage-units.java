/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Kibibytes.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class KibibyteTest {

    /**
     * Checks that a new {@link Kibibyte} instance must be created with a BigInteger.
     */
    @Test
    public void shouldConstructWithBigInteger() {
        // Given
        Kibibyte unit;

        // When
        unit = new Kibibyte(BigInteger.valueOf(1024));

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Kibibyte#valueOf(long)} does not return <code>null</code>.
     */
    @Test
    public void shouldCreateKibibyte() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kibibyte.valueOf(1024);

        // Then
        Assert.assertNotNull("The created unit should never be NULL.", unit);
    }

    /**
     * Checks that {@link Kibibyte#toString()} shows the correct symbol.
     */
    @Test
    public void shouldShowCorrectSymbol() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kibibyte.valueOf(1024);

        // Then
        Assert.assertTrue("The symbol for Kibibyte should be 'KiB'.", unit.toString().endsWith("KiB"));
    }

    /**
     * Checks that {@link Kibibyte#toString()} shows the correct value.
     */
    @Test
    public void shouldShowCorrectValue() {
        // Given
        final StorageUnit<?> unit;

        // When
        unit = Kibibyte.valueOf(1024);

        // Then
        Assert.assertTrue("1024 bytes should be interpreted as '1.00' Kibibytes.", unit.toString().startsWith("1.00"));
    }

}
