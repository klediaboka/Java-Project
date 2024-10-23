/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
public class EkoFrontPrTest {
    
    private static Connection connection;
    
     @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Create a connection to an in-memory database for testing
        connection = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS shitje (ibillno INT, iID VARCHAR(50), iEmri VARCHAR(50), iSasia DOUBLE, iCmimi DOUBLE, iNentotali DOUBLE)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS materialet (idProdukti VARCHAR(50), Sasia DOUBLE)");
        statement.close();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testJButton5ActionPerformed() throws Exception {
        EkoFrontPr instance = new EkoFrontPr(); // replace YourClass with the actual name of your class

        // Mocking necessary components for the test
        JTextField jTextField7 = new JTextField("123");
        JTextField jTextField8 = new JTextField("TestProduct");
        JTextField jTextField9 = new JTextField("2.5");
        JTextField jTextField10 = new JTextField("10.5");
        JTextField jTextField11 = new JTextField();
        JTextField jTextField6 = new JTextField("1");

        // Use reflection to set private fields
        Field field7 = EkoFrontPr.class.getDeclaredField("jTextField7");
        field7.setAccessible(true);
        field7.set(instance, jTextField7);

        Field field8 = EkoFrontPr.class.getDeclaredField("jTextField8");
        field8.setAccessible(true);
        field8.set(instance, jTextField8);

        Field field9 = EkoFrontPr.class.getDeclaredField("jTextField9");
        field9.setAccessible(true);
        field9.set(instance, jTextField9);

        Field field10 = EkoFrontPr.class.getDeclaredField("jTextField10");
        field10.setAccessible(true);
        field10.set(instance, jTextField10);

        Field field11 = EkoFrontPr.class.getDeclaredField("jTextField11");
        field11.setAccessible(true);
        field11.set(instance, jTextField11);

        Field field6 = EkoFrontPr.class.getDeclaredField("jTextField6");
        field6.setAccessible(true);
        field6.set(instance, jTextField6);

        ActionEvent evt = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

        // Use reflection to call the private method
        Method method = EkoFrontPr.class.getDeclaredMethod("jButton5ActionPerformed", ActionEvent.class);
        method.setAccessible(true);
        method.invoke(instance, evt);

        // Add assertions to verify the behavior or outcomes of the method
        assertEquals("26.25", jTextField11.getText()); // Assuming the calculation is correct
        // Add more assertions if necessary
    }
}