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
package de.xn__ho_hia.utils.storage_unit;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.utils.storage_unit.StorageUnit;
import de.xn__ho_hia.utils.storage_unit.StorageUnits;

/**
 * Test cases for the {@link StorageUnit} class that check its behavior as a {@link Number}.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitNumberTest {

    /**
     * Ensures that the {@link Number#doubleValue()} method is implemented.
     */
    @Test
    public void shouldReturnDoubleValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final double result = unit.doubleValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024D, result, 0D);
    }

    /**
     * Ensures that the {@link Number#longValue()} method is implemented.
     */
    @Test
    public void shouldReturnLongValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final long result = unit.longValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024L, result);
    }

    /**
     * Ensures that the {@link Number#floatValue()} method is implemented.
     */
    @Test
    public void shouldReturnFloatValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final float result = unit.floatValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024F, result, 0F);
    }

    /**
     * Ensures that the {@link Number#intValue()} method is implemented.
     */
    @Test
    public void shouldReturnIntValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final int result = unit.intValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024, result);
    }

}
