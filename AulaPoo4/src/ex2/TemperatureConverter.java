package ex2;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return 1.8*celsius + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit-32)/1.8;
    }
}
