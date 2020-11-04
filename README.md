# EE Mars Rover Kata

## Problem Description

You are part of the team that explores Mars by sending remotely controlled vehicles to the surface of
the planet. Develop an API that translates the commands sent from earth to instructions that are
understood by the rover.
When the rover touches down on Mars, it is initialised with its current coordinates, and the direction
it is facing. These could be any coordinates, supplied as arguments `(x, y, direction)` e.g. `(4,
2, EAST)`.

## Requirements

- JVM version 11

## How To Use

Use the included Gradle wrapper scripts (`gradlew` on MacOS and Linux or `gradlew.bat` on Windows) to 
build and run tests.

If you like to see an example run, you can use the `run` target. On MacOS / Linux this can be easily 
executed like this:
```
./gradlew run
``` 

## Used Tooling

- IntelliJ (no necessary to run the project)
- Gradle
- Kotlin
- JUnit 5
- Strikt (for assertions)
- Mockk (mocking framework)

## Limitations

- The coordinates are currently hard coded to the range [-10, 10]
- The `RoverController` understands the command `F` only. This means, the rover can only move towards the direction it 
is currently headed.
- There is no direct interaction available to send commands via command line yet. This is why the `run` target 
randomly initiates the rover at a valid position and moves it a random number of times.
- Logging is not available yet due to time limitations
- There is no explicit range check yet

## Possible next steps

- Implement turns
- Make the controller listen to a network port for commands