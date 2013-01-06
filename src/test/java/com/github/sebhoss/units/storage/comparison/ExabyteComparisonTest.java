/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage.comparison;

import org.junit.Assert;
import org.junit.Test;

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

/**
 * Test for compareTo() implementations of the storage unit {@link Exabyte}.
 */
@SuppressWarnings({ "nls", "static-method" })
public class ExabyteComparisonTest {

    /**
     * Checks that {@link Exabyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndKilo() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Kilobyte kilo = Kilobyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(kilo);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndKibi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndMega() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(mega);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndMebi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndGiga() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndGibi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndTera() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndTebi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndPeta() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Petabyte peta = Petabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(peta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndPebi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndExa() {
        // Given
        final Exabyte less = Exabyte.valueOf(50);
        final Exabyte more = Exabyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndExbi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Exbibyte exbi = Exbibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(exbi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndZetta() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndZebi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndYotta() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Yottabyte yotta = Yottabyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(yotta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Exabyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldCompareExaAndYobi() {
        // Given
        final Exabyte exa = Exabyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = exa.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
