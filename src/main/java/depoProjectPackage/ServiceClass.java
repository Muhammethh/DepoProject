package depoProjectPackage;


import java.util.*;

public class ServiceClass {

    Map<Integer, PojoClass> urunListesi = new HashMap<>();
    PojoClass ürün = new PojoClass();
    Scanner input = new Scanner(System.in);

    public void urunTanimlama() {
        input.nextLine();
        int sayac = 1;

        while (sayac != 0) {


            System.out.println("Ürün ismini giriniz");
            String urunAdi = input.nextLine();


            String[] urunKelimeler = urunAdi.split(" ");

            try {
                if (urunAdi.contains(" ")) {
                    urunAdi = urunKelimeler[0].substring(0, 1).toUpperCase() + urunKelimeler[0].substring(1).toLowerCase() + " "
                            + urunKelimeler[1].substring(0, 1).toUpperCase() + urunKelimeler[1].substring(1).toLowerCase();

                } else {
                    urunAdi = urunKelimeler[0].substring(0, 1).toUpperCase() + urunKelimeler[0].substring(1).toLowerCase();
                }
            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Kelime sonunda boşluk tespit edildi");
                urunAdi = urunKelimeler[0].substring(0, 1).toUpperCase() + urunKelimeler[0].substring(1).toLowerCase();

            } //ürün adı olarak 3.kelimeyi alamıyoruz 😁


            System.out.println("Ürün üreticisini giriniz");
            String üretici = input.nextLine();
            String[] ureticiKelimeler = üretici.split(" ");

            try {
                if (üretici.contains(" ")) {

                    üretici = ureticiKelimeler[0].substring(0, 1).toUpperCase() + ureticiKelimeler[0].substring(1).toLowerCase() + " "
                            + ureticiKelimeler[1].substring(0, 1).toUpperCase() + ureticiKelimeler[1].substring(1).toLowerCase();

                } else {
                    üretici = ureticiKelimeler[0].substring(0, 1).toUpperCase() + ureticiKelimeler[0].substring(1).toLowerCase();
                }
            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Kelime sonunda boşluk tespit edildi");
                üretici = urunKelimeler[0].substring(0, 1).toUpperCase() + urunKelimeler[0].substring(1).toLowerCase();

            }


            System.out.println("Ürün birimini giriniz");
            String birim = input.nextLine();

            System.out.println("Ürün ID'yi giriniz");
            int id = input.nextInt();

            ürün = new PojoClass(urunAdi, üretici, birim, id);

            this.urunListesi.put(ürün.ürünId, ürün);

            System.out.println("Çıkış için 0'a basın, devam etmek için herhangi bir rakama basınız"); //burada rakam
            sayac = input.nextInt();
            input.nextLine();
        }

        System.out.println("ürünListesi = " + urunListesi);

    }


    public void urunuRafaKoy() {


        System.out.println("Rafa koymak istenilen ürün ID'sini giriniz");
        int id = input.nextInt();

        if (!this.urunListesi.containsKey(id)) {

            while (true) {

                System.out.println(id + " Numaralı ürün depoda bulunmamaktadır,lütfen farklı bir ID giriniz");
                for (Map.Entry<Integer, PojoClass> w : urunListesi.entrySet()) {
                    System.out.println("ID: " + w.getKey() + " - Ürün Adı: " + w.getValue().getÜrünIsmi() + " Ürün stoğu: " + w.getValue().getMiktar());
                }
                id = input.nextInt();

                if (this.urunListesi.containsKey(id)) {
                    break;
                }
            }

        }

        System.out.println("Raf numarasını giriniz");
        int raf2 = input.nextInt();

        ürün = this.urunListesi.get(id);
        ürün.setRaf(raf2);

        System.out.println(ürün.getÜrünIsmi() + " ürünü " + ürün.getRaf() + " rafına konuldu.");
        System.out.println("ürünListesi = " + urunListesi);

    }


