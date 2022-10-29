/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.jakarta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class BinaryStorageUnitConverterTest {

    @Test
    void shouldConvertBigIntegerToStorageUnit() {
        final var converter = new BinaryStorageUnitConverter();
        final var unit = converter.convertToEntityAttribute(BigInteger.valueOf(1024L));

        Assertions.assertNotNull(unit);
    }

}
