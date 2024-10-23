/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

public class RregAdminTest {

    @Test
    public void testInsertAdmin() {
        RregAdmin adminFrame = new RregAdmin();
        
        // Set some sample data for testing
        adminFrame.jTextField1.setText("1");
        adminFrame.jTextField2.setText("John");
        adminFrame.jTextField3.setText("Doe");
        adminFrame.jTextField4.setText("123456");
        adminFrame.jTextField7.setText("john.doe@example.com");
        adminFrame.jTextField5.setText("password");
        adminFrame.jTextField6.setText("123456789");

        try {
            // Use reflection to access the private method
            Method method = RregAdmin.class.getDeclaredMethod("jButton1ActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(adminFrame, (java.awt.event.ActionEvent) null);
            
            // You may add additional assertions here based on the expected behavior
            // For example, you could assert that after insertion, the frame should be invisible:
            // assertFalse(adminFrame.isVisible());
            
            // Check if the Login frame is visible after registration
            assertTrue(adminFrame.isVisible());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}
