/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.orika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class DecimalStorageUnitConverterTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var converter = new DecimalStorageUnitConverter();
        final var unit = converter.convertFrom(BigInteger.valueOf(1000L), null, null);

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

    @Test
    void shouldConvertStorageUnitToBigInteger() {
        final var converter = new BinaryStorageUnitConverter();
        final var value = converter.convertTo(StorageUnits.kilobyte(1), null, null);

        Assertions.assertEquals(BigInteger.valueOf(1000L), value);
    }

}