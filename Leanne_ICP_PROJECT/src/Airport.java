//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Airport {
    private int Airport_ID;
    private String Name;
    private String City;
    private String Country;
    private String IATA_Code;
    private String ICAO_Code;
    private float Latitude;
    private float Longitude;
    private int Altitude;
    private float Timezone;
    private String DST;
    private String Tz_database_time_zone;
    private String Type;
    private String Source;

    /**
     * @param airport_ID
     * @param name
     * @param city
     * @param country
     * @param IATA_Code
     * @param ICAO_Code
     * @param latitude
     * @param longitude
     * @param altitude
     * @param timezone
     * @param DST
     * @param tz_database_time_zone
     * @param type
     * @param source
     * */
    public Airport(int airport_ID,
                   String name,
                   String city,
                   String country,
                   String IATA_Code,
                   String ICAO_Code,
                   float latitude,
                   float longitude,
                   int altitude,
                   float timezone,
                   String DST,
                   String tz_database_time_zone,
                   String type,
                   String source) {
        this.Airport_ID = airport_ID;
        this.Name = name;
        this.City = city;
        this.Country = country;
        this.IATA_Code = IATA_Code;
        this.ICAO_Code = ICAO_Code;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.Altitude = altitude;
        this.Timezone = timezone;
        this.DST = DST;
        this.Tz_database_time_zone = tz_database_time_zone;
        this.Type = type;
        this.Source = source;
    }


    public String getCity() {
        return this.City;
    }

    public String getCountry() {
        return this.Country;
    }

    public String getIATA_Code() {
        return this.IATA_Code;
    }

    /**
     * The toString() method returns a string representation of the object
     *
     * @return The toString method is being returned.
     */
    public String toString() {
        return "Airport{Airport_ID=" +
                this.Airport_ID +
                ", Name='" + this.Name + "', City='" + this.City + "', Country='" +
                this.Country +
                "', IATA_Code='" + this.IATA_Code + "', ICAO_Code='" + this.ICAO_Code +
                "', Latitude=" + this.Latitude + ", Longitude=" + this.Longitude +
                ", Altitude=" + this.Altitude + ", Timezone=" + this.Timezone +
                ", DST='" + this.DST + "', Tz_database_time_zone='" + this.Tz_database_time_zone +
                "', Type='" + this.Type + "', Source='" + this.Source + "'}";
    }

    /**
     * If the object is the same object, return true.
     * If the object is not an Airport object, return false. If the object
     * is an Airport object, compare the Airport_ID's
     *
     * @param obj The object to compare this Airport against.
     * @return The hashcode of the object.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Airport)) {
            return false;
        } else {
            Airport airport = (Airport)obj;
            return this.Airport_ID == airport.Airport_ID;
        }
    }
}
