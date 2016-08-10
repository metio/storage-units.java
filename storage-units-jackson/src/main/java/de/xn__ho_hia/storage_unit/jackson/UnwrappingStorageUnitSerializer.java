/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.jackson;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import de.xn__ho_hia.storage_unit.StorageUnit;

/**
 * Serializes a {@link StorageUnit} by unwrapping the enclosed {@link BigInteger} value.
 */
public final class UnwrappingStorageUnitSerializer extends JsonSerializer<StorageUnit<?>> {

    @Override
    public void serialize(final StorageUnit<?> value, final JsonGenerator jsonGenerator,
            final SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(value.inByte());
    }

}
