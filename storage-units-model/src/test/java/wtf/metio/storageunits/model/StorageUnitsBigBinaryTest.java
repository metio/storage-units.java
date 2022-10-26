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

public class StorageUnitsBigBinaryTest {

    private static final BigInteger MULTIPLIER = BigInteger.valueOf(1024);

    public static List<Map.Entry<BigInteger, Class<? extends StorageUnit<?>>>> INPUTS = List.of(
        Map.entry(BigInteger.ONE, Byte.class),
        Map.entry(MULTIPLIER, Kibibyte.class),
        Map.entry(MULTIPLIER.pow(2), Mebibyte.class),
        Map.entry(MULTIPLIER.pow(3), Gibibyte.class),
        Map.entry(MULTIPLIER.pow(4), Tebibyte.class),
        Map.entry(MULTIPLIER.pow(5), Pebibyte.class),
        Map.entry(MULTIPLIER.pow(6), Exbibyte.class),
        Map.entry(MULTIPLIER.pow(7), Zebibyte.class),
        Map.entry(MULTIPLIER.pow(8), Yobibyte.class),
        Map.entry(MULTIPLIER.pow(9), Yobibyte.class)
    );

    @TestFactory
    Stream<DynamicTest> shouldCreateCorrectBinaryUnit() {
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
    Stream<DynamicTest> shouldCreateCorrectBinaryUnitNegated() {
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
