/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class StorageUnitTest {

  @TestFactory
  Stream<DynamicTest> shouldThrowNPEForNullCompareToCheck() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .map(constructor -> constructor.apply(1L))
        .map(unit -> DynamicTest.dynamicTest(String.format("%s compared to null", unit),
            () -> Assertions.assertThrows(NullPointerException.class, () -> unit.compareTo(null))));
  }

  @TestFactory
  Stream<DynamicTest> shouldBeEqualToItself() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .map(constructor -> constructor.apply(1L))
        .map(unit -> DynamicTest.dynamicTest(String.format("%s compared to null", unit),
            () -> Assertions.assertEquals(unit, unit, "Unit is not equal to itself")));
  }

  @TestFactory
  Stream<DynamicTest> shouldNotBeEqualToSomethingElse() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .map(constructor -> constructor.apply(1L))
        .map(unit -> DynamicTest.dynamicTest(String.format("%s compared to some object", unit),
            () -> Assertions.assertNotEquals(unit, new Object(), "Unit is equal to something else")));
  }

  @Test
  void shouldCalculateHashCode() {
    // Given
    final var unit = StorageUnits.kibibyte(1);

    // When
    final int hashCode = unit.hashCode();

    // Then
    Assertions.assertEquals(1024, hashCode, "Conversion was not correct");
  }

}
