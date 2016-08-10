/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.mongodb;

import java.math.BigInteger;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.eclipse.jdt.annotation.NonNull;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.StorageUnit;

/**
 * Abstract implementation of a MongoDB {@link Codec} for {@link StorageUnit StorageUnits}.
 *
 * @see <a href="http://mongodb.github.io/mongo-java-driver/3.3/bson/codecs/">MongoDB Codec documentation</a>
 */
abstract class AbstractStorageUnitCodec implements Codec<StorageUnit<?>> {

    @Override
    public final void encode(final BsonWriter writer, final StorageUnit<?> value, final EncoderContext encoderContext) {
        writer.writeString(value.inByte().toString());
    }

    @Override
    @SuppressWarnings(CompilerWarnings.UNCHECKED)
    public final Class<StorageUnit<?>> getEncoderClass() {
        return (Class<StorageUnit<?>>) (Object) StorageUnit.class;
    }

    @Override
    public final StorageUnit<?> decode(final BsonReader reader, final DecoderContext decoderContext) {
        final String bsonValue = reader.readString();
        final BigInteger value = new BigInteger(bsonValue);
        return convertToStorageUnit(value);
    }

    protected abstract StorageUnit<?> convertToStorageUnit(@NonNull BigInteger value);

}
