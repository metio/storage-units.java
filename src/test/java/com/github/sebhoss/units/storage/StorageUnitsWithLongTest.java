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

import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for the {@link StorageUnits} class that work with {@link Long}s.
 */
@RunWith(Theories.class)
public class StorageUnitsWithLongTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    /**
     * Ensures that high-level constructors for all given unit constructors produce a not-null output when fed with a
     * {@link Long} value.
     *
     * @param constructor
     *            The constructor function for the storage unit under test.
     * @see StorageUnitsWithBigIntegerTest#shouldCreateNotNullUnit(Function)
     */
    @Theory
    @SuppressWarnings({ "static-method", "nls" })
    public void shouldCreateNotNullUnit(final Function<Long, StorageUnit<?>> constructor) {
        // Given
        final Long bytes = Long.valueOf(1);

        // When
        final StorageUnit<?> unit = constructor.apply(bytes);

        // Then
        Assert.assertNotNull("Unit could not be created", unit);
    }

}
