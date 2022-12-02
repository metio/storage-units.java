/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.jakarta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class DecimalStorageUnitConverterTest {

    @Test
    void convertBigIntegerToStorageUnit() {
        final var converter = new DecimalStorageUnitConverter();
        final var unit = converter.convertToEntityAttribute(BigInteger.valueOf(1000L));

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

    @Test
    void convertStorageUnitToBigInteger() {
        final var converter = new DecimalStorageUnitConverter();
        final var value = converter.convertToDatabaseColumn(StorageUnits.kilobyte(1));

        Assertions.assertEquals(BigInteger.valueOf(1000L), value);
    }

}
