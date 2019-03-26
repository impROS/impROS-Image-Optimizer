package picsmallerv1;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Watermark {

    int topLeftX;
    int topLeftY;

    void addImageWatermark(File watermarkImageFile, File sourceImageFile, File destImageFile) {
        try {
            float logoSaydamlik = Float.parseFloat(picSmaller_anamenu.txtLogoSaydamlik.getText()) / 100;
            System.out.println("Logo Saydamlik : " + logoSaydamlik);
            BufferedImage sourceImage = ImageIO.read(sourceImageFile);
            BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

            //
            Graphics2D g2d = (Graphics2D) sourceImage.getGraphics();
            AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, logoSaydamlik);
            g2d.setComposite(alphaChannel);

            // Logo 
            //"Sağ Alt", "Sağ Üst", "Orta", "Sol Alt", "Sol Üst"
            String strLogoKonum = picSmaller_anamenu.txtLogoKonum.getText();
                     if (strLogoKonum.equalsIgnoreCase("Sağ Üst")) {//ok
                topLeftX = (sourceImage.getWidth())-watermarkImage.getWidth();
                topLeftY = 0;
            } else if (strLogoKonum.equalsIgnoreCase("Orta")) { //ok
                topLeftX = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
                topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
            } else if (strLogoKonum.equalsIgnoreCase("Sağ Alt")) {//ok
                topLeftX = sourceImage.getWidth()- watermarkImage.getWidth();
                topLeftY = sourceImage.getHeight()-watermarkImage.getHeight();
            } else if (strLogoKonum.equalsIgnoreCase("Sol Alt")) {//ok
                topLeftX = 0;
                topLeftY = (sourceImage.getHeight() - watermarkImage.getHeight());
            } else if (strLogoKonum.equalsIgnoreCase("Sol Üst")) {//ok
                topLeftX = 0;
                topLeftY = 0;
            }

            //
            g2d.drawImage(watermarkImage, topLeftX, topLeftY, null);

            ImageIO.write(sourceImage, "png", destImageFile);
            g2d.dispose();

            System.out.println("Watermark Resime Eklendi");

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
