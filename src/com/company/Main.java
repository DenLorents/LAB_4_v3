package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static int CheckCorrectFunction(String value) {
        int func = -1;
        try {
            func = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            func = -1;
        }
        return func;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int inCountTriangle = 1;
        System.out.println("Введите количество четырёхугольников: " + inCountTriangle);

        Quadrate[] quadrates = new Quadrate[inCountTriangle];

        int CountQuadrate = 0;
        int function = 0;

        for (int i = 0; i < quadrates.length; i++) {
            quadrates[i] = new Quadrate();

            System.out.print("Введите x1 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX1(scan.nextInt());
            System.out.print("Введите y1 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY1(scan.nextInt());

            System.out.print("Введите x2 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX2(scan.nextInt());
            System.out.print("Введите y2 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY2(scan.nextInt());

            System.out.print("Введите x3 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX3(scan.nextInt());
            System.out.print("Введите y3 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY3(scan.nextInt());

            System.out.print("Введите x4 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setX4(scan.nextInt());
            System.out.print("Введите y4 для четырёхугольника №" + (i + 1) + ": ");
            quadrates[i].setY4(scan.nextInt());

            quadrates[i].numberQuadrate = ++CountQuadrate;
        }
        //Формулы и подсчет сторон, диагоналей, периметра четырёхугольника и проверка на ромб
        for (int i = 0; i < quadrates.length; i++) {
            // d = √((x2-x1)²+(y2-y1)²),
            quadrates[i].side1 = Math.sqrt((Math.pow(quadrates[i].x2 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y2 - quadrates[i].y1, 2));
            quadrates[i].side2 = Math.sqrt((Math.pow(quadrates[i].x3 - quadrates[i].x2, 2)) + Math.pow(quadrates[i].y3 - quadrates[i].y2, 2));
            quadrates[i].side3 = Math.sqrt((Math.pow(quadrates[i].x4 - quadrates[i].x3, 2)) + Math.pow(quadrates[i].y4 - quadrates[i].y3, 2));
            quadrates[i].side4 = Math.sqrt((Math.pow(quadrates[i].x4 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y4 - quadrates[i].y1, 2));

            quadrates[i].diagonal1 = Math.sqrt((Math.pow(quadrates[i].x3 - quadrates[i].x1, 2)) + Math.pow(quadrates[i].y3 - quadrates[i].y1, 2));
            quadrates[i].diagonal2 = Math.sqrt((Math.pow(quadrates[i].x2 - quadrates[i].x4, 2)) + Math.pow(quadrates[i].y2 - quadrates[i].y4, 2));

            quadrates[i].perimeter = quadrates[i].side1 + quadrates[i].side2 + quadrates[i].side3 + quadrates[i].side4;


            System.out.println("Сторона (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side1);
            System.out.println("Сторона (2) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side2);
            System.out.println("Сторона (3) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side3);
            System.out.println("Сторона (4) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].side4);

            System.out.println("Диагональ (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].diagonal1);
            System.out.println("Диагональ (1) четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].diagonal2);

            System.out.println("Периметр четырёхугольника №" + quadrates[i].numberQuadrate + ": " + quadrates[i].perimeter);


            if (quadrates[i].side1 == quadrates[i].side2 || quadrates[i].side1 == quadrates[i].side4 && quadrates[i].side3 == quadrates[i].side2 || quadrates[i].side3 == quadrates[i].side4 && quadrates[i].diagonal1 != quadrates[i].diagonal2) {
                quadrates[i].rhombus = true;
            }
        }

        do {
            System.out.println("\nСписок функций: ");
            System.out.println("1) Сохранение в файл");
            System.out.println("2) Загрузить из файла");
            System.out.println("3) Выход из программы");
            do {
                System.out.print("Введите номер функции: ");
                function = CheckCorrectFunction(scan.nextLine());
            } while (function == -1);

            switch (function) {
                case 1:
                    System.out.println("Введите путь к файлу:");
                    String wayToFile = scan.nextLine();
                    ArrayList<Quadrate> triangleArrayList = new ArrayList<>();
                    triangleArrayList.addAll(Arrays.asList(quadrates));
                    BinaryDataSaver.save(triangleArrayList, wayToFile);
                    System.out.println("Файл сохранён");
                    break;
                case 2:
                    System.out.println("Введите путь к файлу:");
                    String wayToFileLoad = scan.nextLine();
                    System.out.println("Файл загружен");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nТакой функции нет");
            }
        } while (function != 0);
    }
}
