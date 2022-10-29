/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

class StorageUnitToBigIntegerMapperTest {

    @Test
    void shouldConvertStorageUnitToBigInteger() {
        final var mapper = new StorageUnitToBigIntegerMapper();
        final var value = mapper.convert(StorageUnits.kibibyte(1));

        Assertions.assertEquals(BigInteger.valueOf(1024L), value);
    }

}
