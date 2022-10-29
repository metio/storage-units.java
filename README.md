<!--
SPDX-FileCopyrightText: The Storage-Units Authors
SPDX-License-Identifier: 0BSD
 -->

# Storage-Units

Storage units according to ISO IEC 80000-13:2008 implemented in Java.

## Features

* Immutable, type- and thread-safe object model for storage units
* Convenience factories to create units
* Basic arithmetic operators
* Comparisons and equality checks between units
* Lossless conversion between all units
* Human-readable text format, including custom formats
* Compatible with any `java.lang.Number`
* Custom serializers for Jackson, MongoDB & EclipseLink

### Available Units

| Name     | Symbol | Exponential         | Absolute                               |
|----------|--------|---------------------|----------------------------------------|
| Byte     | B      | 2<sup>0</sup> Byte  | 1 Byte                                 |
| Kibibyte | KiB    | 2<sup>10</sup> Byte | 1 024 Byte                             |
| Mebibyte | MiB    | 2<sup>20</sup> Byte | 1 048 576 Byte                         |
| Gibibyte | GiB    | 2<sup>30</sup> Byte | 1 073 741 824 Byte                     |
| Tebibyte | TiB    | 2<sup>40</sup> Byte | 1 099 511 627 776 Byte                 |
| Pebibyte | PiB    | 2<sup>50</sup> Byte | 1 125 899 906 842 624 Byte             |
| Exbibyte | EiB    | 2<sup>60</sup> Byte | 1 152 921 504 606 846 976 Byte         |
| Zebibyte | ZiB    | 2<sup>70</sup> Byte | 1 180 591 620 717 411 303 424 Byte     |
| Yobibyte | YiB    | 2<sup>80</sup> Byte | 1 208 925 819 614 629 174 706 176 Byte |

| Name      | Symbol | Exponential          | Absolute                               |
|-----------|--------|----------------------|----------------------------------------|
| Byte      | B      | 10<sup>0</sup> Byte  | 1 Byte                                 |
| Kilobyte  | KB     | 10<sup>3</sup> Byte  | 1 000 Byte                             |
| Megabyte  | MB     | 10<sup>6</sup> Byte  | 1 000 000 Byte                         |
| Gigabyte  | GB     | 10<sup>9</sup> Byte  | 1 000 000 000 Byte                     |
| Terabyte  | TB     | 10<sup>12</sup> Byte | 1 000 000 000 000 Byte                 |
| Petabyte  | PB     | 10<sup>15</sup> Byte | 1 000 000 000 000 000 Byte             |
| Exabyte   | EB     | 10<sup>18</sup> Byte | 1 000 000 000 000 000 000 Byte         |
| Zettabyte | ZB     | 10<sup>21</sup> Byte | 1 000 000 000 000 000 000 000 Byte     |
| Yottabyte | YB     | 10<sup>24</sup> Byte | 1 000 000 000 000 000 000 000 000 Byte |

## Usage

### Factories

Each unit implements a Byte-based static factory method (`valueOf(BigInteger)` or `valueOf(long)`) that can be used to represent a given number of bytes in a specific unit. Note that `Long.MAX_VALUE == 8 Exabyte`, thus use `BigInteger` if you want to work with anything bigger than a eight Exabyte. When in doubt, always use `BigInteger`.

```java
// 'long' based
Kilobyte unit = Kilobyte.valueOf(500)                                       // 500 Byte or "0.50 kB"
Kibibyte unit = Kibibyte.valueOf(512)                                       // 512 Byte or "0.50 KiB"

Megabyte unit = Megabyte.valueOf(1_000_000)                                 // 1 000 000 Byte or "1.00 MB"
Mebibyte unit = Mebibyte.valueOf(1_048_576)                                 // 1 048 576 Byte or "1.00 MiB"

// 'BigInteger' based
Kilobyte unit = Kilobyte.valueOf(BigInteger.valueOf(500))                   // 500 Byte or "0.50 kB"
Kibibyte unit = Kibibyte.valueOf(BigInteger.valueOf(512))                   // 512 Byte or "0.50 KiB"

Megabyte unit = Megabyte.valueOf(BigInteger.valueOf(1000000))               // 1 000 000 Byte or "1.00 MB"
Mebibyte unit = Mebibyte.valueOf(BigInteger.valueOf(1_048_576))             // 1 048 576 Byte or "1.00 MB"
```

The `StorageUnits` class offers three factory methods that automatically pick the best-matching unit for a given number of bytes.

#### Binary Units

```java
// 'long' based
StorageUnit<?> unit = StorageUnits.binaryValueOf(256)                         // Kibibyte (0.25 KiB)
StorageUnit<?> unit = StorageUnits.binaryValueOf(1048576)                     // Mebibyte (1.00 MiB)

// 'BigInteger' based
StorageUnit<?> unit = StorageUnits.binaryValueOf(BigInteger.valueOf(256))     // Kibibyte (0.25 MiB)
StorageUnit<?> unit = StorageUnits.binaryValueOf(BigInteger.valueOf(1048576)) // Mebibyte (1.00 MiB)
```

