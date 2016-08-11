/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.eclipselink;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.eclipse.persistence.internal.helper.DatabaseField;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.DirectCollectionMapping;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.CommonKilobyte;
import de.xn__ho_hia.storage_unit.Kibibyte;
import de.xn__ho_hia.storage_unit.Kilobyte;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 *
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitConverterTest {

    /**
     * @return Suppliers to create a storage-unit converter.
     */
    @DataPoints("supplier")
    public static final List<Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>>> suppliers() {
        final List<Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>>> suppliers = new ArrayList<>();
        suppliers.add(new Tuple2<>(BinaryStorageUnitConverter::new, Kibibyte.class));
        suppliers.add(new Tuple2<>(CommonStorageUnitConverter::new, CommonKilobyte.class));
        suppliers.add(new Tuple2<>(DecimalStorageUnitConverter::new, Kilobyte.class));
        return suppliers;
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldNotBeMutable(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>> supplier) {
        // given
        final AbstractStorageUnitConverter converter = supplier.v1.get();

        // when
        final boolean isMutable = converter.isMutable();

        // then
        Assert.assertFalse(isMutable);
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldConvertUnitToBigInteger(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>> supplier) {
        // given
        final StorageUnit<?> unit = StorageUnits.kilobyte(1);
        final AbstractStorageUnitConverter converter = supplier.v1.get();

        // when
        final Object dataValue = converter.convertObjectValueToDataValue(unit, null);

        // then
        Assert.assertNotNull(dataValue);
        Assert.assertEquals(new BigInteger("1000"), dataValue);
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldConvertBigIntegerToUnit(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>> supplier) {
        // given
        final BigInteger dataValue = new BigInteger("2000");
        final AbstractStorageUnitConverter converter = supplier.v1.get();

        // when
        final Object objectValue = converter.convertDataValueToObjectValue(dataValue, null);

        // then
        Assert.assertNotNull(dataValue);
        Assert.assertEquals(supplier.v2, objectValue.getClass());
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldInitializeAsBigInt(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>> supplier) {
        // given
        final DatabaseMapping mapping = Mockito.mock(DatabaseMapping.class);
        final DatabaseField field = new DatabaseField();
        BDDMockito.given(mapping.getField()).willReturn(field);
        final AbstractStorageUnitConverter converter = supplier.v1.get();

        // when
        converter.initialize(mapping, null);

        // then
        Assert.assertEquals(java.sql.Types.BIGINT, field.getSqlType());
    }

    /**
     * @param supplier
     *            The supplier to use.
     */
    @Theory
    public void shouldInitializeAsBigIntWithDirectCollectionMapping(
            @FromDataPoints("supplier") final Tuple2<Supplier<AbstractStorageUnitConverter>, Class<?>> supplier) {
        // given
        final DirectCollectionMapping mapping = new DirectCollectionMapping();
        final DatabaseField field = new DatabaseField();
        mapping.setDirectField(field);
        final AbstractStorageUnitConverter converter = supplier.v1.get();

        // when
        converter.initialize(mapping, null);

        // then
        Assert.assertEquals(java.sql.Types.BIGINT, field.getSqlType());
    }

}
