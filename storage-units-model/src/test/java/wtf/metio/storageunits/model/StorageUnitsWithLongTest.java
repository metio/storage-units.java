/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

final class StorageUnitsWithLongTest {

  @TestFactory
  Stream<DynamicTest> shouldCreateNotNullUnit() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .map(constructor -> {
          final var unit = constructor.apply(1L);

          return DynamicTest.dynamicTest(unit.toString(), () -> Assertions.assertNotNull(unit));
        });
  }

}
