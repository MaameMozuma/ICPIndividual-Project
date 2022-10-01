//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class DataReader {
    static String Input_File;
    private final String Airport_File;
    private final String Airline_File;
    private final String Route_File;
    static Scanner inputStream = null;
    static Hashtable<String, ArrayList<Airport>> Airport_List = new Hashtable();
    static Hashtable<Integer, Airline> Airline_List = new Hashtable();
    static Hashtable<String, ArrayList<Route>> Route_List = new Hashtable();
    static Hashtable<String, Airport> iata_hashtable = new Hashtable();
    static ArrayList<String> Source_Destination_List = new ArrayList();

    /**
    *@param input_File
    *@param airport_File
    *@param airline_File
    *@param route_File
    */
    public DataReader(String input_File, String airport_File, String airline_File, String route_File) {
        Input_File = input_File;
        this.Airport_File = airport_File;
        this.Airline_File = airline_File;
        this.Route_File = route_File;
    }

    /**
     * This function checks if the file is empty or not, and if it is, it throws an exception
     * @param file_name The name of the file to be checked.
     * @return The Scanner object is being returned.
     */
    public static Scanner CheckFileValidity(String file_name) {
        try {
            inputStream = new Scanner(new FileInputStream(file_name));
            if (!inputStream.hasNextLine()) {
                throw new EmptyFileException();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("The file " + file_name + " was not found.");
            System.exit(0);
        } catch (EmptyFileException efe) {
            System.out.println(efe.getMessage());
            System.exit(0);
        }

        return inputStream;
    }


    /**
     * This function reads the airport file and stores the data in a hash table
     * @param fileStreamObject The file stream object that is passed in from the main method.
     */
    public void ReadAirportFile(Scanner fileStreamObject) {
        while(fileStreamObject.hasNextLine()) {
            String[] line = fileStreamObject.nextLine().split(",");
            if (line.length == 14 && !line[9].equals("\\N")) {
                Airport airport = new Airport(Integer.parseInt(line[0]),
                        line[1], line[2], line[3], line[4], line[5],
                        Float.parseFloat(line[6]), Float.parseFloat(line[7]),
                        Integer.parseInt(line[8]), Float.parseFloat(line[9]), line[10],
                        line[11], line[12], line[13]);
                String arr = line[2] + line[3];
                String iata_code = line[4];
                if (iata_code != "\\N") {
                    iata_hashtable.put(iata_code, airport);
                }

                //checking if that city and country exists in the dictionary and
                //adding the airport to an array list of airports if not, create a new entry
                if (this.checkKeyExists(arr)) {
                    Airport_List.get(arr).add(airport);
                } else {
                    ArrayList<Airport> AirportCollection = new ArrayList();
                    AirportCollection.add(airport);
                    Airport_List.put(arr, AirportCollection);
                }
            }
        }

        fileStreamObject.close();
    }

    /**
     * This function checks if the airport code exists in the HashMap
     * @param a The airport code that you want to check if it exists in the HashMap
     * @return A boolean value.
     */
    public boolean checkKeyExists(String a) {
        boolean keyExists = false;
        if (getAirport_List().size() != 0) {
            for (String key : getAirport_List().keySet()){
                if (key.equals(a)) {
                    keyExists = true;
                }
            }
        }

        return keyExists;
    }

    /**
     * This function reads the airline file and stores the data in a hashmap
     * @param fileStreamObject The file stream object that is used to read the file.
     */
    public void ReadAirlineFile(Scanner fileStreamObject) {
        while(fileStreamObject.hasNextLine()) {
            String[] line = fileStreamObject.nextLine().split(",");
            if (line.length == 8) {
                Airline airline = new Airline(Integer.parseInt(line[0]), line[1],
                        line[2], line[3], line[4], line[5], line[6], line[7]);
                Airline_List.put(Integer.parseInt(line[0]), airline);
            }
        }

        fileStreamObject.close();
    }

    /**
     * This function reads the route file and creates a hashmap of routes with the key being the route_id
     * @param fileStreamObject The file stream object that is passed in from the main method.
     */
    public void ReadRouteFile(Scanner fileStreamObject) {
        while(inputStream.hasNextLine()) {
            String[] line = inputStream.nextLine().split(",");
            if (line.length == 9) {
                Route route = new Route(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                String routeKey = line[2];
                Route_List.putIfAbsent(routeKey, new ArrayList());
                ((ArrayList)Route_List.get(routeKey)).add(route);
            }
        }

        fileStreamObject.close();
    }


    /**
     * This function reads the input file and stores the source and destination in a list
     * @param fileStreamObject This is the object of the Scanner class that we created in the main method.
     */
    public static void ReadInputFile(Scanner fileStreamObject) {
        while(fileStreamObject.hasNextLine()) {
            String[] line = fileStreamObject.nextLine().split(",");
            if (line.length == 2) {
                Source_Destination_List.add(line[0]);
                Source_Destination_List.add(line[1].trim());
            }
        }

    }

    /**
     * Reads all the files and checks if they are valid
     */
    public void ReadAllFiles() {
        ReadInputFile(CheckFileValidity(Input_File));
        this.ReadRouteFile(CheckFileValidity(this.Route_File));
        this.ReadAirportFile(CheckFileValidity(this.Airport_File));
        this.ReadAirlineFile(CheckFileValidity(this.Airline_File));
    }

    /**
     * This function returns the Airport_List Hashtable
     * @return The Airport_List Hashtable is being returned.
     */
    public static Hashtable<String, ArrayList<Airport>> getAirport_List() {
        return Airport_List;
    }
}

