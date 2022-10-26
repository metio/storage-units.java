/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
