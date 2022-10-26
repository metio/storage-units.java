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
 * Yobibyte as specified in ISO IEC 80000-13:2008 (1 Yobibyte = 1 208 925 819 614 629 174 706 176 Byte).
 */
public final class Yobibyte extends StorageUnit<Yobibyte> {

  /**
   * Generated
   */
  @Serial
  private static final long serialVersionUID = -5606322878020884194L;

  Yobibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Yobibyte contains.
   * @return A new Yobibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Yobibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Yobibyte contains.
   * @return A new Yobibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Yobibyte contains.
   * @return A new Yobibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Yobibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte divide(@NotNull final BigInteger divisor) {
    return new Yobibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte multiply(@NotNull final BigInteger factor) {
    return new Yobibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Yobibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yobibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_YOBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "YiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
