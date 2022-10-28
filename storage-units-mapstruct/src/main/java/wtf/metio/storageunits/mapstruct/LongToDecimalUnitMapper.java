/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.mapstruct;

import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Maps {@link Long} values to decimal storage units.
 */
public final class LongToDecimalUnitMapper {

  public StorageUnit<?> convert(final Long value) {
    return StorageUnits.decimalValueOf(value);
  }

}
