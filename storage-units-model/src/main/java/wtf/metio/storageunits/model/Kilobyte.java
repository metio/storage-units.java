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
 * Kilobyte as specified in ISO IEC 80000-13:2008 (1 Kilobyte = 1 000 Byte).
 */
public final class Kilobyte extends StorageUnit<Kilobyte> {

  @Serial
  private static final long serialVersionUID = 6952239416014811456L;

  Kilobyte(@NotNull final BigInteger numberOfBytes) {
    super(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Kilobyte contains.
   * @return A new Kilobyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Kilobyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Kilobyte contains.
   * @return A new Kilobyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Kilobyte contains.
   * @return A new Kilobyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte add(@NotNull final BigInteger bytesToAdd) {
    return new Kilobyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte divide(@NotNull final BigInteger divisor) {
    return new Kilobyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte multiply(@NotNull final BigInteger factor) {
    return new Kilobyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Kilobyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kilobyte subtract(final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return BYTES_IN_A_KILOBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "kB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
