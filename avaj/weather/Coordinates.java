package avaj.weather;

public class Coordinates {
    // instances (data)
    private int longitude;
    private int latitude;
    private int height;
    // constructor initializes instances
    public Coordinates(int longitude, int latitude, int height) throws ArithmeticException {
        
        if ((longitude < 0) || (latitude < 0) || (height < 0)) {
			throw new ArithmeticException("Error: Coordinates cannot be negative for aircrafts");
		}
        
        if (height > 100)
            throw new ArithmeticException("Error: Height cannot be greater than 100");
        
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