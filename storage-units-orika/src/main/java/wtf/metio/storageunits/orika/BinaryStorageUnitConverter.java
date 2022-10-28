/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.orika;

import java.math.BigInteger;
import ma.glasnost.orika.metadata.Type;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts {@link BigInteger} values to binary storage units.
 */
public final class BinaryStorageUnitConverter extends AbstractStorageUnitConverter {

  @Override
  public StorageUnit<?> convertFrom(final BigInteger value, Type<StorageUnit<?>> destinationType) {
    return StorageUnits.binaryValueOf(value);
  }

}
