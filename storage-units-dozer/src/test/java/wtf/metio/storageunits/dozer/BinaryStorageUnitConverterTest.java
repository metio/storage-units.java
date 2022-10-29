/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.dozer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnit;

class BinaryStorageUnitConverterTest {

    @Test
    void shouldConvertLongToStorageUnit() {
        final var converter = new BinaryStorageUnitConverter();
        final var unit = converter.convert(null, 1024L, StorageUnit.class, Long.class);

        Assertions.assertNotNull(unit);
    }

}
