package depoProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Depo {
    static ArrayList<Urun> urunListesi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int idCounter = 1000;

    // 1. Ürün Tanımlama
    public static void urunTanimlama() {
        System.out.print("Ürün ismi: ");
        String isim = scanner.nextLine();
        System.out.print("Üretici: ");
        String uretici = scanner.nextLine();
        System.out.print("Birim: ");
        String birim = scanner.nextLine();

        Urun yeniUrun = new Urun(idCounter++, isim, uretici, birim);
        urunListesi.add(yeniUrun);
        System.out.println("Ürün başarıyla tanımlandı. Ürün ID: " + yeniUrun.id);
        System.out.println("\n".repeat(2));
    }

    // 2. Ürün Listeleme
    public static void urunListeleme() {
        System.out.printf("%-10s %-15s %-17s %-12s %-15s %-10s",
                "ID", "İsim", "Üretici", "Miktar", "Birim", "Raf ");
        System.out.println(" \n" + "----------------------------------------------------------------------------------- ");
        for (Urun urun : urunListesi) {
            System.out.println(urun);  // Her bir ürünün toString formatında çıktısı alınır
        }
        System.out.println("\n".repeat(2));
    }

    // 3. Ürün Girişi
    public static void urunGirisi() {
        int miktar = 0;
        boolean idVarmı = false;
        Urun seçilenUrun = null;

        while (!idVarmı) {
            System.out.print("Giriş yapılacak ürünün ID'sini girin: ");
            int id = scanner.nextInt();

            for (Urun urun : urunListesi) {
                if (urun.id == id) {
                    idVarmı = true;
                    seçilenUrun = urun;
                    System.out.println("\n".repeat(2));
                    break;
                }
            }

            if (!idVarmı) {
                System.out.println("ID bulunamadı lütfen farklı ID giriniz");

            }


        }

        while (true) {

            System.out.print("Giriş yapılacak miktarı girin: ");
            miktar = scanner.nextInt();
            scanner.nextLine(); // Scanner tamponunu temizlemek için

            if (miktar <= 0) {
                System.out.println("Giriş yapılacak miktar sıfırdan büyük olmalıdır.");
            } else {
                seçilenUrun.miktar += miktar;
                System.out.println("Ürün girişi yapıldı. Güncel miktar: " + seçilenUrun.miktar + " " + seçilenUrun.birim + " " + seçilenUrun.isim + " ");
                break;
            }

        }
        System.out.println("\n".repeat(2));

    }

    // 4. Ürünü Rafa Koyma
    public static void urunuRafaKoy() {
        int id = 0;
        Urun seçilenUrun = null;
        boolean idVarmı = false;
        while (!idVarmı) {

            System.out.print("Rafa koymak istediğiniz ürünün ID'sini girin: ");
            id = scanner.nextInt();
            scanner.nextLine();
            for (Urun urun : urunListesi) {
                if (urun.id == id) {
                    seçilenUrun = urun;
                    idVarmı = true;
                    break;

                } else {
                    System.out.println("Ürün ID bulunamadı.");

                }
            }
        }

        if (seçilenUrun.id == id) {

            System.out.print("Raf numarasını girin: ");
            String raf = scanner.nextLine();
            seçilenUrun.raf = raf;
            System.out.println(seçilenUrun.isim + " raf numarası " + seçilenUrun.raf + " olarak güncellenci");
        }

        System.out.println("\n".repeat(2));


    }

    public static void urunCikisi() {
        boolean idVarmı = false;
        Urun secilenUrun = null;

        while (!idVarmı) {
            System.out.print("Çıkış yapılacak ürünün ID'sini girin: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            for (Urun urun : urunListesi) {
                if (urun.id == id) { // Doğru ID bulunduğunda
                    idVarmı = true;
                    secilenUrun = urun;
                    break;
                }
            }

            if (!idVarmı) {
                System.out.println("Ürün ID bulunamadı. Lütfen geçerli bir ID girin.\n");
            }
        }

        while (true) {
            // Ürün bulunduysa miktar girişi yapılır
            System.out.print("Çıkış yapılacak miktarı girin: ");
            int miktar = scanner.nextInt();
            scanner.nextLine();

            if (miktar < 0) {
                System.out.println("Miktar sıfırdan küçük olamaz");
                continue;
            }
            // Miktar kontrolü
            if (secilenUrun.miktar >= miktar) {
                secilenUrun.miktar -= miktar;
                System.out.println("Ürün çıkışı yapıldı. Kalan miktar: " + secilenUrun.miktar + " " + secilenUrun.birim + " " + secilenUrun.isim + " ");
                break;
            } else {
                System.out.println("Yetersiz miktar! Güncel miktar: " + secilenUrun.miktar);
            }


        }
        System.out.println("\n".repeat(2));
    }

    public void start() {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Depo Yonetim Sistemimize Hos Geldiniz");
            System.out.println("1-Urun Tanimlama       \n" +
                    "2-Urun Listele        \n" +
                    "3-Urun Girisi         \n" +
                    "4-Urunu Rafa Koy      \n" +
                    "5-Urun Cikis          \n" +
                    "6-Cikis               \n" +
                    "Seciminizi yapin      \n");

            try {
                int secim = input.nextInt();
                input.nextLine();

                switch (secim) {
                    case 1:
                        Depo.urunTanimlama();
                        Depo.urunListeleme();
                        break;

                    case 2:
                        Depo.urunListeleme();

                        break;

                    case 3:
                        Depo.urunListeleme();
                        Depo.urunGirisi();

                        break;

                    case 4:
                        Depo.urunListeleme();
                        Depo.urunuRafaKoy();

                        break;

                    case 5:
                        Depo.urunCikisi();
                        Depo.urunListeleme();
                        break;

                    case 6:
                        System.out.println("Cikis yapiliyor...");
                        input.close();
                        return;

                    default:
                        System.out.println("Gecersiz secim tekrar deneyin");

                }
            } catch (InputMismatchException e) {
                System.err.println("Lütfen geçerli bir rakam giriniz."); // InputMismatchException: Kullanıcıdan alınan girdi beklenen veri yürüyle eşleşmeyince
                input.nextLine(); // Hatalı girişi temizle
            }
        }
    }


}
