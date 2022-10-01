//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Starting Reading...");
        DataReader dataReader = new DataReader("accra-winnipeg.txt", "airports.csv",
                "airlines.csv", "routes.csv");
        dataReader.ReadAllFiles();
        File file = new File("accra-winnipeg.txt");
        Scanner scan = new Scanner(file);
        String startCity = "";
        String startCountry = "";
        String destCity = "";
        String destCountry = "";
        String start = "";
        String dest = "";

        while (scan.hasNextLine()) {
            start = scan.nextLine();
            dest = scan.nextLine();
        }

        startCity = start.split(",")[0].trim();
        startCountry = start.split(",")[1].trim();
        destCity = dest.split(",")[0].trim();
        destCountry = dest.split(",")[1].trim();
        Breadth_First_Search bfs = new Breadth_First_Search(startCity, startCountry, destCity, destCountry);
        bfs.BFS();

        System.out.println("Done executing!");
    }
}
