/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.jackson;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.StorageUnit;

/**
 * Tests deserialization with Jackson using defaults.
 */
@SuppressWarnings(CompilerWarnings.NLS)
public class JacksonDefaultDeserializationTest {

    private ObjectMapper mapper;

    /**
     * Creates the {@link ObjectMapper}.
     */
    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new StorageUnitModule());
    }

    /**
     * @throws IOException
     *             In case something goes wrong during deserialization.
     */
    @Test
    public void shouldDeserializeStorageUnit() throws IOException {
        // given
        final String input = "1024";

        // when
        final StorageUnit<?> unit = mapper.readValue(input, StorageUnit.class);

        // then
        Assert.assertEquals("1.00 KiB", unit.toString());
    }

    /**
     * @throws IOException
     *             In case something goes wrong during deserialization.
     */
    @Test
    public void shouldDeserializeNonStorageUnit() throws IOException {
        // given
        final String input = "1024";

        // when
        final String output = mapper.readValue(input, String.class);

        // then
        Assert.assertEquals("1024", output);
    }

}
