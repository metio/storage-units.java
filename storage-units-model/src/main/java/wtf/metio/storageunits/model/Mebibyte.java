/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

/**
 * Mebibyte as specified in ISO IEC 80000-13:2008 (1 Mebibyte = 1 048 576 Byte).
 */
public final class Mebibyte extends StorageUnit<Mebibyte> {

  @Serial
  private static final long serialVersionUID = 7697583678146919524L;

  Mebibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Mebibyte contains.
   * @return A new Mebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Mebibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Mebibyte contains.
   * @return A new Mebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Mebibyte contains.
   * @return A new Mebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Mebibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte divide(@NotNull final BigInteger divisor) {
    return new Mebibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte multiply(@NotNull final BigInteger factor) {
    return new Mebibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Mebibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Mebibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_MEBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "MiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
