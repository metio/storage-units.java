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

import com.github.sebhoss.warnings.CompilerWarnings;

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
