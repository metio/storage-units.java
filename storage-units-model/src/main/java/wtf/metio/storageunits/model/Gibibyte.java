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
 * Gibibyte as specified in ISO IEC 80000-13:2008 (1 Gibibyte = 1 073 741 824 Byte).
 */
public final class Gibibyte extends StorageUnit<Gibibyte> {

  @Serial
  private static final long serialVersionUID = -1104749948510944566L;

  Gibibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Gibibyte contains.
   * @return A new Gibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Gibibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Gibibyte contains.
   * @return A new Gibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Gibibyte contains.
   * @return A new Gibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Gibibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte divide(@NotNull final BigInteger divisor) {
    return new Gibibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte multiply(@NotNull final BigInteger factor) {
    return new Gibibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Gibibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gibibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return BYTES_IN_A_GIBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "GiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
