/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jakarta;

import java.math.BigInteger;
import org.modelmapper.AbstractConverter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts {@link BigInteger} values to binary storage units.
 */
public final class BigIntegerToBinaryUnitConverter extends AbstractConverter<BigInteger, StorageUnit<?>> {

  @Override
  protected StorageUnit<?> convert(final BigInteger value) {
    return StorageUnits.binaryValueOf(value);
  }

}
