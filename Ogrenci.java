package OgrenciIsleriOtomasyonu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Ogrenci extends Kullanici implements OgrenciIslemleri, VeriIslemleri {
    public ArrayList<String> dersler;
    public Map<String, Integer> notlar;
    public OgretimUyesi danismanHoca;

    public Ogrenci(String id, String isim, String sifre, OgretimUyesi danisman) {
        super(id, isim, sifre);
        danismanHoca = danisman;
        this.dersler = new ArrayList<>();
        this.notlar = new HashMap<>();
    }
    public void sifreDegistir(String yeniSifre) {
    	sifre = yeniSifre;
    }

    @Override
    public void dersSec(String dersAdi) {
        danismanHoca.bekleyenDersler.put(dersAdi, this);
    }


    public void notSorgula(String dersKodu) {
        
    }

	public void idDegistir(String yeniId) {
		id = yeniId;
	}
}