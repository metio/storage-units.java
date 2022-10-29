/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
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