#### Decimal Units

```java
// 'long' based
StorageUnit<?> unit = StorageUnits.decimalValueOf(120000)                      // Kilobyte (120.00 kB)
StorageUnit<?> unit = StorageUnits.decimalValueOf(1000000)                     // Megabyte (1.00 MB)

// 'BigInteger' based
StorageUnit<?> unit = StorageUnits.decimalValueOf(BigInteger.valueOf(120000))  // Kilobyte (120.00 kB)
StorageUnit<?> unit = StorageUnits.decimalValueOf(BigInteger.valueOf(1000000)) // Megabyte (1.00 MB)
```

Additionally high-level factory methods are also available in the `StorageUnits` class.

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

Kibibyte unit = kibibyte(1)   // 1 024 Byte
Mebibyte unit = mebibyte(1)   // 1 048 576 Byte
Gibibyte unit = gibibyte(1)   // 1 073 741 824 Byte
Tebibyte unit = tebibyte(1)   // 1 099 511 627 776 Byte
Pebibyte unit = pebibyte(1)   // 1 125 899 906 842 624 Byte
Exbibyte unit = exbibyte(1)   // 1 152 921 504 606 846 976 Byte
Zebibyte unit = zebibyte(1)   // 1 180 591 620 717 411 303 424 Byte
Yobibyte unit = yobibyte(1)   // 1 208 925 819 614 629 174 706 176 Byte

Kilobyte unit = kilobyte(1)   // 1 000 Byte
Megabyte unit = megabyte(1)   // 1 000 000 Byte
Gigabyte unit = gigabyte(1)   // 1 000 000 000 Byte
Terabyte unit = terabyte(1)   // 1 000 000 000 000 Byte
Petabyte unit = petabyte(1)   // 1 000 000 000 000 000 Byte
Exabyte unit = exabyte(1)     // 1 000 000 000 000 000 000 Byte
Zettabyte unit = zettabyte(1) // 1 000 000 000 000 000 000 000 Byte
Yottabyte unit = yottabyte(1) // 1 000 000 000 000 000 000 000 000 Byte
```

### Add, Subtract, Multiply, Divide

Each unit implements the basic four math operations. All operations retain their original type, e.g. `[Kilobyte] + [Megabyte] = [Kilobyte]`

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

kilobyte(4).add(kilobyte(8))        // 4 Kilobyte + 8 Kilobyte = 12 Kilobyte = 12 000 Byte
kibibyte(1).add(1024)               // 1 Kibibyte + 1 024 Byte = 2 Kibibyte = 2 048 Byte
kibibyte(1).subtract(24)            // 1 024 Byte - 24 Byte = 1 000 Byte
megabyte(5).subtract(kilobyte(500)) // 5 Megabyte - 500 Kilobyte = 4.5 Megabyte = 4 500 Kilobyte = 4 500 000 Byte
gigabyte(1).multiply(5)             // 1 Gigabyte times 5 = 5 Gigabyte
terabyte(1).divide(5)               // 1 Terabyte divided by 5 = 0.2 Terabyte = 200 Gigabyte
```

### Comparison & Equality

Each unit is comparable to each other unit.

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

kibibyte(1024).compareTo(mebibyte(1)) == 0 // true
kibibyte(1000).compareTo(mebibyte(1)) == 0 // false
petabyte(3).compareTo(terabyte(3000)) == 0 // true

megabyte(1000).equals(gigabyte(1))         // true
megabyte(1024).equals(gigabyte(1))         // false
terabyte(12).equals(gigabyte(12000))       // true
```

### Formatting

Each unit prints a human-readable string, representing the amount of bytes in the given unit using the symbol specified in ISO IEC 80000-13:2008.

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

// default pattern '0.00'
terabyte(2).toString()                         // "2.00 TB"
gigabyte(1).add(megabyte(200)).toString()      // "1.20 GB"
petabyte(1).subtract(terabyte(250)).toString() // "0.75 PB"

// use custom pattern
kilobyte(212345).toString("0.0")                                    // "212345.0 kB"
gibibyte(2123458).asTebibyte().toString("#,###.000")                // "2,073.689 TiB"
kilobyte(120).asMegabyte().add(gigabyte(1)).toString("#,##0.00000") // "1,000.12000 MB"

// use custom pattern with specific Locale
kilobyte(212345).toString("0.0", Locale.GERMAN)                     // "212345,0 kB"
gibibyte(2123458).asTebibyte().toString("#,###.000", Locale.GERMAN) // "2.073,689 TiB"

// use custom format
Format customFormat = new DecimalFormat("#.00000");
terabyte(4).asTebibyte().toString(customFormat) // "3.63798 TiB"

// without creating unit type first
long numberOfBytes = 1_000_000_000_000_000L;
formatAsPetabyte(numberOfBytes) // "1.00 PB"
formatAsTerabyte(numberOfBytes) // "1000.00 TB"
formatAsPebibyte(numberOfBytes) // "0.89 PiB"

// use custom pattern
formatAsTerabyte(numberOfBytes, "#0.#####") // "1000 TB"
formatAsPebibyte(numberOfBytes, "#0.#####") // "0.88818 PiB"

// use custom pattern with specific Locale
formatAsTerabyte(numberOfBytes, "#0.#####", Locale.GERMAN) // "1000 TB"
formatAsPebibyte(numberOfBytes, "#0.#####", Locale.GERMAN) // "0,88818 PiB"

// use custom format
formatAsTerabyte(numberOfBytes, customFormat) // "1000.00000 TB"
formatAsPebibyte(numberOfBytes, customFormat) // ".88818 PiB"
```

