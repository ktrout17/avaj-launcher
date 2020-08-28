package avaj.weather;


public class Coordinates {
    // instances (data)
    private int longitude;
    private int latitude;
    private int height;
    // constructor initializes instances
    public Coordinates(int longitude, int latitude, int height) {
        
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
    // methods (type int return type)
    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}