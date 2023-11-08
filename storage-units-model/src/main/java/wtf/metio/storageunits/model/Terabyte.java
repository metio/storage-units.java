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
 * Terabyte as specified in ISO IEC 80000-13:2008 (1 Terabyte = 1 000 000 000 000 Byte).
 */
public final class Terabyte extends StorageUnit<Terabyte> {

    @Serial
    private static final long serialVersionUID = 2160488069631638952L;

    Terabyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Terabyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Terabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Terabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Terabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Terabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Terabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte divide(final @NotNull BigInteger divisor) {
        return new Terabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte multiply(final @NotNull BigInteger factor) {
        return new Terabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Terabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Terabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TERABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "TB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
