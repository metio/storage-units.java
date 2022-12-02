/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class BigIntegerToDecimalUnitMapperTest {

    @Test
    void convertBigIntegerToStorageUnit() {
        final var mapper = new BigIntegerToDecimalUnitMapper();
        final var unit = mapper.convert(BigInteger.valueOf(1000L));

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
