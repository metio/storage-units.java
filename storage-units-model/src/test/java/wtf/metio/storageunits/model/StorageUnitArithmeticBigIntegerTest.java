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

class StorageUnitArithmeticBigIntegerTest {

    private LongStream numberOfBytes() {
        return LongStream.of(1, 2, 3, 5, 8, 13, 100, 500, -500, 123456789);
    }

    @TestFactory
    Stream<DynamicTest> shouldAddNumberOfBytes() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = BigInteger.ONE;
                            final var unit = constructor.apply(initialAmount);
                            final var operation = bytes < 0 ? "-" : "+";

                            return DynamicTest.dynamicTest(
                                    String.format("%s %s %s Bytes", unit.toString(), operation, Math.abs(bytes)), () -> {
                                        final var calculatedResult = unit.add(bytes);
                                        final var expectedResult = initialAmount.add(BigInteger.valueOf(bytes));

                                        Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                                    });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldAddStorageUnit() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = BigInteger.valueOf(bytes);
                            final var amountToAdd = BigInteger.ONE;
                            final var unit = constructor.apply(initialAmount);
                            final var unitToAdd = constructor.apply(amountToAdd);

                            return DynamicTest.dynamicTest(String.format("%s + 1", unit.toString()), () -> {
                                final var calculatedResult = unit.add(unitToAdd);
                                final var expectedResult = initialAmount.add(amountToAdd);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldSubtractStorageUnit() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = BigInteger.valueOf(bytes);
                            final var amountToSubtract = BigInteger.ONE;
                            final var unit = constructor.apply(initialAmount);
                            final var unitToSubtract = constructor.apply(amountToSubtract);

                            return DynamicTest.dynamicTest(String.format("%s - 1", unit.toString()), () -> {
                                final var calculatedResult = unit.subtract(unitToSubtract);
                                final var expectedResult = initialAmount.subtract(amountToSubtract);

                                Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                            });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> shouldReturnNewInstanceAfterAddLong() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.ONE;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s + 1000 Bytes", first.toString()), () -> {
                        final var second = first.add(1000);

                        Assertions.assertNotSame(first, second, "The add(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> shouldReturnNewInstanceAfterDivide() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s / 5", first.toString()), () -> {
                        final var second = first.divide(5);

                        Assertions.assertNotSame(first, second, "The divide(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> shouldReturnNewInstanceAfterMultiply() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s * 5", first.toString()), () -> {
                        final var second = first.multiply(5);

                        Assertions.assertNotSame(first, second, "The multiply(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> shouldReturnNewInstanceAfterSubtractLong() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s - 100 Bytes", first.toString()), () -> {
                        final var second = first.subtract(100);

                        Assertions.assertNotSame(first, second, "The subtract(long) method must return a new instance.");
                    });
                });
    }

}
