package OgrenciIsleriOtomasyonu;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Insets;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OgrenciIsleriOtomasyonu {

    public static JFrame frame;
    private static ArrayList<Ogrenci> Ogrenciler = new ArrayList<Ogrenci>();
    private static ArrayList<OgretimUyesi> Ogretmenler = new ArrayList<OgretimUyesi>();
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static JTextField textField_3;
    private static JTextField textField_4;
    private static JTextField textField_5;
    private static JTextField textField_6;
    private static JTextField textField_7;
    private static JTextField textField_8;
    private static JTextField textField_9;
    private static JTextField textField_10;
    private static JTextField textField_11;
    public static void main(String[] args) {
    	
    	if(Ogrenciler.isEmpty())
    	{
    		OgretimUyesi testogretmen = new OgretimUyesi("1", "Zeynep Tuğçe", "1");
	    	Ogretmenler.add(testogretmen);
	    	Ogrenci testogrenci = new Ogrenci("1306230027", "Mustafa Burak", "1", testogretmen);
	    	Ogrenciler.add(testogrenci);
	    	Ogrenci testogrenci2 = new Ogrenci("1306220076", "Zeynep Pınarlı", "2", testogretmen);
	    	Ogrenciler.add(testogrenci2);
    	}
        frame = new JFrame("Öğrenci İşleri Otomasyonu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        
        
        
        // ogretmenSayfasi(testogretmen);
        
        // ogrenciSayfasi();
        
        girisSayfasi(panel);

        
        
        frame.setVisible(true);
    }

    private static void girisSayfasi(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Kullanıcı Türü:");
        userLabel.setBounds(10, 20, 100, 25);
        panel.add(userLabel);
        
        String[] userTypes = {"Öğrenci", "Öğretmen"};
        JComboBox<String> userTypeCombo = new JComboBox<>(userTypes);
        userTypeCombo.setBounds(120, 20, 165, 25);
        panel.add(userTypeCombo);

        JLabel idLabel = new JLabel("Numara:");
        idLabel.setBounds(10, 60, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(120, 60, 165, 25);
        panel.add(idText);

        JLabel passwordLabel = new JLabel("Şifre:");
        passwordLabel.setBounds(10, 100, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 100, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Giriş Yap");
        loginButton.setBounds(10, 150, 150, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userType = (String) userTypeCombo.getSelectedItem();
                String userId = idText.getText();
                String password = new String(passwordText.getPassword());
                
                

                if (userType.equals("Öğrenci")) {
                	boolean login = false;
                	for (Ogrenci a : Ogrenciler) {
                		
                        if(userId.equals(a.id) && password.equals(a.sifre))
                        {
                        	JOptionPane.showMessageDialog(frame, "Hoşgeldiniz " + a.isim + ". Ogrenci sayfası açılıyor");
                            frame.dispose();
                            ogrenciSayfasi(a);
                            login = true;
                            break;
                            
                        }
                    }
                	if (!login) {
                		JOptionPane.showMessageDialog(frame, "Hatalı giriş!", "Hata", JOptionPane.ERROR_MESSAGE);
                	}
                } 
                else 
                {
                	boolean login = false;
                	for (OgretimUyesi a : Ogretmenler) 
                	{
                        if(userId.equals(a.id) && password.equals(a.sifre))
                        {
                        	JOptionPane.showMessageDialog(frame, "Hoşgeldiniz " + a.isim + ". Ogretmen sayfası açılıyor");
                            frame.dispose();
                            ogretmenSayfasi(a);
                            login = true;
                            break;
                        }
                    }
                	if (!login) {
                		JOptionPane.showMessageDialog(frame, "Hatalı giriş!", "Hata", JOptionPane.ERROR_MESSAGE);
                	}
                }
            }
        });
    }
   
    
    
    
    //  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI
    //  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI
    //  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI
    //  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI
    //  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI -  OGRENCI SAYFASI
    
    private static void ogrenciSayfasi(Ogrenci loginolan) {
    	JFrame ogrenciFrame = new JFrame("Öğrenci Sayfası");
        ogrenciFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	ogrenciFrame.setSize(600, 400);
    	ogrenciFrame.getContentPane().setLayout(null);
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
    	tabbedPane.setBounds(0, 0, 584, 361);
    	
    	
    	
    	/*
    	 * KİŞİSEL BİLGİLER EKRANI
    	 						*/
    	
	    	JPanel kisiselBilgilerPanel = new JPanel();
	    	kisiselBilgilerPanel.setLayout(null);
	
	    	Ogrenci ogrenci = loginolan;
	
	    	// kişiye özel bilgiler ve tarih
	    	JLabel lblAdSoyad = new JLabel("Ad, Soyad: " + ogrenci.isim);
	    	lblAdSoyad.setBounds(10, 11, 200, 25);
	    	kisiselBilgilerPanel.add(lblAdSoyad);
	    	JLabel lblNumara = new JLabel("Numara: " + ogrenci.id);
	    	lblNumara.setBounds(10, 45, 200, 25);
	    	kisiselBilgilerPanel.add(lblNumara);
	    	JLabel lblDanisman = new JLabel("Danışman Hoca: " + ogrenci.danismanHoca.isim);
	    	lblDanisman.setBounds(10, 80, 200, 25);
	    	kisiselBilgilerPanel.add(lblDanisman);

	    	// Tarih ve saat
	        JLabel lblTarihSaat = new JLabel("Tarih ve Saat: ");
	        lblTarihSaat.setBounds(269, 249, 300, 25);
	        kisiselBilgilerPanel.add(lblTarihSaat);

	        JLabel lblGecenSure = new JLabel("Sistemde Geçen Süre: 0 saniye");
	        lblGecenSure.setBounds(269, 280, 300, 25);
	        kisiselBilgilerPanel.add(lblGecenSure);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	        Timer timer = new Timer(1000, new ActionListener() {
	            long startTime = System.currentTimeMillis();

	            public void actionPerformed(ActionEvent e) {
	                String formattedDateTime = LocalDateTime.now().format(formatter);
	                lblTarihSaat.setText("Tarih ve Saat: " + formattedDateTime);

	                long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
	                lblGecenSure.setText("Sistemde Geçen Süre: " + elapsedSeconds + " saniye");
	            }
	        });
	        timer.start();

	    	// alınan ders sayısı
	    	JLabel lblDersSayisi = new JLabel("Alınan Ders Sayısı: " + ogrenci.dersler.size());
	    	lblDersSayisi.setBounds(10, 115, 200, 25);
	    	kisiselBilgilerPanel.add(lblDersSayisi);
	
	    	// not ortalamasi ve hesaplama
	    	double toplamNot = ogrenci.notlar.values().stream().filter(not -> not != -1).mapToInt(Integer::intValue).sum();
	    	long girilenNotSayisi = ogrenci.notlar.values().stream().filter(not -> not != -1).count();
	    	double ortalama = girilenNotSayisi == 0 ? 0 : toplamNot / girilenNotSayisi;
	    	JLabel lblGenelOrtalama = new JLabel(String.format("Genel Not Ortalaması: %.2f", ortalama));
	    	lblGenelOrtalama.setBounds(10, 150, 200, 25);
	    	kisiselBilgilerPanel.add(lblGenelOrtalama);
	
	    	// alınan dersler ve listesi
	    	JLabel lblDersler = new JLabel("Alınan Dersler:");
	    	lblDersler.setBounds(300, 11, 200, 25);
	    	kisiselBilgilerPanel.add(lblDersler);
	
	    	int yOffset = 30;
	    	for (String ders : ogrenci.dersler) {
	    	    JLabel lblDers = new JLabel("- " + ders);
	    	    lblDers.setBounds(320, yOffset, 200, 25);
	    	    kisiselBilgilerPanel.add(lblDers);
	    	    yOffset += 25;
	    	}
	    	tabbedPane.addTab("Kişisel Bilgiler", kisiselBilgilerPanel);
	    	
	    	
	    	
	    	
	    	
    	
	    /*
	     	* DERS SEÇME EKRANI
	     						*/
	    	

	    	JPanel dersSecimiPanel = new JPanel();
	    	dersSecimiPanel.setLayout(null);
	    	
	    	
	    	// DERS SEÇİM VE DANIŞMAN ONAYINA YOLLAMA KISMI
	    	
	    	JLabel lblNewLabel_2 = new JLabel("Lütfen ders seçimi yapınız.");
	    	lblNewLabel_2.setBounds(37, 37, 153, 14);
	    	dersSecimiPanel.add(lblNewLabel_2);
	    	
	    	JCheckBox checkbox_1 = new JCheckBox("Veri Yapıları");
	    	checkbox_1.setBounds(37, 58, 97, 23);
	    	dersSecimiPanel.add(checkbox_1);
	    	
	    	
	    	JCheckBox checkbox_2 = new JCheckBox("Diferansiyel Denklemler");
	    	checkbox_2.setBounds(37, 84, 153, 23);
	    	dersSecimiPanel.add(checkbox_2);
	    	
	    	JCheckBox checkbox_3 = new JCheckBox("Nesneye Yönelik Programlama");
	    	checkbox_3.setBounds(37, 110, 207, 23);
	    	dersSecimiPanel.add(checkbox_3);
	    	
	    	JCheckBox checkbox_4 = new JCheckBox("Lojik Devre Tasarımı");
	    	checkbox_4.setBounds(37, 136, 180, 23);
	    	dersSecimiPanel.add(checkbox_4);
	    	
	    	JCheckBox checkbox_5 = new JCheckBox("Devreler ve Sistemler");
	    	checkbox_5.setBounds(37, 162, 190, 23);
	    	dersSecimiPanel.add(checkbox_5);
	    	
	    	JCheckBox checkbox_6 = new JCheckBox("Olasılık Teorisi ve İstatistik");
	    	checkbox_6.setBounds(37, 188, 180, 23);
	    	dersSecimiPanel.add(checkbox_6);
	    	
	    	JButton btnNewButton = new JButton("Gönder");
	    	btnNewButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			ArrayList<String> ders = new ArrayList<String>();
	    			if(checkbox_1.isSelected())
	    				ders.add(checkbox_1.getText());
	    			if(checkbox_2.isSelected())
	    				ders.add(checkbox_2.getText());
	    			if(checkbox_3.isSelected())
	    				ders.add(checkbox_3.getText());
	    			if(checkbox_4.isSelected())
	    				ders.add(checkbox_4.getText());
	    			if(checkbox_5.isSelected())
	    				ders.add(checkbox_5.getText());
	    			if(checkbox_6.isSelected())
	    				ders.add(checkbox_6.getText());
	    			if(ders.isEmpty())
	    				JOptionPane.showMessageDialog(frame, "Lütfen en az 1 ders seç", "Hata", JOptionPane.ERROR_MESSAGE);
	    			else
	    			{
	    				for(String secilenders : ders)
	    				{
	    					if(loginolan.dersler.contains(secilenders))
	    						JOptionPane.showMessageDialog(frame, "Ders: " + secilenders + " zaten seçildi ve onaylandı.", "Hata", JOptionPane.ERROR_MESSAGE);
	    					else
	    						loginolan.dersSec(secilenders);    						
	    				}
	    				JOptionPane.showMessageDialog(frame, "Seçilen geçerli dersler danışman onayına gönderildi.");
	    				
	    			}
	    		}
	    		
	    	});
	    	btnNewButton.setBounds(37, 218, 89, 23);
	    	dersSecimiPanel.add(btnNewButton);
	    	
	    	
	    	// MEVCUT ALINAN DERSLERİ LİSTELEME KISMI
	    	
	    	JLabel lblNewLabel_6 = new JLabel("Mevcut aldığınız dersler:");
	    	lblNewLabel_6.setBounds(347, 37, 146, 14);
	    	dersSecimiPanel.add(lblNewLabel_6);
	    	
	    	JPanel panel_2 = new JPanel();
	    	panel_2.setBackground(new Color(207, 207, 207));
	    	panel_2.setBounds(347, 58, 146, 157);
	    	dersSecimiPanel.add(panel_2);
	    	
	    	JButton btnNewButton_4 = new JButton("Yenile");
	    	btnNewButton_4.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			panel_2.removeAll();
	    			
	    			if (loginolan.dersler.isEmpty()) {
	    				JLabel lblNoCourses = new JLabel("Henüz ders almıyorsunuz");
	    				lblNoCourses.setHorizontalAlignment(SwingConstants.CENTER);
	    				lblNoCourses.setBounds(0, 0, 146, 14);
	    				panel_2.add(lblNoCourses);
	    			} else {
	    				int yPosition = 0;
	    				for (String ders : loginolan.dersler) {
	    					JLabel lblDers = new JLabel(ders);
	    					lblDers.setBounds(0, yPosition, 146, 14);
	    					panel_2.add(lblDers);
	    					yPosition += 20;
	    				}
	    			}
	    			
	    			// Panel'ı yeniden çizin
	    			panel_2.revalidate();
	    			panel_2.repaint();
	    		}
	    	});
	
	    	tabbedPane.addTab("Ders Seçimi", dersSecimiPanel);
	    	
	    	
	    	
    	
	    /*
	     	* NOT GÖRÜNTÜLEME EKRANI 
	     							*/
	    	
	    	
	    	JPanel notGoruntulemePanel = new JPanel();
	    	notGoruntulemePanel.setLayout(null);
	    	
	    	
	    	// NOTLARI YÜKLEME VE GÖSTERME KISMI 
	    	
	    	JPanel panel_3 = new JPanel();
	    	panel_3.setBackground(new Color(192, 192, 192));
	    	panel_3.setBounds(112, 47, 365, 241);
	    	notGoruntulemePanel.add(panel_3);
	    	
	    	JButton btnNewButton_6 = new JButton("Notları Yükle");
	    	btnNewButton_6.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			panel_3.removeAll();
	    			
	    			if (loginolan.dersler.isEmpty()) {
	    				JLabel messageLabel = new JLabel("Şu an ders almıyorsunuz.");
	    				messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    				panel_3.add(messageLabel);
	    			} else {
	    				for (Map.Entry<String, Integer> entry : loginolan.notlar.entrySet()) {
	    					JPanel dersPanel = new JPanel();
	    					dersPanel.setLayout(new FlowLayout());
	    					
	    					JLabel dersLabel = new JLabel(entry.getKey());
	    					dersPanel.add(dersLabel);
	    					
	    					JTextField notField = new JTextField(String.valueOf(entry.getValue()), 5); // 5 karakter genişliğinde
	    					notField.setEditable(false); // Salt okunur
	    					dersPanel.add(notField);
	    					
	    					panel_3.add(dersPanel);
	    				}
	    			}
	    			
	    			panel_3.revalidate();
	    			panel_3.repaint();
	    		}
	    	});
	    	btnNewButton_6.setBounds(226, 299, 122, 23);
	    	notGoruntulemePanel.add(btnNewButton_6);
	    	
	    	JLabel lblNewLabel_7 = new JLabel("Notlarınızı görüntülemek için Butona tıklayın.");
	    	lblNewLabel_7.setBounds(176, 11, 320, 14);
	    	notGoruntulemePanel.add(lblNewLabel_7);
	    	
	    	JLabel lblNewLabel_8 = new JLabel("Eğer not girilmemişse default olarak -1 gözükecektir");
	    	lblNewLabel_8.setBounds(157, 22, 297, 14);
	    	notGoruntulemePanel.add(lblNewLabel_8);
	    	
	    	btnNewButton_4.setBounds(345, 218, 89, 23);
	    	dersSecimiPanel.add(btnNewButton_4);
	    	tabbedPane.addTab("Not Görüntüleme", notGoruntulemePanel);
	    	
	    	

	    	
	    	/*
	    	 	* MESAJ ATMA VE MESAJ KUTUSU 
	    	 									*/
	    	
	    	
	    	JPanel mesajAtmaPanel1 = new JPanel();
	    	mesajAtmaPanel1.setLayout(null);
	    	
	    	DefaultListModel<String> listModel = new DefaultListModel<>();
	    	JList<String> list = new JList<>(listModel);
	    	JScrollPane scrollPane1 = new JScrollPane(list);
	    	scrollPane1.setBounds(10, 11, 87, 311);
	    	mesajAtmaPanel1.add(scrollPane1);
	    	
	    	// MESAJLARIN LİSTELENDİĞİ ALAN
	    	JPanel panel_4 = new JPanel();
	    	panel_4.setBounds(107, 11, 380, 280);
	    	panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
	    	mesajAtmaPanel1.add(panel_4);
	    	
	    	JButton btnNewButton_7 = new JButton("Yenile");
	    	btnNewButton_7.setBounds(497, 268, 72, 23);
	    	btnNewButton_7.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			listModel.clear();
	    			for (Ogrenci ogrenci : Ogrenciler) {
	    				if (!ogrenci.equals(loginolan)) { // kendi hariç herkesi listeye ekle.
	    					listModel.addElement(ogrenci.isim);
	    				}
	    			}
	    			for (OgretimUyesi ogretmen : Ogretmenler) {
	    				listModel.addElement(ogretmen.isim);
	    			}
	    			panel_4.removeAll();
	    		}
	    	});
	    	mesajAtmaPanel1.add(btnNewButton_7);
	    	
	    	JTextField textField_12 = new JTextField();
	    	textField_12.setBounds(107, 302, 380, 20);
	    	mesajAtmaPanel1.add(textField_12);
	    	
	    	JButton btnNewButton_8 = new JButton("Gönder");
	    	btnNewButton_8.setBounds(497, 302, 72, 23);
	    	btnNewButton_8.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			String selectedUser = list.getSelectedValue();
	    			String newMessage = textField_12.getText().trim();
	    			
	    			if (selectedUser == null) {
	    				JOptionPane.showMessageDialog(null, "Lütfen bir kişi seçin!", "Hata", JOptionPane.ERROR_MESSAGE);
	    				return;
	    			}
	    			
	    			if (newMessage.isEmpty()) {
	    				JOptionPane.showMessageDialog(null, "Lütfen bir mesaj yazın!", "Hata", JOptionPane.ERROR_MESSAGE);
	    				return;
	    			}
	    			
	    			loginolan.mesajlar.putIfAbsent(selectedUser, new ArrayList<>()); // içi boşsa oluştur
	    			loginolan.mesajlar.get(selectedUser).add("Siz: " + newMessage);
	    			
	    			Object alici = null;
	    			for (Ogrenci ogrenci : Ogrenciler) {
	    				if (ogrenci.isim.equals(selectedUser)) {
	    					alici = ogrenci;
	    					break;
	    				}
	    			}
	    			for (OgretimUyesi ogretmen : Ogretmenler) {
	    				if (ogretmen.isim.equals(selectedUser)) {
	    					alici = ogretmen;
	    					break;
	    				}
	    			}
	    			
	    			if (alici != null) {
	    				if (alici instanceof Ogrenci) {
	    					Ogrenci ogrenci = (Ogrenci) alici;
	    					ogrenci.mesajlar.putIfAbsent(loginolan.isim, new ArrayList<>()); 
	    					ogrenci.mesajlar.get(loginolan.isim).add(loginolan.isim + ": " + newMessage);
	    				} else if (alici instanceof OgretimUyesi) {
	    					OgretimUyesi ogretmen = (OgretimUyesi) alici;
	    					ogretmen.mesajlar.putIfAbsent(loginolan.isim, new ArrayList<>());
	    					ogretmen.mesajlar.get(loginolan.isim).add(loginolan.isim + ": " + newMessage);
	    				}
	    			}
	    			
	    			// paneli yenile
	    			updateMesajPanel(selectedUser, loginolan, panel_4);
	    			textField_12.setText("");
	    		}
	    	});
	    	
	    	mesajAtmaPanel1.add(btnNewButton_8);
	    	
	    	// JListten seçilen kişi
	    	list.addListSelectionListener(e -> {
	    		if (!e.getValueIsAdjusting()) {
	    			String selectedUser = list.getSelectedValue();
	    			if (selectedUser != null) {
	    				updateMesajPanel(selectedUser, loginolan, panel_4);
	    			}
	    		}
	    	});
	    	tabbedPane.addTab("Mesaj Atma", mesajAtmaPanel1);
	    	ogrenciFrame.getContentPane().add(tabbedPane);
	    	
	    
	    	
	    	
	    	
	    	
	    /*
	     	* AYARLAR, ÇIKIŞ YAPMA, ŞİFRE DEĞİŞTİRME EKRANI 
	     													*/
	    	
	    	

	    	JPanel ayarlarPanel = new JPanel();
	    	ayarlarPanel.setLayout(null);
	    	JLabel label = new JLabel("Ayarlar: Şifre ve Numara değiştirme ekranı.");
	    	label.setBounds(220, 9, 152, 14);
	    	ayarlarPanel.add(label);
	    	
	    	
	    	JButton logoutButton = new JButton("Çıkış Yap");
	    	logoutButton.setBounds(240, 282, 99, 40);
	    	logoutButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			//ogrenciFrame.dispose();
	    			main(null);
	    		}
	    	});
	    	ayarlarPanel.add(logoutButton);
	    	
	    	
	    	JPanel panel = new JPanel();
	    	panel.setBackground(new Color(209, 209, 209));
	    	panel.setBounds(10, 53, 251, 213);
	    	ayarlarPanel.add(panel);
	    	panel.setLayout(null);
	    	
	    	JButton btnNewButton_2 = new JButton("Değiştir");
	    	btnNewButton_2.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			if(textField.getText().isEmpty() || textField_1.getText().isEmpty() || textField_2.getText().isEmpty())
	    			{
	                	JOptionPane.showMessageDialog(frame, "Lütfen gerekli yerleri doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
	    			}
	    			else
	    			{
	    				if(textField.getText().equals(loginolan.sifre) && !textField.getText().equals(textField_1.getText()) && textField_2.getText().equals(textField_1.getText()))
	    				{
	                    	JOptionPane.showMessageDialog(frame, "Şifreniz değiştiriliyor, güvenlik sebebiyle çıkış yapılacaktır.");
	                    	loginolan.sifreDegistir(textField_1.getText());
	                    	ogrenciFrame.dispose();
	            			main(null);
	    				}
	    				else
	    				{
	    					if(!textField.getText().equals(loginolan.sifre))
	    						JOptionPane.showMessageDialog(frame, "Eski şifreniz uyuşmuyor.", "Hata", JOptionPane.ERROR_MESSAGE);
	    					else if(textField.getText().equals(textField_1.getText()))
	    						JOptionPane.showMessageDialog(frame, "Eski şifre ile yeni şifre aynı olamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
	    					else
	    						JOptionPane.showMessageDialog(frame, "Yeni şifreler uyuşmuyor.", "Hata", JOptionPane.ERROR_MESSAGE);
	    				}
	    			}
	    		}
	    	});
	    	btnNewButton_2.setBounds(74, 163, 89, 23);
	    	panel.add(btnNewButton_2);
	    	
	    	JLabel lblNewLabel_3 = new JLabel("Eski şifre:");
	    	lblNewLabel_3.setBackground(new Color(255, 255, 255));
	    	lblNewLabel_3.setBounds(10, 11, 67, 32);
	    	panel.add(lblNewLabel_3);
	    	
	    	textField = new JTextField();
	    	textField.setBounds(109, 17, 86, 20);
	    	panel.add(textField);
	    	textField.setColumns(10);
	    	
	    	JLabel lblNewLabel_3_1 = new JLabel("Yeni şifre:");
	    	lblNewLabel_3_1.setBackground(Color.WHITE);
	    	lblNewLabel_3_1.setBounds(10, 56, 67, 32);
	    	panel.add(lblNewLabel_3_1);
	    	
	    	textField_1 = new JTextField();
	    	textField_1.setColumns(10);
	    	textField_1.setBounds(109, 62, 86, 20);
	    	panel.add(textField_1);
	    	
	    	JLabel lblNewLabel_3_1_1 = new JLabel("Tekrar yeni şifre:");
	    	lblNewLabel_3_1_1.setBackground(Color.WHITE);
	    	lblNewLabel_3_1_1.setBounds(10, 99, 89, 32);
	    	panel.add(lblNewLabel_3_1_1);
	    	
	    	textField_2 = new JTextField();
	    	textField_2.setColumns(10);
	    	textField_2.setBounds(109, 105, 86, 20);
	    	panel.add(textField_2);
	    	
	    	JPanel panel_1 = new JPanel();
	    	panel_1.setLayout(null);
	    	panel_1.setBackground(new Color(209, 209, 209));
	    	panel_1.setBounds(318, 53, 251, 213);
	    	ayarlarPanel.add(panel_1);
	    	
	    	JButton btnNewButton_2_1 = new JButton("Değiştir");
	    	btnNewButton_2_1.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			if(textField_3.getText().isEmpty() || textField_4.getText().isEmpty() || textField_5.getText().isEmpty())
	    			{
	                	JOptionPane.showMessageDialog(frame, "Lütfen gerekli yerleri doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
	    			}
	    			else
	    			{
	    				if(textField_3.getText().equals(loginolan.id) && textField_5.getText().equals(loginolan.sifre) && !textField_3.getText().equals(textField_4.getText()))
	    				{
	                    	JOptionPane.showMessageDialog(frame, "Kullanıcı adı değiştiriliyor, güvenlik sebebiyle çıkış yapılacaktır.");
	                    	loginolan.id = textField_4.getText();
	                    	ogrenciFrame.dispose();
	            			main(null);
	    				}
	    				else if(textField_3.getText().equals(textField_4.getText()))
	    					JOptionPane.showMessageDialog(frame, "Eski kullanıcı adı ile yeni kullanıcı adı aynı olamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
	    				else if(!textField_5.getText().equals(loginolan.sifre))
	    					JOptionPane.showMessageDialog(frame, "Lütfen şifrenizi doğru girin", "Hata", JOptionPane.ERROR_MESSAGE);
	    				else if(!textField_3.getText().equals(loginolan.id))
	    					JOptionPane.showMessageDialog(frame, "Lütfen şuanki kullanıcı adınızı doğru girin", "Hata", JOptionPane.ERROR_MESSAGE);
	
	    			}
	    		}
	    	});
	    	btnNewButton_2_1.setBounds(74, 163, 89, 23);
	    	panel_1.add(btnNewButton_2_1);
	    	
	    	JLabel lblNewLabel_3_2 = new JLabel("Eski kullanıcı adı:");
	    	lblNewLabel_3_2.setBackground(Color.WHITE);
	    	lblNewLabel_3_2.setBounds(10, 11, 89, 32);
	    	panel_1.add(lblNewLabel_3_2);
	    	
	    	textField_3 = new JTextField();
	    	textField_3.setColumns(10);
	    	textField_3.setBounds(109, 17, 86, 20);
	    	panel_1.add(textField_3);
	    	
	    	JLabel lblNewLabel_3_1_2 = new JLabel("Yeni kullanıcı adı:");
	    	lblNewLabel_3_1_2.setBackground(Color.WHITE);
	    	lblNewLabel_3_1_2.setBounds(10, 56, 89, 32);
	    	panel_1.add(lblNewLabel_3_1_2);
	    	
	    	textField_4 = new JTextField();
	    	textField_4.setColumns(10);
	    	textField_4.setBounds(109, 62, 86, 20);
	    	panel_1.add(textField_4);
	    	
	    	JLabel lblNewLabel_3_1_1_1 = new JLabel("Şifre:");
	    	lblNewLabel_3_1_1_1.setBackground(Color.WHITE);
	    	lblNewLabel_3_1_1_1.setBounds(10, 99, 89, 32);
	    	panel_1.add(lblNewLabel_3_1_1_1);
	    	
	    	textField_5 = new JTextField();
	    	textField_5.setColumns(10);
	    	textField_5.setBounds(109, 105, 86, 20);
	    	panel_1.add(textField_5);
	    	
	    	JLabel lblNewLabel_4 = new JLabel("Şifre değiştirme ekranı");
	    	lblNewLabel_4.setBounds(62, 28, 124, 14);
	    	ayarlarPanel.add(lblNewLabel_4);
	    	
	    	JLabel lblNewLabel_5 = new JLabel("Kullanıcı adı değiştirme ekranı");
	    	lblNewLabel_5.setBounds(382, 28, 138, 14);
	    	ayarlarPanel.add(lblNewLabel_5);
	    	
	    	
	    	tabbedPane.addTab("Ayarlar", ayarlarPanel);
	    	ogrenciFrame.getContentPane().add(tabbedPane);
	    	ogrenciFrame.setVisible(true);
    }
    
    static void updateMesajPanel(String selectedUser, Ogrenci loginolan, JPanel panel_4) {
    	if(selectedUser != null)
    	{
	        panel_4.removeAll();
	        ArrayList<String> mesajlar = loginolan.mesajlar.getOrDefault(selectedUser, new ArrayList<>());
	
	        if (mesajlar.isEmpty()) {
	            panel_4.add(new JLabel("Henüz mesaj yok."));
	        } else {
	            for (String message : mesajlar) {
	                panel_4.add(new JLabel(message));
	            }
	        }
	
	        panel_4.revalidate();
	        panel_4.repaint();
    	}
    }

    
    
    
    
    
    //  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI
    //  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI
    //  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI
    //  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI
    //  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI -  OGRETMEN SAYFASI
    
    
    
    private static void ogretmenSayfasi(OgretimUyesi loginolan) {
        JFrame ogretmenFrame = new JFrame("Öğretmen Sayfası");
        ogretmenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ogretmenFrame.setSize(600, 400);
        JTabbedPane tabbedPane = new JTabbedPane();

        
        
        /*
         	* KİŞİSEL BİLGİLER EKRANI 
         								*/
        JPanel kisiselBilgilerPanel = new JPanel();
        kisiselBilgilerPanel.setLayout(null);
        tabbedPane.addTab("Kişisel Bilgiler", kisiselBilgilerPanel);

        JLabel lblAdSoyad = new JLabel("Ad Soyad: " + loginolan.isim);
        lblAdSoyad.setBounds(10, 11, 200, 25);
        kisiselBilgilerPanel.add(lblAdSoyad);

        JLabel lblNumara = new JLabel("Numara: " + loginolan.id);
        lblNumara.setBounds(10, 45, 200, 25);
        kisiselBilgilerPanel.add(lblNumara);

        long ogrenciSayisi = Ogrenciler.stream().filter(ogr -> ogr.danismanHoca.equals(loginolan)).count();
        JLabel lblOgrenciSayisi = new JLabel("Danışmanlık Yapılan Öğrenci Sayısı: " + ogrenciSayisi);
        lblOgrenciSayisi.setBounds(10, 80, 300, 25);
        kisiselBilgilerPanel.add(lblOgrenciSayisi);

        JList<String> ogrenciListesi = new JList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Ogrenciler.stream()
            .filter(ogr -> ogr.danismanHoca.equals(loginolan))
            .forEach(ogr -> listModel.addElement(ogr.isim));
        ogrenciListesi.setModel(listModel);

        JScrollPane scrollPane = new JScrollPane(ogrenciListesi);
        scrollPane.setBounds(250, 10, 200, 200);
        kisiselBilgilerPanel.add(scrollPane);

        // Tarih ve sistemde geçen süre
        JLabel lblTarihSaat = new JLabel("Tarih ve Saat: ");
        lblTarihSaat.setBounds(10, 250, 300, 25);
        kisiselBilgilerPanel.add(lblTarihSaat);

        JLabel lblGecenSure = new JLabel("Sistemde Geçen Süre: 0 saniye");
        lblGecenSure.setBounds(10, 280, 300, 25);
        kisiselBilgilerPanel.add(lblGecenSure);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        Timer timer = new Timer(1000, new ActionListener() {
            long startTime = System.currentTimeMillis();

            @Override
            public void actionPerformed(ActionEvent e) {
                String formattedDateTime = LocalDateTime.now().format(formatter);
                lblTarihSaat.setText("Tarih ve Saat: " + formattedDateTime);

                long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
                lblGecenSure.setText("Sistemde Geçen Süre: " + elapsedSeconds + " saniye");
            }
        });
        timer.start();

        
        
        
        /*
         	* DERS İŞLEMLERİ PANELİ 
         							*/
        
        
        JPanel dersIslemleriPanel = new JPanel();
        dersIslemleriPanel.setBackground(new Color(255, 255, 255));
        dersIslemleriPanel.setLayout(null);
        
        JLabel label = new JLabel("Ders İşlemleri: Yeni ders ekleme/silme ekranı.");
        label.setBounds(200, 9, 214, 14);
        dersIslemleriPanel.add(label);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(1, 1, 520, 247);
        int columns = 4;
        panel_2.setLayout(new GridLayout(0, columns));
        dersIslemleriPanel.add(panel_2);
        
        JScrollPane scrollPane1 = new JScrollPane(panel_2);
        scrollPane1.setBounds(32, 31, 522, 249);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        dersIslemleriPanel.add(scrollPane1);
        
        JButton btnNewButton_1 = new JButton("Bekleyen Dersleri Onayla");
        btnNewButton_1.setBounds(340, 291, 214, 31);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(loginolan.bekleyenDersler.isEmpty())
        			JOptionPane.showMessageDialog(frame, "Bekleyen dersiniz henüz yok.");
        		else
        		{
        			loginolan.dersEkle();
        			JOptionPane.showMessageDialog(frame, "Bekleyen dersler onaylandı.");
        			updatePanel(panel_2, loginolan);
        		}
        		
        	}
        });
        dersIslemleriPanel.add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Bekleyen dersleri listele");
        btnNewButton_3.setBounds(32, 291, 214, 31);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (loginolan.bekleyenDersler.isEmpty()) {
        			JOptionPane.showMessageDialog(frame, "Bekleyen ders henüz yok", "Hata", JOptionPane.ERROR_MESSAGE);
        		} else {
        			updatePanel(panel_2, loginolan);
        		}
        	}
        });
        dersIslemleriPanel.add(btnNewButton_3);
        
        tabbedPane.addTab("Ders İşlemleri", dersIslemleriPanel);
        
        
        
        /*
         	* NOT GİRİŞ PANELİ 
         						*/
        
        JPanel notGirisiPanel = new JPanel();
        notGirisiPanel.setLayout(null);

        JList<String> studentList = new JList<>();
        studentList.setBounds(10, 11, 87, 311);
        notGirisiPanel.add(studentList);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(107, 11, 368, 311);
        notGirisiPanel.add(panel_3);

        JButton btnNewButton_5 = new JButton("Yükle");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = new DefaultListModel<>();
                for (Ogrenci ogrenci : loginolan.alinanDersler.keySet()) {
                    model.addElement(ogrenci.isim);
                }
                studentList.setModel(model);
            }
        });
        btnNewButton_5.setBounds(480, 299, 89, 23);
        notGirisiPanel.add(btnNewButton_5);

        studentList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedOgrenci = studentList.getSelectedValue();
                    if (selectedOgrenci != null) {
                        updateOgrenciDersleriPanel(selectedOgrenci, loginolan, panel_3);
                    }
                }
            }
        });
        tabbedPane.addTab("Not Girişi", notGirisiPanel);
        
        
        
        
        /*
         	* MESAJ KUTUSU VE MESAJ GÖNDERME PANELİ 
         											*/
        
        
        JPanel mesajAtmaPanel1 = new JPanel();
        mesajAtmaPanel1.setLayout(null);

        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel1);
        JScrollPane scrollPane11 = new JScrollPane(list);
        scrollPane11.setBounds(10, 11, 87, 311);
        mesajAtmaPanel1.add(scrollPane11);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(107, 11, 380, 280);
        panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
        mesajAtmaPanel1.add(panel_4);

        JButton btnNewButton_7 = new JButton("Yenile");
        btnNewButton_7.setBounds(497, 268, 72, 23);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listModel1.clear();
                for (Ogrenci ogrenci : Ogrenciler) {
                    listModel1.addElement(ogrenci.isim);
                }
                for (OgretimUyesi ogretmen : Ogretmenler) {
                    if (!ogretmen.equals(loginolan)) {
                        listModel1.addElement(ogretmen.isim);
                    }
                }
                panel_4.removeAll();
            }
        });
        mesajAtmaPanel1.add(btnNewButton_7);

        JTextField textField_12 = new JTextField();
        textField_12.setBounds(107, 302, 380, 20);
        mesajAtmaPanel1.add(textField_12);

        JButton btnNewButton_8 = new JButton("Gönder");
        btnNewButton_8.setBounds(497, 302, 72, 23);
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedUser = list.getSelectedValue();
                String newMessage = textField_12.getText().trim();

                if (selectedUser == null) {
                    JOptionPane.showMessageDialog(null, "Lütfen bir kişi seçin!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (newMessage.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen bir mesaj yazın!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                loginolan.mesajlar.putIfAbsent(selectedUser, new ArrayList<>()); // Eğer yoksa oluştur
                loginolan.mesajlar.get(selectedUser).add("Siz: " + newMessage);

                Object alici = null;
                for (Ogrenci ogrenci : Ogrenciler) {
                    if (ogrenci.isim.equals(selectedUser)) {
                        alici = ogrenci;
                        break;
                    }
                }
                for (OgretimUyesi ogretmen : Ogretmenler) {
                    if (ogretmen.isim.equals(selectedUser)) {
                        alici = ogretmen;
                        break;
                    }
                }

                if (alici != null) {
                    if (alici instanceof Ogrenci) {
                        Ogrenci ogrenci = (Ogrenci) alici;
                        ogrenci.mesajlar.putIfAbsent(loginolan.isim, new ArrayList<>()); 
                        ogrenci.mesajlar.get(loginolan.isim).add(loginolan.isim + ": " + newMessage);
                    } else if (alici instanceof OgretimUyesi) {
                        OgretimUyesi ogretmen = (OgretimUyesi) alici;
                        ogretmen.mesajlar.putIfAbsent(loginolan.isim, new ArrayList<>()); 
                        ogretmen.mesajlar.get(loginolan.isim).add(loginolan.isim + ": " + newMessage);
                    }
                }
                updateMesajPanel(selectedUser, loginolan, panel_4);

                textField_12.setText("");
            }
        });

        mesajAtmaPanel1.add(btnNewButton_8);

        // JList seçilen öğrenci
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedUser = list.getSelectedValue();
                if (selectedUser != null) {
                    updateMesajPanel(selectedUser, loginolan, panel_4);
                }
            }
        });
        tabbedPane.addTab("Mesaj Atma", mesajAtmaPanel1);
        ogretmenFrame.getContentPane().add(tabbedPane);


        
        
        /*
         	* AYARLAR ŞİFRE/NUMARA DĞEİŞTİRME PANELİ 
         												*/
        
        JPanel ayarlarPanel = new JPanel();
        ayarlarPanel.setLayout(null);
        tabbedPane.addTab("Ayarlar", null, ayarlarPanel, null);
        
        JLabel label_1 = new JLabel("Ayarlar: Şifre/Numara değiştirme ekranı.");
        label_1.setBounds(220, 9, 210, 14);
        ayarlarPanel.add(label_1);
        
        JButton logoutButton_1 = new JButton("Çıkış Yap");
        logoutButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ogretmenFrame.dispose();
        		main(null);
        	}
        });
        logoutButton_1.setBounds(240, 282, 99, 40);
        ayarlarPanel.add(logoutButton_1);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(209, 209, 209));
        panel.setBounds(10, 53, 251, 213);
        ayarlarPanel.add(panel);
        
        JButton btnNewButton_2 = new JButton("Değiştir");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textField_6.getText().isEmpty() || textField_7.getText().isEmpty() || textField_8.getText().isEmpty())
    			{
                	JOptionPane.showMessageDialog(frame, "Lütfen gerekli yerleri doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
    			}
    			else
    			{
    				if(textField_6.getText().equals(loginolan.sifre) && !textField_6.getText().equals(textField_7.getText()) && textField_8.getText().equals(textField_7.getText()))
    				{
                    	JOptionPane.showMessageDialog(frame, "Şifreniz değiştiriliyor, güvenlik sebebiyle çıkış yapılacaktır.");
                    	loginolan.sifre = textField_7.getText();
                    	ogretmenFrame.dispose();
            			main(null);
    				}
    				else
    				{
    					if(!textField_6.getText().equals(loginolan.sifre))
    						JOptionPane.showMessageDialog(frame, "Eski şifreniz uyuşmuyor.", "Hata", JOptionPane.ERROR_MESSAGE);
    					else if(textField_6.getText().equals(textField_7.getText()))
    						JOptionPane.showMessageDialog(frame, "Eski şifre ile yeni şifre aynı olamaz.", "Hata", JOptionPane.ERROR_MESSAGE);
    					else
    						JOptionPane.showMessageDialog(frame, "Yeni şifreler uyuşmuyor.", "Hata", JOptionPane.ERROR_MESSAGE);
    				}
    			}
        	}
        });
        btnNewButton_2.setBounds(74, 163, 89, 23);
        panel.add(btnNewButton_2);
        
        JLabel lblNewLabel_3 = new JLabel("Eski şifre:");
        lblNewLabel_3.setBackground(Color.WHITE);
        lblNewLabel_3.setBounds(10, 11, 67, 32);
        panel.add(lblNewLabel_3);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(109, 17, 86, 20);
        panel.add(textField_6);
        
        JLabel lblNewLabel_3_1 = new JLabel("Yeni şifre:");
        lblNewLabel_3_1.setBackground(Color.WHITE);
        lblNewLabel_3_1.setBounds(10, 56, 67, 32);
        panel.add(lblNewLabel_3_1);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(109, 62, 86, 20);
        panel.add(textField_7);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Tekrar yeni şifre:");
        lblNewLabel_3_1_1.setBackground(Color.WHITE);
        lblNewLabel_3_1_1.setBounds(10, 99, 89, 32);
        panel.add(lblNewLabel_3_1_1);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        textField_8.setBounds(109, 105, 86, 20);
        panel.add(textField_8);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(209, 209, 209));
        panel_1.setBounds(318, 53, 251, 213);
        ayarlarPanel.add(panel_1);
        
        JButton btnNewButton_2_1 = new JButton("Değiştir");
        btnNewButton_2_1.setBounds(74, 163, 89, 23);
        panel_1.add(btnNewButton_2_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("Eski kullanıcı adı:");
        lblNewLabel_3_2.setBackground(Color.WHITE);
        lblNewLabel_3_2.setBounds(10, 11, 89, 32);
        panel_1.add(lblNewLabel_3_2);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(109, 17, 86, 20);
        panel_1.add(textField_9);
        
        JLabel lblNewLabel_3_1_2 = new JLabel("Yeni kullanıcı adı:");
        lblNewLabel_3_1_2.setBackground(Color.WHITE);
        lblNewLabel_3_1_2.setBounds(10, 56, 89, 32);
        panel_1.add(lblNewLabel_3_1_2);
        
        textField_10 = new JTextField();
        textField_10.setColumns(10);
        textField_10.setBounds(109, 62, 86, 20);
        panel_1.add(textField_10);
        
        JLabel lblNewLabel_3_1_1_1 = new JLabel("Şifre:");
        lblNewLabel_3_1_1_1.setBackground(Color.WHITE);
        lblNewLabel_3_1_1_1.setBounds(10, 99, 89, 32);
        panel_1.add(lblNewLabel_3_1_1_1);
        
        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(109, 105, 86, 20);
        panel_1.add(textField_11);
        
        JLabel lblNewLabel_4 = new JLabel("Şifre değiştirme ekranı");
        lblNewLabel_4.setBounds(62, 28, 152, 14);
        ayarlarPanel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Kullanıcı adı değiştirme ekranı");
        lblNewLabel_5.setBounds(382, 28, 187, 14);
        ayarlarPanel.add(lblNewLabel_5);
        ogretmenFrame.setVisible(true);
    }
    
    
    // BEKLEYEN DERSLERİ LİSTELEME, TEKTEK ONAYLAMA, GÜNCELLEME METHOODU
    public static void updatePanel(JPanel panel_2, OgretimUyesi loginolan) {
        panel_2.removeAll();
        int columns = 4; 
        panel_2.setLayout(new GridLayout(0, columns));

        for (Map.Entry<String, Ogrenci> deger : loginolan.bekleyenDersler.entrySet()) {
            String isim = deger.getValue().isim;
            String key = deger.getKey();
			int separatorIndex = key.indexOf(" | ");
			String dersAdi = key.substring(separatorIndex + 3);

            JLabel isimLabel = new JLabel(isim);
            JLabel dersLabel = new JLabel(dersAdi);

            JButton onaylaButton = new JButton("Onayla");
            JButton reddetButton = new JButton("Reddet");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);
            gbc.gridx = panel_2.getComponentCount() % columns;
            gbc.gridy = panel_2.getComponentCount() / columns;
            panel_2.add(isimLabel, gbc);
            gbc.gridx = panel_2.getComponentCount() % columns;
            panel_2.add(dersLabel, gbc);
            gbc.gridx = panel_2.getComponentCount() % columns;
            panel_2.add(onaylaButton, gbc);
            gbc.gridx = panel_2.getComponentCount() % columns;
            panel_2.add(reddetButton, gbc);

            onaylaButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	String key = deger.getKey();
        	        int separatorIndex = key.indexOf(" | ");
        	        if (separatorIndex != -1) {
        	            String dersAdi = key.substring(separatorIndex + 3);
        	            deger.getValue().dersler.add(dersAdi);
        	            deger.getValue().notlar.put(dersAdi, -1);
        	            
        	            if (!loginolan.alinanDersler.containsKey(deger.getValue())) {
        	                loginolan.alinanDersler.put(deger.getValue(), new ArrayList<String>());
        	            }
        	            loginolan.alinanDersler.get(deger.getValue()).add(dersAdi);
        	        }
    			    loginolan.bekleyenDersler.remove(key);
                    JOptionPane.showMessageDialog(frame, "Ders onaylandı: " + dersAdi);
                    updatePanel(panel_2, loginolan);
                }
            });

            reddetButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "Ders reddedildi: " + dersAdi);
                    loginolan.bekleyenDersler.remove(key);
                    updatePanel(panel_2, loginolan);
                }
            });
        }

        panel_2.revalidate();
        panel_2.repaint();
    }
    
    // MESAJ EKRANI
    static void updateMesajPanel(String selectedUser, OgretimUyesi loginolan, JPanel panel_4) {
        panel_4.removeAll();
        ArrayList<String> mesajlar = loginolan.mesajlar.getOrDefault(selectedUser, new ArrayList<>());

        if (mesajlar.isEmpty()) {
            panel_4.add(new JLabel("Henüz mesaj yok."));
        } else {
            for (String message : mesajlar) {
                panel_4.add(new JLabel(message));
            }
        }

        panel_4.revalidate();
        panel_4.repaint();
    }
    
    //NOT GİRME PANEL GÜNCELLEME
    private static void updateOgrenciDersleriPanel(String ogrenciAdi, OgretimUyesi loginolan, JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Ogrenci ogrenci : loginolan.alinanDersler.keySet()) {
            if (ogrenci.isim.equals(ogrenciAdi)) {
                ArrayList<String> dersler = loginolan.alinanDersler.get(ogrenci);
                for (String ders : dersler) {
                    JPanel dersPanel = new JPanel();
                    dersPanel.setLayout(new FlowLayout());
                    JLabel dersLabel = new JLabel(ders);
                    dersPanel.add(dersLabel);
                    Integer mevcutNot = ogrenci.notlar.getOrDefault(ders, -1);
                    JTextField notField = new JTextField(String.valueOf(mevcutNot), 5); 
                    dersPanel.add(notField);
                    JButton notButton = new JButton("Güncelle");
                    notButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String notText = notField.getText();
                            if (!notText.isEmpty()) {
                                int not = Integer.parseInt(notText);
                                loginolan.notGir(ogrenci.id, ders, not);
                                JOptionPane.showMessageDialog(panel, "Not başarıyla güncellendi.");
                            } else {
                                JOptionPane.showMessageDialog(panel, "Lütfen notu girin.", "Hata", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    dersPanel.add(notButton);

                    panel.add(dersPanel);
                }
                break;
            }
        }
        panel.revalidate();
        panel.repaint();
    }
}


