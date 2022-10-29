/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Stream;

class StorageUnitsParseTest {

    @TestFactory
    Stream<DynamicTest> shouldParseStrings() {
        return Map.ofEntries(
                        Map.entry("100", BigInteger.valueOf(100L)),
                        Map.entry("100 b", BigInteger.valueOf(100L)),
                        Map.entry("10 kB", BigInteger.valueOf(10L * 1000L)),
                        Map.entry("10 KiB", BigInteger.valueOf(10L * 1024L)),
                        Map.entry("5 MB", BigInteger.valueOf(5L * 1000L * 1000L)),
                        Map.entry("5 MiB", BigInteger.valueOf(5L * 1024L * 1024L))
                )
                .entrySet().stream()
                .map(entry -> DynamicTest.dynamicTest(entry.getKey(),
                        () -> Assertions.assertEquals(entry.getValue(), StorageUnits.parse(entry.getKey()).inByte())));
    }

}
