# Googlon Test

This is a text analizer for the googlon language.

## Requirements

* JVM 8+

This project is written, and tested on JVM 8 cant guarantee working if
you are using any version older than that one.

* Internet connection

You will need internet conection to build the project since Gradle
will download JUnit dependencies 

## How to build

In the Java world it is common to include the buiding tool inside the code repository.
This is to facilitate development and also ensure about tool version.

In this project I am using Gradle which is included through Graddle Wrapper feature.

So please just do:

`./gradlew build test`

This will allow you to trigger the run and the tests.

## How to run

After building the project you'll find a JAR fine under './build/libs'
You just need to do:

`java -jar ./build/libs/googlon-1.0-SNAPSHOT.jar` [FILENAME]

*FILENAME is the file containing the Googlon text you want to
execute.