//ALUNOS: LARYSSA BARBOSA SOARES E MELISSA ESCARMELOTO GUEDES

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField display;
    private String operador = "";
    private double numero1 = 0;
    private boolean novoNumero = true;

    public Calculadora() {
        super("Calculadora");

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(5, 4, 5, 5));

        String[] botoes = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+",
            "C"
        };

        for (String txt : botoes) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);

            if (txt.equals("C")) {
                painelBotoes.add(btn);
                for (int i = 0; i < 3; i++) painelBotoes.add(new JLabel());
            } else {
                painelBotoes.add(btn);
            }
        }

        setLayout(new BorderLayout(5, 5));
        add(display, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = e.getActionCommand();

        try {
            if (texto.matches("[0-9]") || texto.equals(".")) {
                if (novoNumero) {
                    display.setText(texto);
                    novoNumero = false;
                } else {
                    display.setText(display.getText() + texto);
                }
            } 
            else if (texto.matches("[+\\-*/]")) {
                numero1 = Double.parseDouble(display.getText());
                operador = texto;
                novoNumero = true;
            } 
            else if (texto.equals("=")) {
                double numero2 = Double.parseDouble(display.getText());
                double resultado = 0;

                switch (operador) {
                    case "+": resultado = numero1 + numero2; break;
                    case "-": resultado = numero1 - numero2; break;
                    case "*": resultado = numero1 * numero2; break;
                    case "/":
                        if (numero2 == 0) throw new ArithmeticException("Divisão por zero!");
                        resultado = numero1 / numero2;
                        break;
                }

                display.setText(String.valueOf(resultado));
                novoNumero = true;
            }
            else if (texto.equals("C")) {
                display.setText("0");
                numero1 = 0;
                operador = "";
                novoNumero = true;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: número inválido!");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado!");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}


