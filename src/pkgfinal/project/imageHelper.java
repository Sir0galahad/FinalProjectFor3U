/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author millc9988
 */
public class imageHelper {

    public static BufferedImage LoadImage(String name) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return img;
    }
}
