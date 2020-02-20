package goedegep.geo.dbl;

import java.util.logging.Logger;

public class WGS84BoundingBox {
  @SuppressWarnings("unused")
private static final Logger LOGGER = Logger.getLogger(WGS84BoundingBox.class.getName());

  private final double west;
  private final double north;
  private final double east;
  private final double south;
  
  public WGS84BoundingBox(double west, double north, double east, double south) {
    this.west = west;
    this.north = north;
    this.east = east;
    this.south = south;
  }
  
  public WGS84BoundingBox(double westAndEast, double northAndSouth) {
    this(westAndEast, northAndSouth, westAndEast, northAndSouth);
  }

  public double getWest() {
    return west;
  }

  public double getNorth() {
    return north;
  }

  public double getEast() {
    return east;
  }

  public double getSouth() {
    return south;
  }

  public WGS84Coordinates getCenter() {
    double width = east - west;
    double height = north - south;
    
    return new WGS84Coordinates(south + height / 2, west + width / 2);
  }
  
  public WGS84BoundingBox extend(WGS84BoundingBox boundingBox) {
    return new WGS84BoundingBox(
        Math.min(west, boundingBox.getWest()),
        Math.max(north, boundingBox.getNorth()),
        Math.max(east, boundingBox.getEast()),
        Math.min(south, boundingBox.getSouth()));
  }

  public WGS84BoundingBox extend(double longitude, double latitude) {
    WGS84BoundingBox extendedBoundingBox = new WGS84BoundingBox(
        Math.min(west, longitude),
        Math.max(north, latitude),
        Math.max(east, longitude),
        Math.min(south, latitude));
    
    return extendedBoundingBox;
  }
  
  public String toString() {
    return String.valueOf(west) + ", " + String.valueOf(north) + ", " + String.valueOf(east) + ", " + String.valueOf(south);
  }
}
