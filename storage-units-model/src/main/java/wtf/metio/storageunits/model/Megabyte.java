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
 * Megabyte as specified in ISO IEC 80000-13:2008 (1 Megabyte = 1 000 000 Byte).
 */
public final class Megabyte extends StorageUnit<Megabyte> {

    @Serial
    private static final long serialVersionUID = 5901923092058760111L;

    Megabyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Megabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Megabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Megabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Megabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Megabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte divide(final @NotNull BigInteger divisor) {
        return new Megabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte multiply(final @NotNull BigInteger factor) {
        return new Megabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Megabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Megabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEGABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "MB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
