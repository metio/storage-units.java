/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.jackson;

import java.util.function.Supplier;

import com.fasterxml.jackson.databind.JsonDeserializer;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.jackson.StorageUnitModule.PreferredUnitType;

/**
 *
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class PreferredUnitTypeTest {

    /**
    *
    */
    @Test
    public void shouldSupportBinaryUnitsFromString() {
        // given
        final String type = "BINARY";

        // when
        @NonNull
        final PreferredUnitType unitType = StorageUnitModule.PreferredUnitType.valueOf(type);

        // then
        Assert.assertNotNull(unitType);
    }

    /**
    *
    */
    @Test
    public void shouldSupportBinaryUnits() {
        // given
        final PreferredUnitType type = StorageUnitModule.PreferredUnitType.BINARY;

        // when
        final Supplier<JsonDeserializer<?>> deserializer = type.deserializer;

        // then
        Assert.assertNotNull(deserializer.get());
        Assert.assertTrue(BinaryStorageUnitDeserializer.class.isAssignableFrom(deserializer.get().getClass()));
    }

    /**
    *
    */
    @Test
    public void shouldSupportCommonUnitsFromString() {
        // given
        final String type = "COMMON";

        // when
        @NonNull
        final PreferredUnitType unitType = StorageUnitModule.PreferredUnitType.valueOf(type);

        // then
        Assert.assertNotNull(unitType);
    }

    /**
    *
    */
    @Test
    public void shouldSupportCommonUnits() {
        // given
        final PreferredUnitType type = StorageUnitModule.PreferredUnitType.COMMON;

        // when
        final Supplier<JsonDeserializer<?>> deserializer = type.deserializer;

        // then
        Assert.assertNotNull(deserializer.get());
        Assert.assertTrue(CommonStorageUnitDeserializer.class.isAssignableFrom(deserializer.get().getClass()));
    }

    /**
    *
    */
    @Test
    public void shouldSupportDecimalUnitsFromString() {
        // given
        final String type = "DECIMAL";

        // when
        @NonNull
        final PreferredUnitType unitType = StorageUnitModule.PreferredUnitType.valueOf(type);

        // then
        Assert.assertNotNull(unitType);
    }

    /**
    *
    */
    @Test
    public void shouldSupportDecimalUnits() {
        // given
        final PreferredUnitType type = StorageUnitModule.PreferredUnitType.DECIMAL;

        // when
        final Supplier<JsonDeserializer<?>> deserializer = type.deserializer;

        // then
        Assert.assertNotNull(deserializer.get());
        Assert.assertTrue(DecimalStorageUnitDeserializer.class.isAssignableFrom(deserializer.get().getClass()));
    }

}
