#!/bin/sh

echo .
echo Executing Clean...
echo .

mvn clean
if [ $? == 0 ]; then
    echo .
    echo Executing install...
    echo .
    mvn install
    if [ $? == 0 ]; then
        if [ -f target/ExampleWebApp.war ]; then
            echo .
            echo Executing deploy...
            echo .
            cp target/ExampleWebApp.war /usr/local/Cellar/tomcat/9.0.6/libexec/webapps
            /usr/local/bin/wget "http://tomcat:tomcat@localhost:8081/manager/reload?path=/ExampleWebApp" -O - -q
        fi
    else
        echo .
        echo install target failed...
        echo .
    fi
else
    echo .
    echo clean target failed...
    echo .
fi

mvn javadoc:javadoc
if [ $? != 0 ]; then
    echo .
    echo javadoc failed to generate
    echo .
fi

