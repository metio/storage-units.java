/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 * Tests serialization with Jackson.
 */
@SuppressWarnings(CompilerWarnings.NLS)
public class JacksonSerializationTest {

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
     * @throws JsonProcessingException
     *             In case something goes wrong during serialization
     */
    @Test
    public void shouldSerializeStorageUnit() throws JsonProcessingException {
        // given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1L);

        // when
        final String output = mapper.writeValueAsString(unit);

        // then
        Assert.assertEquals("1024", output);
    }

    /**
     * @throws JsonProcessingException
     *             In case something goes wrong during serialization
     */
    @Test
    public void shouldSerializeNonStorageUnit() throws JsonProcessingException {
        // given
        final String input = "abc";

        // when
        final String output = mapper.writeValueAsString(input);

        // then
        Assert.assertEquals("\"abc\"", output);
    }

}
