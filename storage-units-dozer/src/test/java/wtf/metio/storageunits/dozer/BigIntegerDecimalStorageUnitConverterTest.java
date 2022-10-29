/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.dozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class BigIntegerDecimalStorageUnitConverterTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var converter = new BigIntegerDecimalStorageUnitConverter();
        final var unit = converter.convertTo(BigInteger.valueOf(1000L));

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
