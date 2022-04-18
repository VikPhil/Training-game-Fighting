package config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadFrame implements DefaultValues{

    public static BufferedImage getSprites(String sprite) {
        BufferedImage img = null;
        InputStream is = LoadFrame.class.getResourceAsStream("/" + sprite); // импорт картинки
        try {
                img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
