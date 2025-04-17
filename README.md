# xtdb-problem

Demonstrating a problem with using xtdb-core with the latest reitit
libraries.

Can reproduce this by starting the repl and evaluating in the user namespace

```
(go)
```

You can see that the system launches normally if you comment the
xtdb-core dependency and try again.

You can test that the server is functioning by using

```
curl http://localhost:3333/api/foo -v
```

Probably has to do with conflicting dependency for Jetty

```
metosin/reitit-middleware 0.8.0
  X metosin/reitit-ring 0.8.0 :use-top
  . lambdaisland/deep-diff 0.0-47
    . mvxcvi/puget 1.1.2
      X mvxcvi/arrangement 1.2.0 :older-version
      X fipp/fipp 0.6.17 :older-version
    X fipp/fipp 0.6.17 :older-version
    X org.clojure/core.rrb-vector 0.0.14 :superseded
    . tech.droit/clj-diff 1.0.1
    X mvxcvi/arrangement 1.2.0 :older-version
  . metosin/muuntaja 0.6.11
    . metosin/jsonista 0.3.13
      . com.fasterxml.jackson.core/jackson-core 2.18.2 :newer-version
      . com.fasterxml.jackson.core/jackson-databind 2.18.2 :newer-version
        . com.fasterxml.jackson.core/jackson-annotations 2.18.2 :newer-version
        . com.fasterxml.jackson.core/jackson-core 2.18.2
      . com.fasterxml.jackson.datatype/jackson-datatype-jsr310 2.18.2 :newer-version
        . com.fasterxml.jackson.core/jackson-annotations 2.18.2
        . com.fasterxml.jackson.core/jackson-core 2.18.2
        . com.fasterxml.jackson.core/jackson-databind 2.18.2
    . com.cognitect/transit-clj 1.0.333 :newer-version
      . com.cognitect/transit-java 1.0.371 :newer-version
        X com.fasterxml.jackson.core/jackson-core 2.14.2 :older-version
        . org.msgpack/msgpack 0.6.12
          . com.googlecode.json-simple/json-simple 1.1.1
          . org.javassist/javassist 3.18.1-GA
        . javax.xml.bind/jaxb-api 2.4.0-b180830.0359
          . javax.activation/javax.activation-api 1.2.0
  . metosin/spec-tools 0.10.7
    . org.clojure/spec.alpha 0.5.238
org.clojure/clojure 1.12.0
  . org.clojure/spec.alpha 0.5.238
  . org.clojure/core.specs.alpha 0.4.74
metosin/ring-http-response 0.9.5
  X ring/ring-core 1.13.0 :superseded
    X org.ring-clojure/ring-core-protocols 1.13.0 :parent-omitted
    X org.ring-clojure/ring-websocket-protocols 1.13.0 :parent-omitted
    X ring/ring-codec 1.2.0 :parent-omitted
    X commons-io/commons-io 2.17.0 :parent-omitted
    X org.apache.commons/commons-fileupload2-core 2.0.0-M1 :parent-omitted
    X crypto-random/crypto-random 1.2.1 :parent-omitted
    X crypto-equality/crypto-equality 1.0.1 :parent-omitted
  . potemkin/potemkin 0.4.7
    . riddley/riddley 0.1.12
com.xtdb/xtdb-jdbc 2.0.0-beta6
  X com.xtdb/xtdb-api 2.0.0-beta6 :use-top
  . org.jetbrains.kotlin/kotlin-stdlib-jdk8 2.1.0
    . org.jetbrains.kotlin/kotlin-stdlib 2.1.0
      X org.jetbrains/annotations 13.0 :older-version
    . org.jetbrains.kotlin/kotlin-stdlib-jdk7 2.1.0
      . org.jetbrains.kotlin/kotlin-stdlib 2.1.0
  X org.postgresql/postgresql 42.2.23 :superseded
    X org.checkerframework/checker-qual 3.5.0 :parent-omitted
integrant/repl 0.4.0
  . org.clojure/tools.namespace 1.5.0
    . org.clojure/java.classpath 1.1.0
    . org.clojure/tools.reader 1.4.0
  X integrant/integrant 0.13.0 :use-top
ring/ring-jetty-adapter 1.14.1
  . ring/ring-core 1.14.1 :newer-version
    . org.ring-clojure/ring-core-protocols 1.14.1
    . org.ring-clojure/ring-websocket-protocols 1.14.1
    . ring/ring-codec 1.3.0
    . commons-io/commons-io 2.18.0
    . org.apache.commons/commons-fileupload2-core 2.0.0-M2
      X commons-io/commons-io 2.15.1 :older-version
    . crypto-random/crypto-random 1.2.1
      X commons-codec/commons-codec 1.15 :older-version
    . crypto-equality/crypto-equality 1.0.1
  . org.ring-clojure/ring-jakarta-servlet 1.14.1
    . ring/ring-core 1.14.1
  . org.eclipse.jetty/jetty-server 12.0.18
    . org.eclipse.jetty/jetty-http 12.0.18
      . org.eclipse.jetty/jetty-io 12.0.18
      . org.eclipse.jetty/jetty-util 12.0.18
        . org.slf4j/slf4j-api 2.0.16
      . org.slf4j/slf4j-api 2.0.16
    . org.eclipse.jetty/jetty-io 12.0.18
      . org.eclipse.jetty/jetty-util 12.0.18
      . org.slf4j/slf4j-api 2.0.16
    . org.slf4j/slf4j-api 2.0.16
  . org.eclipse.jetty/jetty-unixdomain-server 12.0.18
    . org.eclipse.jetty/jetty-server 12.0.18
    . org.slf4j/slf4j-api 2.0.16
  . org.eclipse.jetty.ee9/jetty-ee9-servlet 12.0.18
    . org.eclipse.jetty.ee9/jetty-ee9-nested 12.0.18
      . org.eclipse.jetty/jetty-http 12.0.18
      . org.eclipse.jetty/jetty-security 12.0.18
        . org.eclipse.jetty/jetty-server 12.0.18
        . org.slf4j/slf4j-api 2.0.16
      . org.eclipse.jetty/jetty-server 12.0.18
      . org.eclipse.jetty/jetty-session 12.0.18
        . org.eclipse.jetty/jetty-server 12.0.18
        . org.slf4j/slf4j-api 2.0.16
      . org.eclipse.jetty.toolchain/jetty-jakarta-servlet-api 5.0.2
      . org.slf4j/slf4j-api 2.0.16
    . org.eclipse.jetty.ee9/jetty-ee9-security 12.0.18
      . org.eclipse.jetty/jetty-security 12.0.18
      . org.eclipse.jetty.ee9/jetty-ee9-nested 12.0.18
      . org.slf4j/slf4j-api 2.0.16
    . org.slf4j/slf4j-api 2.0.16
  . org.eclipse.jetty.ee9.websocket/jetty-ee9-websocket-jetty-server 12.0.18
    . org.eclipse.jetty.ee9/jetty-ee9-servlet 12.0.18
    . org.eclipse.jetty.ee9/jetty-ee9-webapp 12.0.18
      . org.eclipse.jetty/jetty-ee 12.0.18
        . org.eclipse.jetty/jetty-server 12.0.18
        . org.slf4j/slf4j-api 2.0.16
      . org.eclipse.jetty/jetty-xml 12.0.18
        . org.eclipse.jetty/jetty-util 12.0.18
        . org.slf4j/slf4j-api 2.0.16
      . org.eclipse.jetty.ee9/jetty-ee9-servlet 12.0.18
      . org.slf4j/slf4j-api 2.0.16
    . org.eclipse.jetty.ee9.websocket/jetty-ee9-websocket-jetty-api 12.0.18
    . org.eclipse.jetty.ee9.websocket/jetty-ee9-websocket-jetty-common 12.0.18
      . org.eclipse.jetty.ee9.websocket/jetty-ee9-websocket-jetty-api 12.0.18
      . org.eclipse.jetty.websocket/jetty-websocket-core-common 12.0.18
        . org.eclipse.jetty/jetty-http 12.0.18
        . org.eclipse.jetty/jetty-io 12.0.18
        . org.slf4j/slf4j-api 2.0.16
    . org.eclipse.jetty.ee9.websocket/jetty-ee9-websocket-servlet 12.0.18
      . org.eclipse.jetty.ee9/jetty-ee9-servlet 12.0.18
      . org.eclipse.jetty.websocket/jetty-websocket-core-server 12.0.18
        . org.eclipse.jetty/jetty-server 12.0.18
        . org.eclipse.jetty.websocket/jetty-websocket-core-common 12.0.18
      . org.slf4j/slf4j-api 2.0.16
    . org.eclipse.jetty.toolchain/jetty-jakarta-servlet-api 5.0.2
    . org.slf4j/slf4j-api 2.0.16
com.xtdb/xtdb-api 2.0.0-beta6
  . org.clojure/spec.alpha 0.5.238
  X com.cognitect/transit-clj 1.0.329 :superseded
    X com.cognitect/transit-java 1.0.362 :parent-omitted
  X com.cognitect/transit-java 1.0.362 :superseded
    X com.fasterxml.jackson.core/jackson-core 2.8.7 :superseded
    . org.msgpack/msgpack 0.6.12
      X com.googlecode.json-simple/json-simple 1.1.1 :parent-omitted
      X org.javassist/javassist 3.18.1-GA :parent-omitted
    . javax.xml.bind/jaxb-api 2.3.0
  . org.apache.arrow/arrow-algorithm 18.1.0
    . org.apache.arrow/arrow-vector 18.1.0
    . org.apache.arrow/arrow-memory-core 18.1.0
      . org.slf4j/slf4j-api 2.0.16
  . org.apache.arrow/arrow-compression 18.1.0
    . org.apache.arrow/arrow-vector 18.1.0
    . org.apache.arrow/arrow-memory-core 18.1.0
    . org.apache.commons/commons-compress 1.27.1
      . commons-codec/commons-codec 1.17.1
      X commons-io/commons-io 2.16.1 :older-version
      . org.apache.commons/commons-lang3 3.16.0
    . com.github.luben/zstd-jni 1.5.6-6
  . org.apache.arrow/arrow-vector 18.1.0
    . org.apache.arrow/arrow-format 18.1.0
      . com.google.flatbuffers/flatbuffers-java 24.3.25
    . org.apache.arrow/arrow-memory-core 18.1.0
    X com.fasterxml.jackson.core/jackson-core 2.18.0 :superseded
    X com.fasterxml.jackson.core/jackson-annotations 2.18.0 :superseded
    X com.fasterxml.jackson.core/jackson-databind 2.18.0 :superseded
      X com.fasterxml.jackson.core/jackson-annotations 2.18.0 :parent-omitted
      X com.fasterxml.jackson.core/jackson-core 2.18.0 :parent-omitted
    X com.fasterxml.jackson.datatype/jackson-datatype-jsr310 2.18.0 :superseded
      X com.fasterxml.jackson.core/jackson-annotations 2.18.0 :parent-omitted
      X com.fasterxml.jackson.core/jackson-core 2.18.0 :parent-omitted
      X com.fasterxml.jackson.core/jackson-databind 2.18.0 :parent-omitted
    . commons-codec/commons-codec 1.17.1
    . com.google.flatbuffers/flatbuffers-java 24.3.25
    . org.slf4j/slf4j-api 2.0.16
  . org.apache.arrow/arrow-memory-netty 18.1.0
    . org.apache.arrow/arrow-memory-core 18.1.0
    . org.apache.arrow/arrow-memory-netty-buffer-patch 18.1.0
      . org.apache.arrow/arrow-memory-core 18.1.0
      . io.netty/netty-buffer 4.1.114.Final
        X io.netty/netty-common 4.1.114.Final :older-version
      X io.netty/netty-common 4.1.114.Final :older-version
      . org.slf4j/slf4j-api 2.0.16
    X io.netty/netty-common 4.1.114.Final :older-version
  . org.jetbrains.kotlin/kotlin-stdlib-jdk8 2.1.0
  . org.jetbrains.kotlinx/kotlinx-serialization-json-jvm 1.8.0
    . org.jetbrains.kotlin/kotlin-stdlib 2.1.0
    . org.jetbrains.kotlinx/kotlinx-serialization-core-jvm 1.8.0
      . org.jetbrains.kotlin/kotlin-stdlib 2.1.0
  . com.github.ben-manes.caffeine/caffeine 3.1.8
    X org.checkerframework/checker-qual 3.37.0 :superseded
    . com.google.errorprone/error_prone_annotations 2.21.1
aero/aero 1.1.6
metosin/reitit-ring 0.8.0
  X metosin/reitit-core 0.8.0 :use-top
  . ring/ring-core 1.14.1
integrant/integrant 0.13.1
  . weavejester/dependency 0.2.1
metosin/reitit-core 0.8.0
  . meta-merge/meta-merge 1.0.0
metosin/malli 0.17.0
  . fipp/fipp 0.6.27
    . org.clojure/core.rrb-vector 0.1.2 :newer-version
  . mvxcvi/arrangement 2.1.0
  . borkdude/dynaload 0.3.5
  . borkdude/edamame 1.4.27
    X org.clojure/tools.reader 1.3.4 :older-version
  . org.clojure/test.check 1.1.1
com.github.seancorfield/next.jdbc 1.3.955
  . org.clojure/java.data 1.2.107
  . camel-snake-kebab/camel-snake-kebab 0.4.3
metosin/reitit-malli 0.8.0
  X metosin/reitit-core 0.8.0 :use-top
  X metosin/malli 0.17.0 :use-top
com.xtdb/xtdb-http-client-jvm 2.0.0-beta6
  X com.xtdb/xtdb-api 2.0.0-beta6 :use-top
  . pro.juxt.clojars-mirrors.hato/hato 0.8.2
  . pro.juxt.clojars-mirrors.metosin/reitit-core 0.5.15
  . org.jetbrains.kotlin/kotlin-stdlib-jdk8 2.1.0
com.xtdb/xtdb-core 2.0.0-beta6
  X com.xtdb/xtdb-api 2.0.0-beta6 :use-top
  . org.clojure/tools.logging 1.2.4
  . org.slf4j/slf4j-api 2.0.16
  . org.clojure/spec.alpha 0.5.238
  . org.clojure/data.json 2.4.0
  . org.clojure/data.csv 1.0.1
  . org.clojure/tools.cli 1.0.206
  . com.cognitect/transit-clj 1.0.329
  . org.apache.arrow/arrow-algorithm 18.1.0
  . org.apache.arrow/arrow-compression 18.1.0
  . org.apache.arrow/arrow-vector 18.1.0
  . org.apache.arrow/arrow-memory-netty 18.1.0
  . io.netty/netty-common 4.1.117.Final
  . org.roaringbitmap/RoaringBitmap 1.3.0
  X integrant/integrant 0.13.1 :use-top
  . clj-commons/clj-yaml 1.0.27
    . org.yaml/snakeyaml 2.1
    . org.flatland/ordered 1.15.11
  . org.babashka/sci 0.6.37
    . borkdude/sci.impl.reflector 0.0.1
    X borkdude/edamame 1.0.16 :older-version
    . org.babashka/sci.impl.types 0.0.2
  . commons-codec/commons-codec 1.17.1
  . com.carrotsearch/hppc 0.9.1
  . com.github.ben-manes.caffeine/caffeine 3.1.8
  . buddy/buddy-hashers 2.0.167
    . buddy/buddy-core 1.11.423
      X commons-codec/commons-codec 1.16.0 :older-version
      . org.bouncycastle/bcpkix-jdk18on 1.75
        . org.bouncycastle/bcprov-jdk18on 1.75
        . org.bouncycastle/bcutil-jdk18on 1.75
          . org.bouncycastle/bcprov-jdk18on 1.75
      . org.bouncycastle/bcprov-jdk18on 1.75
      . cheshire/cheshire 5.11.0
        X com.fasterxml.jackson.core/jackson-core 2.13.3 :older-version
        . com.fasterxml.jackson.dataformat/jackson-dataformat-smile 2.13.3
          X com.fasterxml.jackson.core/jackson-core 2.13.3 :older-version
        . com.fasterxml.jackson.dataformat/jackson-dataformat-cbor 2.13.3
          X com.fasterxml.jackson.core/jackson-core 2.13.3 :older-version
        . tigris/tigris 0.1.2
    . clojurewerkz/scrypt 1.2.0
      . com.lambdaworks/scrypt 1.4.0
  X ring/ring-core 1.10.0 :older-version
  . info.sunng/ring-jetty9-adapter 0.22.4
    X ring/ring-core 1.10.0 :older-version
    X org.eclipse.jetty/jetty-server 11.0.18 :older-version
    . org.eclipse.jetty.websocket/websocket-jetty-api 11.0.18
    . org.eclipse.jetty.websocket/websocket-jetty-server 11.0.18
      . org.eclipse.jetty.websocket/websocket-jetty-api 11.0.18
      . org.eclipse.jetty.websocket/websocket-jetty-common 11.0.18
        . org.eclipse.jetty.websocket/websocket-jetty-api 11.0.18
        . org.eclipse.jetty.websocket/websocket-core-common 11.0.18
          X org.eclipse.jetty/jetty-io 11.0.18 :older-version
          X org.eclipse.jetty/jetty-http 11.0.18 :older-version
          X org.slf4j/slf4j-api 2.0.5 :older-version
      . org.eclipse.jetty.websocket/websocket-servlet 11.0.18
      . org.eclipse.jetty.toolchain/jetty-jakarta-servlet-api 5.0.2
      . org.eclipse.jetty/jetty-servlet 11.0.18
        X org.eclipse.jetty/jetty-security 11.0.18 :older-version
        X org.slf4j/slf4j-api 2.0.5 :older-version
      . org.eclipse.jetty/jetty-webapp 11.0.18
        . org.eclipse.jetty/jetty-servlet 11.0.18
        X org.eclipse.jetty/jetty-xml 11.0.18 :older-version
        X org.slf4j/slf4j-api 2.0.5 :older-version
      X org.slf4j/slf4j-api 2.0.5 :older-version
    . org.eclipse.jetty.websocket/websocket-servlet 11.0.18
      . org.eclipse.jetty.websocket/websocket-core-server 11.0.18
        . org.eclipse.jetty.websocket/websocket-core-common 11.0.18
        X org.eclipse.jetty/jetty-server 11.0.18 :older-version
      . org.eclipse.jetty/jetty-servlet 11.0.18
      X org.slf4j/slf4j-api 2.0.5 :older-version
    . org.eclipse.jetty.http2/http2-server 11.0.18
      . org.eclipse.jetty.http2/http2-common 11.0.18
        . org.eclipse.jetty.http2/http2-hpack 11.0.18
          X org.eclipse.jetty/jetty-util 11.0.18 :older-version
          X org.eclipse.jetty/jetty-http 11.0.18 :older-version
          X org.eclipse.jetty/jetty-io 11.0.18 :older-version
          X org.slf4j/slf4j-api 2.0.5 :older-version
        X org.slf4j/slf4j-api 2.0.5 :older-version
      X org.eclipse.jetty/jetty-server 11.0.18 :older-version
      X org.slf4j/slf4j-api 2.0.5 :older-version
    . org.eclipse.jetty/jetty-alpn-server 11.0.18
    . org.eclipse.jetty/jetty-alpn-java-server 11.0.18
      X org.eclipse.jetty/jetty-io 11.0.18 :older-version
      . org.eclipse.jetty/jetty-alpn-server 11.0.18
      X org.slf4j/slf4j-api 2.0.5 :older-version
  . org.eclipse.jetty/jetty-alpn-server 11.0.18
    X org.eclipse.jetty/jetty-server 11.0.18 :older-version
    X org.slf4j/slf4j-api 2.0.5 :older-version
  X metosin/muuntaja 0.6.8 :older-version
  X metosin/reitit-core 0.5.15 :use-top
  . metosin/reitit-interceptors 0.5.15
    X metosin/reitit-ring 0.5.15 :use-top
    . lambdaisland/deep-diff 0.0-47
    X metosin/muuntaja 0.6.8 :older-version
  X metosin/reitit-ring 0.5.15 :use-top
  . metosin/reitit-http 0.5.15
    X metosin/reitit-core 0.5.15 :use-top
    X metosin/reitit-ring 0.5.15 :use-top
  . metosin/reitit-sieppari 0.5.15
    X metosin/reitit-core 0.5.15 :use-top
    . metosin/sieppari 0.0.0-alpha13
  . io.micrometer/micrometer-core 1.14.1
    . io.micrometer/micrometer-commons 1.14.1
    . io.micrometer/micrometer-observation 1.14.1
      . io.micrometer/micrometer-commons 1.14.1
    . org.hdrhistogram/HdrHistogram 2.2.2
    . org.latencyutils/LatencyUtils 2.0.3
  . io.micrometer/micrometer-registry-prometheus 1.14.1
    . io.micrometer/micrometer-core 1.14.1
    . io.prometheus/prometheus-metrics-core 1.3.3
      . io.prometheus/prometheus-metrics-model 1.3.3
      . io.prometheus/prometheus-metrics-config 1.3.3
    . io.prometheus/prometheus-metrics-tracer-common 1.3.3
    . io.prometheus/prometheus-metrics-exposition-formats 1.3.3
      . io.prometheus/prometheus-metrics-model 1.3.3
      . io.prometheus/prometheus-metrics-config 1.3.3
  . org.jetbrains.kotlin/kotlin-stdlib-jdk8 2.1.0
  . org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm 1.10.1
    . org.jetbrains/annotations 23.0.0
    . org.jetbrains.kotlin/kotlin-stdlib 2.1.0
  . com.charleskorn.kaml/kaml-jvm 0.56.0
    X org.jetbrains.kotlinx/kotlinx-serialization-core-jvm 1.6.2 :older-version
    X org.jetbrains.kotlin/kotlin-stdlib 1.9.21 :older-version
    . org.snakeyaml/snakeyaml-engine 2.7
  . com.google.protobuf/protobuf-kotlin 4.28.3
    . com.google.protobuf/protobuf-java 4.28.3
    X org.jetbrains.kotlin/kotlin-stdlib 1.6.0 :older-version
  . org.postgresql/postgresql 42.7.3 :newer-version
    . org.checkerframework/checker-qual 3.42.0 :newer-version
  . org.antlr/antlr4 4.13.2
    . org.antlr/antlr4-runtime 4.13.2
    . org.antlr/antlr-runtime 3.5.3
    . org.antlr/ST4 4.3.4
      . org.antlr/antlr-runtime 3.5.3
    . org.abego.treelayout/org.abego.treelayout.core 1.0.3
    . com.ibm.icu/icu4j 72.1
  . org.antlr/antlr4-runtime 4.13.2
```

