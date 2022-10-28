/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.mapstruct;

import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;

/**
 * Maps storage units to {@link BigInteger}s.
 */
public final class StorageUnitToBigIntegerMapper {

  public BigInteger convert(final StorageUnit<?> storageUnit) {
    return storageUnit.inByte();
  }

}