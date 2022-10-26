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

/**
 * Test cases for the {@link StorageUnit} class and its behavior towards comparing one unit with another.
 */
final class StorageUnitCompareToTest {

  @TestFactory
  Stream<DynamicTest> shouldCompareSmallerToBiggerUnit() {
    return TestObjects.longBasedConstructors().stream()
        .flatMap(first -> TestObjects.longBasedConstructors().stream()
            .map(second -> {
              final Long smallerAmount = 123L;
              final Long biggerAmount = 987L;
              final StorageUnit<?> smallerUnit = first.apply(smallerAmount);
              final StorageUnit<?> biggerUnit = second.apply(biggerAmount);

              return DynamicTest.dynamicTest(String.format("%s < %s", smallerUnit, biggerUnit), () ->
                  Assertions.assertTrue(smallerUnit.compareTo(biggerUnit) < 0,
                      "The smaller unit was not smaller than the bigger unit."));
            }));
  }

  @TestFactory
  Stream<DynamicTest> shouldCompareBiggerToSmallerUnit() {
    return TestObjects.longBasedConstructors().stream()
        .flatMap(first -> TestObjects.longBasedConstructors().stream()
            .map(second -> {
              final Long smallerAmount = 123L;
              final Long biggerAmount = 987L;
              final StorageUnit<?> smallerUnit = first.apply(smallerAmount);
              final StorageUnit<?> biggerUnit = second.apply(biggerAmount);

              return DynamicTest.dynamicTest(String.format("%s > %s", biggerUnit, smallerUnit), () ->
                  Assertions.assertTrue(biggerUnit.compareTo(smallerUnit) > 0,
                      "The bigger unit was not bigger than the smaller unit."));
            }));
  }

  @TestFactory
  Stream<DynamicTest> shouldCompareEqualSizedUnit() {
    return TestObjects.longBasedConstructors().stream()
        .flatMap(first -> TestObjects.longBasedConstructors().stream()
            .map(second -> {
              final Long amount = 123L;
              final StorageUnit<?> firstUnit = first.apply(amount);
              final StorageUnit<?> secondUnit = second.apply(amount);

              return DynamicTest.dynamicTest(String.format("%s = %s", firstUnit, secondUnit), () ->
                  Assertions.assertTrue(firstUnit.compareTo(secondUnit) == 0,
                      "The equally sized units where not detected as such."));
            }));
  }

}
