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
 * Zettabyte as specified in ISO IEC 80000-13:2008 (1 Zettabyte = 1 000 000 000 000 000 000 000 Byte).
 */
public final class Zettabyte extends StorageUnit<Zettabyte> {

    @Serial
    private static final long serialVersionUID = 8849006574018911826L;

    Zettabyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Zettabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Zettabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte divide(final @NotNull BigInteger divisor) {
        return new Zettabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte multiply(final @NotNull BigInteger factor) {
        return new Zettabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Zettabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zettabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BYTES_IN_A_ZETTABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "ZB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
