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

import de.xn__ho_hia.utils.storage_unit.Exabyte;
import de.xn__ho_hia.utils.storage_unit.Exbibyte;
import de.xn__ho_hia.utils.storage_unit.Gibibyte;
import de.xn__ho_hia.utils.storage_unit.Gigabyte;
import de.xn__ho_hia.utils.storage_unit.Kibibyte;
import de.xn__ho_hia.utils.storage_unit.Kilobyte;
import de.xn__ho_hia.utils.storage_unit.Mebibyte;
import de.xn__ho_hia.utils.storage_unit.Megabyte;
import de.xn__ho_hia.utils.storage_unit.Pebibyte;
import de.xn__ho_hia.utils.storage_unit.Petabyte;
import de.xn__ho_hia.utils.storage_unit.StorageUnit;
import de.xn__ho_hia.utils.storage_unit.Tebibyte;
import de.xn__ho_hia.utils.storage_unit.Terabyte;
import de.xn__ho_hia.utils.storage_unit.Yobibyte;
import de.xn__ho_hia.utils.storage_unit.Yottabyte;
import de.xn__ho_hia.utils.storage_unit.Zebibyte;
import de.xn__ho_hia.utils.storage_unit.Zettabyte;

/**
 * Test cases for the {@link StorageUnit} implementations of <code>getNumberOfBytesPerUnit()</code>.
 */
@RunWith(Theories.class)
public class StorageUnitNumberOfBytesPerUnitTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static List<Function<BigInteger, StorageUnit<?>>> UNITS = ObjectMother.bigIntegerBasedConstructors();

    @SuppressWarnings("nls")
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
        final BigInteger bytes = BigInteger.valueOf(1);
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
