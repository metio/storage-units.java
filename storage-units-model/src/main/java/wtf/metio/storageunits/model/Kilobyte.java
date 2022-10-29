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
 * Kilobyte as specified in ISO IEC 80000-13:2008 (1 Kilobyte = 1 000 Byte).
 */
public final class Kilobyte extends StorageUnit<Kilobyte> {

    @Serial
    private static final long serialVersionUID = 6952239416014811456L;

    Kilobyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Kilobyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte add(final @NotNull BigInteger bytesToAdd) {
        return new Kilobyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte divide(final @NotNull BigInteger divisor) {
        return new Kilobyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte multiply(final @NotNull BigInteger factor) {
        return new Kilobyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Kilobyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kilobyte subtract(final StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BYTES_IN_A_KILOBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "kB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
