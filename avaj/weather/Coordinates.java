package avaj.weather;

public class Coordinates {
    // instances (data)
    private int longitude;
    private int latitude;
    private int height;
    // constructor initializes instances
    public Coordinates(int longitude, int latitude, int height) throws ArithmeticException {
        
        if (longitude < 0)
            longitude = 0;
        else if (latitude < 0)
            latitude = 0;
        else if (height > 100)
            height = 100;
        
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