/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.jakarta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class BinaryStorageUnitConverterTest {

    @Test
    void convertBigIntegerToStorageUnit() {
        final var converter = new BinaryStorageUnitConverter();
        final var unit = converter.convertToEntityAttribute(BigInteger.valueOf(1024L));

        Assertions.assertEquals(StorageUnits.kibibyte(1), unit);
    }

    @Test
    void convertStorageUnitToBigInteger() {
        final var converter = new BinaryStorageUnitConverter();
        final var value = converter.convertToDatabaseColumn(StorageUnits.kibibyte(1));

        Assertions.assertEquals(BigInteger.valueOf(1024L), value);
    }

}
