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

import com.github.sebhoss.units.storage.StorageUnit;
import com.github.sebhoss.units.storage.StorageUnits;
import com.github.sebhoss.units.storage.Terabyte;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for arithmetic operations with {@link Terabyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class TerabyteArithmeticTest {

    /**
     * Checks that {@link Terabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.add(StorageUnits.terabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 + 1 terabytes should be '2.00 TB'.", "2.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.add(StorageUnits.terabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.add(StorageUnits.terabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 TB' + '1.00 TB' should be '2.00 TB'.", "2.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 TB' / 5 should be '0.20 TB'.", "0.20 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Terabyte first = StorageUnits.terabyte(1);

        // When
        final Terabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Terabyte unit = StorageUnits.terabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 TB' and 5 should be '5.00 TB'.", "5.00 TB", unit.toString());
    }

    /**
     * Checks that {@link Terabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Terabyte first = StorageUnits.terabyte(10);

        // When
        final Terabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Terabyte unit = StorageUnits.terabyte(10);

        // When
        unit = unit.subtract(StorageUnits.terabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 10 terabytes and 1 terabyte should be '9.00 TB'.", "9.00 TB",
                unit.toString());
    }

    /**
     * Checks that {@link Terabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Terabyte first = StorageUnits.terabyte(10);

        // When
        final Terabyte second = first.subtract(StorageUnits.terabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Terabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Terabyte unit = StorageUnits.terabyte(10);

        // When
        unit = unit.subtract(StorageUnits.terabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 TB' and '1.00 TB' should be '9.00 TB'.", "9.00 TB",
                unit.toString());
    }

}
