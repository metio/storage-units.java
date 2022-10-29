/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.modelmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class BigIntegerToDecimalUnitConverterTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var converter = new BigIntegerToDecimalUnitConverter();
        final var unit = converter.convert(BigInteger.valueOf(1000L));

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
