/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.StorageUnits.kilobyte;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Conversions test cases for the examples in the README.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class ReadmeConversionsTest {

    /**
     * Tests the README example: Converting a unit to the best matching unit.
     */
    @Test
    public void shouldFormatUnitWithDefaults() {
        Assert.assertEquals("1.10 MB", kilobyte(900).add(kilobyte(200)).asBestMatchingUnit().toString());
        Assert.assertEquals("1.05 MiB", kilobyte(900).add(kilobyte(200)).asBestMatchingBinaryUnit().toString());
        Assert.assertEquals("1.10 MB", kilobyte(900).add(kilobyte(200)).asBestMatchingMetricUnit().toString());
    }

}
