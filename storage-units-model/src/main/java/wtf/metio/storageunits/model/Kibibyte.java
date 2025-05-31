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
 * Kibibyte as specified in ISO IEC 80000-13:2008 (1 Kibibyte = 1 024 Byte).
 */
public final class Kibibyte extends StorageUnit<Kibibyte> {

    @Serial
    private static final long serialVersionUID = 3798828851496657978L;

    private static final int conversionScale = computeFiniteConversionScale(StorageUnit.BYTES_IN_A_KIBIBYTE);

    Kibibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Kibibyte contains.
     * @return A new Kibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Kibibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Kibibyte contains.
     * @return A new Kibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Kibibyte contains.
     * @return A new Kibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Kibibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte divide(final @NotNull BigInteger divisor) {
        return new Kibibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte multiply(final @NotNull BigInteger factor) {
        return new Kibibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Kibibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Kibibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KIBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "KiB";
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
