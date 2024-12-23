package OgrenciIsleriOtomasyonu;

interface OgretmenIslemleri {
    void dersEkle();
    void dersSil(String dersKodu);
    void notGir(String dersKodu, int not);
}