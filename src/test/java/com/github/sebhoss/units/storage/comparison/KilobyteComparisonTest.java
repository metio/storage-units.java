/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage.comparison;

import junit.framework.Assert;

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
 * Test for compareTo() implementations of the storage unit {@link Kilobyte}.
 */
@SuppressWarnings({ "nls", "static-method" })
public class KilobyteComparisonTest {

    /**
     * Checks that {@link Kilobyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndKilo() {
        // Given
        final Kilobyte less = Kilobyte.valueOf(50);
        final Kilobyte more = Kilobyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndKibi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndMega() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(mega);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndMebi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndGiga() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndGibi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndTera() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndTebi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndPeta() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Petabyte peta = Petabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(peta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndPebi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndExa() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Exabyte exa = Exabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(exa);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndExbi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Exbibyte exbi = Exbibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(exbi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndZetta() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndZebi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndYotta() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Yottabyte yotta = Yottabyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(yotta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Kilobyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldCompareKiloAndYobi() {
        // Given
        final Kilobyte kilo = Kilobyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = kilo.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
