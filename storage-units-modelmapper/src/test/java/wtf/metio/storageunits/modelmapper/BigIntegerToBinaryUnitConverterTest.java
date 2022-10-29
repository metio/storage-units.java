/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.modelmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class BigIntegerToBinaryUnitConverterTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var converter = new BigIntegerToBinaryUnitConverter();
        final var unit = converter.convert(BigInteger.valueOf(1024L));

        Assertions.assertNotNull(unit);
    }

}
