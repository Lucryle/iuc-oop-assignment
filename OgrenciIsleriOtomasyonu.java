package OgrenciIsleriOtomasyonu;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.GridLayout;

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
    	
    	
    	OgretimUyesi testogretmen = new OgretimUyesi("testogretmen", "zeynep", "testsifre");
    	Ogretmenler.add(testogretmen);

    	Ogrenci testogrenci = new Ogrenci("testogrenci", "burki", "testsifre", testogretmen);
    	Ogrenciler.add(testogrenci);
    	Ogrenci testogrenci2 = new Ogrenci("testogrenci2", "zeyno", "testsifre", testogretmen);
    	Ogrenciler.add(testogrenci2);
 
        frame = new JFrame("Öğrenci İşleri Otomasyonu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        
        
        
        //ogretmenSayfasi(testogretmen);
        
        //ogrenciSayfasi();
        placeComponents(panel);

        
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Kullanıcı Türü:");
        userLabel.setBounds(10, 20, 100, 25);
        panel.add(userLabel);

        JCheckBox checkbox = new JCheckBox("Beni hatırla");
        checkbox.setBounds(10, 138, 97, 23);
        panel.add(checkbox);
        
        String[] userTypes = {"Öğrenci", "Öğretmen"};
        JComboBox<String> userTypeCombo = new JComboBox<>(userTypes);
        userTypeCombo.setBounds(120, 20, 165, 25);
        panel.add(userTypeCombo);

        JLabel idLabel = new JLabel("Kullanıcı ID:");
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
        loginButton.setBounds(10, 168, 150, 25);
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
    
    private static void ogrenciSayfasi(Ogrenci loginolan) {
    	JFrame ogrenciFrame = new JFrame("Öğrenci Sayfası");
        ogrenciFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	ogrenciFrame.setSize(600, 400);
    	ogrenciFrame.getContentPane().setLayout(null);
    	
    	JTabbedPane tabbedPane = new JTabbedPane();
    	tabbedPane.setBounds(0, 0, 584, 361);
    	
    	JPanel kisiselBilgilerPanel = new JPanel();
    	kisiselBilgilerPanel.setLayout(null);
    	
    	JPanel dersSecimiPanel = new JPanel();
    	dersSecimiPanel.setLayout(null);
    	
    	JPanel notGoruntulemePanel = new JPanel();
    	notGoruntulemePanel.add(new JLabel("Not Görüntüleme: Matematik: 90, Fizik: 85"));
    	
    	JPanel mesajAtmaPanel = new JPanel();
    	mesajAtmaPanel.add(new JLabel("Mesaj Atma: Mesaj gönderme ekranı."));
    	
    	JPanel ayarlarPanel = new JPanel();
    	ayarlarPanel.setLayout(null);
    	JLabel label = new JLabel("Ayarlar: Şifre değiştirme ekranı.");
    	label.setBounds(220, 9, 152, 14);
    	ayarlarPanel.add(label);
    	
    	tabbedPane.addTab("Kişisel Bilgiler", kisiselBilgilerPanel);
    	
    	JLabel lblNewLabel = new JLabel("Ad, Soyad: ");
    	lblNewLabel.setBounds(10, 11, 97, 38);
    	kisiselBilgilerPanel.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("numara");
    	lblNewLabel_1.setBounds(10, 60, 97, 55);
    	kisiselBilgilerPanel.add(lblNewLabel_1);
    	tabbedPane.addTab("Ders Seçimi", dersSecimiPanel);
    	
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
    					loginolan.dersSec(secilenders);
                	JOptionPane.showMessageDialog(frame, "Seçilen dersler danışman onayına gönderildi.");

    			}
    		}
    		
    	});
    	btnNewButton.setBounds(37, 218, 89, 23);
    	dersSecimiPanel.add(btnNewButton);
    	
    	JButton logoutButton = new JButton("Çıkış Yap");
    	logoutButton.setBounds(240, 282, 99, 40);
    	logoutButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			ogrenciFrame.dispose();
    			main(null);
    		}
    	});
    	ayarlarPanel.add(logoutButton);
    	
    	tabbedPane.addTab("Not Görüntüleme", notGoruntulemePanel);
    	tabbedPane.addTab("Mesaj Atma", mesajAtmaPanel);
    	tabbedPane.addTab("Ayarlar", ayarlarPanel);
    	
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
                    	loginolan.sifre = textField_1.getText();
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
    	
    	
    	ogrenciFrame.getContentPane().add(tabbedPane);
    	ogrenciFrame.setVisible(true);
    }

    private static void ogretmenSayfasi(OgretimUyesi loginolan) {
        JFrame ogretmenFrame = new JFrame("Öğretmen Sayfası");
        ogretmenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ogretmenFrame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel kisiselBilgilerPanel = new JPanel();
        kisiselBilgilerPanel.add(new JLabel("Kişisel Bilgiler: Dr. Ahmet, ID: 2001"));

        JPanel dersIslemleriPanel = new JPanel();
        dersIslemleriPanel.setBackground(new Color(255, 255, 255));
        dersIslemleriPanel.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Bekleyen Dersleri Onayla");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(loginolan.bekleyenDersler.isEmpty())
                	JOptionPane.showMessageDialog(frame, "Bekleyen dersiniz henüz yok.");
        		else
        		{
        			loginolan.dersEkle();
                	JOptionPane.showMessageDialog(frame, "Bekleyen dersler onaylandı.");
        		}

        	}
        });
        btnNewButton_1.setBounds(388, 291, 169, 31);
        dersIslemleriPanel.add(btnNewButton_1);
        JLabel label = new JLabel("Ders İşlemleri: Yeni ders ekleme/silme ekranı.");
        label.setBounds(229, 9, 214, 14);
        dersIslemleriPanel.add(label);

        JPanel notGirisiPanel = new JPanel();
        notGirisiPanel.add(new JLabel("Not Girişi: Öğrenciye not girme ekranı."));

        JPanel mesajAtmaPanel = new JPanel();
        mesajAtmaPanel.add(new JLabel("Mesaj Atma: Mesaj gönderme ekranı."));
        
        tabbedPane.addTab("Kişisel Bilgiler", kisiselBilgilerPanel);
        tabbedPane.addTab("Ders İşlemleri", dersIslemleriPanel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(32, 31, 522, 249);
        dersIslemleriPanel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 1));
        JButton btnNewButton_3 = new JButton("Bekleyen dersleri listele");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    if (loginolan.bekleyenDersler.isEmpty()) {
        	        JOptionPane.showMessageDialog(frame, "Bekleyen ders henüz yok", "Hata", JOptionPane.ERROR_MESSAGE);
        	    } else {
        	        panel_2.removeAll();
        	        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        	        for (Map.Entry<String, Ogrenci> deger : loginolan.bekleyenDersler.entrySet()) {
        	            if (deger.getKey() == null) {
        	                System.out.println("Hata: Ders adı null.");
        	            }
        	            JLabel label = new JLabel(deger.getValue().isim + " | " + deger.getValue().id + " | " + deger.getKey());
        	            panel_2.add(label);
        	        }
        	        panel_2.revalidate();
        	        panel_2.repaint();
        	    }
        	}
        });
        btnNewButton_3.setBounds(32, 291, 169, 31);
        dersIslemleriPanel.add(btnNewButton_3);
        
        tabbedPane.addTab("Not Girişi", notGirisiPanel);
        tabbedPane.addTab("Mesaj Atma", mesajAtmaPanel);

        ogretmenFrame.getContentPane().add(tabbedPane);
        
        JPanel ayarlarPanel = new JPanel();
        ayarlarPanel.setLayout(null);
        tabbedPane.addTab("Ayarlar", null, ayarlarPanel, null);
        
        JLabel label_1 = new JLabel("Ayarlar: Şifre değiştirme ekranı.");
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
}
