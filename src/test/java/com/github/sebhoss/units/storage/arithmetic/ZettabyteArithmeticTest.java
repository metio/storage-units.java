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
import com.github.sebhoss.units.storage.Zettabyte;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for arithmetic operations with {@link Zettabyte}s.
 */
@SuppressWarnings({ "static-method", "nls" })
public class ZettabyteArithmeticTest {

    /**
     * Checks that {@link Zettabyte#add(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddLong() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#add(long)} adds the given number of bytes to the new instance.
     */
    @Test
    public void shouldAddLongNumberOfBytes() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.add(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The sum of 1 zettabyte and 1 exabyte should be ~ '1.00 ZB'.", "1.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#add(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterAddStorage() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.add(StorageUnits.zettabyte(1));

        // Then
        Assert.assertNotSame("The add(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#add(StorageUnit)} adds the given storage amount to the new instance.
     */
    @Test
    public void shouldAddStorage() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.add(StorageUnits.zettabyte(1));

        // Then
        Assert.assertEquals("The sum of '1.00 ZB' + '1.00 ZB' should be '2.00 ZB'.", "2.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#divide(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterDivide() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#divide(long)} divides the current storage amount correct to the new instance.
     */
    @Test
    public void shouldDivide() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.divide(5);

        // Then
        Assert.assertEquals("The division '1.00 ZB' / 5 should be '0.20 ZB'.", "0.20 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#multiply(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterMultiply() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(1);

        // When
        final Zettabyte second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#multiply(long)} multiplies the current storage amount correct to the new instance.
     */
    @Test
    public void shouldMultiply() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.multiply(5);

        // Then
        Assert.assertEquals("The product of '1.00 ZB' and 5 should be '5.00 ZB'.", "5.00 ZB", unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#subtract(long)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractLong() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(10);

        // When
        final Zettabyte second = first.subtract(1000);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#subtract(long)} subtracts the given number of bytes to the new instance.
     */
    @Test
    public void shouldSubtractLongNumberOfBytes() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(1);

        // When
        unit = unit.subtract(StorageUnits.exabyte(1).longValue());

        // Then
        Assert.assertEquals("The difference between 1 zettabytes and 1 exabytes should not be noticeable.", "1.00 ZB",
                unit.toString());
    }

    /**
     * Checks that {@link Zettabyte#subtract(StorageUnit)} returns a new instance.
     */
    @Test
    public void shouldReturnNewInstanceAfterSubtractStorage() {
        // Given
        final Zettabyte first = StorageUnits.zettabyte(10);

        // When
        final Zettabyte second = first.subtract(StorageUnits.zettabyte(1));

        // Then
        Assert.assertNotSame("The subtract(StorageUnit) method must return a new instance.", first, second);
    }

    /**
     * Checks that {@link Zettabyte#subtract(StorageUnit)} subtracts the given storage amount to the new instance.
     */
    @Test
    public void shouldSubtractStorage() {
        // Given
        Zettabyte unit = StorageUnits.zettabyte(10);

        // When
        unit = unit.subtract(StorageUnits.zettabyte(1));

        // Then
        Assert.assertEquals("The difference between '10.00 ZB' and '1.00 ZB' should be '9.00 ZB'.", "9.00 ZB",
                unit.toString());
    }

}
