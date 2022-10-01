//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breadth_First_Search {
    private static String Source_City_Name;
    private static String Source_Country_Name;
    private static String Destination_City_Name;
    private static String Destination_Country_Name;

    ArrayList<Node> Starting_Nodes_Available;

    public Breadth_First_Search(String source_City_Name, String source_Country_Name, String destination_City_Name, String destination_Country_Name) {
        Source_City_Name = source_City_Name;
        Source_Country_Name = source_Country_Name;
        Destination_City_Name = destination_City_Name;
        Destination_Country_Name = destination_Country_Name;
    }

    /**
     * This function takes in a hashtable of airports and returns an arraylist of nodes that are the starting nodes for the
     * search
     *
     * @param a Hashtable of all airports
     * @return The starting nodes of the graph.
     */
    public ArrayList<Node> getStartingNodes(Hashtable<String, ArrayList<Airport>> a) {
        String start_list = Source_City_Name + Source_Country_Name;
        String end_list = Destination_City_Name + Destination_Country_Name;
        ArrayList<Airport> Starting_airports = a.get(start_list);
        ArrayList<Node> Starting_nodes = new ArrayList();

       for(Airport airport: Starting_airports) {
            Node starting_node = new Node(airport, null, null, 0);
            Starting_nodes.add(starting_node);
        }
        return Starting_nodes;
    }

    /**
     * > This function takes an airport as an argument and returns a list of all the routes that originate from that
     * airport
     *
     * @param airport The airport object that we are currently looking at.
     * @return The list of routes that are associated with the airport.
     */
    private ArrayList<Route> actions(Airport airport) {
        String key = airport.getIATA_Code();
        ArrayList<Route> actions_list = new ArrayList();
        if (DataReader.Route_List.containsKey(key)) {
            actions_list = DataReader.Route_List.get(key);
        }

        return actions_list;
    }


    /**
     * The function takes in the source city name and source country name and returns true if the goal is found and false
     * if the goal is not found
     *
     * @return A boolean value.
     */
    public boolean BFS() {
        HashSet<Airport> Explored_Nodes = new HashSet();
        Queue<Node> Frontier = new LinkedList();
        System.out.println("About to do a BFS on the problem");
       // new ArrayList(List.of(Source_City_Name, Source_Country_Name));
        Starting_Nodes_Available = getStartingNodes(DataReader.getAirport_List());
        if (this.Starting_Nodes_Available == null) {
            return false;
        } else {
            for (Node n : Starting_Nodes_Available){
                if (this.goal_test(n)) {
                    System.out.println("You are there!");
                    printPath(n);
                    System.out.println(n);
                    return true;
                }

                Frontier.add(n);
            }

            // Checking if the frontier is empty.
            while(!Frontier.isEmpty()) {
                Node popped_node = Frontier.remove();
                Explored_Nodes.add(popped_node.getState());
                ArrayList<Route> actions_available = actions(popped_node.getState());
              for (Route r: actions_available) {
                  Node child = new Node(DataReader.iata_hashtable.get(r.getDestination_Airport_Code()), popped_node, r, popped_node.getPath_cost() + 1);
                  if (!Explored_Nodes.contains(child.getState()) && !Frontier.contains(child)) {
                      if (this.goal_test(child)) {
                          System.out.println(child);
                          printPath(child);
                          return true;
                      }

                      Frontier.add(child);
                  }
              }
            }
            return false;
        }
    }

    /**
     * If the node's state is null, then return false. Otherwise, return true if the node's state's city and country are
     * equal to the destination city and country
     *
     * @param n The node to be tested
     * @return The goal test is returning true if the city and country of the node is equal to the destination city and
     * country.
     */
    public boolean goal_test(Node n) {
        if (n.getState() == null) {
            return false;
        } else {
            return n.getState().getCity().equals(Destination_City_Name) && n.getState().getCountry().equals(Destination_Country_Name);
        }
    }

    /**
     * This function takes in the destination node and prints the path from the source to the destination
     *
     * @param destination The destination node
     */
    public static void printPath(Node destination) {
        String file_string_name = Source_City_Name + "-" + Destination_City_Name + "_output.txt";
        ArrayList<Route> actions = new ArrayList();

        for(Node node = destination; node.getParent() != null; node = node.getParent()) {
            actions.add(node.getAction());
        }

        Collections.reverse(actions);
        int count = 1;
        int total_stops = 0;
        System.out.println(file_string_name);
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(new FileOutputStream(file_string_name));
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }

        System.out.println("Writing to the file");

        // Checking if the actions list is empty. If it is empty, then it will not print anything.
        if (!actions.isEmpty()) {
            for(Route r : actions) {
                outputStream.println("" + count + ". " + r.getAirline_Code() + " from " + r.getSource_Airport_Code()
                        + " to " + r.getDestination_Airport_Code() + " " + r.getStops() + " stops");
                ++count;
            }
        }

        // Printing the total number of flights.
        outputStream.println("Total flights: " + actions.size());
        outputStream.println("Total additional stops:" + total_stops);
        outputStream.println("Optimality Criteria: flights");
        outputStream.close();
    }
}
