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
 * Quettabyte as specified in ISO IEC 80000-13:2008 (1 Quettabyte = 1 000 000 000 000 000 000 000 000 000 000 Byte).
 */
public final class Quettabyte extends StorageUnit<Quettabyte> {

    @Serial
    private static final long serialVersionUID = -7866123408102424489L;

    Quettabyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Quettabyte contains.
     * @return A new Quettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Quettabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Quettabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Quettabyte contains.
     * @return A new Quettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Quettabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Quettabyte contains.
     * @return A new Quettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Quettabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Quettabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte divide(final @NotNull BigInteger divisor) {
        return new Quettabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte multiply(final @NotNull BigInteger factor) {
        return new Quettabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Quettabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Quettabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_QUETTABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "QB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
