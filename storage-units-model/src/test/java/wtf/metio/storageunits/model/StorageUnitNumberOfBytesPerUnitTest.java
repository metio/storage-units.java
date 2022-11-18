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

class StorageUnitNumberOfBytesPerUnitTest {

    private static final Map<Class<?>, BigInteger> EXPECTED_NUMBERS = Map.ofEntries(
            Map.entry(Byte.class, new BigInteger("1")),
            // binary units
            Map.entry(Kibibyte.class, new BigInteger("1024")),
            Map.entry(Mebibyte.class, new BigInteger("1048576")),
            Map.entry(Gibibyte.class, new BigInteger("1073741824")),
            Map.entry(Tebibyte.class, new BigInteger("1099511627776")),
            Map.entry(Pebibyte.class, new BigInteger("1125899906842624")),
            Map.entry(Exbibyte.class, new BigInteger("1152921504606846976")),
            Map.entry(Zebibyte.class, new BigInteger("1180591620717411303424")),
            Map.entry(Yobibyte.class, new BigInteger("1208925819614629174706176")),
            Map.entry(Robibyte.class, new BigInteger("1237940039285380274899124224")),
            Map.entry(Qubibyte.class, new BigInteger("1267650600228229401496703205376")),
            // decimal units
            Map.entry(Kilobyte.class, new BigInteger("1000")),
            Map.entry(Megabyte.class, new BigInteger("1000000")),
            Map.entry(Gigabyte.class, new BigInteger("1000000000")),
            Map.entry(Terabyte.class, new BigInteger("1000000000000")),
            Map.entry(Petabyte.class, new BigInteger("1000000000000000")),
            Map.entry(Exabyte.class, new BigInteger("1000000000000000000")),
            Map.entry(Zettabyte.class, new BigInteger("1000000000000000000000")),
            Map.entry(Yottabyte.class, new BigInteger("1000000000000000000000000")),
            Map.entry(Ronnabyte.class, new BigInteger("1000000000000000000000000000")),
            Map.entry(Quettabyte.class, new BigInteger("1000000000000000000000000000000"))
    );

    @TestFactory
    Stream<DynamicTest> shouldReturnNumberOfBytesPerUnit() {
        return TestObjects.bigIntegerBasedConstructors().stream()
                .flatMap(constructor -> EXPECTED_NUMBERS.entrySet().stream()
                        .map(entry -> {
                            final BigInteger bytes = BigInteger.ONE;
                            final StorageUnit<?> unit = constructor.apply(bytes);

                            final BigInteger numberOfBytesPerUnit = unit.getNumberOfBytesPerUnit();
                            final BigInteger expectedNumberOfBytesPerUnit = EXPECTED_NUMBERS.get(unit.getClass());

                            return DynamicTest.dynamicTest(unit.toString(), () ->
                                    Assertions.assertEquals(expectedNumberOfBytesPerUnit, numberOfBytesPerUnit));
                        }));
    }

}
