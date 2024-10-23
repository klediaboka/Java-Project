/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.lang.reflect.Method;


import java.lang.reflect.Method;

public class passEKOTest {

    @Test
    public void testButton2ActionPerformed() throws Exception {
        passEKO passEKOInstance = new passEKO();
        Method method = passEKO.class.getDeclaredMethod("jButton2ActionPerformed", ActionEvent.class);
        method.setAccessible(true); // Allow access to private method
        JButton button = new JButton();
        ActionEvent event = new ActionEvent(button, ActionEvent.ACTION_PERFORMED, "Update");
        method.invoke(passEKOInstance, event);
        // Add assertions or checks here based on the behavior you want to test
    }
}

