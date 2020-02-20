package goedegep.geo.dbl;

/**
 * This class represents the coordinates of a location. Coordinate's latitude and longitude are
 * represented in decimal degrees. A negative longitude means West (of Greenwich) and a negative latitude means South
 * (of the equator).
 */
public class WGS84Coordinates {
    private double latitude;
    private double longitude;
    
    public WGS84Coordinates(double latitude, double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder();
      
      buf.append(latitude);
      buf.append(", ");
      buf.append(longitude);
      
      return buf.toString();
    }
}
