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
 * Test for compareTo() implementations of the storage unit {@link Yottabyte}.
 */
@SuppressWarnings({ "nls", "static-method", "null" })
public class YottabyteComparisonTest {

    /**
     * Checks that {@link Yottabyte} and {@link Kilobyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndKilo() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Kilobyte kilo = Kilobyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(kilo);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Kibibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndKibi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Kibibyte kibi = Kibibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(kibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Megabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndMega() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Megabyte mega = Megabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(mega);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Mebibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndMebi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Mebibyte mebi = Mebibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(mebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Gigabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndGiga() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Gigabyte giga = Gigabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(giga);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Gibibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndGibi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Gibibyte gibi = Gibibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(gibi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Terabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndTera() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Terabyte tera = Terabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(tera);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Tebibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndTebi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Tebibyte tebi = Tebibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(tebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Petabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndPeta() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Petabyte peta = Petabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(peta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Pebibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndPebi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Pebibyte pebi = Pebibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(pebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Exabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndExa() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Exabyte exa = Exabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(exa);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Exbibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndExbi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Exbibyte exbi = Exbibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(exbi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Zettabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndZetta() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Zettabyte zetta = Zettabyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(zetta);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Zebibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndZebi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Zebibyte zebi = Zebibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(zebi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Yottabyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndYotta() {
        // Given
        final Yottabyte less = Yottabyte.valueOf(50);
        final Yottabyte more = Yottabyte.valueOf(150);

        // When
        final int comparison = less.compareTo(more);

        // Then
        Assert.assertEquals("50 Byte should be less then 150 Byte.", -1, comparison);
    }

    /**
     * Checks that {@link Yottabyte} and {@link Yobibyte} can be compared.
     */
    @Test
    public void shouldCompareYottaAndYobi() {
        // Given
        final Yottabyte yotta = Yottabyte.valueOf(50);
        final Yobibyte yobi = Yobibyte.valueOf(50);

        // When
        final int comparison = yotta.compareTo(yobi);

        // Then
        Assert.assertEquals("50 Byte should be the same, no matter which representation was chosen.", 0, comparison);
    }

}
