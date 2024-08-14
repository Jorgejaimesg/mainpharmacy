package com.mainpharmacy.region.infraestructure.regionui;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import com.mainpharmacy.country.aplication.FindCountryByCodeUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.region.aplication.FindRegionByCodeUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;

public class FindRegionUI extends JFrame implements ActionListener{
    private JLabel  labelcode, title, logoImg, labelName, labelCountry, Name, Countries;
    private JButton NewButton, findButton, backButton;
    private JTextField codeRegion;

    RegionService RegionService = new RegionRepository();
    FindRegionByCodeUseCase findRegionByCodeUseCase = new FindRegionByCodeUseCase(RegionService);
    CountryService countryService = new CountryRepository();
    FindCountryByCodeUseCase findCountryByCodeUseCase = new FindCountryByCodeUseCase(countryService);

    public FindRegionUI(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Find Region");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/regions.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Find Region");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelcode = new JLabel("Code : ");
        labelcode.setBounds(80, 130, 150, 30);
        labelcode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelcode.setForeground(new Color(0, 0, 100));
        add(labelcode);

        codeRegion = new JTextField();
        codeRegion.setBounds(170, 130, 220, 30);
        codeRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        codeRegion.setForeground(new Color(0, 0, 100));
        add(codeRegion);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(80, 170, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        Countries = new JLabel();
        Countries.setBounds(170, 170, 220, 30);
        Countries.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Countries.setForeground(new Color(0, 0, 100));
        Countries.setVisible(false);
        add(Countries);
    


        labelName = new JLabel("Name : ");
        labelName.setBounds(80, 210, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JLabel();
        Name.setBounds(170, 210, 220, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        NewButton = new JButton("New");
        NewButton.setBounds(125, 270, 120, 30);
        NewButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        NewButton.setForeground(new Color(0, 0, 100));
        NewButton.addActionListener(this);
        add(NewButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 270, 120, 30);
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

    public void startFindRegion() {
        FindRegionUI FindUI = new FindRegionUI();
        FindUI.setBounds(0, 0, 520, 350);
        FindUI.setVisible(true);
        FindUI.setResizable(false);
        FindUI.setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                String RegionCode = codeRegion.getText().trim().toUpperCase();
                if (RegionCode.length()>0){
                    Optional<Region> Region = findRegionByCodeUseCase.findRegionByCode(RegionCode);
                    if (Region.isPresent()){
                        Name.setVisible(true);
                        Name.setText(Region.get().getNamereg());
                        Optional<Country> foundCountry = findCountryByCodeUseCase.findCountryByCode(Region.get().getCodeCountry());
                        Countries.setVisible(true);
                        Countries.setText(foundCountry.get().getName());
                    } else {
                        JOptionPane.showMessageDialog(this, "The Region doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  

        if(e.getSource()==NewButton){
            codeRegion.setText("");
            Name.setVisible(false);
            Name.setText("");
            Countries.setVisible(false);
        
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            RegionUI RegionUI = new RegionUI();
            RegionUI.startRegion();
        }
    }
}
