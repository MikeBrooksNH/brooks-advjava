package edu.mbrooks.advanced.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * A Utility class that provides application properties and
 * configuration settings.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michael.brooks
 */
public class ProgramConfiguration {

    private String serverAddr;
    private String serverPort;
    private String threadCnt;
    private String ConnectionString;
    private String DBUser;
    private String DBPass;
    private String Version;


    /**
     * This could be embelished to throw a FileNotFound Exception at the very least (probably can't open, etc as well)
     * @param propertiesFile the location of the properties file
     */
    public void load(String propertiesFile) {
        Properties properties = new Properties();
        InputStream inStream = null;

        // First try loading from the current directory
        try {
            File file = new File(propertiesFile);
            inStream = new FileInputStream(file);
        } catch (Exception e) {
            inStream = null;
        }

        try {
            if ( inStream == null ) {
                // Try loading from classpath
                inStream = getClass().getResourceAsStream(propertiesFile);
            }

            // Try loading properties from the file (if found)
            properties.load(inStream );
            System.out.println("loaded properties");
            for (String s : properties.stringPropertyNames()) {
                if (s.compareToIgnoreCase("ServerAddress") == 0) {
                    this.serverAddr = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("ServerPort") == 0) {
                    serverPort = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("ThreadCount") == 0) {
                    threadCnt = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("ConnectionString") == 0) {
                    ConnectionString = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("DBUser") == 0) {
                    DBUser = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("DBPass") == 0) {
                    // Really need to consider having an encrypted password in the properties file
                    // https://stackoverflow.com/questions/1132567/encrypt-password-in-configuration-files
                    // https://dzone.com/articles/storing-passwords-java-web
                    DBPass = properties.getProperty(s);
                } else if (s.compareToIgnoreCase("Version") == 0) {
                    Version = properties.getProperty(s);
                }
            }
        } catch ( Exception e ) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    /**
     * Server address property getter
     * @return serverAddr Server address (not used in this program)
     */
    public String getServerAddr() {
        return serverAddr;
    }

    /**
     * Server port property getter
     * @return serverPort port that the server is supposed to be running on
     */
    public String getServerPort() {
        return serverPort;
    }

    /**
     * Max number of threds to use
     * @return threadCnt the max thread count to use
     */
    public String getThreadCnt() {
        return threadCnt;
    }

    /**
     * DB Password getter
     * @return DBPass password for the user connecting to the DB
     */
    public String getDBPass() {
        return DBPass;
    }

    /**
     * DB Username getter
     * @return DBUser username to connect to the DB as
     */
    public String getDBUser() {
        return DBUser;
    }

    /**
     * Connection string getter
     * @return ConnectionString is the jdbc connection string for connecting to the DB
     */
    public String getConnectionString() {
        return ConnectionString;
    }
    public String getVersion() {
        return Version;
    }
}
