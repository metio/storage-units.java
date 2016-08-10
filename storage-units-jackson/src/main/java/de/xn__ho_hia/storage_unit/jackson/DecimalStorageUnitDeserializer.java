/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.jackson;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import org.eclipse.jdt.annotation.NonNull;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 * Deserializes value back into decimal storage units.
 */
public final class DecimalStorageUnitDeserializer extends JsonDeserializer<StorageUnit<?>> {

    @Override
    public StorageUnit<?> deserialize(final JsonParser jsonParser, final DeserializationContext context)
            throws IOException, JsonProcessingException {
        @NonNull
        final BigInteger value = Nullsafe.nonNull(jsonParser.getBigIntegerValue());
        return StorageUnits.decimalValueOf(value);
    }

}
