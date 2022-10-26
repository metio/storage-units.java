/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.eclipselink;

import java.io.Serial;
import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts database values to decimal storage units.
 */
public final class DecimalStorageUnitConverter extends AbstractStorageUnitConverter {

  @Serial
  private static final long serialVersionUID = -6919304587763247036L;

  @Override
  protected StorageUnit<?> convertToStorageUnit(final BigInteger value) {
    return StorageUnits.decimalValueOf(value);
  }

}
