package com.learning.measurement;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ConverterApp extends JFrame {

    private JPanel contentPane;
    private JTextField txtMetros;
    private JComboBox cboConverter;
    private JLabel lblResult;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConverterApp frame = new ConverterApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConverterApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(28, 12, 156, 201);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(ConverterApp.class.getResource
        ("/com/learning/images/medidas.png")));
        label.setBounds(12, 14, 133, 169);
        panel.add(label);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(186, 12, 219, 201);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblMetros = new JLabel("Metros");
        lblMetros.setBounds(0, 32, 70, 15);
        panel_1.add(lblMetros);

        txtMetros = new JTextField();
        txtMetros.setBounds(83, 28, 114, 24);
        panel_1.add(txtMetros);
        txtMetros.setColumns(10);

        cboConverter = new JComboBox();
        cboConverter.setModel(new DefaultComboBoxModel(new String[]{
            "Centimetros", "Milimetros", "Pies", "Pulgadas", "Yardas",
            "Años Luz", "Angstroms"}));
        cboConverter.setBounds(83, 77, 114, 24);
        panel_1.add(cboConverter);

        JLabel lblConvertirA = new JLabel("Convertir a");
        lblConvertirA.setBounds(0, 82, 83, 15);
        panel_1.add(lblConvertirA);

        lblResult = new JLabel("");
        lblResult.setBounds(12, 136, 195, 24);
        panel_1.add(lblResult);

        JButton btnNewButton = new JButton("Convertir");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtMetros.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "debe ingresar una medida");
                }
                try {
                	calculateConversion();
                }catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "solo se permiten numeros");
				}
                
            }
        });
        btnNewButton.setBounds(28, 248, 230, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Limpiar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtMetros.setText("");
                lblResult.setText("");
            }
        });
        btnNewButton_1.setBounds(283, 248, 117, 25);
        contentPane.add(btnNewButton_1);
    }

    public void calculateConversion()throws NumberFormatException{
        ConverMeasurement convermeasurement
                = new ConverMeasurement();
        String unitOfMeasurement;
        unitOfMeasurement = cboConverter.getSelectedItem().toString();
        switch (unitOfMeasurement) {
            case "Centimetros":
                lblResult.setText(convermeasurement
                        .toCentimeter(
                                Double.parseDouble(txtMetros.getText())) + 
                        " cms");
                break;
            case "Milimetros":
                lblResult.setText(convermeasurement
                        .toMillimeter(
                                Double.parseDouble(txtMetros.getText())) + 
                        " mm");
                break;

            case "Pies":
                lblResult.setText(convermeasurement.toFoot(
                        Double.parseDouble(txtMetros.getText())) + " ft");
                break;
            case "Pulgadas":
                lblResult.setText(convermeasurement.toInches(
                        Double.parseDouble(txtMetros.getText())) + " inch");
                break;
            case "Yardas":
                lblResult.setText(convermeasurement.toYard(
                        Double.parseDouble(txtMetros.getText())) + " yd");

                break;
            case "Años Luz":

                lblResult.setText(convermeasurement.toligthYear(
                        Double.parseDouble(txtMetros.getText())) + "  X  "
                        + "10e-16  ly");
                break;
            case "Angstroms":
                lblResult.setText(convermeasurement.toAngstrom(
                        Double.parseDouble(txtMetros.getText())) + " X "
                        + "10e10  A°");
                break;

        }
    }
}
