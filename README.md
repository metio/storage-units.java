<!--
SPDX-FileCopyrightText: The Storage-Units Authors
SPDX-License-Identifier: 0BSD
 -->

# Storage-Units [![Chat](https://img.shields.io/badge/irc.libera.chat-%23metio-blue.svg)](ircs://irc.libera.chat:6697/#metio)

Storage units according to ISO IEC 80000-13:2008 implemented in Java.

## Features

* Immutable, type- and thread-safe object model for storage units
* Convenience factories to create units
* Basic arithmetic operators
* Comparisons and equality checks between units
* Lossless conversion between all units
* Human-readable text format, including custom formats
* Compatible with any `java.lang.Number`
* Custom serializers for Jackson, MongoDB, EclipseLink, and others

### Available Units

| Name     | Symbol | Exponential          | Absolute                                       |
|----------|--------|----------------------|------------------------------------------------|
| Byte     | B      | 2<sup>0</sup> Byte   | 1 Byte                                         |
| Kibibyte | KiB    | 2<sup>10</sup> Byte  | 1 024 Byte                                     |
| Mebibyte | MiB    | 2<sup>20</sup> Byte  | 1 048 576 Byte                                 |
| Gibibyte | GiB    | 2<sup>30</sup> Byte  | 1 073 741 824 Byte                             |
| Tebibyte | TiB    | 2<sup>40</sup> Byte  | 1 099 511 627 776 Byte                         |
| Pebibyte | PiB    | 2<sup>50</sup> Byte  | 1 125 899 906 842 624 Byte                     |
| Exbibyte | EiB    | 2<sup>60</sup> Byte  | 1 152 921 504 606 846 976 Byte                 |
| Zebibyte | ZiB    | 2<sup>70</sup> Byte  | 1 180 591 620 717 411 303 424 Byte             |
| Yobibyte | YiB    | 2<sup>80</sup> Byte  | 1 208 925 819 614 629 174 706 176 Byte         |
| Robibyte | RiB    | 2<sup>90</sup> Byte  | 1 237 940 039 285 380 274 899 124 224 Byte     |
| Qubibyte | QiB    | 2<sup>100</sup> Byte | 1 267 650 600 228 229 401 496 703 205 376 Byte |

| Name       | Symbol | Exponential          | Absolute                                       |
|------------|--------|----------------------|------------------------------------------------|
| Byte       | B      | 10<sup>0</sup> Byte  | 1 Byte                                         |
| Kilobyte   | KB     | 10<sup>3</sup> Byte  | 1 000 Byte                                     |
| Megabyte   | MB     | 10<sup>6</sup> Byte  | 1 000 000 Byte                                 |
| Gigabyte   | GB     | 10<sup>9</sup> Byte  | 1 000 000 000 Byte                             |
| Terabyte   | TB     | 10<sup>12</sup> Byte | 1 000 000 000 000 Byte                         |
| Petabyte   | PB     | 10<sup>15</sup> Byte | 1 000 000 000 000 000 Byte                     |
| Exabyte    | EB     | 10<sup>18</sup> Byte | 1 000 000 000 000 000 000 Byte                 |
| Zettabyte  | ZB     | 10<sup>21</sup> Byte | 1 000 000 000 000 000 000 000 Byte             |
| Yottabyte  | YB     | 10<sup>24</sup> Byte | 1 000 000 000 000 000 000 000 000 Byte         |
| Ronnabyte  | RB     | 10<sup>27</sup> Byte | 1 000 000 000 000 000 000 000 000 000 Byte     |
| Quettabyte | QB     | 10<sup>30</sup> Byte | 1 000 000 000 000 000 000 000 000 000 000 Byte |

## Usage

### Factories

Each unit implements a Byte-based static factory method (`valueOf(BigInteger)` or `valueOf(long)`) that can be used to represent a given number of bytes in a specific unit. Note that `Long.MAX_VALUE == 8 Exabyte`, thus use `BigInteger` if you want to work with anything bigger than a eight Exabyte. When in doubt, always use `BigInteger`.

