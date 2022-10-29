/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mongodb;

import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

public final class BinaryStorageUnitCodec extends AbstractStorageUnitCodec {

  @Override
  protected StorageUnit<?> convertToStorageUnit(final BigInteger value) {
    return StorageUnits.binaryValueOf(value);
  }

}
