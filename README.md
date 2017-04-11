# Picture Gallery

## Tutorial how to install the project

Installing environment (You need Java 8 to install):

1. Download Tomcat 9 (Core) by [link](http://tomcat.apache.org/download-90.cgi) and unpack it.

2. Download Gradle ver. 3.3 by [link](https://gradle.org/install#manually).

3. Unpack and set path in the environment variable Path to folder */bin*.

4. Download and install PostgreSQL by [link](https://www.postgresql.org/download/windows/).

5. Download and install NodeJS with npm by [link](https://nodejs.org/en/download/).

## Building project

1. Download or clone project from this repository.

2. In the console, go to the folder with the project and run the command `gradle war`.

3. Copy file `PictureGallery.war` from folder /build/libs/ to Tomcat's /webapps/.

## Logging

Logging save to Tomcat `/logs/debug.log`.
