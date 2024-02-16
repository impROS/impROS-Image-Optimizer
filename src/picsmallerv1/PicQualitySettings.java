package picsmallerv1;

import com.idrsolutions.image.png.PngCompressor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import static picsmallerv1.picSmaller_anamenu.basladiMi;

public class PicQualitySettings implements Runnable {

    boolean isAkilliKucult = false;
    boolean isWatermarkEkle = false;
    int yuzdelik = 1;
    float kalite = 0.5f;
    int sayacBasarili = 0, sayacBasarisiz = 0;
    static boolean isNull = false;

    public PicQualitySettings(boolean isAkilliKucult, boolean isWatermarkEkle) {
        this.isAkilliKucult = isAkilliKucult;
        this.isWatermarkEkle = isWatermarkEkle;
    }

    @Override
    public void run() {
        Watermark addWatermarkClass = new Watermark();

        kalite = (Float.parseFloat(picSmaller_anamenu.txtResimKalite.getText())) / 100;
        System.out.println("Kalite : " + kalite);
        String strKaydedilecekDizin = picSmaller_anamenu.txtKaydetDizin.getText();
        ImageWriter writer = null;
        ImageOutputStream ios = null;
        File compressedImageFile;
        File addedWatermark;

        yuzdelik = 0;
        sayacBasarili = 0;
        sayacBasarisiz = 0;
        int toplam = 0;
        long start = System.currentTimeMillis();
        for (File resim : picSmaller_anamenu.arrResimler) {
            picSmaller_anamenu.lblGecenSure.setText("Resim : " + resim.getName());
            // compressedImageFile = new File(strKaydedilecekDizin + "\\" + resim.getName());//kaydedilecekDizin
            compressedImageFile = new File(strKaydedilecekDizin + File.separator + resim.getName());//kaydedilecekDizin

            try {
                System.out.println("1");

                BufferedImage image;
                String strResimUzanti = resim.getName().substring(resim.getName().length() - 3, resim.getName().length());
                strResimUzanti = strResimUzanti.toLowerCase();
                System.out.println("Resim Sonu :" + strResimUzanti);
                addedWatermark = resim;
                if (isWatermarkEkle) {
                    File watermarkFile = new File(picSmaller_anamenu.txtWatermarkDizin.getText());//logo
                    addWatermarkClass.addImageWatermark(watermarkFile, resim, compressedImageFile);
                    addedWatermark = compressedImageFile;

                }
                if (strResimUzanti.equalsIgnoreCase("png")) {

                    //  PngCompressor.compress(resim, resim);
                    PngCompressor.compress(addedWatermark, compressedImageFile);
                    sayacBasarili++;
                } else if (strResimUzanti.equalsIgnoreCase("jpg") || strResimUzanti.equalsIgnoreCase("peg")) {

                    try {
                        image = ImageIO.read(_toJPG(addedWatermark, compressedImageFile));
                        OutputStream os = new FileOutputStream(compressedImageFile);
                        //image = ImageIO.read((addedWatermark));
                        if (!isNull) {
                            Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
                            writer = (ImageWriter) writers.next();
                            ios = ImageIO.createImageOutputStream(os);
                            writer.setOutput(ios);
                            ImageWriteParam param = writer.getDefaultWriteParam();
                            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                            param.setCompressionQuality(kalite);

                            writer.write(null, new IIOImage(image, null, null), param);
                            ios.close();

                            writer.dispose();
                        } else {

                            //System.out.println("*******************************NULL****************************");
                        }

                    } catch (Exception ex) {

                    } finally {
                        sayacBasarili++;
                        try {
                            ios.close();

                        } catch (Exception e) {
                        }

                    }

                }

            } catch (IOException ex) {
                System.err.println("Hata || " + ex.getMessage());

            } catch (Exception ex) {
                picSmaller_anamenu.lblDurum.setText("Hata :" + ex.getMessage());
            } finally {
                try {
                    writer.dispose();
                } catch (Exception ex) {
                    // picSmaller_anamenu.lblDurum.setText("Hata Final:" + ex.getMessage());
                }
                toplam++;
                sayacBasarisiz=toplam-sayacBasarili;
                yuzdelik = (sayacBasarili + sayacBasarisiz) * 100 / picSmaller_anamenu.arrResimler.size();
                progressBarGuncelle(yuzdelik);
            }

            if (picSmaller_anamenu.basladiMi == false) {
                break;
            }

        }
        long stop = System.currentTimeMillis();
        long duration = stop - start;
        long saniye = TimeUnit.MILLISECONDS.toSeconds(duration) % 3600;
        long dakika = TimeUnit.MILLISECONDS.toMinutes(duration) % 60;
        long saat = TimeUnit.MILLISECONDS.toHours(duration);
        picSmaller_anamenu.lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnPasif.png")));
        basladiMi = false;
        System.out.println("Geçen Sure :: " + saniye + " Saniye, " + dakika + " Dakika, " + saat + " Saat.");

        picSmaller_anamenu.lblGecenSure.setText("Geçen Sure : " + saniye + " Saniye, " + dakika + " Dakika, " + saat + " Saat.");
        picSmaller_anamenu.lblDurum.setText("İşlem Tamamlandı." + sayacBasarili + " Başarılı , " + sayacBasarisiz + " Başarısız");
        picSmaller_anamenu.lblProgressbar.setIcon(null);
    }

    public File _toJPG(File pngResim, File hedef) {

        BufferedImage bufferGambar;
        try {

            bufferGambar = ImageIO.read(pngResim);

            BufferedImage newBufferGambar = new BufferedImage(bufferGambar.getWidth(), bufferGambar.getHeight(), BufferedImage.TYPE_INT_RGB);

            newBufferGambar.createGraphics().drawImage(bufferGambar, 0, 0, Color.white, null);
            ImageIO.write(newBufferGambar, "jpg", hedef);
           // sayacBasarili++;
        } catch (Exception e) {
            picSmaller_anamenu.lblDurum.setText("Hata : " + e.getMessage() + " : " + pngResim.getAbsoluteFile());
            picSmaller_anamenu.lblDurum.setToolTipText(pngResim.getAbsoluteFile() + "");
            System.out.println("Hata Tojpg: " + e.getMessage() + pngResim.getAbsoluteFile());
            //sayacBasarisiz++;

            isNull = true;
            return pngResim;
        }
        isNull = false;
        return hedef;

    }

    public void progressBarGuncelle(int yuzdelik) {
        picSmaller_anamenu.txtProgressValue.setText("%" + yuzdelik);
    }

    public void copyFile(File from, File to) throws IOException {

        if (to.exists() && to.length() == from.length()) {
            System.out.println("Dosya Zaten Var");
        } else {
            Files.copy(from.toPath(), to.toPath());
            System.out.println("basarili");
        }
    }

}
