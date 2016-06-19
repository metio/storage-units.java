/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;
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

import de.xn__ho_hia.quality.null_analysis.NullsafeMath;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for the {@link StorageUnit} implementations of <code>getNumberOfBytesPerUnit()</code>.
 */
@RunWith(Theories.class)
public class StorageUnitNumberOfBytesPerUnitTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static List<Function<BigInteger, StorageUnit<?>>> UNITS = TestObjects.bigIntegerBasedConstructors();

    @SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.NULL })
    private static final Map<Class<?>, BigInteger> EXPECTED_NUMBERS = Collections.unmodifiableMap(Stream.of(
            // binary units
            new SimpleEntry<>(Kibibyte.class, new BigInteger("1024")),
            new SimpleEntry<>(Mebibyte.class, new BigInteger("1048576")),
            new SimpleEntry<>(Gibibyte.class, new BigInteger("1073741824")),
            new SimpleEntry<>(Tebibyte.class, new BigInteger("1099511627776")),
            new SimpleEntry<>(Pebibyte.class, new BigInteger("1125899906842624")),
            new SimpleEntry<>(Exbibyte.class, new BigInteger("1152921504606846976")),
            new SimpleEntry<>(Zebibyte.class, new BigInteger("1180591620717411303424")),
            new SimpleEntry<>(Yobibyte.class, new BigInteger("1208925819614629174706176")),
            // metric units
            new SimpleEntry<>(Kilobyte.class, new BigInteger("1000")),
            new SimpleEntry<>(Megabyte.class, new BigInteger("1000000")),
            new SimpleEntry<>(Gigabyte.class, new BigInteger("1000000000")),
            new SimpleEntry<>(Terabyte.class, new BigInteger("1000000000000")),
            new SimpleEntry<>(Petabyte.class, new BigInteger("1000000000000000")),
            new SimpleEntry<>(Exabyte.class, new BigInteger("1000000000000000000")),
            new SimpleEntry<>(Zettabyte.class, new BigInteger("1000000000000000000000")),
            new SimpleEntry<>(Yottabyte.class, new BigInteger("1000000000000000000000000")))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue)));

    /**
     * Ensures that the correct number of bytes per unit is returned.
     *
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    @SuppressWarnings({ "nls", "static-method" })
    public void shouldReturnNumberOfBytesPerUnit(final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final BigInteger bytes = NullsafeMath.asBigInteger(1);
        final StorageUnit<?> unit = constructor.apply(bytes);
        final Class<?> unitClass = unit.getClass();

        // When
        final BigInteger numberOfBytesPerUnit = unit.getNumberOfBytesPerUnit();
        final BigInteger expectedNumberOfBytesPerUnit = EXPECTED_NUMBERS.get(unitClass);

        // Then
        Assert.assertEquals("Incorrect number of bytes per unit returned.",
                expectedNumberOfBytesPerUnit, numberOfBytesPerUnit);
    }

}
