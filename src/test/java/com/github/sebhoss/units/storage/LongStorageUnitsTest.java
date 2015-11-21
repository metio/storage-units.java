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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 *
 *
 */
@RunWith(Theories.class)
public class LongStorageUnitsTest {

    /**
     * @return The factory methods to create storage units to test.
     */
    @DataPoints
    public static List<Function<Long, StorageUnit<?>>> longStorageUnits() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();

        // binary units
        units.add(StorageUnits::kibibyte);
        units.add(StorageUnits::mebibyte);
        units.add(StorageUnits::gibibyte);
        units.add(StorageUnits::pebibyte);
        units.add(StorageUnits::tebibyte);
        units.add(StorageUnits::exbibyte);
        units.add(StorageUnits::zebibyte);
        units.add(StorageUnits::yobibyte);

        // metric units
        units.add(StorageUnits::kilobyte);
        units.add(StorageUnits::megabyte);
        units.add(StorageUnits::gigabyte);
        units.add(StorageUnits::petabyte);
        units.add(StorageUnits::terabyte);
        units.add(StorageUnits::exabyte);
        units.add(StorageUnits::zettabyte);
        units.add(StorageUnits::yottabyte);

        return units;
    }

    /**
     * @param createUnit
     *            The creation function for the storage unit under test.
     */
    @SuppressWarnings({ "static-method", "nls" })
    @Theory
    public void shouldCreateNotNullUnitForLong(final Function<Long, StorageUnit<?>> createUnit) {
        // Given
        final Long bytes = Long.valueOf(1);

        // When
        final StorageUnit<?> unit = createUnit.apply(bytes);

        // Then
        Assert.assertNotNull("Unit could not be created", unit);
    }

    /**
     * @throws NoSuchMethodException
     *             exc
     * @throws IllegalAccessException
     *             exc
     * @throws InvocationTargetException
     *             exc
     * @throws InstantiationException
     *             exc
     */
    @Test
    @SuppressWarnings({ "static-method", "nls" })
    public void shouldDeclarePrivateConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Constructor<StorageUnits> constructor = StorageUnits.class.getDeclaredConstructor();
        Assert.assertTrue("Constructor is not private", Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
