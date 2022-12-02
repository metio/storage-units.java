/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class StorageUnitArithmeticLongTest {

    private static LongStream numberOfBytes() {
        return LongStream.of(1, 2, 3, 5, 8, 13, 100, 500, -500, 123456789);
    }

    @TestFactory
    Stream<DynamicTest> addNumberOfBytes() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = 1L;
                            final var unit = constructor.apply(initialAmount);
                            final var operation = bytes < 0 ? "-" : "+";

                            return DynamicTest.dynamicTest(
                                    String.format("%s %s %s Bytes", unit.toString(), operation, Math.abs(bytes)), () -> {
                                        final var calculatedResult = unit.add(bytes);
                                        final var expectedResult = BigInteger.valueOf(initialAmount + bytes);

                                        Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                                    });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> addStorageUnit() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = bytes;
                            final var amountToAdd = 1L;
                            final var unit = constructor.apply(initialAmount);
                            final var unitToAdd = constructor.apply(amountToAdd);

                            return DynamicTest.dynamicTest(String.format("%s + 1", unit.toString()), () -> {
                                final var calculatedResult = unit.add(unitToAdd);
                                final var expectedResult = BigInteger.valueOf(initialAmount + amountToAdd);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterAddLong() {
        return TestObjects.longBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = 1L;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(
                            String.format("%s + 1000 Bytes", first.toString()), () -> {
                                final var second = first.add(1000);

                                Assertions.assertNotSame(first, second, "The add(long) method must return a new instance.");
                            });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterDivide() {
        return TestObjects.longBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = 1000L;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(
                            String.format("%s / 5", first.toString()), () -> {
                                final var second = first.divide(5);

                                Assertions.assertNotSame(first, second, "The divide(long) method must return a new instance.");
                            });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterMultiply() {
        return TestObjects.longBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = 1000L;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(
                            String.format("%s * 5", first.toString()), () -> {
                                final var second = first.multiply(5);

                                Assertions.assertNotSame(first, second, "The multiply(long) method must return a new instance.");
                            });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterSubtractLong() {
        return TestObjects.longBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = 1000L;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(
                            String.format("%s - 20 Bytes", first.toString()), () -> {
                                final var second = first.subtract(20);

                                Assertions.assertNotSame(first, second, "The subtract(long) method must return a new instance.");
                            });
                });
    }

    @TestFactory
    Stream<DynamicTest> subtractStorageUnit() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = bytes;
                            final var amountToSubtract = 1L;
                            final var unit = constructor.apply(initialAmount);
                            final var unitToSubtract = constructor.apply(amountToSubtract);

                            return DynamicTest.dynamicTest(String.format("%s - 1", unit.toString()), () -> {
                                final var calculatedResult = unit.subtract(unitToSubtract);
                                final var expectedResult = BigInteger.valueOf(initialAmount - amountToSubtract);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> subtractLong() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = bytes;
                            final var amountToSubtract = 1L;
                            final var unit = constructor.apply(initialAmount);

                            return DynamicTest.dynamicTest(String.format("%s - 1", unit.toString()), () -> {
                                final var calculatedResult = unit.subtract(amountToSubtract);
                                final var expectedResult = BigInteger.valueOf(initialAmount - amountToSubtract);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> divideLong() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = bytes;
                            final var unit = constructor.apply(initialAmount);

                            return DynamicTest.dynamicTest(String.format("%s / 1", unit.toString()), () -> {
                                final var calculatedResult = unit.divide(1);
                                final var expectedResult = BigInteger.valueOf(initialAmount);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> multiplyLong() {
        return TestObjects.longBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = bytes;
                            final var unit = constructor.apply(initialAmount);

                            return DynamicTest.dynamicTest(String.format("%s * 1", unit.toString()), () -> {
                                final var calculatedResult = unit.multiply(1);
                                final var expectedResult = BigInteger.valueOf(initialAmount);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

}
