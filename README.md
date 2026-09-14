# network-port-scanner
A multi-threaded TCP port scanner built in Java, using `ExecutorService` 
for concurrent connection attempts.

## Features
- Scans a custom port range on a given host
- Multi-threaded (100 concurrent threads) for fast scanning
- Simple command-line interface

## How to run
1. Download `NetworkPortScanner.jar` from this repo
2. Run: `java -jar NetworkPortScanner.jar`
3. Enter the host/IP and port range when prompted.

## What I learned
- Java networking with `Socket` and `InetSocketAddress`
- Concurrency with `ExecutorService`
- Thread-safe collections (`CopyOnWriteArrayList`)
- Building and troubleshooting executable JARs

## Tech
Java, `java.net.Socket`, `java.util.concurrent`
