package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        initializeFirstLine();
        initializeSecondLine();
        initializeThirdLine();
        int price;
        String start = new Scanner(System.in).nextLine();
        String end = new Scanner(System.in).nextLine();
        int startLine = checkWhichLine(start);
        int endLine = checkWhichLine(end);
        if (startLine == endLine) {
            price = getPriceForSameLine(start, end, startLine);
        } else {
            price = getPriceForDifferentLine(start, end, startLine, endLine);
        }
        System.out.println(price);
    }

    private static int getPriceForDifferentLine(String start, String end, int startLine, int endLine) {
        int price = 0;
        if ((startLine == 1 && endLine == 2) || (startLine == 2 && endLine == 1)) {
            String changedStation = "Sadat";
            if (firstLine.contains(start) && secondLine.contains(end)) {
                price = getPriceOfDiffState(start, end, changedStation, firstLine, secondLine);
            } else if (firstLine.contains(end) && secondLine.contains(start)) {
                price = getPriceOfDiffState(end, start, changedStation, firstLine, secondLine);
            }
        } else if ((startLine == 2 && endLine == 3) || (startLine == 3 && endLine == 2)) {
            String changedStation = "Attaba";
            if (secondLine.contains(start) && thirdLine.contains(end)) {
                price = getPriceOfDiffState(start, end, changedStation, secondLine, thirdLine);
            } else if (secondLine.contains(end) && thirdLine.contains(start)) {
                price = getPriceOfDiffState(end, start, changedStation, secondLine, thirdLine);
            }
        } else if ((startLine == 1 && endLine == 3) || (startLine == 3 && endLine == 1)) {
            String changedStation = "Nasser";
            if (firstLine.contains(start) && thirdLine.contains(end)) {
                price = getPriceOfDiffState(start, end, changedStation, firstLine, thirdLine);
            } else if (firstLine.contains(end) && thirdLine.contains(start)) {
                price = getPriceOfDiffState(end, start, changedStation, firstLine, thirdLine);
            }
        }
        return price;
    }

    private static int getPriceOfDiffState(String start, String end, String changedStation, ArrayList<String> secondLine, ArrayList<String> thirdLine) {
        int startIndex;
        int endIndex;
        int price;
        startIndex = secondLine.indexOf(start);
        endIndex = thirdLine.indexOf(end);
        int numberOfStationsForFirstLine = Math.abs(startIndex - secondLine.indexOf(changedStation));
        int numberOfStationsForSecondLine = Math.abs(endIndex - thirdLine.indexOf(changedStation));
        int totalStations = Math.abs(numberOfStationsForFirstLine + numberOfStationsForSecondLine) + 1;
        price = getTicketPrice(totalStations);
        return price;
    }

    private static int getTicketPrice(int totalStations) {
        if (totalStations == 0) {
            return 0;
        } else if (totalStations <= 9) {
            return 6;
        } else if (totalStations <= 16)
            return 8;
        else
            return 12;
    }

    private static int getPriceForSameLine(String start, String end, int startLine) {
        int price = 0;
        if (startLine == 1) {
            price = calculatePriceForSameLine(start, end, firstLine);
        }
        if (startLine == 2) {
            price = calculatePriceForSameLine(start, end, secondLine);
        }
        if (startLine == 3) {
            price = calculatePriceForSameLine(start, end, thirdLine);
        }
        return price;
    }

    private static int checkWhichLine(String station) {
        if (firstLine.contains(station)) {
            return 1;
        }
        if (secondLine.contains(station)) {
            return 2;
        }
        if (thirdLine.contains(station)) {
            return 3;
        }
        return 0;
    }

    private static int calculatePriceForSameLine(String start, String end, ArrayList<String> line) {
        if (line.contains(start) && line.contains(end)) {
            int indexOfStart = line.indexOf(start);
            int indexOfEnd = line.indexOf(end);
            int difference = Math.abs(indexOfEnd - indexOfStart) + 1;
            return getTicketPrice(difference);
        }
        return 0;
    }

    private static final ArrayList<String> firstLine = new ArrayList<>();
    private static final ArrayList<String> secondLine = new ArrayList<>();
    private static final ArrayList<String> thirdLine = new ArrayList<>();

    private static void initializeFirstLine() {
        firstLine.add("Helwan");
        firstLine.add("Ain Helwan");
        firstLine.add("Helwan University");
        firstLine.add("Wadi Hof");
        firstLine.add("Hadayek Helwan");
        firstLine.add("El-Maasara");
        firstLine.add("Tora El-Asmant");
        firstLine.add("Kozzika");
        firstLine.add("Tora El-Balad");
        firstLine.add("Sakanat El-Maadi");
        firstLine.add("Maadi");
        firstLine.add("Hadayek El-Maadi");
        firstLine.add("Dar El-Salam");
        firstLine.add("El-Zahraa");
        firstLine.add("Mar Girgis");
        firstLine.add("El-Malek El-Saleh");
        firstLine.add("Al-Sayeda Zeinab");
        firstLine.add("Saad Zaghloul");
        firstLine.add("Sadat");
        firstLine.add("Nasser");
        firstLine.add("Orabi");
        firstLine.add("Al-Shohadaa");
        firstLine.add("Ghamra");
        firstLine.add("El-Demerdash");
        firstLine.add("Manshiet El-Sadr");
        firstLine.add("Kobri El-Qobba");
        firstLine.add("Hammamat El-Qobba");
        firstLine.add("Saray El-Qobba");
        firstLine.add("Hadayeq El-Zaitoun");
        firstLine.add("Helmeyet El-Zaitoun");
        firstLine.add("El-Matareyya");
        firstLine.add("Ain Shams");
        firstLine.add("Ezbet El-Nakhl");
        firstLine.add("El-Marg");
    }

    private static void initializeSecondLine() {
        secondLine.add("El-Mounib");
        secondLine.add("Sakiat Mekky");
        secondLine.add("Omm El-Masryeen");
        secondLine.add("El Giza");
        secondLine.add("Faisal");
        secondLine.add("Cairo University");
        secondLine.add("El Bohoth");
        secondLine.add("Dokki");
        secondLine.add("Opera");
        secondLine.add("Sadat");
        secondLine.add("Mohamed Naguib");
        secondLine.add("Attaba");
        secondLine.add("Al-Shohadaa");
        secondLine.add("Masarra");
        secondLine.add("Road El-Farag");
        secondLine.add("St. Teresa");
        secondLine.add("Khalafawy");
        secondLine.add("Mezallat");
        secondLine.add("Kolleyyet El-Zeraa");
        secondLine.add("Shubra El-Kheima");
    }

    private static void initializeThirdLine() {
        thirdLine.add("Airport");
        thirdLine.add("Ahmed Galal");
        thirdLine.add("Adly Mansour");
        thirdLine.add("El Haykestep");
        thirdLine.add("Omar Ibn El-Khattab");
        thirdLine.add("Qobaa");
        thirdLine.add("Hesham Barakat");
        thirdLine.add("El-Nozha");
        thirdLine.add("Nadi El-Shams");
        thirdLine.add("Alf Maskan");
        thirdLine.add("Heliopolis Square");
        thirdLine.add("Haroun");
        thirdLine.add("Al-Ahram");
        thirdLine.add("Koleyet El-Banat");
        thirdLine.add("Stadium");
        thirdLine.add("Fair Zone");
        thirdLine.add("Abbassia");
        thirdLine.add("Abdou Pasha");
        thirdLine.add("El Geish");
        thirdLine.add("Bab El Shaaria");
        thirdLine.add("Attaba");
        thirdLine.add("Nasser");
        thirdLine.add("Maspero");
        thirdLine.add("Safaa Hegazy");
        thirdLine.add("Kit Kat");
        thirdLine.add("Sudan Street");
        thirdLine.add("Imbaba");
        thirdLine.add("El-Bohy");
        thirdLine.add("Al-Qawmeya Al-Arabiya");
        thirdLine.add("Ring Road");
        thirdLine.add("Rod al-Farag Axis");
        thirdLine.add("El-Tawfikeya");
        thirdLine.add("Wadi El-Nil");
        thirdLine.add("Gamaat El Dowal Al-Arabiya");
    }
}