package picsmallerv1;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author x.impROS.x
 */
public class picSmaller_anamenu extends javax.swing.JFrame {

    public static ArrayList<File> arrResimler = new ArrayList<>();
    JFileChooser dosyaSecici = new JFileChooser();

    Date zaman = new Date();
    int baslangicZaman = 0, bitisZaman = 0, gecenSure = 0;
    int baslangicSaat = 0, baslangicDakika = 0, baslangicSaniye = 0;

    public picSmaller_anamenu() {
        
        initComponents();
        txtLogoSaydamlik.setBackground(new Color(0, 0, 0, 0));
        txtProgressValue.setBackground(new Color(0, 0, 0, 0));
        txtDizin.setBackground(new Color(0, 0, 0, 0));
        txtLogoKonum.setBackground(new Color(0, 0, 0, 0));
        txtKaydetDizin.setBackground(new Color(0, 0, 0, 0));
        txtWatermarkDizin.setBackground(new Color(0, 0, 0, 0));
        txtResimSayisi.setBackground(new Color(0, 0, 0, 0));
        dosyaSecici.setDialogTitle("Resim Klasörü Secin");
        dosyaSecici.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dosyaSecici.setAcceptAllFileFilterUsed(false);
        dosyaSecici.addChoosableFileFilter(new FileNameExtensionFilter("JPG || PNG ", "jpg", "jpeg", "png"));
        dosyaSecici.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg", "jpeg"));
        dosyaSecici.addChoosableFileFilter(new FileNameExtensionFilter("PNG", "png"));
        lblInfo.setVisible(false);
        lblInfoKapat.setVisible(false);
        Hardware4Win pcID = new Hardware4Win();
        String strB = null, timeStamp = null;
        iniIslem veritabani = new iniIslem("settings.ini");
        try {
            timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
            strB = (veritabani.oku("B").isEmpty()) ? "null" : "false";

        } catch (Exception e) {
            yaziPost(pcID.getSerialNumber() + " " + timeStamp);
            veritabani.yaz("B", "true");

        }
        uptadePro();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resimler/icon.png")));
    }

