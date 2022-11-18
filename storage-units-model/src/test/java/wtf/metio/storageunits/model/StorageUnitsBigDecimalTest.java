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

import static wtf.metio.storageunits.model.TestObjects.DECIMAL_MULTIPLIER;
import static wtf.metio.storageunits.model.TestUtils.logIncorrectCreation;

class StorageUnitsBigDecimalTest {

    private static final BigInteger MULTIPLIER = BigInteger.valueOf(DECIMAL_MULTIPLIER);

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
            Map.entry(MULTIPLIER.pow(9), Ronnabyte.class),
            Map.entry(MULTIPLIER.pow(10), Quettabyte.class),
            Map.entry(MULTIPLIER.pow(11), Quettabyte.class)
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
