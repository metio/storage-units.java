/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.math.BigInteger;
import java.util.stream.Stream;

class StorageUnitsWithBigIntegerTest {

    @TestFactory
    Stream<DynamicTest> createNotNullUnit() {
        return TestObjects.highLevelBigIntegerBasedConstructors().stream()
                .map(constructor -> {
                    final var unit = constructor.apply(BigInteger.ONE);

                    return DynamicTest.dynamicTest(unit.toString(), () -> Assertions.assertNotNull(unit));
                });
    }

}
