/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.orika;

import java.math.BigInteger;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import wtf.metio.storageunits.model.StorageUnit;

/**
 * Abstract implementation of a Orika {@link BidirectionalConverter} for {@link StorageUnit StorageUnits}.
 */
abstract class AbstractStorageUnitConverter extends BidirectionalConverter<StorageUnit<?>, BigInteger> {

  @Override
  public final BigInteger convertTo(final StorageUnit<?> storageUnit, final Type<BigInteger> destinationType, final MappingContext mappingContext) {
    return storageUnit.inByte();
  }

}
