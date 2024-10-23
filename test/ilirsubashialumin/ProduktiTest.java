/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

public class ProduktiTest {

    @Test
    public void testInsertProduct() {
        Produkti produktiFrame = new Produkti();
        
        // Set some sample data for testing
        produktiFrame.jTextField1.setText("Product Name");
        produktiFrame.jTextField4.setText("Type");
        produktiFrame.jTextField2.setText("10");
        produktiFrame.jTextField3.setText("50.00");
        produktiFrame.jTextField5.setText("1");

        try {
            // Use reflection to access the private method
            Method method = Produkti.class.getDeclaredMethod("jButton1ActionPerformed", java.awt.event.ActionEvent.class);
            method.setAccessible(true);
            method.invoke(produktiFrame, (java.awt.event.ActionEvent) null);
            
   
            
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}
