package MineSweeper;

import java.util.Scanner;
import java.util.Random;

public class MineSweeper {

    int sa,su;
    Random r = new Random();
    int satir;
    int sutun;
    int mayinsayisi;


    MineSweeper(int satir, int sutun) {
        Scanner in = new Scanner(System.in);
        this.sa = sa;
        this.su = su;
        this.satir = satir;
        this.sutun = sutun;
        mayinsayisi = (satir * sutun) / 4;
        String[][] tarla = new String[satir][sutun]; // platrofmu arka planda oluşturdum
        String[][] tarla2 = new String[satir][sutun]; // oyun oynayacağımız alan

        for (int d=0;d<tarla.length;d++){
            for (int e=0;e<tarla[0].length;e++){
                tarla[d][e]= "0"; // ilk önce bütün değerlere 0 atadım
            }
        }

        for (int f=0;f<tarla2.length;f++){
            for (int g=0;g<tarla2[0].length;g++){
                tarla2[f][g]="-";  //oyun oynayacağımız alanın ön yüzü
            }
        }


        for (int i = 0; i < mayinsayisi; i++) {
            int a = r.nextInt(satir) ;
            int b = r.nextInt(sutun) ;
            tarla[a][b] = "*" ; // rastgele mayınları yerleştirdim
        }

        for (int j = 0; j < tarla.length; j++) {  //mayınların çevresine sayıları yerleştirdim
            for (int k = 0; k < tarla[0].length; k++) {
                if (tarla[j][k] == "*") {
                    if (j==0 && k==0){
                        tarla[j][k+1]+=1;
                        tarla[j+1][k]+=1;
                        tarla[j+1][k+1]+=1;
                    } else if (j==0 && k!=0 && k!= tarla[0].length-1){
                       tarla[j][k-1]+=1;
                       tarla[j][k+1]+=1;
                       tarla[j+1][k]+=1;
                       tarla[j+1][k+1]+=1;
                       tarla[j+1][k+1]+=1;
                   } else if (k==0 && j!=0 && j!=tarla.length-1) {
                       tarla[j-1][k]+=1;
                       tarla[j+1][k]+=1;
                       tarla[j][k+1]+=1;
                       tarla[j+1][k+1]+=1;
                       tarla[j-1][k+1]+=1;
                   } else if (j!=0 && k!=0 && j!=tarla.length-1 && k!=tarla[0].length-1){
                       tarla[j-1][k-1]+=1;
                       tarla[j-1][k]+=1;
                       tarla[j-1][k+1]+=1;
                       tarla[j][k-1]+=1;
                       tarla[j][k+1]+=1;
                       tarla[j+1][k-1]+=1;
                       tarla[j+1][k]+=1;
                       tarla[j+1][k+1]+=1;
                   } else if (k==0 && j==tarla.length-1) {
                        tarla[j-1][k]+=1;
                        tarla[j-1][k+1]+=1;
                        tarla[j][k+1]+=1;
                    } else if (j==0 && k==tarla[0].length-1) {
                        tarla[j][k-1]+=1;
                        tarla[j+1][k-1]+=1;
                        tarla[j+1][k]+=1;
                    } else if (j==tarla.length-1 && k!=0 && k!=tarla[0].length-1){
                        tarla[j][k-1]+=1;
                        tarla[j][k+1]+=1;
                        tarla[j-1][k]+=1;
                        tarla[j-1][k-1]+=1;
                        tarla[j-1][k+1]+=1;
                    } else if (k==tarla[0].length-1 && j!=0 && j!=tarla.length-1) {
                        tarla[j-1][k]+=1;
                        tarla[j+1][k]+=1;
                        tarla[j][k-1]+=1;
                        tarla[j-1][k-1]+=1;
                        tarla[j+1][k-1]+=1;
                    } else {
                        tarla[j-1][k-1]+=1;
                        tarla[j-1][k]+=1;
                        tarla[j][k-1]+=1;
                    }
                }
            }
        }

        for (int l=0;l<tarla.length;l++){
            for (int m=0;m<tarla[0].length;m++){
                if (tarla[l][m].equals("*1") || tarla[l][m].equals("*11") || tarla[l][m].equals("*111") || tarla[l][m].equals("*1111")){
                    tarla[l][m]="*";
                } else if (tarla[l][m].equals("01")) {
                    tarla[l][m]="1";
                } else if (tarla[l][m].equals("011")) {
                    tarla[l][m]="2";
                } else if (tarla[l][m].equals("0111")) {
                    tarla[l][m]="3";
                } else if (tarla[l][m].equals("01111")) {
                    tarla[l][m]="4";
                }
            }
        }
        int count =0;
        for (int n=0;n<tarla.length;n++) {
            for (int p=0;p<tarla[0].length;p++){
                if (tarla[n][p].equals("*")){
                    count++;
                }
            }
        }
        int noncount = (satir*sutun)-count;
        for (int q=0;q<noncount;q++){
            for (int r=0;r<tarla2.length;r++){
                for (int s=0;s<tarla2[0].length;s++){
                    System.out.print(tarla2[r][s]+"  ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("===========================");
            System.out.println();
            System.out.print("Satır girin: ");
            sa = in.nextInt();
            System.out.print("Sütun girin: ");
            su = in.nextInt();
            if (!tarla[sa][su].equals("*")){
                tarla2[sa][su]=tarla[sa][su];
            } else if (tarla[sa][su].equals("*")) {
                System.out.println("Game over");
                System.out.println("========================");
                break;
            }
        }
    }
}

