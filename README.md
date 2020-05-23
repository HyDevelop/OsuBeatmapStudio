<h1 align="center">
  <br>
  <br>
  OsuBeatmapParser
  <h4 align="center">
  Read .osu files in Java / Kotlin
  </h4>
  <h5 align="center">
<a href="#maven">Get Started</a>&nbsp;&nbsp;
<a href="#doc">Documentation</a>&nbsp;&nbsp;
<a href="#qa">FAQ</a>&nbsp;&nbsp;
<a href="#license">License</a>&nbsp;&nbsp;
<a href="README.cn.md">中文</a>
</h5>
  <br>
  <br>
  <br>
</h1>


<a name="maven"></a>
Maven / Gradle Import
--------

### 1. Add Repository

Add JitPack's repository into your `pom.xml` first:

#### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### Gradle

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add Dependency

Add this dependency to your `<dependencies>` tag:

#### Maven

```xml
<dependency>
    <groupId>com.github.HyDevelop</groupId>
    <artifactId>OsuBeatmapParser</artifactId>
    <version>1.1.0.94</version>
</dependency>
```

#### Gradle

```gradle
dependencies {
    implementation 'com.github.HyDevelop:OsuBeatmapParser:1.1.0.94'
}
```

The dependency would be ready once you reimport.

If you are not using maven or gradle, [Import from Other Package Managers](https://jitpack.io/#HyDevelop/OsuBeatmapParser/1.1.0.94)

<br>

<a name="doc"></a>
Documentation
--------

### 1. How to read a beatmap

#### Kotlin

```kt
val beatmap = BeatmapReader.parse(File("file_name.osu"))
// or
val beatmap = BeatmapReader.parse(beatmapText)
```

#### Java

```java
Beatmap beatmap = BeatmapReader.parse(new File("file_name.osu"));
// or
Beatmap beatmap = BeatmapReader.parse(beatmapText);
```

### 2. How to save a beatmap

#### Kotlin

```kt
File("output.osu").writeText(beatmap.toString())
```

#### Java

```java
PrintWriter out = new PrintWriter("output.osu");
out.print(beatmap);
```

### 3. What can you do with a beatmap

You can manipulate it like an object. Almost every property is parsed (except for color properties that I'm not sure about).<br>
Read some code!<br>
![https://i.imgur.com/0wus8KB.png](https://i.imgur.com/0wus8KB.png)

<br>

<a name="qa"></a>
Frequently Asked Questions:
--------

### Q: How are you?

I'm great, how are you?

<br>

<a name="license"></a>
License: MIT
--------
