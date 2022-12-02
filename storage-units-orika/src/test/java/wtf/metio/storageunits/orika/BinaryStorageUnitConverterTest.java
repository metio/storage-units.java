/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.orika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class BinaryStorageUnitConverterTest {

    @Test
    void convertBigIntegerToStorageUnit() {
        final var converter = new BinaryStorageUnitConverter();
        final var unit = converter.convertFrom(BigInteger.valueOf(1024L), null, null);

        Assertions.assertEquals(StorageUnits.kibibyte(1), unit);
    }

    @Test
    void convertStorageUnitToBigInteger() {
        final var converter = new BinaryStorageUnitConverter();
        final var value = converter.convertTo(StorageUnits.kibibyte(1), null, null);

        Assertions.assertEquals(BigInteger.valueOf(1024L), value);
    }

}
