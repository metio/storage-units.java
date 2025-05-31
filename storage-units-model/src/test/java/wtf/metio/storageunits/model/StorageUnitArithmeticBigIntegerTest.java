/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class StorageUnitArithmeticBigIntegerTest {

    private static final int WHOLE_TEST = 42;
    private static LongStream numberOfBytes() {
        return LongStream.of(1, 2, 3, 5, 8, 13, 100, 500, -500, 123456789);
    }

    @TestFactory
    Stream<DynamicTest> addNumberOfBytes() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .flatMap(constructor -> numberOfBytes()
                        .mapToObj(bytes -> {
                            final var initialAmount = BigInteger.ONE;
                            final var unit = constructor.apply(initialAmount);
                            final var operation = bytes < 0 ? "-" : "+";

                            return DynamicTest.dynamicTest(
                                    String.format("%s %s %s Bytes", unit.toString(), operation, Math.abs(bytes)), () -> {
                                        final var calculatedResult = unit.add(BigInteger.valueOf(bytes));
                                        final var expectedResult = initialAmount.add(BigInteger.valueOf(bytes));

                                        Assertions.assertEquals(expectedResult, calculatedResult.inByte());
                                    });
                        }));
    }

    @TestFactory
    Stream<DynamicTest> addStorageUnit() {
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
    Stream<DynamicTest> subtractStorageUnit() {
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
    Stream<DynamicTest> returnNewInstanceAfterAddBigInteger() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.ONE;
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s + 1000 Bytes", first.toString()), () -> {
                        final var second = first.add(BigInteger.valueOf(1000));

                        Assertions.assertNotSame(first, second, "The add(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterDivide() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s / 5", first.toString()), () -> {
                        final var second = first.divide(BigInteger.valueOf(5));

                        Assertions.assertNotSame(first, second, "The divide(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterMultiply() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s * 5", first.toString()), () -> {
                        final var second = first.multiply(BigInteger.valueOf(5));

                        Assertions.assertNotSame(first, second, "The multiply(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> returnNewInstanceAfterSubtractBigInteger() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var initialAmount = BigInteger.valueOf(1000);
                    final var first = constructor.apply(initialAmount);

                    return DynamicTest.dynamicTest(String.format("%s - 100 Bytes", first.toString()), () -> {
                        final var second = first.subtract(BigInteger.valueOf(100));

                        Assertions.assertNotSame(first, second, "The subtract(long) method must return a new instance.");
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> getUnitValue() {

        record D(Function<BigInteger, StorageUnit<?>> constructor, RoundingMode rm) {}

        return Arrays.stream(RoundingMode.values()).flatMap(rm->
                TestObjects.bigIntegerBasedConstructors().stream().map(e->new D(e, rm)))
                .map(ti -> {
                    final var initialAmount = BigInteger.valueOf(1);
                    final var first = ti.constructor.apply(initialAmount);
                    final var bpu = first.getNumberOfBytesPerUnit();
                    final int digits = first.getNumberOfBytesPerUnit().toString().length();

                    return DynamicTest.dynamicTest(String.format("getUnitValue() - %s - %s", first.getClass().getSimpleName(), ti.rm), () -> {

                        // fill it up to the brim.
                        StringBuilder sb = new StringBuilder(digits);
                        for (int i = 0; i < digits; i++) { sb.append((char)(i%9+ '1')); }
                        var testValue = new BigInteger(sb.toString());
                        final var real = ti.constructor.apply(testValue);

                        // do the math ourselves and compare? What else can we do.
                        // scale value of 1000 - just something that's guaranteed to cover
                        // all defined units, and isn't too large enough to slow JDK down
                        var exp = new BigDecimal(testValue).divide(new BigDecimal(bpu), 1000, ti.rm).stripTrailingZeros();
                        Assertions.assertEquals(exp, real.unitValue(ti.rm), ()->"unitValue() - "+ti.rm + " on "+testValue + ", bpu="+bpu +", scale="+real.conversionScale());

                        // make sure we didn't miswire any of the implementations.
                        Assertions.assertEquals(StorageUnit.computeFiniteConversionScale(bpu), real.conversionScale());

                        if (ti.rm != RoundingMode.UNNECESSARY) {
                            var wholeExp = new BigDecimal(testValue).divide(new BigDecimal(bpu), 0, ti.rm).toBigInteger();
                            Assertions.assertEquals(wholeExp, real.wholeUnitValue(ti.rm), () -> "wholeUnitValue() - " + ti.rm + " on " + testValue + ", bpu=" + bpu + ", scale=" + real.conversionScale());
                        }

                        var remExp = testValue.remainder(bpu);
                        Assertions.assertEquals(remExp, real.remainder());

                        if (bpu.equals(BigInteger.ONE)) {
                            Assertions.assertTrue(real.isWhole());
                        } else {
                            Assertions.assertFalse(real.isWhole());
                            var whole = ti.constructor.apply(BigInteger.valueOf(WHOLE_TEST).multiply(bpu));
                            Assertions.assertTrue(whole.isWhole());
                            if (ti.rm == RoundingMode.UNNECESSARY) {
                                Assertions.assertEquals(BigInteger.valueOf(WHOLE_TEST), whole.wholeUnitValue(ti.rm));
                            }
                        }

                    });
                });
    }

}
