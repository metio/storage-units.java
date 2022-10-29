/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.dozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class BigIntegerBinaryStorageUnitConverterTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var converter = new BigIntegerBinaryStorageUnitConverter();
        final var unit = converter.convertTo(BigInteger.valueOf(1024L));

        Assertions.assertNotNull(unit);
    }

}
