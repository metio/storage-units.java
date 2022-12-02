/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

class LongToBinaryUnitMapperTest {

    @Test
    void convertLongToStorageUnit() {
        final var mapper = new LongToBinaryUnitMapper();
        final var unit = mapper.convert(1024L);

        Assertions.assertEquals(StorageUnits.kibibyte(1), unit);
    }

}
