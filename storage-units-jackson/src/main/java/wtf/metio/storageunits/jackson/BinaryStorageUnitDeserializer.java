/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Deserializes value back into binary storage units.
 */
public final class BinaryStorageUnitDeserializer extends JsonDeserializer<StorageUnit<?>> {

    @Override
    public StorageUnit<?> deserialize(final JsonParser jsonParser, final DeserializationContext context)
            throws IOException {
        return StorageUnits.binaryValueOf(jsonParser.getBigIntegerValue());
    }

}
