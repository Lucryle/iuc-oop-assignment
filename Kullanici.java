package OgrenciIsleriOtomasyonu;

abstract class Kullanici implements VeriIslemleri {
    protected String id;
    protected String isim;
    protected String sifre;

    public Kullanici(String id, String isim, String sifre) {
        this.id = id;
        this.isim = isim;
        this.sifre = sifre;
    }

    public void sifreDegistir(String yeniSifre) {
        this.sifre = yeniSifre;
        System.out.println("Şifre başarıyla değiştirildi.");
    }
}
