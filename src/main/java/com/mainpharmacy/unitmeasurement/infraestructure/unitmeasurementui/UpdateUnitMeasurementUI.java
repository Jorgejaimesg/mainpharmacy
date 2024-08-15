package com.mainpharmacy.unitmeasurement.infraestructure.unitmeasurementui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mainpharmacy.unitmeasurement.aplication.FindUnitMeasurementByCodeUseCase;
import com.mainpharmacy.unitmeasurement.aplication.UpdateUnitMeasurementUseCase;
import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;
import com.mainpharmacy.unitmeasurement.infraestructure.UnitMeasurementRepository;

import javax.swing.JOptionPane;

public class UpdateUnitMeasurementUI extends JFrame implements ActionListener {
    private JLabel  labelcode, title, logoImg, labelName;
    private JTextField codeunitmeasurement, Name;
    private JButton updateButton, findButton, backButton;

    UnitMeasurementService unitmeasurementService = new UnitMeasurementRepository();
    FindUnitMeasurementByCodeUseCase findUnitMeasurementByCodeUseCase = new FindUnitMeasurementByCodeUseCase(unitmeasurementService);
    UpdateUnitMeasurementUseCase updateUnitMeasurementUseCase = new UpdateUnitMeasurementUseCase(unitmeasurementService);

    public UpdateUnitMeasurementUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update Unit");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/measurement.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Update Unit");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelcode = new JLabel("Code : ");
        labelcode.setBounds(100, 130, 150, 30);
        labelcode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelcode.setForeground(new Color(0, 0, 100));
        add(labelcode);

        codeunitmeasurement = new JTextField();
        codeunitmeasurement.setBounds(170, 130, 220, 30);
        codeunitmeasurement.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        codeunitmeasurement.setForeground(new Color(0, 0, 100));
        add(codeunitmeasurement);

        labelName = new JLabel("Name : ");
        labelName.setBounds(95, 170, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(170, 170, 220, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        updateButton = new JButton("Update");
        updateButton.setBounds(125, 240, 120, 30);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 240, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        findButton = new JButton("🔍");
        findButton.setBounds(400, 130, 60, 30);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);

    }

    public void startUpdateUnitMeasurement() {
        UpdateUnitMeasurementUI updateUI = new UpdateUnitMeasurementUI();
        updateUI.setBounds(0, 0, 520, 350);
        updateUI.setVisible(true);
        updateUI.setResizable(false);
        updateUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                int unitmeasurementCode = Integer.parseInt(codeunitmeasurement.getText().trim().toUpperCase());
                if (unitmeasurementCode>0){
                    Optional<UnitMeasurement> unitmeasurement = findUnitMeasurementByCodeUseCase.findUnitMeasurementByCode(unitmeasurementCode);
                    if (unitmeasurement.isPresent()){
                        Name.setVisible(true);
                        Name.setText(unitmeasurement.get().getDescriptionmode());
                    } else {
                        JOptionPane.showMessageDialog(this, "The UnitMeasurement doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==updateButton){
            int unitmeasurementid = Integer.parseInt(codeunitmeasurement.getText().trim());
            String unitmeasurementName = Name.getText().trim();
            UnitMeasurement updatedUnitMeasurement = new UnitMeasurement();
            updatedUnitMeasurement.setDescriptionmode(unitmeasurementName);
            updatedUnitMeasurement.setId(unitmeasurementid);
            if (unitmeasurementName.length()>0){
                updateUnitMeasurementUseCase.execute(updatedUnitMeasurement);
                JOptionPane.showMessageDialog(this, "Updated succesfully", "succes", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "Error to update", "Error", JOptionPane.ERROR_MESSAGE);

            }
            System.out.println(updatedUnitMeasurement);
            Name.setText("");
            codeunitmeasurement.setText("");
            Name.setVisible(false);
    }

        if(e.getSource()==backButton){
            this.setVisible(false);
            UnitMeasurementUI unitmeasurementUI = new UnitMeasurementUI();
            unitmeasurementUI.startUnitMeasurement();
        }
    }
    }
