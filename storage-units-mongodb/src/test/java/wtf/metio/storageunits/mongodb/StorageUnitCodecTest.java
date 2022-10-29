/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.mongodb;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.util.stream.Stream;

class StorageUnitCodecTest {

    private Stream<AbstractStorageUnitCodec> codecs() {
        return Stream.of(new BinaryStorageUnitCodec(), new DecimalStorageUnitCodec());
    }

    @TestFactory
    Stream<DynamicTest> shouldEncodeStorageUnitClass() {
        return codecs()
                .map(AbstractStorageUnitCodec::getEncoderClass)
                .map(encoderClass -> DynamicTest.dynamicTest("should use correct encoder class",
                        () -> Assertions.assertEquals(StorageUnit.class, encoderClass)));
    }

    @TestFactory
    Stream<DynamicTest> shouldEncodeStorageUnit() {
        return codecs()
                .map(codec -> DynamicTest.dynamicTest("should encode storage unit", () -> {
                    final var writer = Mockito.mock(BsonWriter.class);
                    final var context = EncoderContext.builder().build();
                    final var value = StorageUnits.kilobyte(1L);

                    codec.encode(writer, value, context);

                    Mockito.verify(writer).writeString("1000");
                }));
    }

    @TestFactory
    Stream<DynamicTest> shouldDecodeStorageUnit() {
        return codecs()
                .map(codec -> DynamicTest.dynamicTest("should encode storage unit", () -> {
                    final var reader = Mockito.mock(BsonReader.class);
                    final var context = DecoderContext.builder().build();
                    BDDMockito.given(reader.readString()).willReturn("2000");

                    final var value = codec.decode(reader, context);

                    Assertions.assertEquals(StorageUnits.kilobyte(2), value);
                }));
    }

}
