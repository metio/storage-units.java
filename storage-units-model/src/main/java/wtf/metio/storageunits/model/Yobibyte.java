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
 * Yobibyte as specified in ISO IEC 80000-13:2008 (1 Yobibyte = 1 208 925 819 614 629 174 706 176 Byte).
 */
public final class Yobibyte extends StorageUnit<Yobibyte> {

    @Serial
    private static final long serialVersionUID = -5606322878020884194L;

    Yobibyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Yobibyte contains.
     * @return A new Yobibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Yobibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Yobibyte contains.
     * @return A new Yobibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Yobibyte contains.
     * @return A new Yobibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Yobibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte divide(final @NotNull BigInteger divisor) {
        return new Yobibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte multiply(final @NotNull BigInteger factor) {
        return new Yobibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Yobibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yobibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "YiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
