/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_EXABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_EXBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_GIBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_GIGABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_KIBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_KILOBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_MEBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_MEGABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_PEBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_PETABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_TEBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_TERABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_YOBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_YOTTABYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_ZEBIBYTE;
import static wtf.metio.storageunits.model.StorageUnit.BYTES_IN_A_ZETTABYTE;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class StorageUnitsFormattingWithPatternAndLocaleTest {

  @FunctionalInterface
  interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);

  }

  private static final String PATTERN = "#0.0";

  private static final Locale LOCALE = Locale.GERMAN;

  private static final List<BigInteger> BYTES = List.of(
      BYTES_IN_A_KIBIBYTE,
      BYTES_IN_A_MEBIBYTE,
      BYTES_IN_A_GIBIBYTE,
      BYTES_IN_A_TEBIBYTE,
      BYTES_IN_A_PEBIBYTE,
      BYTES_IN_A_EXBIBYTE,
      BYTES_IN_A_ZEBIBYTE,
      BYTES_IN_A_YOBIBYTE,
      BYTES_IN_A_KILOBYTE,
      BYTES_IN_A_MEGABYTE,
      BYTES_IN_A_GIGABYTE,
      BYTES_IN_A_TERABYTE,
      BYTES_IN_A_PETABYTE,
      BYTES_IN_A_EXABYTE,
      BYTES_IN_A_ZETTABYTE,
      BYTES_IN_A_YOTTABYTE
  );

  private static final List<TriFunction<BigInteger, String, Locale, String>> BIG_INTEGER_FORMATTERS = List.of(
      StorageUnits::formatAsBinaryUnit,
      StorageUnits::formatAsKibibyte,
      StorageUnits::formatAsMebibyte,
      StorageUnits::formatAsGibibyte,
      StorageUnits::formatAsTebibyte,
      StorageUnits::formatAsPebibyte,
      StorageUnits::formatAsExbibyte,
      StorageUnits::formatAsZebibyte,
      StorageUnits::formatAsYobibyte,
      StorageUnits::formatAsDecimalUnit,
      StorageUnits::formatAsKilobyte,
      StorageUnits::formatAsMegabyte,
      StorageUnits::formatAsGigabyte,
      StorageUnits::formatAsTerabyte,
      StorageUnits::formatAsPetabyte,
      StorageUnits::formatAsExabyte,
      StorageUnits::formatAsZettabyte,
      StorageUnits::formatAsYottabyte
  );

  private static final List<TriFunction<Long, String, Locale, String>> LONG_FORMATTERS = List.of(
      StorageUnits::formatAsBinaryUnit,
      StorageUnits::formatAsKibibyte,
      StorageUnits::formatAsMebibyte,
      StorageUnits::formatAsGibibyte,
      StorageUnits::formatAsTebibyte,
      StorageUnits::formatAsPebibyte,
      StorageUnits::formatAsExbibyte,
      StorageUnits::formatAsZebibyte,
      StorageUnits::formatAsYobibyte,
      StorageUnits::formatAsDecimalUnit,
      StorageUnits::formatAsKilobyte,
      StorageUnits::formatAsMegabyte,
      StorageUnits::formatAsGigabyte,
      StorageUnits::formatAsTerabyte,
      StorageUnits::formatAsPetabyte,
      StorageUnits::formatAsExabyte,
      StorageUnits::formatAsZettabyte,
      StorageUnits::formatAsYottabyte
  );

  @TestFactory
  Stream<DynamicTest> shouldFormatBigIntegerAsStorageUnitWithPatternAndLocale() {
    return BIG_INTEGER_FORMATTERS.stream()
        .flatMap(formatter -> BYTES.stream()
            .map(bytes -> DynamicTest.dynamicTest(String.format("%s formatted", bytes),
                () -> Assertions.assertNotNull(formatter.apply(bytes, PATTERN, LOCALE)))));
  }

  @TestFactory
  Stream<DynamicTest> shouldFormatLongAsStorageUnitWithPatternAndLocale() {
    return LONG_FORMATTERS.stream()
        .flatMap(formatter -> BYTES.stream()
            .map(bytes -> DynamicTest.dynamicTest(String.format("%s formatted", bytes),
                () -> Assertions.assertNotNull(formatter.apply(bytes.longValue(), PATTERN, LOCALE)))));
  }

}
