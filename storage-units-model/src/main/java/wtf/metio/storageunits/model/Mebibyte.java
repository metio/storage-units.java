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
 * Mebibyte as specified in ISO IEC 80000-13:2008 (1 Mebibyte = 1 048 576 Byte).
 */
public final class Mebibyte extends StorageUnit<Mebibyte> {

    @Serial
    private static final long serialVersionUID = 7697583678146919524L;

    Mebibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Mebibyte contains.
     * @return A new Mebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Mebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Mebibyte contains.
     * @return A new Mebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Mebibyte contains.
     * @return A new Mebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Mebibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte divide(final @NotNull BigInteger divisor) {
        return new Mebibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte multiply(final @NotNull BigInteger factor) {
        return new Mebibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Mebibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Mebibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "MiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
