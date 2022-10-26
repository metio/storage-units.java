/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class StorageUnitConversionTest {

  @TestFactory
  Stream<DynamicTest> shouldConvertUnitIntoAnotherUnit() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .flatMap(constructor -> expressions().stream()
            .map(expression -> {
              final var original = constructor.apply(1L);
              final var result = expression.apply(original);

              return DynamicTest.dynamicTest(String.format("%s -> %s", original.toString(), result.toString()), () -> {
                Assertions.assertAll(
                    () -> Assertions.assertNotNull(result, "Could not convert one unit into another"),
                    () -> Assertions.assertEquals(original.inByte(), result.inByte(),
                        "Amounts should be the same after conversion")
                );
              });
            }));
  }

  public static List<Function<StorageUnit<?>, StorageUnit<?>>> expressions() {
    final List<Function<StorageUnit<?>, StorageUnit<?>>> units = new ArrayList<>();

    units.add(StorageUnit::asBestMatchingBinaryUnit);
    units.add(StorageUnit::asBestMatchingDecimalUnit);
    units.add(StorageUnit::asBestMatchingUnit);

    units.add(StorageUnit::asByte);

    units.add(StorageUnit::asKibibyte);
    units.add(StorageUnit::asMebibyte);
    units.add(StorageUnit::asGibibyte);
    units.add(StorageUnit::asTebibyte);
    units.add(StorageUnit::asPebibyte);
    units.add(StorageUnit::asExbibyte);
    units.add(StorageUnit::asZebibyte);
    units.add(StorageUnit::asYobibyte);

    units.add(StorageUnit::asKilobyte);
    units.add(StorageUnit::asMegabyte);
    units.add(StorageUnit::asGigabyte);
    units.add(StorageUnit::asTerabyte);
    units.add(StorageUnit::asPetabyte);
    units.add(StorageUnit::asExabyte);
    units.add(StorageUnit::asZettabyte);
    units.add(StorageUnit::asYottabyte);

    return units;
  }

}
