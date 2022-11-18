/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

class StorageUnitConversionTest {

    @TestFactory
    Stream<DynamicTest> shouldConvertUnitIntoAnotherUnit() {
        return TestObjects.highLevelLongBasedConstructors().stream()
                .flatMap(constructor -> expressions().stream()
                        .map(expression -> {
                            final var original = constructor.apply(1L);
                            final var result = expression.apply(original);

                            return DynamicTest.dynamicTest(String.format("%s -> %s", original.toString(), result.toString()), () ->
                                    Assertions.assertAll(
                                            () -> Assertions.assertNotNull(result, "Could not convert one unit into another"),
                                            () -> Assertions.assertEquals(original.inByte(), result.inByte(),
                                                    "Amounts should be the same after conversion")
                                    ));
                        }));
    }

    public static List<Function<StorageUnit<?>, StorageUnit<?>>> expressions() {
        final List<Function<StorageUnit<?>, StorageUnit<?>>> units = new ArrayList<>();

        units.add(StorageUnit::asBestMatchingBinaryUnit);
        units.add(StorageUnit::asBestMatchingDecimalUnit);
        units.add(StorageUnit::asBestMatchingUnit);

        units.add(StorageUnit::asByte);

        units.add(StorageUnit::asKibibyte);
        units.add(StorageUnit::asMebibyte);
        units.add(StorageUnit::asGibibyte);
        units.add(StorageUnit::asTebibyte);
        units.add(StorageUnit::asPebibyte);
        units.add(StorageUnit::asExbibyte);
        units.add(StorageUnit::asZebibyte);
        units.add(StorageUnit::asYobibyte);
        units.add(StorageUnit::asRobibyte);
        units.add(StorageUnit::asQubibyte);

        units.add(StorageUnit::asKilobyte);
        units.add(StorageUnit::asMegabyte);
        units.add(StorageUnit::asGigabyte);
        units.add(StorageUnit::asTerabyte);
        units.add(StorageUnit::asPetabyte);
        units.add(StorageUnit::asExabyte);
        units.add(StorageUnit::asZettabyte);
        units.add(StorageUnit::asYottabyte);
        units.add(StorageUnit::asRonnabyte);
        units.add(StorageUnit::asQuettabyte);

        return units;
    }

}
