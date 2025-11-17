//ALUNOS: LARYSSA BARBOSA SOARES E MELISSA ESCARMELOTO GUEDES

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa extends JFrame {

    private JTextField txtNumero, txtNome, txtSexo, txtIdade;
    private JRadioButton rbM, rbF;
    private ButtonGroup grupoSexo;
    private JButton btnCadastrar, btnLimpar, btnMostrar, btnSair;

    private Pessoa umaPessoa = new Pessoa();

    public FormPessoa() {
        setTitle("Semana 06 - Exercicio 1");
        setSize(580, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Numero:"));
        txtNumero = new JTextField(String.valueOf(umaPessoa.getKp()));
        txtNumero.setEnabled(false);
        add(txtNumero);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Sexo:"));

        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbM = new JRadioButton("M");
        rbF = new JRadioButton("F");

        grupoSexo = new ButtonGroup();
        grupoSexo.add(rbM);
        grupoSexo.add(rbF);

        painelSexo.add(rbM);
        painelSexo.add(rbF);
        add(painelSexo);

        add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        add(txtIdade);

        // BOTÕES
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        add(btnCadastrar);
        add(btnLimpar);
        add(btnMostrar);
        add(btnSair);

        // ACÕES
        btnCadastrar.addActionListener(e -> cadastrar());
        btnLimpar.addActionListener(e -> limparCampos());
        btnMostrar.addActionListener(e -> mostrarDados());
        btnSair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void cadastrar() {
        if (!validarCampos()) return;

        umaPessoa.setNome(txtNome.getText());
        umaPessoa.setSexo(rbM.isSelected() ? 'M' : 'F');
        umaPessoa.setIdade(Integer.parseInt(txtIdade.getText()));

        JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!");
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        grupoSexo.clearSelection();
        txtNome.requestFocus();
    }

    private void mostrarDados() {
        JOptionPane.showMessageDialog(this,
                "Numero: " + umaPessoa.getKp() +
                "\nNome:   " + umaPessoa.getNome() +
                "\nSexo:   " + umaPessoa.getSexo() +
                "\nIdade:  " + umaPessoa.getIdade());
    }

    private boolean validarCampos() {
        if (txtNome.getText().trim().isEmpty()) {
            alert("O campo Nome e obrigatorio!");
            return false;
        }

        if (!rbM.isSelected() && !rbF.isSelected()) {
            alert("Selecione o sexo!");
            return false;
        }

        try {
            int idade = Integer.parseInt(txtIdade.getText().trim());
            if (idade < 0) throw new NumberFormatException();
        } catch (Exception ex) {
            alert("Idade invalida.");
            return false;
        }

        return true;
    }

    private void alert(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new FormPessoa();
    }
}

