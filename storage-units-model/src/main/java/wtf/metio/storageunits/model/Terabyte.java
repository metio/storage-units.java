/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

/**
 * Terabyte as specified in ISO IEC 80000-13:2008 (1 Terabyte = 1 000 000 000 000 Byte).
 */
public final class Terabyte extends StorageUnit<Terabyte> {

  @Serial
  private static final long serialVersionUID = 2160488069631638952L;

  Terabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Terabyte contains.
   * @return A new Kilobyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Terabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Terabyte contains.
   * @return A new Terabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Terabyte contains.
   * @return A new Terabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Terabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte divide(@NotNull final BigInteger divisor) {
    return new Terabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte multiply(@NotNull final BigInteger factor) {
    return new Terabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Terabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Terabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_TERABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "TB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
