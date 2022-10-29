/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.orika;

import java.math.BigInteger;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts {@link BigInteger} values to binary storage units.
 */
public final class BinaryStorageUnitConverter extends AbstractStorageUnitConverter {

  @Override
  public StorageUnit<?> convertFrom(final BigInteger value, final Type<StorageUnit<?>> destinationType, final MappingContext mappingContext) {
    return StorageUnits.binaryValueOf(value);
  }

}
