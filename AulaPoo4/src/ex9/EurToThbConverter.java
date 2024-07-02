package ex9;

public class EurToThbConverter implements CurrencyConverter{
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount*39.58;
    }
}
