/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.dozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

class LongDecimalStorageUnitConverterTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var converter = new LongDecimalStorageUnitConverter();
        final var unit = converter.convertTo(1000L);

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