```java
// 'long' based
Kilobyte unit = Kilobyte.valueOf(500)                           // 500 Byte or "0.50 kB"
Kibibyte unit = Kibibyte.valueOf(512)                           // 512 Byte or "0.50 KiB"

Megabyte unit = Megabyte.valueOf(1_000_000)                     // 1 000 000 Byte or "1.00 MB"
Mebibyte unit = Mebibyte.valueOf(1_048_576)                     // 1 048 576 Byte or "1.00 MiB"

// 'BigInteger' based
Kilobyte unit = Kilobyte.valueOf(BigInteger.valueOf(500))       // 500 Byte or "0.50 kB"
Kibibyte unit = Kibibyte.valueOf(BigInteger.valueOf(512))       // 512 Byte or "0.50 KiB"

Megabyte unit = Megabyte.valueOf(BigInteger.valueOf(1000000))   // 1 000 000 Byte or "1.00 MB"
Mebibyte unit = Mebibyte.valueOf(BigInteger.valueOf(1_048_576)) // 1 048 576 Byte or "1.00 MB"
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
Robibyte unit = robibyte(1)   // 1 237 940 039 285 380 274 899 124 224 Byte
Qubibyte unit = qubibyte(1)   // 1 267 650 600 228 229 401 496 703 205 376 Byte

Kilobyte unit = kilobyte(1)     // 1 000 Byte
Megabyte unit = megabyte(1)     // 1 000 000 Byte
Gigabyte unit = gigabyte(1)     // 1 000 000 000 Byte
Terabyte unit = terabyte(1)     // 1 000 000 000 000 Byte
Petabyte unit = petabyte(1)     // 1 000 000 000 000 000 Byte
Exabyte unit = exabyte(1)       // 1 000 000 000 000 000 000 Byte
Zettabyte unit = zettabyte(1)   // 1 000 000 000 000 000 000 000 Byte
Yottabyte unit = yottabyte(1)   // 1 000 000 000 000 000 000 000 000 Byte
Ronnabyte unit = ronnabyte(1)   // 1 000 000 000 000 000 000 000 000 000 Byte
Quettabyte unit = quettabyte(1) // 1 000 000 000 000 000 000 000 000 000 000 Byte
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
```

Each unit can be expressed as a fraction of another unit (precise up to 24 decimal places)

```java
import static wtf.metio.storageunits.model.StorageUnits.*;

BigDecimal kilobytes = megabyte(1).inKilobyte()  // 1 000
BigInteger bytes = kibibyte(2).inByte()          // 2 048
BigDecimal terabytes = gigabyte(15).inTerabyte() // 0.015
```

### Serialization/Converters/Mappers

Multiple custom serializers, converters, and mappers are available for all storage units.

#### Dozer

