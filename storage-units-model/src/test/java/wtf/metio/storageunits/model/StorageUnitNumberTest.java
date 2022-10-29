/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageUnitNumberTest {

    @Test
    void shouldReturnDoubleValue() {
        // Given
        final var unit = StorageUnits.kibibyte(1);

        // When
        final double result = unit.doubleValue();

        // Then
        Assertions.assertEquals(1024D, result, 0D, "Conversion was not correct");
    }

    @Test
    void shouldReturnLongValue() {
        // Given
        final var unit = StorageUnits.kibibyte(1);

        // When
        final long result = unit.longValue();

        // Then
        Assertions.assertEquals(1024L, result, "Conversion was not correct");
    }

    @Test
    void shouldReturnFloatValue() {
        // Given
        final var unit = StorageUnits.kibibyte(1);

        // When
        final float result = unit.floatValue();

        // Then
        Assertions.assertEquals(1024F, result, 0F, "Conversion was not correct");
    }

    @Test
    void shouldReturnIntValue() {
        // Given
        final var unit = StorageUnits.kibibyte(1);

        // When
        final int result = unit.intValue();

        // Then
        Assertions.assertEquals(1024, result, "Conversion was not correct");
    }

}
