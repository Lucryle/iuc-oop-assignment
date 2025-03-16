package OgrenciIsleriOtomasyonu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Kullanici implements VeriIslemleri {
    public String id;
    public String isim;
    public String sifre;
    public Map<String, ArrayList<String>> mesajlar;

    public Kullanici(String id, String isim, String sifre) {
        this.id = id;
        this.isim = isim;
        this.sifre = sifre;
        this.mesajlar = new HashMap<>();
    }

    public void sifreDegistir(String yeniSifre) {
        this.sifre = yeniSifre;
    }
}
