package OgrenciIsleriOtomasyonu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
class OgretimUyesi extends Kullanici implements OgretmenIslemleri, VeriIslemleri {
    public Map<String, Ogrenci> bekleyenDersler;
    public Map<Ogrenci, ArrayList<String>> alinanDersler;

    public OgretimUyesi(String id, String isim, String sifre) {
        super(id, isim, sifre);
        this.bekleyenDersler = new HashMap<String, Ogrenci>();
        this.alinanDersler = new HashMap<Ogrenci, ArrayList<String>>();
    }


	public void idDegistir(String yeniId) {
		id = yeniId;
	}

	public void notGir(String ogrenciId, String dersKodu, int not) {
	    Ogrenci ogrenci = null;
	    for (Map.Entry<Ogrenci, ArrayList<String>> entry : alinanDersler.entrySet()) {
	        if (entry.getKey().id.equals(ogrenciId)) {
	            ogrenci = entry.getKey();
	            break;
	        }
	    }
	    if (ogrenci != null && ogrenci.dersler.contains(dersKodu))
	        ogrenci.notlar.put(dersKodu, not);
	}


	public void dersEkle() {
	    for (Map.Entry<String, Ogrenci> deger : bekleyenDersler.entrySet()) {
	        String key = deger.getKey();
	        int separatorIndex = key.indexOf(" | ");
	        if (separatorIndex != -1) {
	            String dersAdi = key.substring(separatorIndex + 3);
	            deger.getValue().dersler.add(dersAdi);
	            deger.getValue().notlar.put(dersAdi, -1);
	            
	            if (!alinanDersler.containsKey(deger.getValue())) {
	                alinanDersler.put(deger.getValue(), new ArrayList<String>());
	            }
	            alinanDersler.get(deger.getValue()).add(dersAdi);
	        }
	    }
	    bekleyenDersler.clear();
	}

}