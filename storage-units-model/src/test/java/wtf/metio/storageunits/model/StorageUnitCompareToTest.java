/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

/**
 * Test cases for the {@link StorageUnit} class and its behavior towards comparing one unit with another.
 */
final class StorageUnitCompareToTest {

    @TestFactory
    Stream<DynamicTest> compareSmallerToBiggerUnit() {
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
    Stream<DynamicTest> compareBiggerToSmallerUnit() {
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
    Stream<DynamicTest> compareEqualSizedUnit() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(first -> TestObjects.longBasedConstructors().stream()
                        .map(second -> {
                            final Long amount = 123L;
                            final StorageUnit<?> firstUnit = first.apply(amount);
                            final StorageUnit<?> secondUnit = second.apply(amount);

                            return DynamicTest.dynamicTest(String.format("%s = %s", firstUnit, secondUnit), () ->
                                    Assertions.assertEquals(0, firstUnit.compareTo(secondUnit),
                                            "The equally sized units where not detected as such."));
                        }));
    }

}
