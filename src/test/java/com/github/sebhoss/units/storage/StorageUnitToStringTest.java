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
package com.github.sebhoss.units.storage;

import static com.github.sebhoss.units.storage.ObjectMother.highLevelLongBasedConstructors;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for the {@link StorageUnit} class and its {@link StorageUnit#toString() toString} behavior.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitToStringTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static final List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    private static final Map<Class<?>, String> TYPE_SUFFIX_MAPPING = Collections.unmodifiableMap(Stream.of(
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
        final Long bytes = Long.valueOf(1);
        final StorageUnit<?> unit = constructor.apply(bytes);

        // When
        final String formattedUnit = unit.toString();
        final Class<?> unitClass = unit.getClass();

        // Then
        Assert.assertTrue(String.format("Unit [%s] doesn't end with correct suffix", unitClass.getSimpleName()),
                formattedUnit.endsWith(TYPE_SUFFIX_MAPPING.get(unitClass)));
    }

}
