package com.mainpharmacy.modeadministration.infraestructure.modeadministrationui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import com.mainpharmacy.modeadministration.aplication.FindModeAdministrationByCodeUseCase;
import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;
import com.mainpharmacy.modeadministration.infraestructure.ModeAdministrationRepository;

public class FindModeAdministrationUI extends JFrame implements ActionListener{
    private JLabel  labelcode, title, logoImg, labelName, Name;
    private JTextField codemodeadministration;
    private JButton findButton, backButton, newButton;

    ModeAdministrationService modeadministrationService = new ModeAdministrationRepository();
    FindModeAdministrationByCodeUseCase findModeAdministrationByCodeUseCase = new FindModeAdministrationByCodeUseCase(modeadministrationService);

    public FindModeAdministrationUI(){
                setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Find Method");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/ways.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Find Method");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelcode = new JLabel("Code : ");
        labelcode.setBounds(100, 130, 150, 30);
        labelcode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelcode.setForeground(new Color(0, 0, 100));
        add(labelcode);

        codemodeadministration = new JTextField();
        codemodeadministration.setBounds(170, 130, 220, 30);
        codemodeadministration.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        codemodeadministration.setForeground(new Color(0, 0, 100));
        add(codemodeadministration);

        labelName = new JLabel("Name : ");
        labelName.setBounds(95, 170, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JLabel();
        Name.setBounds(170, 170, 220, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 240, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        newButton = new JButton("New");
        newButton.setBounds(125, 240, 120, 30);
        newButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        newButton.setForeground(new Color(0, 0, 100));
        newButton.addActionListener(this);
        add(newButton);

        findButton = new JButton("🔍");
        findButton.setBounds(400, 130, 60, 30);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);

    }

    public void startFindModeAdministration() {
        FindModeAdministrationUI findUI = new FindModeAdministrationUI();
        findUI.setBounds(0, 0, 520, 350);
        findUI.setVisible(true);
        findUI.setResizable(false);
        findUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                int modeadministrationCode = Integer.parseInt(codemodeadministration.getText().trim().toUpperCase());
                if (modeadministrationCode>0){
                    Optional<ModeAdministration> modeadministration = findModeAdministrationByCodeUseCase.findModeAdministrationByCode(modeadministrationCode);
                    if (modeadministration.isPresent()){
                        Name.setVisible(true);
                        Name.setText(modeadministration.get().getDescriptionmode());
                    } else {
                        JOptionPane.showMessageDialog(this, "The ModeAdministration doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==newButton){
            Name.setVisible(false);
            Name.setText("");
            codemodeadministration.setText("");
        
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            ModeAdministrationUI modeadministrationUI = new ModeAdministrationUI();
            modeadministrationUI.startModeAdministration();
        }

    }

    }

