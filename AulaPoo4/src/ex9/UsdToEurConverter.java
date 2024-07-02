package ex9;

public class UsdToEurConverter implements CurrencyConverter{
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        return amount*0.93;
    }
}
