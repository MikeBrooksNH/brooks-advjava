#!/bin/sh

echo
echo Executing Clean...
echo

mvn clean install
if [ $? == 0 ]; then
    echo
    echo Executing deploying to Tomcat...
    echo
    #cp target/ExampleWebApp.war /usr/local/Cellar/tomcat/9.0.6/libexec/webapps
    echo
    echo         Undeploy old war file
    echo
    /usr/local/bin/wget wget http://tomcat:tomcat@192.168.1.137:8081/manager/text/undeploy?path=/ExampleWebApp
    echo
    echo         Deploy new war file
    echo
    /usr/local/bin/wget wget http://tomcat:tomcat@192.168.1.137:8081/manager/text/deploy?path=/ExampleWebApp&war=file:/target/ExampleWebApp.war
    if [ $? == 0 ]; then
        echo
        echo New war has been deployed...
        echo
    else
        echo
        echo install target failed...
        echo
    fi
else
    echo
    echo clean / install target failed...
    echo
fi

mvn javadoc:javadoc
if [ $? != 0 ]; then
    echo
    echo javadoc failed to generate
    echo
fi

