/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.orika;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import wtf.metio.storageunits.model.StorageUnit;

import java.math.BigInteger;

/**
 * Abstract implementation of an Orika {@link BidirectionalConverter} for {@link StorageUnit StorageUnits}.
 */
abstract class AbstractStorageUnitConverter extends BidirectionalConverter<StorageUnit<?>, BigInteger> {

    @Override
    public final BigInteger convertTo(final StorageUnit<?> source, final Type<BigInteger> destinationType, final MappingContext mappingContext) {
        return source.inByte();
    }

}
