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
package com.github.sebhoss.units.storage.comparison;

import com.github.sebhoss.units.storage.Exabyte;
import com.github.sebhoss.units.storage.Exbibyte;
import com.github.sebhoss.units.storage.Gibibyte;
import com.github.sebhoss.units.storage.Gigabyte;
import com.github.sebhoss.units.storage.Kibibyte;
import com.github.sebhoss.units.storage.Kilobyte;
import com.github.sebhoss.units.storage.Mebibyte;
import com.github.sebhoss.units.storage.Megabyte;
import com.github.sebhoss.units.storage.Pebibyte;
import com.github.sebhoss.units.storage.Petabyte;
import com.github.sebhoss.units.storage.Tebibyte;
import com.github.sebhoss.units.storage.Terabyte;
import com.github.sebhoss.units.storage.Yobibyte;
import com.github.sebhoss.units.storage.Yottabyte;
import com.github.sebhoss.units.storage.Zebibyte;
import com.github.sebhoss.units.storage.Zettabyte;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for compareTo() implementations of the storage unit {@link Exbibyte}.
 */
@SuppressWarnings({ "nls", "static-method" })
public class ExbibyteComparisonTest {

    /**
     * Checks that {@link Exbibyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndKilo() {
        // Given
        final Exbibyte exa = Exbibyte.valueOf(50);
        final Kilobyte kilo = Kilobyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(kilo);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndKibi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndMega() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(mega);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndMebi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndGiga() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndGibi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndTera() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndTebi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndPeta() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Petabyte peta = Petabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(peta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndPebi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndExa() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Exabyte exa = Exabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(exa);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndExbi() {
        // Given
        final Exbibyte less = Exbibyte.valueOf(50);
        final Exbibyte more = Exbibyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndZetta() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndZebi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndYotta() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Yottabyte yotta = Yottabyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(yotta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exbibyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldCompareExbiAndYobi() {
        // Given
        final Exbibyte exbi = Exbibyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = exbi.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
