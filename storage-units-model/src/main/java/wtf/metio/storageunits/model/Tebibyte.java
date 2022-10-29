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
 * Tebibyte as specified in ISO IEC 80000-13:2008 (1 Tebibyte = 1 099 511 627 776 Byte).
 */
public final class Tebibyte extends StorageUnit<Tebibyte> {

    @Serial
    private static final long serialVersionUID = 3614537130129620881L;

    Tebibyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Tebibyte contains.
     * @return A new Tebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Tebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Tebibyte contains.
     * @return A new Tebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Tebibyte contains.
     * @return A new Tebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Tebibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte divide(final @NotNull BigInteger divisor) {
        return new Tebibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte multiply(final @NotNull BigInteger factor) {
        return new Tebibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Tebibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Tebibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BYTES_IN_A_TEBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "TiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
