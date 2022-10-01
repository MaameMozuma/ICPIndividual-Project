//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Airline {
    private int Airline_ID;
    private String Name;
    private String Alias;
    private String IATA_Code;
    private String ICAO_Code;
    private String Callsign;
    private String Country;
    private String Active;

    /**
     * @param airline_ID
     * @param name
     * @param alias
     * @param IATA_Code
     * @param ICAO_Code
     * @param callsign
     * @param country
     * @param active
     * */
    public Airline(int airline_ID,
                   String name,
                   String alias,
                   String IATA_Code,
                   String ICAO_Code,
                   String callsign,
                   String country,
                   String active) {
        this.Airline_ID = airline_ID;
        this.Name = name;
        this.Alias = alias;
        this.IATA_Code = IATA_Code;
        this.ICAO_Code = ICAO_Code;
        this.Callsign = callsign;
        this.Country = country;
        this.Active = active;
    }

    /**
     * The toString() method returns a string representation of the object
     *
     * @return The toString method is being returned.
     */
    public String toString() {
        return "Airline{Airline_ID=" +
                this.Airline_ID +
                ", Name='" + this.Name + "', Alias='" + this.Alias +
                "', IATA_Code='" + this.IATA_Code +
                "', ICAO_Code='" + this.ICAO_Code +
                "', Callsign='" + this.Callsign +
                "', Country='" + this.Country +
                "', Active='" + this.Active + "'}";
    }
}

}
