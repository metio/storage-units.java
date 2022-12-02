/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static wtf.metio.storageunits.model.TestObjects.BINARY_MULTIPLIER;
import static wtf.metio.storageunits.model.TestUtils.logIncorrectCreation;

class StorageUnitsBigBinaryTest {

    private static final BigInteger MULTIPLIER = BigInteger.valueOf(BINARY_MULTIPLIER);

    private static final List<Map.Entry<BigInteger, Class<? extends StorageUnit<?>>>> INPUTS = List.of(
            Map.entry(BigInteger.ONE, Byte.class),
            Map.entry(MULTIPLIER, Kibibyte.class),
            Map.entry(MULTIPLIER.pow(2), Mebibyte.class),
            Map.entry(MULTIPLIER.pow(3), Gibibyte.class),
            Map.entry(MULTIPLIER.pow(4), Tebibyte.class),
            Map.entry(MULTIPLIER.pow(5), Pebibyte.class),
            Map.entry(MULTIPLIER.pow(6), Exbibyte.class),
            Map.entry(MULTIPLIER.pow(7), Zebibyte.class),
            Map.entry(MULTIPLIER.pow(8), Yobibyte.class),
            Map.entry(MULTIPLIER.pow(9), Robibyte.class),
            Map.entry(MULTIPLIER.pow(10), Qubibyte.class),
            Map.entry(MULTIPLIER.pow(11), Qubibyte.class)
    );

    @TestFactory
    Stream<DynamicTest> createBinaryUnit() {
        return INPUTS.stream()
                .map(entry -> {
                    final BigInteger bytes = entry.getKey();
                    final Class<? extends StorageUnit<?>> expectedClass = entry.getValue();

                    return DynamicTest.dynamicTest(String.format("%s Bytes as %s", bytes, expectedClass.getSimpleName()), () -> {
                        final StorageUnit<?> unit = StorageUnits.binaryValueOf(bytes);
                        final Class<?> unitClass = unit.getClass();

                        Assertions.assertEquals(expectedClass, unitClass, logIncorrectCreation(bytes, expectedClass, unitClass));
                    });
                });
    }

    @TestFactory
    Stream<DynamicTest> createBinaryUnitNegated() {
        return INPUTS.stream()
                .map(entry -> {
                    final BigInteger bytes = entry.getKey();
                    final Class<? extends StorageUnit<?>> expectedClass = entry.getValue();

                    return DynamicTest.dynamicTest(String.format("%s Bytes as %s", bytes.negate(), expectedClass.getSimpleName()), () -> {
                        final StorageUnit<?> unit = StorageUnits.binaryValueOf(bytes.negate());
                        final Class<?> unitClass = unit.getClass();

                        Assertions.assertEquals(expectedClass, unitClass, logIncorrectCreation(bytes.negate(), expectedClass, unitClass));
                    });
                });
    }

}