    private void uptadePro() {
        try {
            String strAy = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
            if (strAy.equals("09") || strAy.equals("18") || strAy.equals("27")) {
                float guncelVersiyon = 0;

                guncelVersiyon = Float.parseFloat(urlOku("http://improsyazilim.com/ResimKucultmePro/guncelleme.txt"));

                if (VersiyonNo < guncelVersiyon) {
                    int dialogButtonCevap = 0 ;
                   int dialogResult = JOptionPane.showConfirmDialog(null, "Bu Programın Yeni Versiyonu Var.Güncellemek İster Misiniz ?", "Güncelleme",dialogButtonCevap);

                    if (dialogResult == JOptionPane.YES_OPTION) { 
                        openWebpage("http://improsyazilim.com/");
                    }

                } else {
                    System.out.println("Guncellenmeyecek:" + strAy);
                }
            }
            }catch (IOException ex) {

        }
        }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInfoKapat = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        txtResimSayisi = new javax.swing.JTextField();
        lblKapatAkilli = new javax.swing.JLabel();
        lblHakkinda = new javax.swing.JLabel();
        lblBagisYap = new javax.swing.JLabel();
        lblGuncelle = new javax.swing.JLabel();
        lblYeniMenu = new javax.swing.JLabel();
        lblLogoDegis = new javax.swing.JLabel();
        lblLogoDegisEksi = new javax.swing.JLabel();
        lblLogoDegisArti = new javax.swing.JLabel();
        txtWatermarkDizin = new javax.swing.JTextField();
        lblWatermarkSec = new javax.swing.JLabel();
        lblGecenSure = new javax.swing.JLabel();
        lblDurum = new javax.swing.JLabel();
        txtKaydetDizin = new javax.swing.JTextField();
        lblKlasorSec = new javax.swing.JLabel();
        lblKaliteArtir = new javax.swing.JLabel();
        lblKaliteAzalt = new javax.swing.JLabel();
        lblKalite = new javax.swing.JLabel();
        lblUstArtir = new javax.swing.JLabel();
        lblAltAzalt = new javax.swing.JLabel();
        lblAkilliKucult = new javax.swing.JLabel();
        lblBasla = new javax.swing.JLabel();
        lblSaydamlikDegis = new javax.swing.JLabel();
        lblLogoEkle = new javax.swing.JLabel();
        lblProgressbar = new javax.swing.JLabel();
        txtDizin = new javax.swing.JTextField();
        txtProgressValue = new javax.swing.JTextField();
        txtLogoSaydamlik = new javax.swing.JTextField();
        txtLogoKonum = new javax.swing.JTextField();
        lblResimSec = new javax.swing.JLabel();
        txtResimKalite = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        lblArkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInfoKapat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInfoKapat.setForeground(new java.awt.Color(255, 255, 255));
        lblInfoKapat.setText("X");
        lblInfoKapat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInfoKapatMouseClicked(evt);
            }
        });
        getContentPane().add(lblInfoKapat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/info.png"))); // NOI18N
        lblInfo.setText("jLabel2");
        lblInfo.setVisible(false);
        getContentPane().add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 420, 400));

        txtResimSayisi.setEditable(false);
        txtResimSayisi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtResimSayisi.setText("0");
        txtResimSayisi.setBorder(null);
        txtResimSayisi.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtResimSayisi.setEnabled(false);
        txtResimSayisi.setOpaque(false);
        getContentPane().add(txtResimSayisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 173, 30, -1));

        lblKapatAkilli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/ek.png"))); // NOI18N
        lblKapatAkilli.setPreferredSize(new java.awt.Dimension(430, 65));
        getContentPane().add(lblKapatAkilli, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 217, 360, 20));

        lblHakkinda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHakkindaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHakkindaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHakkindaMouseExited(evt);
            }
        });
        getContentPane().add(lblHakkinda, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 100, 20));

        lblBagisYap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBagisYapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBagisYapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBagisYapMouseExited(evt);
            }
        });
        getContentPane().add(lblBagisYap, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 100, 20));

        lblGuncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuncelleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGuncelleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGuncelleMouseExited(evt);
            }
        });
        getContentPane().add(lblGuncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, 20));

        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuSade.png"))); // NOI18N
        lblYeniMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYeniMenuMouseClicked(evt);
            }
        });
        getContentPane().add(lblYeniMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 77, 390, 30));

        lblLogoDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sayacSade.png"))); // NOI18N
        lblLogoDegis.setText("jLabel1");
        getContentPane().add(lblLogoDegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 357, 30, 30));

        lblLogoDegisEksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoDegisEksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoDegisEksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoDegisEksiMouseExited(evt);
            }
        });
        getContentPane().add(lblLogoDegisEksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 375, 26, 12));

        lblLogoDegisArti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoDegisArtiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoDegisArtiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoDegisArtiMouseExited(evt);
            }
        });
        getContentPane().add(lblLogoDegisArti, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 26, 12));

        txtWatermarkDizin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtWatermarkDizin.setForeground(new java.awt.Color(255, 255, 255));
        txtWatermarkDizin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWatermarkDizin.setText("Logo Seçilmedi");
        txtWatermarkDizin.setAutoscrolls(false);
        txtWatermarkDizin.setBorder(null);
        txtWatermarkDizin.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        txtWatermarkDizin.setEnabled(false);
        txtWatermarkDizin.setOpaque(false);
        txtWatermarkDizin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWatermarkDizinActionPerformed(evt);
            }
        });
        getContentPane().add(txtWatermarkDizin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 310, 20));

        lblWatermarkSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png"))); // NOI18N
        lblWatermarkSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWatermarkSecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblWatermarkSecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblWatermarkSecMouseExited(evt);
            }
        });
        getContentPane().add(lblWatermarkSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 420, -1));

        lblGecenSure.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblGecenSure.setForeground(new java.awt.Color(255, 255, 255));
        lblGecenSure.setText("Hazır");
        getContentPane().add(lblGecenSure, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 457, 250, 20));

        lblDurum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDurum.setForeground(new java.awt.Color(255, 255, 255));
        lblDurum.setText("Hazır");
        getContentPane().add(lblDurum, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 475, 250, -1));

        txtKaydetDizin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtKaydetDizin.setForeground(new java.awt.Color(255, 255, 255));
        txtKaydetDizin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKaydetDizin.setText("Kaydedilecek Dizin Seçilmedi");
        txtKaydetDizin.setAutoscrolls(false);
        txtKaydetDizin.setBorder(null);
        txtKaydetDizin.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        txtKaydetDizin.setEnabled(false);
        txtKaydetDizin.setOpaque(false);
        txtKaydetDizin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKaydetDizinActionPerformed(evt);
            }
        });
        getContentPane().add(txtKaydetDizin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 425, 310, 20));

        lblKlasorSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png"))); // NOI18N
        lblKlasorSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKlasorSecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKlasorSecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKlasorSecMouseExited(evt);
            }
        });
        getContentPane().add(lblKlasorSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 418, 420, -1));

        lblKaliteArtir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKaliteArtirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKaliteArtirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKaliteArtirMouseExited(evt);
            }
        });
        getContentPane().add(lblKaliteArtir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 20, 10));

        lblKaliteAzalt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKaliteAzaltMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKaliteAzaltMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKaliteAzaltMouseExited(evt);
            }
        });
        getContentPane().add(lblKaliteAzalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 20, 10));

        lblKalite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnAzalt_1.png"))); // NOI18N
        getContentPane().add(lblKalite, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 184, -1, -1));

        lblUstArtir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUstArtirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblUstArtirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblUstArtirMouseExited(evt);
            }
        });
        getContentPane().add(lblUstArtir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 20, 20));

        lblAltAzalt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAltAzaltMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAltAzaltMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAltAzaltMouseExited(evt);
            }
        });
        getContentPane().add(lblAltAzalt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 20, 10));

        lblAkilliKucult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkPasif.png"))); // NOI18N
        lblAkilliKucult.setText("-");
        lblAkilliKucult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAkilliKucultMouseClicked(evt);
            }
        });
        getContentPane().add(lblAkilliKucult, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 217, 20, -1));

        lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnPasif.png"))); // NOI18N
        lblBasla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBaslaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBaslaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBaslaMouseExited(evt);
            }
        });
        getContentPane().add(lblBasla, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 463, 90, 50));

        lblSaydamlikDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnNormal.png"))); // NOI18N
        getContentPane().add(lblSaydamlikDegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 324, 30, 30));

        lblLogoEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkPasif.png"))); // NOI18N
        lblLogoEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoEkleMouseClicked(evt);
            }
        });
        getContentPane().add(lblLogoEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 245, 20, -1));

        lblProgressbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/progress_Wait.png"))); // NOI18N
        getContentPane().add(lblProgressbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 479, 310, 40));

        txtDizin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDizin.setForeground(new java.awt.Color(255, 255, 255));
        txtDizin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDizin.setText("Seçili Resim veya Klasör Yok");
        txtDizin.setAutoscrolls(false);
        txtDizin.setBorder(null);
        txtDizin.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        txtDizin.setEnabled(false);
        txtDizin.setOpaque(false);
        txtDizin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDizinActionPerformed(evt);
            }
        });
        getContentPane().add(txtDizin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 310, 20));

        txtProgressValue.setEditable(false);
        txtProgressValue.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        txtProgressValue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProgressValue.setText("%0");
        txtProgressValue.setBorder(null);
        txtProgressValue.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        txtProgressValue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtProgressValue.setEnabled(false);
        txtProgressValue.setOpaque(false);
        getContentPane().add(txtProgressValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 460, 30, 20));

        txtLogoSaydamlik.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLogoSaydamlik.setForeground(new java.awt.Color(255, 255, 255));
        txtLogoSaydamlik.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLogoSaydamlik.setText("50");
        txtLogoSaydamlik.setAutoscrolls(false);
        txtLogoSaydamlik.setBorder(null);
        txtLogoSaydamlik.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        txtLogoSaydamlik.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtLogoSaydamlik.setEnabled(false);
        txtLogoSaydamlik.setOpaque(false);
        txtLogoSaydamlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLogoSaydamlikActionPerformed(evt);
            }
        });
        getContentPane().add(txtLogoSaydamlik, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 80, 20));

        txtLogoKonum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLogoKonum.setForeground(new java.awt.Color(255, 255, 255));
        txtLogoKonum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLogoKonum.setText("Sağ Alt");
        txtLogoKonum.setBorder(null);
        txtLogoKonum.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtLogoKonum.setEnabled(false);
        txtLogoKonum.setOpaque(false);
        getContentPane().add(txtLogoKonum, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 365, 80, 20));

        lblResimSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png"))); // NOI18N
        lblResimSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResimSecMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResimSecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResimSecMouseExited(evt);
            }
        });
        getContentPane().add(lblResimSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 134, 420, -1));

        txtResimKalite.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtResimKalite.setForeground(new java.awt.Color(255, 255, 255));
        txtResimKalite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtResimKalite.setText("50");
        getContentPane().add(txtResimKalite, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 70, 20));

        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/menuSade.png"))); // NOI18N
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 410, 50));

        lblArkaplan.setForeground(new java.awt.Color(255, 255, 255));
        lblArkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/arkaplan5.png"))); // NOI18N
        lblArkaplan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblArkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 580));

        setSize(new java.awt.Dimension(566, 609));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //<editor-fold defaultstate="collapsed" desc="Tasarım">


    private void txtLogoSaydamlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLogoSaydamlikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLogoSaydamlikActionPerformed

    private void txtDizinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDizinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDizinActionPerformed
    public static void yaziPost(String yazi) {
        try {

            URL url = new URL("http://improsyazilim.com/ResimKucultmePro/user.php");
            URLConnection con = url.openConnection();

            con.setDoOutput(true);

            try (PrintStream ps = new PrintStream(con.getOutputStream())) {

                ps.print("deger=" + yazi);

                con.getInputStream();
            }
        } catch (MalformedURLException e) {
            System.err.println("Hata " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Hata " + e.getMessage());

        }
    }
    static boolean basladiMi = false;
    private void lblBaslaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBaslaMouseClicked

        String strWarning = "";
        if (txtDizin.getText().equalsIgnoreCase("Seçili Resim veya Klasör Yok")) {
            strWarning += "*Resim Seçme Alanı\n";
        }
        if (txtKaydetDizin.getText().equalsIgnoreCase("Kaydedilecek Dizin Seçilmedi")) {
            strWarning += "*Kaydedilecek Alan\n";
        }
        if (isWatermarkEkle) {
            System.out.println("True");
            if (txtWatermarkDizin.getText().equalsIgnoreCase("Logo Seçilmedi")) {
                strWarning += "*Logo Seçme Alanı\n";
            }
        }
        if (!strWarning.equals("")) {
            JOptionPane.showMessageDialog(null, "Lütfen Şu Alanları Doldurun :\n\n" + strWarning, "Eksik Bilgi", JOptionPane.INFORMATION_MESSAGE);
        } else {

            PicQualitySettings resimKucultClass = new PicQualitySettings(isAkilliKucult, isWatermarkEkle);
            Thread thread_resimKucult = new Thread(resimKucultClass);
            basladiMi = !basladiMi;
            if (basladiMi) {
                lblProgressbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/progressbar1.gif")));
                lblDurum.setText("İşlem Başladı");
                thread_resimKucult.start();
                lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnDur_Pasif.png")));
            } else {
                lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnAktif.png")));
            }

        }


    }//GEN-LAST:event_lblBaslaMouseClicked

    private void lblUstArtirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUstArtirMouseEntered
        lblSaydamlikDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnArtir.png")));
    }//GEN-LAST:event_lblUstArtirMouseEntered

    private void lblAltAzaltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAltAzaltMouseEntered
        lblSaydamlikDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnAzalt.png")));
    }//GEN-LAST:event_lblAltAzaltMouseEntered

    private void lblAltAzaltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAltAzaltMouseExited
        lblSaydamlikDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnNormal.png")));
    }//GEN-LAST:event_lblAltAzaltMouseExited

    private void lblUstArtirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUstArtirMouseExited
        lblSaydamlikDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnNormal.png")));
    }//GEN-LAST:event_lblUstArtirMouseExited

    private void lblBaslaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBaslaMouseEntered
        if (lblBasla.getIcon().toString().contains("Dur")) {
            lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnDur_Aktif.png")));
        } else {
            lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnAktif.png")));
        }

    }//GEN-LAST:event_lblBaslaMouseEntered

    private void lblBaslaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBaslaMouseExited
        if (lblBasla.getIcon().toString().contains("Dur")) {
            lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnDur_Pasif.png")));
        } else {
            lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnPasif.png")));
        }
        //lblBasla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnPasif.png")));
    }//GEN-LAST:event_lblBaslaMouseExited

    private void lblKaliteArtirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteArtirMouseEntered
        lblKalite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnArtir.png")));
    }//GEN-LAST:event_lblKaliteArtirMouseEntered

    private void lblKaliteAzaltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteAzaltMouseEntered
        lblKalite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnAzalt.png")));
    }//GEN-LAST:event_lblKaliteAzaltMouseEntered

    private void lblKaliteArtirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteArtirMouseExited
        lblKalite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnNormal.png")));
    }//GEN-LAST:event_lblKaliteArtirMouseExited

    private void lblKaliteAzaltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteAzaltMouseExited
        lblKalite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/btnNormal.png")));
    }//GEN-LAST:event_lblKaliteAzaltMouseExited
