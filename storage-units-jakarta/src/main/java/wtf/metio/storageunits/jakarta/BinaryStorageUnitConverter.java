/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jakarta;

import jakarta.persistence.Converter;
import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts database values to binary storage units.
 */
@Converter
public final class BinaryStorageUnitConverter extends AbstractStorageUnitConverter {

  @Override
  public StorageUnit<?> convertToEntityAttribute(final BigInteger value) {
    return StorageUnits.binaryValueOf(value);
  }

}