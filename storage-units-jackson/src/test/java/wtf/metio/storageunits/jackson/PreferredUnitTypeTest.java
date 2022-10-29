/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.databind.JsonDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.jackson.StorageUnitModule.PreferredUnitType;

import java.util.function.Supplier;

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
