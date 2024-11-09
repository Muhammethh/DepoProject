package depoProject;

public class Urun {
    public int id;
    public String isim;
    public String uretici;
    public int miktar;
    public String birim;
    public String raf;

    // Ürün sınıfı oluşturuluyor, başlangıç değerleri ayarlanıyor.
    public Urun(int id, String isim, String uretici, String birim) {
        this.id = id;
        this.isim = isim;
        this.uretici = uretici;
        this.miktar = 0;
        this.birim = birim;
        this.raf = "null"; // Başlangıçta raf atanmadığı için "null"
    }




    @Override
    public String toString() {
        // Başlıkları da formatlı yazdırmak için tek seferde yazdırıyoruz
        return String.format("%-10d %-15s %-17s %-12d %-15s %-10s", id, isim, uretici, miktar, birim, raf);
    }


}