//Akilli Kucultme
    boolean isAkilliKucult = false;
    private void lblAkilliKucultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAkilliKucultMouseClicked
        if (lblAkilliKucult.getIcon().toString().endsWith("chkAktif.png")) {
            lblAkilliKucult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkPasif.png")));
            isAkilliKucult = false;
        } else {
            lblAkilliKucult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkAktif.png")));
            isAkilliKucult = true;
    }//GEN-LAST:event_lblAkilliKucultMouseClicked
    }

//Watermark Ekle
    boolean isWatermarkEkle = false;
    private void lblLogoEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoEkleMouseClicked

        if (lblLogoEkle.getIcon().toString().endsWith("chkAktif.png")) {
            lblLogoEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkPasif.png")));
            isWatermarkEkle = false;
        } else {
            lblLogoEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/chkAktif.png")));
            isWatermarkEkle = true;
        }
    }//GEN-LAST:event_lblLogoEkleMouseClicked

    private void lblResimSecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResimSecMouseEntered
        lblResimSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/secHover.png")));
    }//GEN-LAST:event_lblResimSecMouseEntered

    private void lblResimSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResimSecMouseExited
        lblResimSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png")));
    }//GEN-LAST:event_lblResimSecMouseExited
//</editor-fold>
    private void lblResimSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResimSecMouseClicked
        dosyaSecici.setDialogTitle("Bir Resim veya Resim Klasörü Secin");
        dosyaSecici.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        String strUzanti = null;
        if (dosyaSecici.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            String dizin = dosyaSecici.getSelectedFile() + "";
            txtDizin.setText(dizin);
            strUzanti = dosyaSecici.getFileFilter().getDescription() + "";
            //JOptionPane.showMessageDialog(null, "Uzanti = " + strUzanti);

        }
        if (dosyaSecici.getSelectedFile().isFile()) {
            File resimDizin = new File(txtDizin.getText());
            arrResimler.clear();
            arrResimler.add(resimDizin);
            System.out.println("Resim Listesi : " + (arrResimler));
            txtResimSayisi.setText(arrResimler.size() + "");
        } else {
            File resimDizin = new File(txtDizin.getText());
            arrResimler.clear();
            //     "JPG || PNG "  "JPG" "PNG"
            switch (strUzanti) {
                case "JPG || PNG ":
                    listele(resimDizin, "png");
                    listele(resimDizin, "jpg");
                    break;
                case "JPG":
                    listele(resimDizin, "jpg");
                    break;
                case "PNG":
                    listele(resimDizin, "png");
                    break;
            }

            txtResimSayisi.setText(arrResimler.size() + "");
        }

    }//GEN-LAST:event_lblResimSecMouseClicked

    private void lblKlasorSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKlasorSecMouseClicked
        dosyaSecici.setDialogTitle("Kaydedilecek Klasörü Secin");
        dosyaSecici.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (dosyaSecici.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

            String dizin = dosyaSecici.getSelectedFile() + "";
            txtKaydetDizin.setText(dizin);

        }

    }//GEN-LAST:event_lblKlasorSecMouseClicked

    private void lblKlasorSecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKlasorSecMouseEntered
        lblKlasorSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/secHover.png")));
    }//GEN-LAST:event_lblKlasorSecMouseEntered

    private void lblKlasorSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKlasorSecMouseExited
        lblKlasorSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png")));
    }//GEN-LAST:event_lblKlasorSecMouseExited

    private void txtKaydetDizinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKaydetDizinActionPerformed

    }//GEN-LAST:event_txtKaydetDizinActionPerformed

    private void lblKaliteArtirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteArtirMouseClicked
        int tmpResimKalite = Integer.parseInt(txtResimKalite.getText());
        tmpResimKalite++;
        if (tmpResimKalite < 100) {
            txtResimKalite.setText(tmpResimKalite + "");
        }

    }//GEN-LAST:event_lblKaliteArtirMouseClicked

    private void lblKaliteAzaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKaliteAzaltMouseClicked
        int tmpResimKalite = Integer.parseInt(txtResimKalite.getText());
        tmpResimKalite--;
        if (tmpResimKalite > 0) {
            txtResimKalite.setText(tmpResimKalite + "");
        }
    }//GEN-LAST:event_lblKaliteAzaltMouseClicked

    private void txtWatermarkDizinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWatermarkDizinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWatermarkDizinActionPerformed

    private void lblWatermarkSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWatermarkSecMouseClicked
        if (isWatermarkEkle) {

            dosyaSecici.setDialogTitle("Logoyu Seçiniz");
            dosyaSecici.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (dosyaSecici.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                String dizin = dosyaSecici.getSelectedFile() + "";
                txtWatermarkDizin.setText(dizin);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Lütfen Logo Eklemeyi Aktifleştiriniz", "Logo Ekleme Aktif Değil", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_lblWatermarkSecMouseClicked

    private void lblWatermarkSecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWatermarkSecMouseEntered
        lblWatermarkSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/secHover.png")));
    }//GEN-LAST:event_lblWatermarkSecMouseEntered

    private void lblWatermarkSecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWatermarkSecMouseExited
        lblWatermarkSec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sec.png")));
    }//GEN-LAST:event_lblWatermarkSecMouseExited

    private void lblUstArtirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUstArtirMouseClicked
        int tmpResimSaydamlik = Integer.parseInt(txtLogoSaydamlik.getText());
        tmpResimSaydamlik++;
        if (tmpResimSaydamlik < 100) {
            txtLogoSaydamlik.setText(tmpResimSaydamlik + "");
        }
    }//GEN-LAST:event_lblUstArtirMouseClicked

    private void lblAltAzaltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAltAzaltMouseClicked
        int tmpResimSaydamlik = Integer.parseInt(txtLogoSaydamlik.getText());
        tmpResimSaydamlik--;
        if (tmpResimSaydamlik > 0) {
            txtLogoSaydamlik.setText(tmpResimSaydamlik + "");
        }
    }//GEN-LAST:event_lblAltAzaltMouseClicked

    private void lblLogoDegisEksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisEksiMouseClicked
        if (nLogoSayac > 0) {
            nLogoSayac--;
            txtLogoKonum.setText(arrLogoKonum[nLogoSayac]);
        }

        // nLogoSayac = nLogoSayac % 5;
    }//GEN-LAST:event_lblLogoDegisEksiMouseClicked

    private void lblLogoDegisEksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisEksiMouseEntered
        lblLogoDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sayacAzalt.png")));
    }//GEN-LAST:event_lblLogoDegisEksiMouseEntered

    private void lblLogoDegisEksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisEksiMouseExited
        lblLogoDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sayacSade.png")));
    }//GEN-LAST:event_lblLogoDegisEksiMouseExited
    String[] arrLogoKonum = {"Sağ Alt", "Sağ Üst", "Orta", "Sol Alt", "Sol Üst"};
    int nLogoSayac = 0;
    private void lblLogoDegisArtiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisArtiMouseClicked
        if (nLogoSayac < 4) {
            nLogoSayac++;
        }
        txtLogoKonum.setText(arrLogoKonum[nLogoSayac]);
        // nLogoSayac = nLogoSayac % 5;
    }//GEN-LAST:event_lblLogoDegisArtiMouseClicked

    private void lblLogoDegisArtiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisArtiMouseEntered
        lblLogoDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sayacArtir.png")));
    }//GEN-LAST:event_lblLogoDegisArtiMouseEntered

    private void lblLogoDegisArtiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoDegisArtiMouseExited
        lblLogoDegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/sayacSade.png")));
    }//GEN-LAST:event_lblLogoDegisArtiMouseExited

    private void lblGuncelleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuncelleMouseEntered
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuGuncelle_Hover.png")));
    }//GEN-LAST:event_lblGuncelleMouseEntered

    private void lblGuncelleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuncelleMouseExited
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuSade.png")));
    }//GEN-LAST:event_lblGuncelleMouseExited

    private void lblBagisYapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBagisYapMouseEntered
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuBagisYap_Hover.png")));
    }//GEN-LAST:event_lblBagisYapMouseEntered

    private void lblBagisYapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBagisYapMouseExited
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuSade.png")));
    }//GEN-LAST:event_lblBagisYapMouseExited

    private void lblHakkindaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHakkindaMouseEntered
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuHakkinda_Hover.png")));
    }//GEN-LAST:event_lblHakkindaMouseEntered

    private void lblHakkindaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHakkindaMouseExited
        lblYeniMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/yeniMenuSade.png")));
    }//GEN-LAST:event_lblHakkindaMouseExited
    float VersiyonNo = 1.0f;
    private void lblGuncelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuncelleMouseClicked

        try {
            float guncelVersiyon = Float.parseFloat(urlOku("http://improsyazilim.com/ResimKucultmePro/guncelleme.txt"));
            if (VersiyonNo < guncelVersiyon) {
                openWebpage("http://improsyazilim.com/");
            } else {
                JOptionPane.showMessageDialog(null, "Program Güncel.Versiyon No: " + VersiyonNo, "Güncelleme Kontrol", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Güncelleme Kontrol Edilemedi");
        }
    }//GEN-LAST:event_lblGuncelleMouseClicked

    private void lblBagisYapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBagisYapMouseClicked
        openWebpage("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GRH653LJSM89S");
    }//GEN-LAST:event_lblBagisYapMouseClicked

    private void lblHakkindaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHakkindaMouseClicked
        lblInfo.setSize(430, 430);

        lblInfo.setVisible(true);
        lblInfoKapat.setVisible(true);
        lblInfo.setSize(430, 430);

    }//GEN-LAST:event_lblHakkindaMouseClicked

    private void lblInfoKapatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInfoKapatMouseClicked
        lblInfo.setVisible(false);
        lblInfoKapat.setVisible(false);
    }//GEN-LAST:event_lblInfoKapatMouseClicked

    private void lblYeniMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYeniMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblYeniMenuMouseClicked

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (URISyntaxException | IOException e) {
        }
    }

    public static String urlOku(String url) throws MalformedURLException, IOException {
        String strToplamVeri = "";
        URL okuyucu = new URL(url);//url olarak internetten rastgele bir txt dosyası verdim
        try (BufferedReader bf = new BufferedReader(//bf  adında karakter tabanlı  okuyucumuzu oluşturduk
                new InputStreamReader(okuyucu.openStream()))) {// input stream ile urlmizi okumaya calisiyoruz
            String veri;//her bir satıra veri diyoruz

            while ((veri = bf.readLine()) != null)//veri boş bir değere eşit olmadığı sürece
            {
                strToplamVeri += veri;
            }
        }
        return strToplamVeri;
    }

    private void listele(File klasor, String strUzanti) {

        try {
            File[] arrklasoricindekiler = klasor.listFiles();
            for (File klasoricindekiler1 : arrklasoricindekiler) {
                if (klasoricindekiler1.isDirectory()) {

                    listele(klasoricindekiler1, strUzanti);
                } else if (klasoricindekiler1.getName().toLowerCase().endsWith(strUzanti)) {
                    arrResimler.add(klasoricindekiler1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(picSmaller_anamenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(picSmaller_anamenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(picSmaller_anamenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(picSmaller_anamenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new picSmaller_anamenu().setVisible(true);
            }
        });
    }
//<editor-fold defaultstate="collapsed" desc="other">


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAkilliKucult;
    private javax.swing.JLabel lblAltAzalt;
    private javax.swing.JLabel lblArkaplan;
    private javax.swing.JLabel lblBagisYap;
    public static javax.swing.JLabel lblBasla;
    public static javax.swing.JLabel lblDurum;
    public static javax.swing.JLabel lblGecenSure;
    private javax.swing.JLabel lblGuncelle;
    private javax.swing.JLabel lblHakkinda;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblInfoKapat;
    private javax.swing.JLabel lblKalite;
    private javax.swing.JLabel lblKaliteArtir;
    private javax.swing.JLabel lblKaliteAzalt;
    private javax.swing.JLabel lblKapatAkilli;
    private javax.swing.JLabel lblKlasorSec;
    private javax.swing.JLabel lblLogoDegis;
    private javax.swing.JLabel lblLogoDegisArti;
    private javax.swing.JLabel lblLogoDegisEksi;
    private javax.swing.JLabel lblLogoEkle;
    private javax.swing.JLabel lblMenu;
    public static javax.swing.JLabel lblProgressbar;
    private javax.swing.JLabel lblResimSec;
    private javax.swing.JLabel lblSaydamlikDegis;
    private javax.swing.JLabel lblUstArtir;
    private javax.swing.JLabel lblWatermarkSec;
    private javax.swing.JLabel lblYeniMenu;
    private javax.swing.JTextField txtDizin;
    public static javax.swing.JTextField txtKaydetDizin;
    public static javax.swing.JTextField txtLogoKonum;
    public static javax.swing.JTextField txtLogoSaydamlik;
    public static javax.swing.JTextField txtProgressValue;
    public static javax.swing.JLabel txtResimKalite;
    private javax.swing.JTextField txtResimSayisi;
    public static javax.swing.JTextField txtWatermarkDizin;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>
