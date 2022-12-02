/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

final class StorageUnitsWithLongTest {

    @TestFactory
    Stream<DynamicTest> createNotNullUnit() {
        return TestObjects.highLevelLongBasedConstructors().stream()
                .map(constructor -> {
                    final var unit = constructor.apply(1L);

                    return DynamicTest.dynamicTest(unit.toString(), () -> Assertions.assertNotNull(unit));
                });
    }

}
