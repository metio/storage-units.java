/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.TestObjects.highLevelLongBasedConstructors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class StorageUnitExpressionTest {

  public static final List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

  @TestFactory
  Stream<DynamicTest> shouldConvertUnitIntoAnotherUnit() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .flatMap(constructor -> expressions().stream()
            .map(expression -> {
              final var original = constructor.apply(1L);
              final var result = expression.apply(original);

              return DynamicTest.dynamicTest(String.format("%s -> %s", original.toString(), result.toString()), () -> {
                Assertions.assertNotNull(result, "Could not expression one unit as another");
              });
            }));
  }

  public static List<Function<StorageUnit<?>, BigDecimal>> expressions() {
    final List<Function<StorageUnit<?>, BigDecimal>> units = new ArrayList<>();

    units.add(StorageUnit::inKibibyte);
    units.add(StorageUnit::inMebibyte);
    units.add(StorageUnit::inGibibyte);
    units.add(StorageUnit::inTebibyte);
    units.add(StorageUnit::inPebibyte);
    units.add(StorageUnit::inExbibyte);
    units.add(StorageUnit::inZebibyte);
    units.add(StorageUnit::inYobibyte);

    units.add(StorageUnit::inKilobyte);
    units.add(StorageUnit::inMegabyte);
    units.add(StorageUnit::inGigabyte);
    units.add(StorageUnit::inTerabyte);
    units.add(StorageUnit::inPetabyte);
    units.add(StorageUnit::inExabyte);
    units.add(StorageUnit::inZettabyte);
    units.add(StorageUnit::inYottabyte);

    return units;
  }

}
