/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jakarta;

import jakarta.persistence.AttributeConverter;
import java.math.BigInteger;
import wtf.metio.storageunits.model.StorageUnit;

/**
 * Abstract implementation of a JPA {@link AttributeConverter} for {@link StorageUnit StorageUnits}.
 *
 * @see <a href=
 * "https://www.eclipse.org/eclipselink/documentation/2.6/jpa/extensions/annotations_ref.htm#CHDEHJEB">EclipseLink
 * documentation</a>
 */
abstract class AbstractStorageUnitConverter implements AttributeConverter<StorageUnit<?>, BigInteger> {

  @Override
  public final BigInteger convertToDatabaseColumn(final StorageUnit<?> storageUnit) {
    return storageUnit.inByte();
  }

}
