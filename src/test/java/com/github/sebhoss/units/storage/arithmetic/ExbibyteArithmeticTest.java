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
package com.github.sebhoss.units.storage.arithmetic;

import com.github.sebhoss.units.storage.Exbibyte;
import com.github.sebhoss.units.storage.StorageUnit;
import com.github.sebhoss.units.storage.StorageUnits;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for arithmetic operations with {@link Exbibyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class ExbibyteArithmeticTest {

    /**
     * Checks that {@link Exbibyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(1);

        // When
        final Exbibyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(1);

        // When
        unit = unit.add(StorageUnits.exbibyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 exbibytes should be '2.00 EiB'.", "2.00 EiB", unit.toString());
    }

    /**
     * Checks that {@link Exbibyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(1);

        // When
        final Exbibyte second = first.add(StorageUnits.exbibyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(1);

        // When
        unit = unit.add(StorageUnits.exbibyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 EiB' + '1.00 EiB' should be '2.00 EiB'.", "2.00 EiB", unit.toString());
    }

    /**
     * Checks that {@link Exbibyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(1);

        // When
        final Exbibyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 EiB' / 5 should be '0.20 EiB'.", "0.20 EiB", unit.toString());
    }

    /**
     * Checks that {@link Exbibyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(1);

        // When
        final Exbibyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 EiB' and 5 should be '5.00 EiB'.", "5.00 EiB", unit.toString());
    }

    /**
     * Checks that {@link Exbibyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(10);

        // When
        final Exbibyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(10);

        // When
        unit = unit.subtract(StorageUnits.exbibyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 exbibytes and 1 exbibyte should be '9.00 EiB'.", "9.00 EiB",
                unit.toString());
    }

    /**
     * Checks that {@link Exbibyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Exbibyte first = StorageUnits.exbibyte(10);

        // When
        final Exbibyte second = first.subtract(StorageUnits.exbibyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Exbibyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Exbibyte unit = StorageUnits.exbibyte(10);

        // When
        unit = unit.subtract(StorageUnits.exbibyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 EiB' and '1.00 EiB' should be '9.00 EiB'.", "9.00 EiB",
                unit.toString());
    }

}
