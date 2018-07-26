#!/bin/sh
# Build
mvn clean
mvn install


# Stop Tomcat
$CATALINA_HOME/bin/shutdown.sh

# Remove the old application
rm -rf $CATALINA_HOME/webapps/ExampleWebApp
rm -f $CATALINA_HOME/webapps/ExampleWebApp.war

# Copy artifacts to webapps dir
cp target/ExampleWebApp.war $CATALINA_HOME/webapps
cp -r target/ExampleWebApp $CATALINA_HOME/webapps/ExampleWebApp

# Restart Tomcat
$CATALINA_HOME/bin/startup.sh
