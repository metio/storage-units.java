/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

class StorageUnitsTest {

    @Test
    void shouldDeclarePrivateConstructor()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        final var constructor = StorageUnits.class.getDeclaredConstructor();

        // When
        final boolean isPrivate = Modifier.isPrivate(constructor.getModifiers());

        // Then
        Assertions.assertTrue(isPrivate, "Constructor is not private");
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
