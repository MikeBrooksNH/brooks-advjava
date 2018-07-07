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

    @Test
    public void testGetConnection() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection ok",connection);
    }

    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
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
