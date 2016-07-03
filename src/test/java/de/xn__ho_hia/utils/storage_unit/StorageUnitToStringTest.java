/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.TestObjects.highLevelLongBasedConstructors;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for the {@link StorageUnit} class and its {@link StorageUnit#toString() toString} behavior.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitToStringTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static final List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    private static final Map<Class<?>, String> TYPE_SUFFIX_MAPPING = Collections
            .unmodifiableMap(Stream.of(
                    new SimpleEntry<>(Kibibyte.class, "KiB"),
                    new SimpleEntry<>(Mebibyte.class, "MiB"),
                    new SimpleEntry<>(Gibibyte.class, "GiB"),
                    new SimpleEntry<>(Tebibyte.class, "TiB"),
                    new SimpleEntry<>(Pebibyte.class, "PiB"),
                    new SimpleEntry<>(Exbibyte.class, "EiB"),
                    new SimpleEntry<>(Zebibyte.class, "ZiB"),
                    new SimpleEntry<>(Yobibyte.class, "YiB"),
                    new SimpleEntry<>(Kilobyte.class, "kB"),
                    new SimpleEntry<>(Megabyte.class, "MB"),
                    new SimpleEntry<>(Gigabyte.class, "GB"),
                    new SimpleEntry<>(Terabyte.class, "TB"),
                    new SimpleEntry<>(Petabyte.class, "PB"),
                    new SimpleEntry<>(Exabyte.class, "EB"),
                    new SimpleEntry<>(Zettabyte.class, "ZB"),
                    new SimpleEntry<>(Yottabyte.class, "YB"))
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue)));

    /**
     * Ensures that each unit prints to correct unit suffix.
     *
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldPrintCorrectUnit(final Function<Long, StorageUnit<?>> constructor) {
        // Given
        final Long bytes = Nullsafe.asLong(1);
        final StorageUnit<?> unit = constructor.apply(bytes);

        // When
        final String formattedUnit = unit.toString();
        final Class<?> unitClass = unit.getClass();

        // Then
        Assert.assertTrue(String.format("Unit [%s] doesn't end with correct suffix", unitClass.getSimpleName()),
                formattedUnit.endsWith(TYPE_SUFFIX_MAPPING.get(unitClass)));
    }

}
