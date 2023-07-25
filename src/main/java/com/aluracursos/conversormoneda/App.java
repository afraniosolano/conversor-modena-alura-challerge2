package com.aluracursos.conversormoneda;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;
	private JComboBox<String> conversionTypeComboBox;
    private JTextField inputField;
    private JLabel resultLabel;
    private JLabel formulaLabel;

    public App() {
        setTitle("Herramienta de Conversión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] conversionTypes = {"Monedas", "Temperatura", "Kilos a Libras"};
        conversionTypeComboBox = new JComboBox<>(conversionTypes);

        inputField = new JTextField(10);
        resultLabel = new JLabel("Resultado: ");
        formulaLabel = new JLabel("Fórmula: ");

        JButton convertButton = new JButton("Convertir");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Agregamos espacios de 10 píxeles entre filas y columnas
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Agregamos un margen de 10 píxeles en todos los lados
        panel.add(conversionTypeComboBox);
        panel.add(inputField);
        panel.add(resultLabel);
        panel.add(formulaLabel);

        add(panel, BorderLayout.CENTER);
        add(convertButton, BorderLayout.SOUTH);
    }

    private void convert() {
        String conversionType = (String) conversionTypeComboBox.getSelectedItem();
        String inputValue = inputField.getText();

        try {
            double input = Double.parseDouble(inputValue);
            double result = 0.0;
            String formula = "";

            switch (conversionType) {
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
            resultLabel.setText("Resultado: " + decimalFormat.format(result));
            formulaLabel.setText("Fórmula: " + formula);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double convertCurrency(double input) {
        // Implementa aquí la lógica para el conversor de monedas
        // Por ejemplo, si deseas convertir de dólares a euros, aquí harías la conversión.
        // Para este ejemplo, se devolverá el mismo valor ingresado.
        return input;
    }

    private double convertTemperature(double input) {
        return (input * 9 / 5) + 32;
    }

    private double convertKilosToPounds(double input) {
        return input * 2.20462;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