Use a [Dozer](https://dozermapper.github.io/) converter like this:

```java
import static wtf.metio.storageunits.dozer.*;

DozerBeanMapperBuilder.create()
        .withCustomConverter(new BigIntegerBinaryStorageUnitConverter())
        .withCustomConverter(new BigIntegerDecimalStorageUnitConverter())
        .withCustomConverter(new LongBinaryStorageUnitConverter())
        .withCustomConverter(new LongDecimalStorageUnitConverter())
        .build();
```

#### EclipseLink

Use any of the three converters like this:

```java
import static wtf.metio.storageunits.eclipselink.*;

@Entity
public class HardDisk implements Serializable {

    @Basic
    @Converter (
        name="binaryConverter",
        converterClass=BinaryStorageUnitConverter.class
    )
    @Convert("binaryConverter")
    public StorageUnit<?> getFreeSize() {
        return freeSize;
    }

    @Basic
    @Converter (
        name="decimalConverter",
        converterClass=DecimalyStorageUnitConverter.class
    )
    @Convert("decimalConverter")
    public StorageUnit<?> getTotalSize() {
        return totalSize;
    }

}
```

#### GSON

Use a [GSON](https://github.com/google/gson) serializer/deserializer like this:

```java
import static wtf.metio.storageunits.gson.*;

new GsonBuilder()
        .registerTypeHierarchyAdapter(StorageUnit.class, new StorageUnitSerializer())
        .registerTypeHierarchyAdapter(StorageUnit.class, new BinaryStorageUnitDeserializer())
        .registerTypeHierarchyAdapter(StorageUnit.class, new DecimalStorageUnitDeserializer())
        .create();
```

#### Jackson

Use the provided `StorageUnitModule` like this:

```java
import static wtf.metio.storageunits.jackson.*;

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(new StorageUnitModule()); // defaults to binary units
objectMapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.BINARY));
objectMapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.DECIMAL));
```

#### Jakarta

Use the provided `AttributeConverter`s like this:

```java
import static wtf.metio.storageunits.jakarta.*;

@Entity
public class HardDisk implements Serializable {

    @Convert(converter = BinaryStorageUnitConverter.class)
    public StorageUnit<?> getFreeSize() {
        return freeSize;
    }

    @Convert(converter = DecimalStorageUnitConverter.class)
    public StorageUnit<?> getTotalSize() {
        return totalSize;
    }

}
```

#### MapStruct

Use any of the available mappers like this:

```java
import static wtf.metio.storageunits.mapstruct.*;

@Mapper( uses = BigIntegerToBinaryUnitMapper.class )
public interface MovieMapper {

     DestinationType toDestination(SourceType sourceValue);

}
```

#### ModelMapper

Use any of the available converters like this:

```java
import static wtf.metio.storageunits.modelmapper.*;

modelMapper.addConverter(new BigIntegerToBinaryUnitConverter());
modelMapper.addConverter(new BigIntegerToDecimalUnitConverter());
modelMapper.addConverter(new LongToBinaryUnitConverter());
modelMapper.addConverter(new LongToDecimalUnitConverter());
modelMapper.addConverter(new StorageUnitToBigIntegerConverter());
```

#### MongoDB

Use any of the three codecs like this:

```java
import static wtf.metio.storageunits.mongodb.*;

CodecRegistry binaryRegistry = CodecRegistries.fromCodecs(new BinaryStorageUnitCodec(), ...);
CodecRegistry decimalRegistry = CodecRegistries.fromCodecs(new DecimalStorageUnitCodec(), ...);
```

#### Orika

Use any of the provided converters like this:

```java
import static wtf.metio.storageunits.orika.*;

ConverterFactory converterFactory = mapperFactory.getConverterFactory();
converterFactory.registerConverter(new BinaryStorageUnitConverter());
converterFactory.registerConverter(new DecimalStorageUnitConverter());
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

    <!-- Dozer ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-dozer</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- Dozer ONLY -->

    <!-- EclipseLink ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-eclipselink</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- EclipseLink ONLY -->

    <!-- GSON ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-gson</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- GSON ONLY -->

    <!-- Jackson ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-jackson</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- Jackson ONLY -->

    <!-- Jakarta ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-jakarta</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- Jakarta ONLY -->

    <!-- MapStruct ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-mapstruct</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- MapStruct ONLY -->

    <!-- ModelMapper ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-modelmapper</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- ModelMapper ONLY -->

    <!-- MongoDB ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-mongodb</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- MongoDB ONLY -->

    <!-- Orika ONLY -->
    <dependency>
        <groupId>wtf.metio.storage-units</groupId>
        <artifactId>storage-units-orika</artifactId>
        <version>${version.storage-units}</version>
    </dependency>
    <!-- Orika ONLY -->
</dependencies>
```

Replace `${version.storage-units}` with the [latest release](https://central.sonatype.com/namespace/wtf.metio.storage-units).

## Reference

Originally inspired by [Twitters util](https://github.com/twitter/util#space) package.

## Alternatives

* [Byte Units](https://github.com/JakeWharton/byteunits)
* [triava](https://github.com/trivago/triava)
