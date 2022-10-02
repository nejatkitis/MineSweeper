package MineSweeper;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz.");
        Scanner input = new Scanner(System.in);
        System.out.println("Oynamak istediğiniz boyutları giriniz : ");
        int a = input.nextInt();
        int b = input.nextInt();
        MineSweeper game = new MineSweeper(a,b);
    }
}
