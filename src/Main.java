import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int rNumber (){
        Random randm= new Random();
        return (randm.nextInt(100));
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        int right=0;
        int select;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;


        while (right<5){
            int number=rNumber();
            System.out.print("Tahminizi giriniz : ");
            select=input.nextInt();

            if (select < 0 || select > 99) {
                System.out.println("Lütfen 0-100 arasında bir değer giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
                continue;
            }

            if (select == number) {
                System.out.println("Tebrikler, doğru tahmin ! Tahmin ettiğini sayı : " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz !");
                if (select > number) {
                    System.out.println(select + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(select + " sayısı, gizli sayıdan küçüktür.");
                }

                wrong[right++] = select;
                System.out.println("Kalan hakkı : " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("Kaybettiniz ! ");
            if (!isWrong) {
                System.out.println("Tahminleriniz : " + Arrays.toString(wrong));
            }
        }
        }

    }
