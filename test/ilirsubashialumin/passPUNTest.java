/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JTextField;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class passPUNTest {

    private static Connection connection;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Establish a connection to a test database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/projekti punes", "root", "");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testUpdatePassword() throws Exception {
        passPUN instance = new passPUN();

        // Mocking necessary components for the test
        JTextField jTextField1 = new JTextField("testusername");
        JTextField jTextField2 = new JTextField("newpassword");
        JTextField jTextField3 = new JTextField("testquestion");

        // Use reflection to set private fields
        Field field1 = passPUN.class.getDeclaredField("jTextField1");
        field1.setAccessible(true);
        field1.set(instance, jTextField1);

        Field field2 = passPUN.class.getDeclaredField("jTextField2");
        field2.setAccessible(true);
        field2.set(instance, jTextField2);

        Field field3 = passPUN.class.getDeclaredField("jTextField3");
        field3.setAccessible(true);
        field3.set(instance, jTextField3);

        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

        // Use reflection to call the private method
        Method method = passPUN.class.getDeclaredMethod("jButton2ActionPerformed", ActionEvent.class);
        method.setAccessible(true);
        method.invoke(instance, evt);

        // Verify if the password is updated in the test database
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM punetori WHERE Email = 'testusername' AND Pytja = 'testquestion'");
        if (resultSet.next()) {
            String password = resultSet.getString("Password");
            assertEquals("newpassword", password);
        } else {
            fail("Failed to retrieve the updated password from the database");
        }
    }
}
