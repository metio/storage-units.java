/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.orika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class BinaryStorageUnitConverterTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var converter = new BinaryStorageUnitConverter();
        final var unit = converter.convertFrom(BigInteger.valueOf(1024L), null, null);

        Assertions.assertNotNull(unit);
    }

}
