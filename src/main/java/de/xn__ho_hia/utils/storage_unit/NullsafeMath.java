package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;

/**
 * Utility class to work with @NonNull match operations.
 */
final class NullsafeMath {

    static BigInteger asBigInteger(final long value) {
        return Nullsafe.nonNull(BigInteger.valueOf(value));
    }

    static Long asLong(final long value) {
        return Nullsafe.nonNull(Long.valueOf(value));
    }

    static BigInteger addNullsafe(final BigInteger first, final BigInteger second) {
        return Nullsafe.nonNull(first.add(second));
    }

    static BigInteger subtractNullsafe(final BigInteger first, final BigInteger second) {
        return Nullsafe.nonNull(first.subtract(second));
    }

    static BigInteger divideNullsafe(final BigInteger first, final BigInteger second) {
        return Nullsafe.nonNull(first.divide(second));
    }

    static BigInteger multiplyNullsafe(final BigInteger first, final BigInteger second) {
        return Nullsafe.nonNull(first.multiply(second));
    }

}
