package com.mainpharmacy.modeadministration.infraestructure.modeadministrationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.aplication.DeleteModeAdministrationUseCase;
import com.mainpharmacy.modeadministration.aplication.FindAllModeAdministrationUseCase;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;
import com.mainpharmacy.modeadministration.infraestructure.ModeAdministrationRepository;

public class DeleteModeAdministrationUI extends JFrame implements ActionListener{
    ModeAdministrationService modeadministrationService = new ModeAdministrationRepository();
    DeleteModeAdministrationUseCase deleteModeAdministrationUseCase = new DeleteModeAdministrationUseCase(modeadministrationService);
    FindAllModeAdministrationUseCase findAllModeAdministrationUseCase = new FindAllModeAdministrationUseCase(modeadministrationService);
    List<ModeAdministration> countries = findAllModeAdministrationUseCase.findAllModeAdministration();

    private JLabel logoImg, title, labelName;
    private JButton deleteButton, backButton;
    private JComboBox<String> Name;

    public DeleteModeAdministrationUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Delete ModeAdministration");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/ways.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Delete Way");
        title.setBounds(180, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelName = new JLabel("Way: ");
        labelName.setBounds(65, 130, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JComboBox<String>();
        Name.setBounds(170, 130, 255, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        add(Name);
        Name.addItem("");
        for(ModeAdministration modeadministration : countries){
            Name.addItem(modeadministration.getDescriptionmode());
        };



        deleteButton = new JButton("Delete");
        deleteButton.setBounds(125, 200, 120, 30);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 200, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }

    public void startDeleteModeAdministration() {
        DeleteModeAdministrationUI deleteUIA = new DeleteModeAdministrationUI();
        deleteUIA.setBounds(0, 0, 500, 300);
        deleteUIA.setVisible(true);
        deleteUIA.setResizable(false);
        deleteUIA.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deleteButton){

            try {
                String modeadministrationName = Name.getSelectedItem().toString();
                if (modeadministrationName.length()>0){   
                deleteModeAdministrationUseCase.execute(modeadministrationName);
                JOptionPane.showMessageDialog(this, "ModeAdministration deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                Name.setSelectedItem("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    if(e.getSource()==backButton){
            this.setVisible(false);
            ModeAdministrationUI modeadministrationUI = new ModeAdministrationUI();
            modeadministrationUI.startModeAdministration();
    }
    }
    }

