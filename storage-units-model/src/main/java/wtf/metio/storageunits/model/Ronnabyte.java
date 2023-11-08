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
 * Ronnabyte as specified in ISO IEC 80000-13:2008 (1 Ronnabyte = 1 000 000 000 000 000 000 000 000 000 Byte).
 */
public final class Ronnabyte extends StorageUnit<Ronnabyte> {

    @Serial
    private static final long serialVersionUID = -7866123408102424489L;

    Ronnabyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Ronnabyte contains.
     * @return A new Ronnabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Ronnabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Ronnabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Ronnabyte contains.
     * @return A new Ronnabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Ronnabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Ronnabyte contains.
     * @return A new Ronnabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Ronnabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Ronnabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte divide(final @NotNull BigInteger divisor) {
        return new Ronnabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte multiply(final @NotNull BigInteger factor) {
        return new Ronnabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Ronnabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Ronnabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_RONNABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "RB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
