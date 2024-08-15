package com.mainpharmacy.activeprinciple.infraestructure.activeprincipleui;

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

import com.mainpharmacy.activeprinciple.aplication.FindActivePrincipleByCodeUseCase;
import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;
import com.mainpharmacy.activeprinciple.infraestructure.ActivePrincipleRepository;

public class FindActivePrincipleUI extends JFrame implements ActionListener{
    private JLabel  labelcode, title, logoImg, labelName, Name;
    private JTextField codeactiveprinciple;
    private JButton findButton, backButton, newButton;

    ActivePrincipleService activeprincipleService = new ActivePrincipleRepository();
    FindActivePrincipleByCodeUseCase findActivePrincipleByCodeUseCase = new FindActivePrincipleByCodeUseCase(activeprincipleService);

    public FindActivePrincipleUI(){
                setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Find Active");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/chemical.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Find Active");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelcode = new JLabel("Code : ");
        labelcode.setBounds(100, 130, 150, 30);
        labelcode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelcode.setForeground(new Color(0, 0, 100));
        add(labelcode);

        codeactiveprinciple = new JTextField();
        codeactiveprinciple.setBounds(170, 130, 220, 30);
        codeactiveprinciple.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        codeactiveprinciple.setForeground(new Color(0, 0, 100));
        add(codeactiveprinciple);

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

    public void startFindActivePrinciple() {
        FindActivePrincipleUI findUI = new FindActivePrincipleUI();
        findUI.setBounds(0, 0, 520, 350);
        findUI.setVisible(true);
        findUI.setResizable(false);
        findUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                int activeprincipleCode = Integer.parseInt(codeactiveprinciple.getText().trim().toUpperCase());
                if (activeprincipleCode>0){
                    Optional<ActivePrinciple> activeprinciple = findActivePrincipleByCodeUseCase.findActivePrincipleByCode(activeprincipleCode);
                    if (activeprinciple.isPresent()){
                        Name.setVisible(true);
                        Name.setText(activeprinciple.get().getDescriptionmode());
                    } else {
                        JOptionPane.showMessageDialog(this, "The ActivePrinciple doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

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
            codeactiveprinciple.setText("");
        
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            ActivePrincipleUI activeprincipleUI = new ActivePrincipleUI();
            activeprincipleUI.startActivePrinciple();
        }

    }

    }

