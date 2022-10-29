/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.dozer;

import com.github.dozermapper.core.CustomConverter;
import com.github.dozermapper.core.MappingException;
import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converter for decimal storage units.
 */
public final class DecimalStorageUnitConverter implements CustomConverter {

  @Override
  public Object convert(
      final Object destination,
      final Object source,
      final Class<?> destinationClass,
      final Class<?> sourceClass) {
    if (source == null) {
      return null;
    }
    if (source instanceof Long value) {
      return StorageUnits.decimalValueOf(value);
    } else if (source instanceof BigInteger value) {
      return StorageUnits.decimalValueOf(value);
    } else if (source instanceof StorageUnit<?> unit) {
      if (Long.class.isAssignableFrom(destinationClass) || long.class.isAssignableFrom(destinationClass)) {
        return unit.longValue();
      } else if (BigInteger.class.isAssignableFrom(destinationClass)) {
        return unit.inByte();
      }
    }

    throw new MappingException("Converter DecimalStorageUnitConverter "
        + "used incorrectly. Arguments passed in were:"
        + destination
        + " and "
        + source);
  }

}
