/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.dozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

class LongBinaryStorageUnitConverterTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var converter = new LongBinaryStorageUnitConverter();
        final var unit = converter.convertTo(1024L);

        Assertions.assertEquals(StorageUnits.kibibyte(1), unit);
    }

}