The stacktrace that is generated

```
2. Unhandled clojure.lang.ExceptionInfo
   Error on key :adapter/jetty when building system
   {:reason :integrant.core/build-threw-exception, :system {:web/routes #function[clojure.lang.AFunction/1]}, :function clojure.lang.MultiFn@614ba4cf, :key :adapter/jetty, :value {:port 3333, :routes #function[clojure.lang.AFunction/1]}}
                 core.cljc:  410  integrant.core$build_exception/invokeStatic
                 core.cljc:  409  integrant.core$build_exception/invoke
                 core.cljc:  421  integrant.core$try_build_action/invokeStatic
                 core.cljc:  418  integrant.core$try_build_action/invoke
                 core.cljc:  427  integrant.core$build_key/invokeStatic
                 core.cljc:  423  integrant.core$build_key/invoke
                  core.clj: 2656  clojure.core/partial/fn
             protocols.clj:  167  clojure.core.protocols/fn
             protocols.clj:  123  clojure.core.protocols/fn
             protocols.clj:   19  clojure.core.protocols/fn/G
             protocols.clj:   31  clojure.core.protocols/seq-reduce
             protocols.clj:   74  clojure.core.protocols/fn
             protocols.clj:   74  clojure.core.protocols/fn
             protocols.clj:   13  clojure.core.protocols/fn/G
                  core.clj: 6965  clojure.core/reduce
                  core.clj: 6947  clojure.core/reduce
                 core.cljc:  453  integrant.core$build/invokeStatic
                 core.cljc:  430  integrant.core$build/invoke
                 core.cljc:  675  integrant.core$init/invokeStatic
                 core.cljc:  667  integrant.core$init/invoke
                 core.cljc:  672  integrant.core$init/invokeStatic
                 core.cljc:  667  integrant.core$init/invoke
                  repl.clj:   37  integrant.repl/init-system/fn
                  repl.clj:   24  integrant.repl/build-system
                  repl.clj:   22  integrant.repl/build-system
                  repl.clj:   34  integrant.repl/init-system
                  repl.clj:   33  integrant.repl/init-system
                  repl.clj:   54  integrant.repl/init/fn
                  AFn.java:  154  clojure.lang.AFn/applyToHelper
                  AFn.java:  144  clojure.lang.AFn/applyTo
                  Var.java:  310  clojure.lang.Var/alterRoot
                  core.clj: 5563  clojure.core/alter-var-root
                  core.clj: 5558  clojure.core/alter-var-root
               RestFn.java:  428  clojure.lang.RestFn/invoke
                  repl.clj:   52  integrant.repl/init
                  repl.clj:   49  integrant.repl/init
                  repl.clj:   61  integrant.repl/go
                  repl.clj:   57  integrant.repl/go
                  repl.clj:   58  integrant.repl/go
                  repl.clj:   57  integrant.repl/go
                      REPL:   43  user/eval32464
                      REPL:   43  user/eval32464
             Compiler.java: 7700  clojure.lang.Compiler/eval
    interruptible_eval.clj:  106  nrepl.middleware.interruptible-eval/evaluator/run/fn
    interruptible_eval.clj:  101  nrepl.middleware.interruptible-eval/evaluator/run
               session.clj:  230  nrepl.middleware.session/session-exec/session-loop
        SessionThread.java:   21  nrepl.SessionThread/run

1. Caused by java.lang.NoSuchMethodError
   'org.eclipse.jetty.websocket.core.WebSocketComponents
   org.eclipse.jetty.websocket.core.server.WebSocketServerComponents.ensureWebSocketComponents(org.eclipse.jetty.server.Server,
   org.eclipse.jetty.server.handler.ContextHandler)'
JettyWebSocketServletContainerInitializer.java:   88  org.eclipse.jetty.ee9.websocket.server.config.JettyWebSocketServletContainerInitializer/initialize
JettyWebSocketServletContainerInitializer.java:  100  org.eclipse.jetty.ee9.websocket.server.config.JettyWebSocketServletContainerInitializer/onStartup
ServletContainerInitializerHolder.java:  150  org.eclipse.jetty.ee9.servlet.ServletContainerInitializerHolder/doStart
    AbstractLifeCycle.java:   93  org.eclipse.jetty.util.component.AbstractLifeCycle/start
   ContainerLifeCycle.java:  169  org.eclipse.jetty.util.component.ContainerLifeCycle/start
   ContainerLifeCycle.java:  113  org.eclipse.jetty.util.component.ContainerLifeCycle/doStart
ServletContextHandler.java: 1634  org.eclipse.jetty.ee9.servlet.ServletContextHandler$ServletContainerInitializerStarter/doStart
    AbstractLifeCycle.java:   93  org.eclipse.jetty.util.component.AbstractLifeCycle/start
ServletContextHandler.java:  341  org.eclipse.jetty.ee9.servlet.ServletContextHandler/startContext
       ContextHandler.java:  698  org.eclipse.jetty.ee9.nested.ContextHandler/doStartInContext
       ContextHandler.java: 1450  org.eclipse.jetty.server.handler.ContextHandler$ScopedContext/call
       ContextHandler.java:  682  org.eclipse.jetty.ee9.nested.ContextHandler/doStart
ServletContextHandler.java:  278  org.eclipse.jetty.ee9.servlet.ServletContextHandler/doStart
    AbstractLifeCycle.java:   93  org.eclipse.jetty.util.component.AbstractLifeCycle/start
   ContainerLifeCycle.java:  169  org.eclipse.jetty.util.component.ContainerLifeCycle/start
   ContainerLifeCycle.java:  113  org.eclipse.jetty.util.component.ContainerLifeCycle/doStart
              Handler.java:  491  org.eclipse.jetty.server.Handler$Abstract/doStart
       ContextHandler.java:  757  org.eclipse.jetty.server.handler.ContextHandler/lambda$doStart$0
       ContextHandler.java: 1456  org.eclipse.jetty.server.handler.ContextHandler$ScopedContext/call
       ContextHandler.java:  757  org.eclipse.jetty.server.handler.ContextHandler/doStart
       ContextHandler.java: 2750  org.eclipse.jetty.ee9.nested.ContextHandler$CoreContextHandler/doStart
    AbstractLifeCycle.java:   93  org.eclipse.jetty.util.component.AbstractLifeCycle/start
   ContainerLifeCycle.java:  169  org.eclipse.jetty.util.component.ContainerLifeCycle/start
               Server.java:  643  org.eclipse.jetty.server.Server/start
   ContainerLifeCycle.java:  120  org.eclipse.jetty.util.component.ContainerLifeCycle/doStart
              Handler.java:  491  org.eclipse.jetty.server.Handler$Abstract/doStart
               Server.java:  584  org.eclipse.jetty.server.Server/doStart
    AbstractLifeCycle.java:   93  org.eclipse.jetty.util.component.AbstractLifeCycle/start
                 jetty.clj:  352  ring.adapter.jetty/run-jetty
                 jetty.clj:  283  ring.adapter.jetty/run-jetty
                  main.clj:   42  main/eval15702/fn
              MultiFn.java:  234  clojure.lang.MultiFn/invoke
                 core.cljc:  419  integrant.core$try_build_action/invokeStatic
                 core.cljc:  418  integrant.core$try_build_action/invoke
                 core.cljc:  427  integrant.core$build_key/invokeStatic
                 core.cljc:  423  integrant.core$build_key/invoke
                  core.clj: 2656  clojure.core/partial/fn
             protocols.clj:  167  clojure.core.protocols/fn
             protocols.clj:  123  clojure.core.protocols/fn
             protocols.clj:   19  clojure.core.protocols/fn/G
             protocols.clj:   31  clojure.core.protocols/seq-reduce
             protocols.clj:   74  clojure.core.protocols/fn
             protocols.clj:   74  clojure.core.protocols/fn
             protocols.clj:   13  clojure.core.protocols/fn/G
                  core.clj: 6965  clojure.core/reduce
                  core.clj: 6947  clojure.core/reduce
                 core.cljc:  453  integrant.core$build/invokeStatic
                 core.cljc:  430  integrant.core$build/invoke
                 core.cljc:  675  integrant.core$init/invokeStatic
                 core.cljc:  667  integrant.core$init/invoke
                 core.cljc:  672  integrant.core$init/invokeStatic
                 core.cljc:  667  integrant.core$init/invoke
                  repl.clj:   37  integrant.repl/init-system/fn
                  repl.clj:   24  integrant.repl/build-system
                  repl.clj:   22  integrant.repl/build-system
                  repl.clj:   34  integrant.repl/init-system
                  repl.clj:   33  integrant.repl/init-system
                  repl.clj:   54  integrant.repl/init/fn
                  AFn.java:  154  clojure.lang.AFn/applyToHelper
                  AFn.java:  144  clojure.lang.AFn/applyTo
                  Var.java:  310  clojure.lang.Var/alterRoot
                  core.clj: 5563  clojure.core/alter-var-root
                  core.clj: 5558  clojure.core/alter-var-root
               RestFn.java:  428  clojure.lang.RestFn/invoke
                  repl.clj:   52  integrant.repl/init
                  repl.clj:   49  integrant.repl/init
                  repl.clj:   61  integrant.repl/go
                  repl.clj:   57  integrant.repl/go
                  repl.clj:   58  integrant.repl/go
                  repl.clj:   57  integrant.repl/go
                      REPL:   43  user/eval32464
                      REPL:   43  user/eval32464
             Compiler.java: 7700  clojure.lang.Compiler/eval
    interruptible_eval.clj:  106  nrepl.middleware.interruptible-eval/evaluator/run/fn
    interruptible_eval.clj:  101  nrepl.middleware.interruptible-eval/evaluator/run
               session.clj:  230  nrepl.middleware.session/session-exec/session-loop
        SessionThread.java:   21  nrepl.SessionThread/run
```
