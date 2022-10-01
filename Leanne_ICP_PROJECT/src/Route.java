//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;

public class Route {
    private String Airline_Code;
    private String Airline_ID;
    private String Source_Airport_Code;
    private String Source_Airport_ID;
    private String Destination_Airport_Code;
    private String Destination_Airport_ID;
    private String Codeshare;
    private String Stops;
    private String Equipment;

    /**
     * @param airline_Code
     * @param airline_ID
     * @param source_Airport_Code
     * @param source_Airport_ID
     * @param destination_Airport_Code
     * @param destination_Airport_ID
     * @param codeshare
     * @param stops
     * @param equipment
     */
    public Route(String airline_Code,
                 String airline_ID,
                 String source_Airport_Code,
                 String source_Airport_ID,
                 String destination_Airport_Code,
                 String destination_Airport_ID,
                 String codeshare,
                 String stops,
                 String equipment) {
        this.Airline_Code = airline_Code;
        this.Airline_ID = airline_ID;
        this.Source_Airport_Code = source_Airport_Code;
        this.Source_Airport_ID = source_Airport_ID;
        this.Destination_Airport_Code = destination_Airport_Code;
        this.Destination_Airport_ID = destination_Airport_ID;
        this.Codeshare = codeshare;
        this.Stops = stops;
        this.Equipment = equipment;
    }


    /**
     * The toString() method returns a string representation of the object
     * @return The toString method is being returned.
     */
    public String toString() {
        return "Route{Airline_Code='" +
                this.Airline_Code + "', Airline_ID='" +
                this.Airline_ID + "', Source_Airport_Code='" +
                this.Source_Airport_Code + "', Source_Airport_ID='" +
                this.Source_Airport_ID + "', Destination_Airport_Code='" +
                this.Destination_Airport_Code + "', Destination_Airport_ID='" +
                this.Destination_Airport_ID + "', Codeshare='" + this.Codeshare +
                "', Stops='" + this.Stops + "', Equipment='" + this.Equipment + "'}";
    }

    /**
     * This function returns the Airline Code of the flight
     * @return The Airline_Code
     */
    public String getAirline_Code() {
        return this.Airline_Code;
    }

    /**
     * This function returns the source airport code of the flight
     * @return The source airport code.
     */
    public String getSource_Airport_Code() {
        return this.Source_Airport_Code;
    }


    /**
     * This function returns the Destination_Airport_Code of the Flight object
     * @return The Destination_Airport_Code
     */
    public String getDestination_Airport_Code() {
        return this.Destination_Airport_Code;
    }

    /**
     * This function returns the stops of the flight
     * @return The stops
     */
    public String getStops() {
        return this.Stops;
    }

    /**
     * If the object is not null and the object is of the same class as the current
     * object, then check if the values of the
     * fields are equal
     * @param o The object to be compared for equality with this route.
     * @return The hashcode of the object.
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Route route = (Route)o;
            return Objects.equals(this.Airline_Code, route.Airline_Code) &&
                    Objects.equals(this.Airline_ID, route.Airline_ID) &&
                    Objects.equals(this.Source_Airport_Code, route.Source_Airport_Code)
                    && Objects.equals(this.Source_Airport_ID, route.Source_Airport_ID) &&
                    Objects.equals(this.Destination_Airport_Code, route.Destination_Airport_Code)
                    && Objects.equals(this.Destination_Airport_ID, route.Destination_Airport_ID)
                    && Objects.equals(this.Codeshare, route.Codeshare)
                    && Objects.equals(this.Stops, route.Stops)
                    && Objects.equals(this.Equipment, route.Equipment);
        } else {
            return false;
        }
    }

    /**
     * The hashCode() function is used to return the hash code value for this object
     * @return The hashcode of the object.
     */
    public int hashCode() {
        return Objects.hash(this.Airline_Code,
                this.Airline_ID,
                this.Source_Airport_Code, this.Source_Airport_ID,
                this.Destination_Airport_Code, this.Destination_Airport_ID,
                this.Codeshare, this.Stops, this.Equipment);
    }
}
