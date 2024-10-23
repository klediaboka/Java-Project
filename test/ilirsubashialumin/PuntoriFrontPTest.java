/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilirsubashialumin;
import ilirsubashialumin.PuntoriFrontP;
import java.lang.reflect.Field;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import org.junit.Test;
import static org.junit.Assert.*;

public class PuntoriFrontPTest {

    @Test
    public void testJLabel7MouseClicked() {
        PuntoriFrontP puntoriFrontP = new PuntoriFrontP(); // Instantiate the main class
        puntoriFrontP.setVisible(true); // Make the GUI visible

        try {
            // Access the private field jLabel7
            Field jLabel7Field = PuntoriFrontP.class.getDeclaredField("jLabel7");
            jLabel7Field.setAccessible(true); // Make the field accessible
            JLabel jLabel7 = (JLabel) jLabel7Field.get(puntoriFrontP); // Get the value of the field

            // Simulate a mouse click on jLabel7
            jLabel7.dispatchEvent(new MouseEvent(
                    jLabel7, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(),
                    0, 0, 0, 1, false));

            // Ensure that LogPun frame is visible and the current frame is not visible after the click
            assertFalse(puntoriFrontP.isVisible());
            assertTrue(puntoriFrontP.getFrames().length > 0); // Assuming LogPun is instantiated and shown
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
