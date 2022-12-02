/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Locale;

class FormatUtilsTest {

    @Test
    void declarePrivateConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        final var constructor = FormatUtils.class.getDeclaredConstructor();

        // When
        final var isPrivate = Modifier.isPrivate(constructor.getModifiers());

        // Then
        Assertions.assertTrue(isPrivate, "Constructor is not private");
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    void createFormat() {
        // given
        final var pattern = "#.#";
        final var locale = Locale.GERMAN;

        // when
        final var format = FormatUtils.asFormat(pattern, locale);

        // then
        Assertions.assertNotNull(format);
    }

}
