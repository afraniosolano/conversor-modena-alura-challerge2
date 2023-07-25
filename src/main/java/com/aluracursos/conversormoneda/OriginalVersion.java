package com.aluracursos.conversormoneda;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class OriginalVersion {

    public static void main(String[] args) {
        String[] conversionTypes = {"Monedas", "Temperatura", "Kilos a Libras"};
        String selectedConversion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el tipo de conversión:",
                "Herramienta de Conversión",
                JOptionPane.QUESTION_MESSAGE,
                null,
                conversionTypes,
                conversionTypes[0]);

        if (selectedConversion != null) {
            String inputValue = JOptionPane.showInputDialog("Ingrese el valor a convertir:");
            if (inputValue != null && !inputValue.isEmpty()) {
                try {
                    double input = Double.parseDouble(inputValue);
                    double result = 0.0;
                    String formula = "";

                    switch (selectedConversion) {
                        case "Monedas":
                            result = convertCurrency(input);
                            formula = input + " unidades = " + result + " unidades convertidas (fórmula: result = input)";
                            break;
                        case "Temperatura":
                            result = convertTemperature(input);
                            formula = input + " °C = " + result + " °F (fórmula: result = (input * 9/5) + 32)";
                            break;
                        case "Kilos a Libras":
                            result = convertKilosToPounds(input);
                            formula = input + " kilos = " + result + " libras (fórmula: result = input * 2.20462)";
                            break;
                    }

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String message = "Resultado: " + decimalFormat.format(result) + "\nFórmula: " + formula;
                    JOptionPane.showMessageDialog(null, message, "Resultado de Conversión", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un valor a convertir.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static double convertCurrency(double input) {
        // Implementa aquí la lógica para el conversor de monedas
        // Por ejemplo, si deseas convertir de dólares a euros, aquí harías la conversión.
        // Para este ejemplo, se devolverá el mismo valor ingresado.
        return input;
    }

    private static double convertTemperature(double input) {
        return (input * 9 / 5) + 32;
    }

    private static double convertKilosToPounds(double input) {
        return input * 2.20462;
    }
}
