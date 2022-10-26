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
 * Tebibyte as specified in ISO IEC 80000-13:2008 (1 Tebibyte = 1 099 511 627 776 Byte).
 */
public final class Tebibyte extends StorageUnit<Tebibyte> {

  @Serial
  private static final long serialVersionUID = 3614537130129620881L;

  Tebibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Tebibyte contains.
   * @return A new Tebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Tebibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Tebibyte contains.
   * @return A new Tebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Tebibyte contains.
   * @return A new Tebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Tebibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte divide(@NotNull final BigInteger divisor) {
    return new Tebibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte multiply(@NotNull final BigInteger factor) {
    return new Tebibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Tebibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Tebibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return BYTES_IN_A_TEBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "TiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
