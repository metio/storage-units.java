/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.eclipselink;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;
import wtf.metio.storageunits.model.StorageUnit;

import java.io.Serial;
import java.math.BigInteger;

/**
 * Abstract implementation of a EclipseLink {@link Converter} for {@link StorageUnit StorageUnits}.
 *
 * @see <a href=
 * "https://www.eclipse.org/eclipselink/documentation/2.6/jpa/extensions/annotations_ref.htm#CHDEHJEB">EclipseLink
 * documentation</a>
 */
abstract class AbstractStorageUnitConverter implements Converter {

    @Serial
    private static final long serialVersionUID = 1696764872656233871L;

    @Override
    public Object convertObjectValueToDataValue(final Object objectValue, final Session session) {
        return ((StorageUnit<?>) objectValue).inByte();
    }

    @Override
    public Object convertDataValueToObjectValue(final Object dataValue, final Session session) {
        return convertToStorageUnit(new BigInteger(dataValue.toString()));
    }

    protected abstract StorageUnit<?> convertToStorageUnit(BigInteger value);

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public void initialize(final DatabaseMapping mapping, final Session session) {
        final DatabaseField field;
        if (mapping instanceof DirectCollectionMapping) {
            field = ((DirectCollectionMapping) mapping).getDirectField();
        } else {
            field = mapping.getField();
        }
        field.setSqlType(java.sql.Types.BIGINT);
    }

}
