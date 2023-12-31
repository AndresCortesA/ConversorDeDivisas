import javax.swing.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Menú principal
        String[] options = { "COP a Extranjera", "COP a Extranjera Detalles", "Extranjera a COP", "Temperatura", "Salir" };
        int selectedOption = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Conversor de Divisas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        while (selectedOption != 4) {
            switch (selectedOption) {
                case 0 -> convertCOPtoForeign();
                case 1 -> convertCOPtoForeignDetails();
                case 2 -> convertForeignToCOP();
                case 3 -> convertTemperature();
            }

            selectedOption = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Conversor de Divisas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        }

        // Salir del programa
        System.exit(0);
    }

    private static void convertCOPtoForeign() {
        // Menú para convertir entre COP y moneda extranjera
        String[] conversionOptions = { "USD", "EUR", "GBP", "JPY", "KRW" };
        String selectedCurrency = (String) JOptionPane.showInputDialog(null,
                "Seleccione la moneda extranjera a convertir:", "Conversor de Divisas", JOptionPane.PLAIN_MESSAGE,
                null, conversionOptions, conversionOptions[0]);

        // Solicitar cantidad de dinero en COP al usuario
        String amountInput = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero (COP):");
        double amount = Double.parseDouble(amountInput);

        // Realizar la conversión seleccionada
        double convertedAmount = switch (selectedCurrency) {
            case "USD" -> convertToUSD(amount);
            case "EUR" -> convertToEUR(amount);
            case "GBP" -> convertToGBP(amount);
            case "JPY" -> convertToJPY(amount);
            default -> convertToKRW(amount);
        };

        // Mostrar resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(null,
                "Cantidad a convertir (COP): " + amount + "\n" +
                        "Cantidad convertida (" + selectedCurrency + "): " + convertedAmount);
    }

    private static void convertCOPtoForeignDetails() {
        // Menú para convertir de COP a todas las monedas extranjeras
        // Solicitar cantidad de dinero en COP al usuario
        String amountInput = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero (COP):");
        double amount = Double.parseDouble(amountInput);

        // Realizar las conversiones a todas las monedas extranjeras
        double usd = convertToUSD(amount);
        double eur = convertToEUR(amount);
        double gbp = convertToGBP(amount);
        double jpy = convertToJPY(amount);
        double krw = convertToKRW(amount);

        // Mostrar resultados en un cuadro de diálogo
        JOptionPane.showMessageDialog(null,
                "Cantidad a convertir (COP): " + amount + "\n\n" +
                        "Conversiones a otras monedas:\n" +
                        "Dólares (USD): " + usd + "\n" +
                        "Euros (EUR): " + eur + "\n" +
                        "Libras Esterlinas (GBP): " + gbp + "\n" +
                        "Yen Japonés (JPY): " + jpy + "\n" +
                        "Won surcoreano (KRW): " + krw);
    }

    private static void convertForeignToCOP() {
        // Menú para convertir de todas las monedas extranjeras a COP
        String[] conversionOptions = { "USD", "EUR", "GBP", "JPY", "KRW" };
        String selectedCurrency = (String) JOptionPane.showInputDialog(null,
                "Seleccione la moneda extranjera a convertir a COP:", "Conversor de Divisas",
                JOptionPane.PLAIN_MESSAGE, null, conversionOptions, conversionOptions[0]);

        // Solicitar cantidad de dinero en la moneda extranjera al usuario
        String amountInput = JOptionPane.showInputDialog(null,
                "Ingrese la cantidad de dinero en " + selectedCurrency + ":");
        double amount = Double.parseDouble(amountInput);

        // Realizar la conversión a COP
        double convertedAmount = switch (selectedCurrency) {
            case "USD" -> convertUSDtoCOP(amount);
            case "EUR" -> convertEURtoCOP(amount);
            case "GBP" -> convertGBPtoCOP(amount);
            case "JPY" -> convertJPYtoCOP(amount);
            default -> convertKRWtoCOP(amount);
        };

        // Mostrar resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(null,
                "Cantidad a convertir (" + selectedCurrency + "): " + amount + "\n" +
                        "Cantidad convertida (COP): " + convertedAmount);
    }

    private static void convertTemperature() {
        // Conversión de temperatura
        String[] temperatureOptions = { "Celsius a Fahrenheit", "Fahrenheit a Celsius" };
        int selectedTemperatureOption = JOptionPane.showOptionDialog(null, "Seleccione la conversión de temperatura:",
                "Conversor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                temperatureOptions, temperatureOptions[0]);

        if (selectedTemperatureOption == 0) {
            // Conversión de Celsius a Fahrenheit
            String temperatureInput = JOptionPane.showInputDialog(null, "Ingrese la temperatura en Celsius:");
            double celsius = Double.parseDouble(temperatureInput);
            double fahrenheit = convertCelsiusToFahrenheit(celsius);

            JOptionPane.showMessageDialog(null,
                    "Temperatura en Celsius: " + celsius + "\n" +
                            "Temperatura en Fahrenheit: " + fahrenheit);
        } else if (selectedTemperatureOption == 1) {
            // Conversión de Fahrenheit a Celsius
            String temperatureInput = JOptionPane.showInputDialog(null, "Ingrese la temperatura en Fahrenheit:");
            double fahrenheit = Double.parseDouble(temperatureInput);
            double celsius = convertFahrenheitToCelsius(fahrenheit);

            JOptionPane.showMessageDialog(null,
                    "Temperatura en Fahrenheit: " + fahrenheit + "\n" +
                            "Temperatura en Celsius: " + celsius);
        }
    }

    // Conversión a Dólares (USD)
    private static double convertToUSD(double amount) {
        // Conversión de Peso Colombiano (COP) a Dólar Estadounidense (USD)
        double conversionRate = 4168.00;
        return amount / conversionRate;
    }

    // Conversión a Euros (EUR)
    private static double convertToEUR(double amount) {
        // Conversión de Peso Colombiano (COP) a Euro (EUR)
        double conversionRate = 4552.08;
        return amount / conversionRate;
    }

    // Conversión a Libras Esterlinas (GBP)
    private static double convertToGBP(double amount) {
        // Conversión de Peso Colombiano (COP) a Libra Esterlina (GBP)
        double conversionRate = 5296.07;
        return amount / conversionRate;
    }

    // Conversión a Yen Japonés (JPY)
    private static double convertToJPY(double amount) {
        // Conversión de Peso Colombiano (COP) a Yen Japonés (JPY)
        double conversionRate = 28.88;
        return amount / conversionRate;
    }

    // Conversión a Won surcoreano (KRW)
    private static double convertToKRW(double amount) {
        // Conversión de Peso Colombiano (COP) a Won surcoreano (KRW)
        double conversionRate = 3.17;
        return amount / conversionRate;
    }

    //------------------------------------------------------------------ conversores inversos ----------------------------------

    // Conversión de Dólar Estadounidense (USD) a Peso Colombiano (COP)
    private static double convertUSDtoCOP(double foreignAmount) {
        double conversionRate = 1.0 / 4168.00; // Ejemplo: 1 USD = 4168.00 COP
        return foreignAmount / conversionRate;
    }

    // Conversión de Euro (EUR) a Peso Colombiano (COP)
    private static double convertEURtoCOP(double foreignAmount) {
        double conversionRate = 1.0 / 4552.08; // Ejemplo: 1 EUR = 4552.08 COP
        return foreignAmount / conversionRate;
    }

    // Conversión de Libra Esterlina (GBP) a Peso Colombiano (COP)
    private static double convertGBPtoCOP(double foreignAmount) {
        double conversionRate = 1.0 / 5296.07; // Ejemplo: 1 GBP = 5296.07 COP
        return foreignAmount / conversionRate;
    }

    // Conversión de Yen Japonés (JPY) a Peso Colombiano (COP)
    private static double convertJPYtoCOP(double foreignAmount) {
        double conversionRate = 1.0 / 28.88; // Ejemplo: 1 JPY = 28.88 COP
        return foreignAmount / conversionRate;
    }

    // Conversión de Won surcoreano (KRW) a Peso Colombiano (COP)
    private static double convertKRWtoCOP(double foreignAmount) {
        double conversionRate = 1.0 / 3.17; // Ejemplo: 1 KRW = 3.17 COP
        return foreignAmount / conversionRate;
    }

    // Conversión de Celsius a Fahrenheit (°C a °F)
    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    // Conversión de Fahrenheit a Celsius (°F a °C)
    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
}