import java.util.Random;
import java.util.Scanner;

public class diceGame {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int toplamOyuncu1 = 0;
        int toplamOyuncu2 = 0;
        int toplamOyuncu3 = 0;

        System.out.print("Hedef tur sayısını girin (1-99):");
        int hedefTur = scanner.nextInt();

        while (hedefTur < 1 || hedefTur > 99) {
            System.out.print("Geçersiz giriş. Hedef tur sayısını tekrar girin (1-99): ");
            hedefTur = scanner.nextInt();
        }
        
//Tablo baslıklarını yazdırma
//Tablo oluşturmak için String.format fonksiyonunu kullandım
//%8s: Dize, 8 karakter genişliğinde bir alana yerleştirilir.      

        System.out.println(String.format("| %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s |",
                "Round", "Oyuncu1", "Oyuncu2", "Oyuncu3", "Toplam1", "Toplam2", "Toplam3"));
        
        for (int tur = 1; tur <= hedefTur; tur++) {
            int zarOyuncu1 = random.nextInt(6) + 1;
            int zarOyuncu2 = random.nextInt(6) + 1;
            int zarOyuncu3 = random.nextInt(6) + 1;
            System.out.println("+----------+----------+----------+----------+----------+----------+----------+");

//random.nextInt(6) ifadesi, 0 ile 5 arasında rastgele bir sayı üretir. Bu değere 1 ekleyerek, 1 ile 6 arasında rastgele bir sayı elde ettim.

            if (zarOyuncu1 == zarOyuncu2 && zarOyuncu2 == zarOyuncu3) {
                toplamOyuncu1 += zarOyuncu1;
                toplamOyuncu2 += zarOyuncu2;
                toplamOyuncu3 += zarOyuncu3;
            } else if (zarOyuncu1 == zarOyuncu2 && zarOyuncu1 > 3) {
                toplamOyuncu1 += 2 * zarOyuncu1;
                toplamOyuncu2 += 2 * zarOyuncu2;
                toplamOyuncu3 += zarOyuncu3;
            } else if (zarOyuncu1 == zarOyuncu3  && zarOyuncu1 > 3) {
                toplamOyuncu1 += 2 * zarOyuncu1;
                toplamOyuncu2 += zarOyuncu2;
                toplamOyuncu3 += 2 * zarOyuncu3;
            } else if (zarOyuncu2 == zarOyuncu3  && zarOyuncu2 > 3) {
                toplamOyuncu1 += zarOyuncu1;
                toplamOyuncu2 += 2 * zarOyuncu2;
                toplamOyuncu3 += 2 * zarOyuncu3;
            } else {
                toplamOyuncu1 += zarOyuncu1;
                toplamOyuncu2 += zarOyuncu2;
                toplamOyuncu3 += zarOyuncu3;
            }
            
//Tablonun içini yazdırma
//%8d: Sayı, 8 karakter genişliğinde bir alana yerleştirilir. 
            
            System.out.println(String.format("| %-8d | %-8d | %-8d | %-8d | %-8d | %-8d | %-8d |",
                    tur, zarOyuncu1, zarOyuncu2, zarOyuncu3, toplamOyuncu1, toplamOyuncu2, toplamOyuncu3));
            
        }

        System.out.println("\n Oyun bitti!");
        scanner.close();
    }
}
