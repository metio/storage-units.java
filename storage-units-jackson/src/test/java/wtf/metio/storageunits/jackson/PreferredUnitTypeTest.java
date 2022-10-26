/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.databind.JsonDeserializer;
import java.util.function.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.jackson.StorageUnitModule.PreferredUnitType;

class PreferredUnitTypeTest {

  @Test
  void shouldSupportBinaryUnitsFromString() {
    // given
    final String type = "BINARY";

    // when
    final PreferredUnitType unitType = StorageUnitModule.PreferredUnitType.valueOf(type);

    // then
    Assertions.assertNotNull(unitType);
  }

  @Test
  void shouldSupportBinaryUnits() {
    // given
    final PreferredUnitType type = StorageUnitModule.PreferredUnitType.BINARY;

    // when
    final Supplier<JsonDeserializer<?>> deserializer = type.deserializer;

    // then
    Assertions.assertNotNull(deserializer.get());
    Assertions.assertTrue(BinaryStorageUnitDeserializer.class.isAssignableFrom(deserializer.get().getClass()));
  }

  @Test
  void shouldSupportDecimalUnitsFromString() {
    // given
    final String type = "DECIMAL";

    // when
    final PreferredUnitType unitType = StorageUnitModule.PreferredUnitType.valueOf(type);

    // then
    Assertions.assertNotNull(unitType);
  }

  @Test
  void shouldSupportDecimalUnits() {
    // given
    final PreferredUnitType type = StorageUnitModule.PreferredUnitType.DECIMAL;

    // when
    final Supplier<JsonDeserializer<?>> deserializer = type.deserializer;

    // then
    Assertions.assertNotNull(deserializer.get());
    Assertions.assertTrue(DecimalStorageUnitDeserializer.class.isAssignableFrom(deserializer.get().getClass()));
  }

}
