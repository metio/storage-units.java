/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import com.google.errorprone.annotations.CheckReturnValue;
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

    Exbibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Exbibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Exbibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte divide(final @NotNull BigInteger divisor) {
        return new Exbibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte multiply(final long factor) {
        return new Exbibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte multiply(final @NotNull BigInteger factor) {
        return new Exbibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte subtract(final long bytesToSubtract) {
        return new Exbibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Exbibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exbibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return new Exbibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "EiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
