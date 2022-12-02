/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.modelmapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnits;

class LongToDecimalUnitConverterTest {

    @Test
    void convertBigIntegerToStorageUnit() {
        final var converter = new LongToDecimalUnitConverter();
        final var unit = converter.convert(1000L);

        Assertions.assertEquals(StorageUnits.kilobyte(1), unit);
    }

}
