/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class BigIntegerToBinaryUnitMapperTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var mapper = new BigIntegerToBinaryUnitMapper();
        final var unit = mapper.convert(BigInteger.valueOf(1024L));

        Assertions.assertNotNull(unit);
    }

}
