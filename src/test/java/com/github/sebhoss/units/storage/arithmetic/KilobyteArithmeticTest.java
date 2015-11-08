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

import com.github.sebhoss.units.storage.Kilobyte;
import com.github.sebhoss.units.storage.StorageUnit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for arithmetic operations with {@link Kilobyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class KilobyteArithmeticTest {

    /**
     * Checks that {@link Kilobyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.add(1000);

        // Then
        Assert.assertEquals("The sum of 1000 + 1000 bytes should be '2.00 kB'.", "2.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.add(Kilobyte.valueOf(1000));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.add(Kilobyte.valueOf(1000));

        // Then
        Assert.assertEquals("The sum of '1.00 kB' + '1.00 kB' should be '2.00 kB'.", "2.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 kB' / 5 should be '0.20 kB'.", "0.20 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 kB' and 5 should be '5.00 kB'.", "5.00 kB", unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.subtract(100);

        // Then
        Assert.assertEquals("The difference between 1000 bytes and 100 bytes should be '0.90 kB'.", "0.90 kB",
                unit.toString());
    }

    /**
     * Checks that {@link Kilobyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Kilobyte first = Kilobyte.valueOf(1000);

        // When
        final Kilobyte second = first.subtract(Kilobyte.valueOf(1000));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Kilobyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Kilobyte unit = Kilobyte.valueOf(1000);

        // When
        unit = unit.subtract(Kilobyte.valueOf(100));

        // Then
        Assert.assertEquals("The difference between '1.00 kB' and '0.10 kB' should be '0.90 kB'.", "0.90 kB",
                unit.toString());
    }

}
