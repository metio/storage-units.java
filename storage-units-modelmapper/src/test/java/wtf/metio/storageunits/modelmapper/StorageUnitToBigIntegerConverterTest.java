/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.modelmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class StorageUnitToBigIntegerConverterTest {

    @Test
    void shouldConvertStorageUnitToBigInteger() {
        final var converter = new StorageUnitToBigIntegerConverter();
        final var value = converter.convert(StorageUnits.kibibyte(1));

        Assertions.assertEquals(BigInteger.valueOf(1024L), value);
    }

}
