/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mongodb;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import wtf.metio.storageunits.model.StorageUnit;

import java.math.BigInteger;

/**
 * Abstract implementation of a MongoDB {@link Codec} for {@link StorageUnit StorageUnits}.
 *
 * @see <a href="http://mongodb.github.io/mongo-java-driver/3.3/bson/codecs/">MongoDB Codec documentation</a>
 */
abstract class AbstractStorageUnitCodec implements Codec<StorageUnit<?>> {

    @Override
    public final void encode(final BsonWriter bsonWriter, final StorageUnit<?> t, final EncoderContext encoderContext) {
        bsonWriter.writeString(t.inByte().toString());
    }

    @Override
    public Class getEncoderClass() {
        return StorageUnit.class;
    }

    @Override
    public final StorageUnit<?> decode(final BsonReader bsonReader, final DecoderContext decoderContext) {
        return convertToStorageUnit(new BigInteger(bsonReader.readString()));
    }

    protected abstract StorageUnit<?> convertToStorageUnit(BigInteger value);

}
