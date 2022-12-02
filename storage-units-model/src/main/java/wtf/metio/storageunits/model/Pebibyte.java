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
 * Pebibyte as specified in ISO IEC 80000-13:2008 (1 Pebibyte = 1 125 899 906 842 624 Byte).
 */
public final class Pebibyte extends StorageUnit<Pebibyte> {

    @Serial
    private static final long serialVersionUID = -6112472064345339882L;

    Pebibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Pebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Pebibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte divide(final @NotNull BigInteger divisor) {
        return new Pebibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte multiply(final @NotNull BigInteger factor) {
        return new Pebibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Pebibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Pebibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "PiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
