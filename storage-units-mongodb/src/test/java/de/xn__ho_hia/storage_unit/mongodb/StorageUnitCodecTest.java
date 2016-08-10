/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.CommonKilobyte;
import de.xn__ho_hia.storage_unit.Kibibyte;
import de.xn__ho_hia.storage_unit.Kilobyte;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 *
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class StorageUnitCodecTest {

    /**
     * @return Suppliers to create a storage-unit codec.
     */
    @DataPoints("supplier")
    public static final List<Tuple2<Supplier<AbstractStorageUnitCodec>, Class<?>>> suppliers() {
        final List<Tuple2<Supplier<AbstractStorageUnitCodec>, Class<?>>> suppliers = new ArrayList<>();
        suppliers.add(new Tuple2<>(BinaryStorageUnitCodec::new, Kibibyte.class));
        suppliers.add(new Tuple2<>(CommonStorageUnitCodec::new, CommonKilobyte.class));
        suppliers.add(new Tuple2<>(DecimalStorageUnitCodec::new, Kilobyte.class));
        return suppliers;
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldEncodeStorageUnitClass(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitCodec>, Class<?>> supplier) {
        // given
        final AbstractStorageUnitCodec codec = supplier.v1.get();

        // when
        final Class<StorageUnit<?>> encoderClass = codec.getEncoderClass();

        // then
        Assert.assertNotNull(encoderClass);
        Assert.assertEquals(StorageUnit.class, encoderClass);
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    @SuppressWarnings(CompilerWarnings.NLS)
    public void shouldEncodeStorageUnit(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitCodec>, Class<?>> supplier) {
        // given
        final AbstractStorageUnitCodec codec = supplier.v1.get();
        final BsonWriter writer = Mockito.mock(BsonWriter.class);
        final EncoderContext context = EncoderContext.builder().build();
        final StorageUnit<?> value = StorageUnits.kilobyte(1L);

        // when
        codec.encode(writer, value, context);

        // then
        Mockito.verify(writer).writeString("1000");
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    @SuppressWarnings(CompilerWarnings.NLS)
    public void shouldDecodeStorageUnit(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitCodec>, Class<?>> supplier) {
        // given
        final AbstractStorageUnitCodec codec = supplier.v1.get();
        final BsonReader reader = Mockito.mock(BsonReader.class);
        final DecoderContext context = DecoderContext.builder().build();
        BDDMockito.given(reader.readString()).willReturn("2000");

        // when
        final StorageUnit<?> value = codec.decode(reader, context);

        // then
        Assert.assertNotNull(value);
        Assert.assertEquals(supplier.v2, value.getClass());
    }

}
