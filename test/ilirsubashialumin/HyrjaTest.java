/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;


import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class HyrjaTest {

    @Test
    public void testAdminButton() {
        Hyrja hyrja = new Hyrja();
        hyrja.setVisible(true);
        
        try {
            // Use reflection to access the private jButton1ActionPerformed method
            Method jButton1ActionPerformedMethod = Hyrja.class.getDeclaredMethod("jButton1ActionPerformed", java.awt.event.ActionEvent.class);
            jButton1ActionPerformedMethod.setAccessible(true);
            
            // Simulate clicking the "Admin" button
            jButton1ActionPerformedMethod.invoke(hyrja, new java.awt.event.ActionEvent(hyrja, java.awt.event.ActionEvent.ACTION_PERFORMED, ""));
            
            // Check if the Login window is opened and Hyrja window is closed
            assertFalse(hyrja.isVisible()); // Hyrja window should be closed
            assertTrue(isLoginWindowOpened()); // Login window should be opened
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
    
    private boolean isLoginWindowOpened() {
        // Check if the Login window is opened
        for (java.awt.Window window : java.awt.Window.getWindows()) {
            if (window instanceof Login) {
                return window.isVisible();
            }
        }
        return false;
    }
}
