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
 * Robibyte as specified in ISO IEC 80000-13:2008 (1 Robibyte = 1 237 940 039 285 380 274 899 124 224 Byte).
 */
public final class Robibyte extends StorageUnit<Robibyte> {

    @Serial
    private static final long serialVersionUID = 3553336770900659080L;

    private static final int conversionScale = computeFiniteConversionScale(StorageUnit.BYTES_IN_A_ROBIBYTE);

    Robibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Robibyte contains.
     * @return A new Robibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Robibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Robibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Robibyte contains.
     * @return A new Robibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Robibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Robibyte contains.
     * @return A new Robibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Robibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Robibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte divide(final @NotNull BigInteger divisor) {
        return new Robibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte multiply(final @NotNull BigInteger factor) {
        return new Robibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Robibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Robibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ROBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "RiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

    @Override
    protected int conversionScale() {
        return conversionScale;
    }

}
