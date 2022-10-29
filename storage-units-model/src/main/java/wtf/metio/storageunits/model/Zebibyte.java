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
 * Zebibyte as specified in ISO IEC 80000-13:2008 (1 Zebibyte = 1 180 591 620 717 411 303 424 Byte).
 */
public final class Zebibyte extends StorageUnit<Zebibyte> {

    @Serial
    private static final long serialVersionUID = 2192254824473341887L;

    Zebibyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Zebibyte contains.
     * @return A new Zebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Zebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Zebibyte contains.
     * @return A new Zebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Zebibyte contains.
     * @return A new Zebibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Zebibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte divide(final @NotNull BigInteger divisor) {
        return new Zebibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte multiply(final @NotNull BigInteger factor) {
        return new Zebibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Zebibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Zebibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZEBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "ZiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
