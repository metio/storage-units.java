/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
