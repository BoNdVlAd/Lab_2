package src;
import java.util.Random;

import java.util.Scanner;




class Matrix {
    public long[][] DO(long columns, long rows) {

        Random rand = new Random();
        long[][] MATRIX = new long[(int) columns][(int) rows];
        for (int i = 0; i < rows; i++) {
            for (int q = 0; q < columns; q++) {
                MATRIX[q][i] = rand.nextLong(0, 10);
            }
        }
        return MATRIX;
    }

    public long[][] Sum(long[][] matrix1, long[][] matrix2, long columns, long rows) {
        long[][] MATRIX = new long[(int) columns * 2][(int) rows * 2];

        for (int i = 0; i < rows * 2; i++) {
            for (int q = 0; q < columns * 2; q++) {
                MATRIX[q][i] = 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int q = 0; q < columns; q++) {
                MATRIX[q][i] = matrix1[q][i];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int q = 0; q < columns; q++) {
                MATRIX[q + (int) columns][i + (int) rows] = matrix2[q][i];
            }
        }


        return MATRIX;
    }
    public long[] Max(long[][] Matrix3,long columns, long rows){

        long[] Result = new long[(int)rows*2];
        long a = 0;
        for (int i = 0; i < rows * 2; i++) {
            for (int q = 0; q < columns * 2; q++) {
                if (Result[i] < Matrix3[q][i]) {
                    Result[i] = Matrix3[q][i];
                }
            }
        }
        return Result;
    }
}


    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random rand = new Random();

            int rand_int1 = rand.nextInt(1000);
            System.out.println("Дія з матрицеями C=A⊕B");
            System.out.println("тип елементів : long");
            System.out.println("C5 = " + 1103%5);
            System.out.println("C7 = "+ 1103%7);
            System.out.println("C11 = "+ 1103%11);
            System.out.println("Введіть розміри матриці");
            System.out.print("кількість стовпців : ");
            long columns = scanner.nextLong();
            System.out.print("кількість рядків : ");
            long rows = scanner.nextLong();

            if(columns<1 || rows<1){
                System.out.println("Помилка: В матриці кількість рядків або стовпців не може бути меншою 1");
                System.exit(0);
            }
            Matrix matrix = new Matrix();
            long[][] Matrix1 = matrix.DO(columns, rows);
            System.out.println("Матриця 1 ");
            for (int i = 0; i < rows; i++) {
                for (int q = 0; q < columns; q++) {
                    System.out.print(" " + Matrix1[q][i] + " ");
                }
                System.out.print("\n");
            }



            long[][] Matrix2 = matrix.DO(columns, rows);
            System.out.println("Матриця 2 ");
            for (int i = 0; i < rows; i++) {
                for (int q = 0; q < columns; q++) {
                    System.out.print(" " + Matrix2[q][i] + " ");
                }
                System.out.print("\n");
            }


            long[][] Matrix3 = matrix.Sum(Matrix1, Matrix2, columns, rows);

            System.out.println("Матриця 3 ");
            for (int i = 0; i < rows * 2; i++) {
                for (int q = 0; q < columns * 2; q++) {
                    System.out.print(" " + Matrix3[q][i] + " ");
                }
                System.out.print("\n");
            }
            long[] RESULT = matrix.Max(Matrix3,columns,rows);
            long Sum = 0;
            for(int i = 0; i < rows*2; i++){
                Sum+=RESULT[i];
            }
            System.out.println("Сума найбільших елементів кожного рядка матриці дорівнює "+Sum);


        }
    }


