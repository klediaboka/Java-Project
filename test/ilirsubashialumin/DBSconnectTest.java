package ilirsubashialumin;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DBSconnectTest {

    private static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Establish a connection to a test database
        connection = DBSconnect.connect();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testConnection() {
        assertNotNull("Connection should not be null", connection);
        try {
            assertFalse("Connection should not be closed", connection.isClosed());
        } catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDatabase() {
        // Add test cases specific to your database structure or requirements
        try {
            Statement statement = connection.createStatement();
          
            statement.close();
        } catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }
    }
}
