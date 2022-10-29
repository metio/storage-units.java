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
 * Gigabyte as specified in ISO IEC 80000-13:2008 (1 Gigabyte = 1 000 000 000 Byte).
 */
public final class Gigabyte extends StorageUnit<Gigabyte> {

    @Serial
    private static final long serialVersionUID = 7581075190529125530L;

    Gigabyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Gigabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Gigabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte divide(final @NotNull BigInteger divisor) {
        return new Gigabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte multiply(final @NotNull BigInteger factor) {
        return new Gigabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Gigabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gigabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BYTES_IN_A_GIGABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "GB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
