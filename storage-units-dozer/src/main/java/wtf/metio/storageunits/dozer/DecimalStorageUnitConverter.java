/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
