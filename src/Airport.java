/**
 * @author Leanne Annor-Adjaye
 *
 */
public class Airport {
    /**
     * Instance Variables/Fields
     */
    private int Airport_ID;
    private String Name;
    private String City;
    private String Country;
    private String IATA_Code;
    private String ICAO_Code;
    private double Latitude;
    private double Longitude;
    private int Altitude;
    private double Timezone;
    private char DST;
    private String Tz_database_time_zone;
    private String Type;
    private String Source;

    public Airport(int airport_ID,
                   String name,
                   String city,
                   String country,
                   String IATA_Code,
                   String ICAO_Code,
                   double latitude,
                   double longitude,
                   int altitude,
                   double timezone,
                   char DST,
                   String tz_database_time_zone,
                   String type,
                   String source) {
        Airport_ID = airport_ID;
        Name = name;
        City = city;
        Country = country;
        this.IATA_Code = IATA_Code;
        this.ICAO_Code = ICAO_Code;
        Latitude = latitude;
        Longitude = longitude;
        Altitude = altitude;
        Timezone = timezone;
        this.DST = DST;
        Tz_database_time_zone = tz_database_time_zone;
        Type = type;
        Source = source;
    }

    public int getAirport_ID() {
        return Airport_ID;
    }

    public String getCity() {
        return City;
    }

    public String getCountry() {
        return Country;
    }
}
