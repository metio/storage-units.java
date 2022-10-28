/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jakarta;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import wtf.metio.storageunits.model.StorageUnits;

class StorageUnitConverterTest {

  private Stream<AbstractStorageUnitConverter> converters() {
    return Stream.of(new BinaryStorageUnitConverter(), new DecimalStorageUnitConverter());
  }

  @TestFactory
  Stream<DynamicTest> shouldNotBeMutable() {
    return converters()
        .map(converter -> DynamicTest.dynamicTest("should not be mutable",
            () -> Assertions.assertFalse(converter.isMutable())));
  }

  @TestFactory
  Stream<DynamicTest> shouldConvertUnitToBigInteger() {
    return converters()
        .map(converter -> converter.convertObjectValueToDataValue(StorageUnits.kilobyte(1), null))
        .map(dataValue -> DynamicTest.dynamicTest("should convert storage unit to big integer",
            () -> Assertions.assertEquals(BigInteger.valueOf(1000L), dataValue)));
  }

  @TestFactory
  Stream<DynamicTest> shouldConvertBigIntegerToUnit() {
    return converters()
        .map(converter -> converter.convertDataValueToObjectValue(BigInteger.valueOf(2000L), null))
        .map(objectValue -> DynamicTest.dynamicTest("should convert big integer to storage unit",
            () -> Assertions.assertEquals(StorageUnits.kilobyte(2), objectValue)));
  }

  @TestFactory
  Stream<DynamicTest> shouldInitializeAsBigInt() {
    return converters()
        .map(converter -> DynamicTest.dynamicTest("should initialize as big integer",
            () -> {
              final var mapping = Mockito.mock(DatabaseMapping.class);
              final var field = new DatabaseField();
              BDDMockito.given(mapping.getField()).willReturn(field);

              converter.initialize(mapping, null);

              Assertions.assertEquals(java.sql.Types.BIGINT, field.getSqlType());
            }));
  }

}
