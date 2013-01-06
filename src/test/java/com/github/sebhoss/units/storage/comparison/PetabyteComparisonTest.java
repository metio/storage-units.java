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
 * Test for compareTo() implementations of the storage unit {@link Petabyte}.
 */
@SuppressWarnings({ "nls", "static-method" })
public class PetabyteComparisonTest {

    /**
     * Checks that {@link Petabyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndKilo() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Kilobyte kilo = Kilobyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(kilo);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndKibi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndMega() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(mega);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndMebi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndGiga() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndGibi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndTera() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndTebi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndPeta() {
        // Given
        final Petabyte less = Petabyte.valueOf(50);
        final Petabyte more = Petabyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndPebi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndExa() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Exabyte exa = Exabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(exa);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndExbi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Exbibyte exbi = Exbibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(exbi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndZetta() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndZebi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndYotta() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Yottabyte yotta = Yottabyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(yotta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Petabyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldComparePetaAndYobi() {
        // Given
        final Petabyte peta = Petabyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = peta.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
