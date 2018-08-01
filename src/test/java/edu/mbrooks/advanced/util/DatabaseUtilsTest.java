package edu.mbrooks.advanced.util;

import edu.mbrooks.advanced.util.DatabaseConnectionException;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {

    private String propfile = "server.properties";
    private String DBURL;
    private String DBUSER;
    private String DBPASS;

    private ProgramConfiguration propgetter = new ProgramConfiguration();

    @Before
    public void load() {
        propgetter.load(propfile);

        DBUSER = propgetter.getDBUser();
        DBPASS = propgetter.getDBPass();
        DBURL = propgetter.getConnectionString();
    }
    

    /* @Test
    public void testGetConnectionNoParams() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection ok no properties",connection);
    }
 */
    @Test
    public void testGetConnectionWithParams() throws Exception{
        Connection connection = DatabaseUtils.getConnection(DBURL, DBUSER, DBPASS);
        assertNotNull("verify that we can get a connection ok with properties",connection);
    }

    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = DatabaseUtils.getConnection(DBURL, DBUSER, DBPASS);
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from quotes");
        assertTrue("verify that we can execute a statement",execute);
    }

    @Test
    public void getHibernateConnection() throws Exception {
        int exitStatus = 0;
            Connection connection = DatabaseUtils.getHibernateConnection();
            Statement statement = connection.createStatement();
            boolean execute = statement.execute("select * from person");
            assertTrue("verify that we can execute a statement", execute);

    }
}
