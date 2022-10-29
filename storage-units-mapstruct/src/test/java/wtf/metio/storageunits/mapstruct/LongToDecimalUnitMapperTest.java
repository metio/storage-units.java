/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

class LongToDecimalUnitMapperTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var mapper = new LongToBinaryUnitMapper();
        final var unit = mapper.convert(1000L);

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
