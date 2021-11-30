package com.company;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryDataSaver {
    private static FileOutputStream outFile;
    private static FileInputStream inFile;
    private Object quadrate;

    public static void save(ArrayList<Quadrate> quadrates, String fileWay) throws IOException {
        byte[] bytesToWrite;
        byte[] numberQuadrate, x1, x2, x3, x4, y1, y2, y3, y4, side1, side2, side3, side4, diagonal1, diagonal2, perimeter, rhombus, razdel;
        String razdelelitel = "&";

        for (Quadrate object : quadrates) {
//Задаём номер  четырёхугольника и координаты точек вершин четырёхугольника
            String s1 = Double.toHexString(object.getNumQuadrate());
            numberQuadrate = s1.getBytes(StandardCharsets.UTF_8);

            String s2 = Double.toHexString(object.getX1());
            x1 = s2.getBytes(StandardCharsets.UTF_8);

            String s3 = Double.toHexString(object.getX2());
            x2 = s3.getBytes(StandardCharsets.UTF_8);

            String s4 = Double.toHexString(object.getX3());
            x3 = s4.getBytes(StandardCharsets.UTF_8);

            String s5 = Double.toHexString(object.getX4());
            x4 = s5.getBytes(StandardCharsets.UTF_8);

            String s6 = Double.toHexString(object.getY1());
            y1 = s6.getBytes(StandardCharsets.UTF_8);

            String s7 = Double.toHexString(object.getY2());
            y2 = s7.getBytes(StandardCharsets.UTF_8);

            String s8 = Double.toHexString(object.getY3());
            y3 = s8.getBytes(StandardCharsets.UTF_8);

            String s9 = Double.toHexString(object.getY4());
            y4 = s9.getBytes(StandardCharsets.UTF_8);

            razdel = razdelelitel.getBytes(StandardCharsets.UTF_8);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            outputStream.write(numberQuadrate);
            outputStream.write(razdel);
            outputStream.write(x1);
            outputStream.write(razdel);
            outputStream.write(x2);
            outputStream.write(razdel);
            outputStream.write(x3);
            outputStream.write(razdel);
            outputStream.write(x4);
            outputStream.write(razdel);
            outputStream.write(y1);
            outputStream.write(razdel);
            outputStream.write(y2);
            outputStream.write(razdel);
            outputStream.write(y3);
            outputStream.write(razdel);
            outputStream.write(y4);


            bytesToWrite = outputStream.toByteArray();
            outFile = null;
            boolean isOpened = false;
            try {
                outFile = new FileOutputStream(fileWay, true);
                isOpened = true;
                outFile.write(bytesToWrite);
            } catch (FileNotFoundException e) {
                System.out.println("Невозможно произвести запись в файл:" + fileWay);
            } catch (IOException e) {
                System.out.println("Ошибка ввода/вывода:" + e);
            }
            if (isOpened) {
                outFile.close();
            }
        }
    }

    public static void load(ArrayList<Quadrate> quadrates, String fileWay) throws IOException {
        quadrates.clear();
        byte[] wert = new byte[0];
        int number = 0;
        try {

            inFile = new FileInputStream(fileWay);
            int bytesAvailable = inFile.available();
            System.out.println("Available: " + bytesAvailable);

            byte[] bytesReaded = new byte[bytesAvailable];
            int count = inFile.read(bytesReaded, 0, bytesAvailable);

            System.out.println("Было считано байт: " + count);
            System.out.println(Arrays.toString(bytesReaded));
            byte[] trap = bytesReaded;
            wert = trap;
            number = count;
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести чтение из файла:" + fileWay);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода:" + e);
        }
        byte[] data = wert;
        int numberQuadrate = 0;
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        int y4 = 0;
        int q = 0;
        String num = "";
        for (int i = 0; i < number; i++) {

            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                num = num + str;
                numberQuadrate = Integer.parseInt(num, 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                x1 = Integer.parseInt(String.valueOf(x1), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                x2 = Integer.parseInt(String.valueOf(x2), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                x3 = Integer.parseInt(String.valueOf(x3), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                x4 = Integer.parseInt(String.valueOf(x4), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");

                y1 = Integer.parseInt(String.valueOf(y1), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");

                y2 = Integer.parseInt(String.valueOf(y2), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                y3 = Integer.parseInt(String.valueOf(y3), 2);
            }
            for (i = q; i < number; i++) {
                if (data[i] == 50) {
                    q = i + 1;
                    break;
                }
                byte[] ab = new byte[1];
                ab[0] = data[i];
                String str = new String(ab, "UTF-8");
                y4 = Integer.parseInt(String.valueOf(y4), 2);
            }
            if (i == number - 1) {
                break;
            }
            numberQuadrate = 0;
            x1 = 0;
            x2 = 0;
            x3 = 0;
            y1 = 0;
            y2 = 0;
            y3 = 0;
        }
    }
}