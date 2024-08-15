package com.mainpharmacy.city.infraestructure.cityui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mainpharmacy.city.aplication.FindCityByCodeUseCase;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;
import com.mainpharmacy.country.aplication.FindCountryByCodeUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.region.aplication.FindRegionByCodeUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FindLaboratoryUI extends JFrame implements ActionListener{
    private JLabel  labelcode, title, logoImg, labelName, labelRegion, Name, Region, labelCountry, country;
    private JButton NewButton, findButton, backButton;
    private JTextField codecity;

    CityService CityService = new CityRepository();
    FindCityByCodeUseCase findCityByCodeUseCase = new FindCityByCodeUseCase(CityService);
    RegionService RegionService = new RegionRepository();
    FindRegionByCodeUseCase findRegionByCodeUseCase = new FindRegionByCodeUseCase(RegionService);
    CountryService countryService = new CountryRepository();
    FindCountryByCodeUseCase findCountryByCodeUseCase = new FindCountryByCodeUseCase(countryService);

    public FindLaboratoryUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Find City");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Find City");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 35));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelcode = new JLabel("Code : ");
        labelcode.setBounds(80, 130, 150, 30);
        labelcode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelcode.setForeground(new Color(0, 0, 100));
        add(labelcode);

        codecity = new JTextField();
        codecity.setBounds(170, 130, 220, 30);
        codecity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        codecity.setForeground(new Color(0, 0, 100));
        add(codecity);

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(80, 210, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        Region = new JLabel();
        Region.setBounds(170, 210, 220, 30);
        Region.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Region.setForeground(new Color(0, 0, 100));
        Region.setVisible(false);
        add(Region);
        
        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(80, 170, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        country = new JLabel();
        country.setBounds(170, 170, 220, 30);
        country.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        country.setForeground(new Color(0, 0, 100));
        country.setVisible(false);
        add(country);

        labelName = new JLabel("Name : ");
        labelName.setBounds(80, 250, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JLabel();
        Name.setBounds(170, 250, 220, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        NewButton = new JButton("New");
        NewButton.setBounds(125, 310, 120, 30);
        NewButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        NewButton.setForeground(new Color(0, 0, 100));
        NewButton.addActionListener(this);
        add(NewButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 310, 120, 30);
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


    public void startFindCity() {
        FindLaboratoryUI FindUI = new FindLaboratoryUI();
        FindUI.setBounds(0, 0, 520, 400);
        FindUI.setVisible(true);
        FindUI.setResizable(false);
        FindUI.setLocationRelativeTo(null);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                String CityCode = codecity.getText().trim().toUpperCase();
                if (CityCode.length()>0){
                    Optional<City> City = findCityByCodeUseCase.findCityByCode(CityCode);
                    if (City.isPresent()){
                        Name.setVisible(true);
                        Name.setText(City.get().getNamecity());
                        Optional<Region> foundRegion = findRegionByCodeUseCase.findRegionByCode(City.get().getCodereg());
                        Region.setVisible(true);
                        Region.setText(foundRegion.get().getNamereg());
                        Optional<Country> foundCountry = findCountryByCodeUseCase.findCountryByCode(foundRegion.get().getCodeCountry());
                        country.setVisible(true);
                        country.setText(foundCountry.get().getName());
                    } else {
                        JOptionPane.showMessageDialog(this, "The City doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  

        if(e.getSource()==NewButton){
            codecity.setText("");
            Name.setVisible(false);
            Name.setText("");
            Region.setText("");
            Region.setVisible(false);
            country.setText("");
            country.setVisible(false);
        
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            LaboratoryUI CityUI = new LaboratoryUI();
            CityUI.startCity();
        }
    }

}
