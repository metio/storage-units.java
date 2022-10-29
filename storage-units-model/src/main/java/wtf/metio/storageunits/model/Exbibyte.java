/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;

/**
 * Exbibyte as specified in ISO IEC 80000-13:2008 (1 Exbibyte = 1 152 921 504 606 846 976 Byte).
 */
public final class Exbibyte extends StorageUnit<Exbibyte> {

    @Serial
    private static final long serialVersionUID = 5993490571003918471L;

    Exbibyte(@NotNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Exbibyte valueOf(@NotNull final BigInteger numberOfBytes) {
        return new Exbibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Exbibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Exbibyte valueOf(@NotNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte add(@NotNull final BigInteger bytesToAdd) {
        return new Exbibyte(bytes.add(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte add(@NotNull final StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte divide(@NotNull final BigInteger divisor) {
        return new Exbibyte(bytes.divide(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte multiply(final long factor) {
        return new Exbibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte multiply(@NotNull final BigInteger factor) {
        return new Exbibyte(bytes.multiply(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte subtract(final long bytesToSubtract) {
        return new Exbibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte subtract(@NotNull final BigInteger bytesToSubtract) {
        return new Exbibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Exbibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
        return new Exbibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXBIBYTE;
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected String getSymbol() {
        return "EiB";
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
