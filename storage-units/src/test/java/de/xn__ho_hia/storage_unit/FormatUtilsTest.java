/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.text.Format;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.FormatUtils;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 *
 *
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class FormatUtilsTest {

    /**
     * Ensures that the constructor of the {@link StorageUnits} class is private.
     * <p>
     * The class should never be instantiated. Instead use the static factory methods to construct storage units.
     *
     * @throws NoSuchMethodException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws IllegalAccessException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws InvocationTargetException
     *             Should not fail in case the StorageUnits class has a constructor..
     * @throws InstantiationException
     *             Should not fail in case the StorageUnits class has a constructor..
     */
    @Test
    public void shouldDeclarePrivateConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        final Constructor<FormatUtils> constructor = FormatUtils.class.getDeclaredConstructor();

        // When
        final boolean isPrivate = Modifier.isPrivate(constructor.getModifiers());

        // Then
        Assert.assertTrue("Constructor is not private", isPrivate);
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Ensures that a {@link Format} can be created from a pattern and a {@link Locale}.
     */
    @Test
    public void shouldCreateFormat() {
        // given
        final String pattern = "#.#";
        final Locale locale = Locale.GERMAN;

        // when
        final Format format = FormatUtils.asFormat(pattern, locale);

        // then
        Assert.assertNotNull(format);
    }

}
