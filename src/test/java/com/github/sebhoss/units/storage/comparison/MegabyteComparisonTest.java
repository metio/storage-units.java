/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
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
 * Test for compareTo() implementations of the storage unit {@link Megabyte}.
 */
@SuppressWarnings({ "nls", "static-method" })
public class MegabyteComparisonTest {

    /**
     * Checks that {@link Megabyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndKilo() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Kilobyte kilo = Kilobyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(kilo);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndKibi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndMega() {
        // Given
        final Megabyte less = Megabyte.valueOf(50);
        final Megabyte more = Megabyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndMebi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndGiga() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndGibi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndTera() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndTebi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndPeta() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Petabyte peta = Petabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(peta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndPebi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndExa() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Exabyte exa = Exabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(exa);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndExbi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Exbibyte exbi = Exbibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(exbi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndZetta() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndZebi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndYotta() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Yottabyte yotta = Yottabyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(yotta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Megabyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldCompareMegaAndYobi() {
        // Given
        final Megabyte mega = Megabyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = mega.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
