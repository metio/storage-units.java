/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class StorageUnitToStringTest {

  private static final Map<Class<?>, String> TYPE_SUFFIX_MAPPING = Map.ofEntries(
      Map.entry(Byte.class, "B"),
      Map.entry(Kibibyte.class, "KiB"),
      Map.entry(Mebibyte.class, "MiB"),
      Map.entry(Gibibyte.class, "GiB"),
      Map.entry(Tebibyte.class, "TiB"),
      Map.entry(Pebibyte.class, "PiB"),
      Map.entry(Exbibyte.class, "EiB"),
      Map.entry(Zebibyte.class, "ZiB"),
      Map.entry(Yobibyte.class, "YiB"),
      Map.entry(Kilobyte.class, "kB"),
      Map.entry(Megabyte.class, "MB"),
      Map.entry(Gigabyte.class, "GB"),
      Map.entry(Terabyte.class, "TB"),
      Map.entry(Petabyte.class, "PB"),
      Map.entry(Exabyte.class, "EB"),
      Map.entry(Zettabyte.class, "ZB"),
      Map.entry(Yottabyte.class, "YB"));

  @TestFactory
  Stream<DynamicTest> shouldPrintCorrectUnit() {
    return TestObjects.highLevelLongBasedConstructors().stream()
        .map(constructor -> constructor.apply(1L))
        .map(unit -> DynamicTest.dynamicTest(unit.toString(), () ->
            Assertions.assertTrue(unit.toString().endsWith(TYPE_SUFFIX_MAPPING.get(unit.getClass())))));

  }

}
