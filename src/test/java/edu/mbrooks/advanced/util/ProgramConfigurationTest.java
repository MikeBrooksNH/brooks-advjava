package edu.mbrooks.advanced.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramConfigurationTest {


    private String ServerAddress="192.168.1.136";
    private String ServerPort="8081";
    private String ThreadCount="5";
    private String DBUser="monty";
    private String DBPass="some_password";
    private String ConnectionString="jdbc:mysql://192.168.1.145:3306/stocks";

    private String propfile = "server.properties";

    private ProgramConfiguration propgetter = new ProgramConfiguration();

    @Before
    public void load() {

        propgetter.load(propfile);
    }

    @Test
    public void getServerAddr() {
        assertEquals("ServerAddress  matches", ServerAddress, propgetter.getServerAddr());
    }

    @Test
    public void getServerPort() {
        assertEquals("ServerPort  matches", ServerPort, propgetter.getServerPort());
    }

    @Test
    public void getThreadCnt() {
        assertEquals("ThreadCount  matches", ThreadCount, propgetter.getThreadCnt());
    }

    @Test
    public void getDBPass() {
        assertEquals("DBUser  matches", DBUser, propgetter.getDBUser());
    }

    @Test
    public void getDBUser() {
        assertEquals("DBPass  matches", DBPass, propgetter.getDBPass());
    }

    @Test
    public void getConnectionString() {
        assertEquals("ConnectionString  matches", ConnectionString, propgetter.getConnectionString());
    }
}

