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
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static wtf.metio.storageunits.model.StorageUnit.*;

/**
 * Formatting test cases for the {@link StorageUnits} class.
 */
public class StorageUnitsFormattingWithPatternTest {

    private static final String PATTERN = "#0.0";

    private static final List<BigInteger> BYTES = List.of(
            BYTES_IN_A_KIBIBYTE,
            BYTES_IN_A_MEBIBYTE,
            BYTES_IN_A_GIBIBYTE,
            BYTES_IN_A_TEBIBYTE,
            BYTES_IN_A_PEBIBYTE,
            BYTES_IN_A_EXBIBYTE,
            BYTES_IN_A_ZEBIBYTE,
            BYTES_IN_A_YOBIBYTE,
            BYTES_IN_A_ROBIBYTE,
            BYTES_IN_A_QUBIBYTE,
            BYTES_IN_A_KILOBYTE,
            BYTES_IN_A_MEGABYTE,
            BYTES_IN_A_GIGABYTE,
            BYTES_IN_A_TERABYTE,
            BYTES_IN_A_PETABYTE,
            BYTES_IN_A_EXABYTE,
            BYTES_IN_A_ZETTABYTE,
            BYTES_IN_A_YOTTABYTE,
            BYTES_IN_A_RONNABYTE,
            BYTES_IN_A_QUETTABYTE
    );

    private static final List<BiFunction<BigInteger, String, String>> BIG_INTEGER_FORMATTERS = List.of(
            StorageUnits::formatAsBinaryUnit,
            StorageUnits::formatAsKibibyte,
            StorageUnits::formatAsMebibyte,
            StorageUnits::formatAsGibibyte,
            StorageUnits::formatAsTebibyte,
            StorageUnits::formatAsPebibyte,
            StorageUnits::formatAsExbibyte,
            StorageUnits::formatAsZebibyte,
            StorageUnits::formatAsYobibyte,
            StorageUnits::formatAsRobibyte,
            StorageUnits::formatAsQubibyte,
            StorageUnits::formatAsDecimalUnit,
            StorageUnits::formatAsKilobyte,
            StorageUnits::formatAsMegabyte,
            StorageUnits::formatAsGigabyte,
            StorageUnits::formatAsTerabyte,
            StorageUnits::formatAsPetabyte,
            StorageUnits::formatAsExabyte,
            StorageUnits::formatAsZettabyte,
            StorageUnits::formatAsYottabyte,
            StorageUnits::formatAsRonnabyte,
            StorageUnits::formatAsQuettabyte
    );

    private static final List<BiFunction<Long, String, String>> LONG_FORMATTERS = List.of(
            StorageUnits::formatAsBinaryUnit,
            StorageUnits::formatAsKibibyte,
            StorageUnits::formatAsMebibyte,
            StorageUnits::formatAsGibibyte,
            StorageUnits::formatAsTebibyte,
            StorageUnits::formatAsPebibyte,
            StorageUnits::formatAsExbibyte,
            StorageUnits::formatAsZebibyte,
            StorageUnits::formatAsYobibyte,
            StorageUnits::formatAsRobibyte,
            StorageUnits::formatAsQubibyte,
            StorageUnits::formatAsDecimalUnit,
            StorageUnits::formatAsKilobyte,
            StorageUnits::formatAsMegabyte,
            StorageUnits::formatAsGigabyte,
            StorageUnits::formatAsTerabyte,
            StorageUnits::formatAsPetabyte,
            StorageUnits::formatAsExabyte,
            StorageUnits::formatAsZettabyte,
            StorageUnits::formatAsYottabyte,
            StorageUnits::formatAsRonnabyte,
            StorageUnits::formatAsQuettabyte
    );

    @TestFactory
    Stream<DynamicTest> formatBigIntegerAsStorageUnitWithPattern() {
        return BIG_INTEGER_FORMATTERS.stream()
                .flatMap(formatter -> BYTES.stream()
                        .map(bytes -> DynamicTest.dynamicTest(String.format("%s formatted", bytes),
                                () -> Assertions.assertNotNull(formatter.apply(bytes, PATTERN)))));
    }

    @TestFactory
    Stream<DynamicTest> formatLongAsStorageUnitWithPattern() {
        return LONG_FORMATTERS.stream()
                .flatMap(formatter -> BYTES.stream()
                        .map(bytes -> DynamicTest.dynamicTest(String.format("%s formatted", bytes),
                                () -> Assertions.assertNotNull(formatter.apply(bytes.longValue(), PATTERN)))));
    }

}
