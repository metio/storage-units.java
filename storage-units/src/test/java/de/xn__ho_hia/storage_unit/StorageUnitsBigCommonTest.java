/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.storage_unit.TestUtils.logIncorrectCreation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.jooq.lambda.tuple.Tuple2;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
*
*
*/
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.STATIC_METHOD)
public class StorageUnitsBigCommonTest {

    private static final BigInteger MULTIPLIER = Nullsafe.asBigInteger(1024);

    /**
     * @return inputs and expected result types.
     */
    @DataPoints("inputs")
    public static List<Tuple2<BigInteger, Class<? extends StorageUnit<?>>>> inputs() {
        final List<Tuple2<BigInteger, Class<? extends StorageUnit<?>>>> inputs = new ArrayList<>();

        inputs.add(new Tuple2<>(BigInteger.ONE, Byte.class));
        inputs.add(new Tuple2<>(MULTIPLIER, CommonKilobyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(2), CommonMegabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(3), CommonGigabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(4), CommonTerabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(5), CommonPetabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(6), CommonExabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(7), CommonZettabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(8), CommonYottabyte.class));
        inputs.add(new Tuple2<>(MULTIPLIER.pow(9), CommonYottabyte.class));

        return inputs;
    }

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @Theory
    public void shouldCreateCorrectBinaryUnit(
            @FromDataPoints("inputs") final Tuple2<BigInteger, Class<? extends StorageUnit<?>>> input) {
        // given
        final BigInteger bytes = input.v1;
        final Class<? extends StorageUnit<?>> expectedClass = input.v2;

        // when
        final StorageUnit<?> unit = StorageUnits.commonValueOf(Nullsafe.nonNull(bytes));
        final Class<?> unitClass = unit.getClass();

        // then
        Assert.assertEquals(logIncorrectCreation(bytes, expectedClass, unitClass), expectedClass, unitClass);
    }

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @Theory
    public void shouldCreateCorrectBinaryUnitNegated(
            @FromDataPoints("inputs") final Tuple2<BigInteger, Class<? extends StorageUnit<?>>> input) {
        // given
        final BigInteger bytes = input.v1;
        final Class<? extends StorageUnit<?>> expectedClass = input.v2;

        // when
        final StorageUnit<?> unit = StorageUnits.commonValueOf(Nullsafe.nonNull(bytes.negate()));
        final Class<?> unitClass = unit.getClass();

        // then
        Assert.assertEquals(logIncorrectCreation(bytes, expectedClass, unitClass), expectedClass, unitClass);
    }

}
