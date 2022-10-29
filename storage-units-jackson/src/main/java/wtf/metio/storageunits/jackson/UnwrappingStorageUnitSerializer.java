/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jackson;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import wtf.metio.storageunits.model.StorageUnit;

/**
 * Serializes a {@link StorageUnit} by unwrapping the enclosed {@link BigInteger} value.
 */
public final class UnwrappingStorageUnitSerializer extends JsonSerializer<StorageUnit<?>> {

    @Override
    public void serialize(final StorageUnit<?> value, final JsonGenerator jsonGenerator,
            final SerializerProvider serializers)
            throws IOException {
        jsonGenerator.writeNumber(value.inByte());
    }

}
