package OgrenciIsleriOtomasyonu;

import java.util.HashMap;
import java.util.Map;
class OgretimUyesi extends Kullanici implements OgretmenIslemleri, VeriIslemleri {
    public Map<String, Ogrenci> bekleyenDersler;

    public OgretimUyesi(String id, String isim, String sifre) {
        super(id, isim, sifre);
        this.bekleyenDersler = new HashMap<String, Ogrenci>();
    }


    public void notGir(String ogrenciId, String dersKodu, int not) {
        System.out.println(ogrenciId + " öğrencisine " + dersKodu + " için not girildi: " + not);
    }


	public void idDegistir(String yeniId) {
		id = yeniId;
	}

	public void dersSil(String dersKodu) {
		// TODO Auto-generated method stub
		
	}

	public void notGir(String dersKodu, int not) {
		// TODO Auto-generated method stub
		
	}

	public void dersEkle() {
		for (Map.Entry<String, Ogrenci> deger : bekleyenDersler.entrySet()) {
	        deger.getValue().dersler.add(deger.getKey());
	    }
		bekleyenDersler.clear();
	}
}