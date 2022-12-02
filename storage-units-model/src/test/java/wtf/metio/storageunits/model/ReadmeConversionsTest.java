/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static wtf.metio.storageunits.model.StorageUnits.kilobyte;

class ReadmeConversionsTest {

    @Test
    void formatUnitWithDefaults() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("1.10 MB",
                        kilobyte(900).add(kilobyte(200)).asBestMatchingUnit().toString()),
                () -> Assertions.assertEquals("1.05 MiB",
                        kilobyte(900).add(kilobyte(200)).asBestMatchingBinaryUnit().toString()),
                () -> Assertions.assertEquals("1.10 MB",
                        kilobyte(900).add(kilobyte(200)).asBestMatchingDecimalUnit().toString())
        );
    }

}
