/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

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
      // decimal units
      Map.entry(Kilobyte.class, new BigInteger("1000")),
      Map.entry(Megabyte.class, new BigInteger("1000000")),
      Map.entry(Gigabyte.class, new BigInteger("1000000000")),
      Map.entry(Terabyte.class, new BigInteger("1000000000000")),
      Map.entry(Petabyte.class, new BigInteger("1000000000000000")),
      Map.entry(Exabyte.class, new BigInteger("1000000000000000000")),
      Map.entry(Zettabyte.class, new BigInteger("1000000000000000000000")),
      Map.entry(Yottabyte.class, new BigInteger("1000000000000000000000000"))
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

              return DynamicTest.dynamicTest(unit.toString(), () -> {
                Assertions.assertEquals(expectedNumberOfBytesPerUnit, numberOfBytesPerUnit);
              });
            }));
  }

}