### Conversions

Each unit can be converted to each other unit without loss of information.

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

Megabyte unit = kilobyte(1000).asMegabyte() // "1.00 MB"
Kilobyte unit = gigabyte(12).asKilobyte()   // "12000000.00 kB"
Gigabyte unit = terabyte(1).asGigabyte()    // "1000.00 GB"

// convert to best-match
kilobyte(1100).asBestMatchingUnit()          // "1.10 MB"
kilobyte(1100).asBestMatchingBinaryUnit()    // "1.05 MiB"
kilobyte(1100).asBestMatchingDecimalUnit()   // "1.10 MB"
kilobyte(1100).asBestMatchingCommonUnit()    // "1.05 MB"
```

Each unit can be expressed as a fraction of another unit (precise up to 24 decimal places)

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

BigDecimal kilobytes = megabyte(1).inKilobyte()  // 1 000
BigInteger bytes = kibibyte(2).inByte()          // 2 048
BigDecimal terabytes = gigabyte(15).inTerabyte() // 0.015
```

### Serialization

Multiple custom serializers are available to store storage units.

#### EclipseLink

Use any of the three converters like this:

```java
@Entity
public class HardDisk implements Serializable {

    @Basic
    @Converter (
        name="binaryConverter",
        converterClass=wtf.metio.storageunits.eclipselink.BinaryStorageUnitConverter.class
    )
    @Convert("binaryConverter")
    public StorageUnit<?> getFreeSize() {
        return freeSize;
    }

    @Basic
    @Converter (
        name="decimalConverter",
        converterClass=wtf.metio.storageunits.eclipselink.DecimalyStorageUnitConverter.class
    )
    @Convert("decimalConverter")
    public StorageUnit<?> getTotalSize() {
        return totalSize;
    }

}
```

#### MongoDB

Use any of the three codecs like this:

```java
CodecRegistry binaryRegistry = CodecRegistries.fromCodecs(new BinaryStorageUnitCodec(), ...);
CodecRegistry decimalRegistry = CodecRegistries.fromCodecs(new DecimalStorageUnitCodec(), ...);
```

#### Jackson

Use the provided `StorageUnitModule` like this:

```java
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(new StorageUnitModule()); // defaults to binary units
objectMapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.BINARY));
objectMapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.DECIMAL));
```

### Integration

To use this project just declare the following dependency inside your POM:

```xml
<dependencies>
  <dependency>
    <groupId>wtf.metio.storage-units</groupId>
    <artifactId>storage-units-model</artifactId>
    <version>${version.storage-units}</version>
  </dependency>

  <!-- EclipseLink ONLY -->
  <dependency>
    <groupId>wtf.metio.storage-units</groupId>
    <artifactId>storage-units-eclipselink</artifactId>
    <version>${version.storage-units}</version>
  </dependency>
  <!-- EclipseLink ONLY -->

  <!-- MongoDB ONLY -->
  <dependency>
    <groupId>wtf.metio.storage-units</groupId>
    <artifactId>storage-units-mongodb</artifactId>
    <version>${version.storage-units}</version>
  </dependency>
  <!-- MongoDB ONLY -->

  <!-- Jackson ONLY -->
  <dependency>
    <groupId>wtf.metio.storage-units</groupId>
    <artifactId>storage-units-jackson</artifactId>
    <version>${version.storage-units}</version>
  </dependency>
  <!-- Jackson ONLY -->
</dependencies>
```

Replace `${version.storage-units}` with the [latest release](https://search.maven.org/search?q=g:wtf.metio.storageunits).

## Reference

Originally inspired by [Twitters util](https://github.com/twitter/util#space) package.

## Alternatives

* [Byte Units](https://github.com/JakeWharton/byteunits)
* [triava](https://github.com/trivago/triava)

## License

```
Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM
LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR
OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
PERFORMANCE OF THIS SOFTWARE.
```
