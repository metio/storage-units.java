/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.TestUtils.logIncorrectCreation;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class StorageUnitsBigDecimalTest {

  private static final BigInteger MULTIPLIER = BigInteger.valueOf(1000);

  private static final List<Map.Entry<BigInteger, Class<? extends StorageUnit<?>>>> INPUTS = List.of(
      Map.entry(BigInteger.ONE, Byte.class),
      Map.entry(MULTIPLIER, Kilobyte.class),
      Map.entry(MULTIPLIER.pow(2), Megabyte.class),
      Map.entry(MULTIPLIER.pow(3), Gigabyte.class),
      Map.entry(MULTIPLIER.pow(4), Terabyte.class),
      Map.entry(MULTIPLIER.pow(5), Petabyte.class),
      Map.entry(MULTIPLIER.pow(6), Exabyte.class),
      Map.entry(MULTIPLIER.pow(7), Zettabyte.class),
      Map.entry(MULTIPLIER.pow(8), Yottabyte.class),
      Map.entry(MULTIPLIER.pow(9), Yottabyte.class)
  );

  @TestFactory
  Stream<DynamicTest> shouldCreateCorrectDecimalUnit() {
    return INPUTS.stream()
        .map(entry -> {
          final BigInteger bytes = entry.getKey();
          final Class<? extends StorageUnit<?>> expectedClass = entry.getValue();

          return DynamicTest.dynamicTest(String.format("%s Bytes as %s", bytes, expectedClass.getSimpleName()), () -> {
            final StorageUnit<?> unit = StorageUnits.decimalValueOf(bytes);
            final Class<?> unitClass = unit.getClass();

            Assertions.assertEquals(expectedClass, unitClass, logIncorrectCreation(bytes, expectedClass, unitClass));
          });
        });
  }

  @TestFactory
  Stream<DynamicTest> shouldCreateCorrectDecimalUnitNegated() {
    return INPUTS.stream()
        .map(entry -> {
          final BigInteger bytes = entry.getKey();
          final Class<? extends StorageUnit<?>> expectedClass = entry.getValue();

          return DynamicTest.dynamicTest(String.format("%s Bytes as %s", bytes.negate(), expectedClass.getSimpleName()),
              () -> {
                final StorageUnit<?> unit = StorageUnits.decimalValueOf(bytes.negate());
                final Class<?> unitClass = unit.getClass();

                Assertions.assertEquals(expectedClass, unitClass,
                    logIncorrectCreation(bytes.negate(), expectedClass, unitClass));
              });
        });
  }

}