    public void urunGirişi() {

        System.out.println("Miktar eklemek istenilen ürün ID'sini giriniz");
        input.nextLine();
        int id = input.nextInt();


        if (!this.urunListesi.containsKey(id)) {

            while (true) {

                System.out.println(id + " Numaralı ürün depoda bulunmamaktadır,lütfen farklı bir ID giriniz");
                for (Map.Entry<Integer, PojoClass> w : urunListesi.entrySet()) {
                    System.out.println("ID: " + w.getKey() + " - Ürün Adı: " + w.getValue().getÜrünIsmi() + " Ürün stoğu: " + w.getValue().getMiktar());
                }
                id = input.nextInt();

                if (this.urunListesi.containsKey(id)) {
                    break;
                }
            }

        }

        System.out.println("Adet giriniz");
        int miktar = input.nextInt();

        ürün = this.urunListesi.get(id);
        ürün.setMiktar(miktar + ürün.getMiktar());

        System.out.println(ürün.getÜrünIsmi() + " ürünü " + ürün.getMiktar() + " olarak güncellendi.");
        System.out.println("ürünListesi = " + urunListesi);


    }


    public void urunÇıkışı() {

        System.out.println("Çıkış yapmak istenilen ürün ID'sini giriniz");
        int id = input.nextInt();


        if (!this.urunListesi.containsKey(id)) {

            while (true) {

                System.out.println(id + " Numaralı ürün depoda bulunmamaktadır,lütfen farklı bir ID giriniz");
                for (Map.Entry<Integer, PojoClass> w : urunListesi.entrySet()) {
                    System.out.println("ID: " + w.getKey() + " - Ürün Adı: " + w.getValue().getÜrünIsmi() + " Ürün stoğu: " + w.getValue().getMiktar());
                }
                id = input.nextInt();

                if (this.urunListesi.containsKey(id)) {
                    break;
                }
            }

        }

        System.out.println("Adet giriniz");
        int miktar = input.nextInt();

        while (true) {

            if (miktar < 0) {

                System.out.println("Geçersiz miktar girildi");
                System.out.printf("Lütfen yeni bir miktar giriniz");

                miktar = input.nextInt();
                continue;
            }
            if (ürün.getMiktar() < miktar) {

                System.out.println("Ürün miktarı yeterli değil");
                System.out.println(ürün.getÜrünIsmi() + " ürünü " + ürün.getMiktar() + " " + ürün.getBirim() + " bulunmaktadır.");
                System.out.println("Lütfen yeni bir miktar giriniz");

                miktar = input.nextInt();
                continue;

            } else {

                ürün = this.urunListesi.get(id);
                ürün.setMiktar(ürün.getMiktar() - miktar);


            }

            break;
        }

        System.out.println(ürün.getÜrünIsmi() + " ürünü " + ürün.getMiktar() + " " + ürün.getBirim() + " olarak güncellendi.");

    }


    public void urunListele() {

        System.out.printf("%7s %10s %15s %10s %10s %10s", "ID", "İsmi", "Üreticisi", "Miktari", "Birimi", "Raf");
        System.out.printf("%n" + "-".repeat(80) + "%n");
        for (Map.Entry<Integer, PojoClass> w : urunListesi.entrySet()) {

            System.out.printf("%7s %10s %15s %10s %10s %10s %n", w.getKey(), w.getValue().getÜrünIsmi(), w.getValue().getÜretici(), w.getValue().getMiktar(), w.getValue().getBirim(), w.getValue().getRaf());
            System.out.println("——————————————————————————".repeat(3));
        }
        System.out.println("\n".repeat(2));



    }


    public void start() {

        while (true){
            System.out.println("\n".repeat(2));

            System.out.printf("-".repeat(10) + "DEPO ANA MENÜ" + "-".repeat(10) + "\n");
            System.out.println("LÜTFEN YAPMAK İSTEDİĞİNİZ İŞLEMİ SEÇİNİZ\n" +
                    "1-> Ürün Tanımlama        \n" +
                    "2-> Ürün Girişi           \n" +
                    "3-> Ürün Listeleme        \n" +
                    "4-> Ürün Rafa Yerleştirme \n" +
                    "5-> Ürün Çıkışı           \n" +
                    "6-> Çıkış           \n");
            int seçim = input.nextInt();
            switch (seçim) {

                case 1:
                    urunTanimlama();
                    break;
                case 2:
                    urunGirişi();
                    break;
                case 3:
                    urunListele();
                    break;
                case 4:
                    urunuRafaKoy();
                    break;
                case 5:
                    urunÇıkışı();
                    break;
                case 6:
                    System.out.println("Çıkış Yapılıyor");
                    return;
                default:
                    System.out.printf("Geçersiz değer girildi");
                    break;

            }


        }


    }

}



