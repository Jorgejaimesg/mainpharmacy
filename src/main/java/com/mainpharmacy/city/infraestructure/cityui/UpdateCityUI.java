package com.mainpharmacy.city.infraestructure.cityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import com.mainpharmacy.city.aplication.FindCityByCodeUseCase;
import com.mainpharmacy.city.aplication.UpdateCityUseCase;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;
import com.mainpharmacy.country.aplication.FindAllCountryUseCase;
import com.mainpharmacy.country.aplication.FindCountryByCodeUseCase;
import com.mainpharmacy.country.aplication.FindCountryByNameUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.region.aplication.FindRegionByCodeUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCountryUseCase;
import com.mainpharmacy.region.aplication.FindRegionByNameUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;

public class UpdateCityUI extends JFrame implements ActionListener{
    private JLabel  labelcode, title, logoImg, labelName, labelRegion, labelCountry;
    private JButton updateButton, findButton, backButton;
    private JTextField codecity, Name;
    private JComboBox<String> Region, country;
    private String countryID;

    CityService CityService = new CityRepository();
    FindCityByCodeUseCase findCityByCodeUseCase = new FindCityByCodeUseCase(CityService);
    UpdateCityUseCase updateCityUseCase = new UpdateCityUseCase(CityService);
    RegionService RegionService = new RegionRepository();
    FindRegionByCodeUseCase findRegionByCodeUseCase = new FindRegionByCodeUseCase(RegionService);
    FindRegionByNameUseCase findRegionByNameUseCase = new FindRegionByNameUseCase(RegionService);
    FindRegionByCountryUseCase findRegionByCountryUseCase = new FindRegionByCountryUseCase(RegionService);
    CountryService countryService = new CountryRepository();
    FindCountryByCodeUseCase findCountryByCodeUseCase = new FindCountryByCodeUseCase(countryService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(countryService);
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(countryService);
    List<Country> countries = findAllCountryUseCase.findAllCountry();


    public UpdateCityUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update City");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(80, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Find region");
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

                
        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(80, 170, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        country = new JComboBox<String>();
        country.setBounds(170, 170, 220, 30);
        country.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        country.setForeground(new Color(0, 0, 100));
        country.setVisible(false);
        add(country);
        country.addItem("");
        for(Country countrylist : countries){
            country.addItem(countrylist.getName());
        };

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(80, 210, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        Region = new JComboBox<String>();
        Region.setBounds(170, 210, 220, 30);
        Region.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Region.setForeground(new Color(0, 0, 100));
        Region.setVisible(false);
        add(Region);
        Region.addItem("");
        country.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRegionupdated();
            }
        });

        labelName = new JLabel("Name : ");
        labelName.setBounds(80, 250, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(170, 250, 220, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        updateButton = new JButton("Update");
        updateButton.setBounds(125, 310, 120, 30);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

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

        private void actualizarRegionupdated() {
        Region.removeAllItems(); 
        String countryName = country.getSelectedItem().toString();
        Optional<Country> countryFound = findCountryByNameUseCase.findCountryByName(countryName);
        if (countryFound.isPresent()){
        this.countryID =countryFound.get().getCodeCountry();
        List<Region> Regions = findRegionByCountryUseCase.findAllRegionByCountry(countryID);
        for(Region Regionitem : Regions){
            Region.addItem(Regionitem.getNamereg());
        };
    }}


    public void startUpdateCity() {
        UpdateCityUI UpdateUI = new UpdateCityUI();
        UpdateUI.setBounds(0, 0, 520, 400);
        UpdateUI.setVisible(true);
        UpdateUI.setResizable(false);
        UpdateUI.setLocationRelativeTo(null);
        
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
                        Region.setSelectedItem(foundRegion.get().getNamereg());
                        Optional<Country> foundCountry = findCountryByCodeUseCase.findCountryByCode(foundRegion.get().getCodeCountry());
                        country.setVisible(true);
                        country.setSelectedItem(foundCountry.get().getName());
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

        if(e.getSource()==updateButton){

            String CityName = Name.getText().trim();
            String Citycode = codecity.getText().trim().toUpperCase();
            String RegionName = Region.getSelectedItem().toString();
            Optional<Region> foundRegion = findRegionByNameUseCase.execute(countryID, RegionName);
            if(foundRegion.isPresent()){
                City updatedCity = new City();
                updatedCity.setCodereg(foundRegion.get().getCodereg());
                updatedCity.setNamecity(CityName);
                updatedCity.setCodecity(Citycode);
                if (CityName.length()>0){
                    updateCityUseCase.execute(updatedCity);
                    JOptionPane.showMessageDialog(this, "Updated succesfully", "succes", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "Error to update", "Error", JOptionPane.ERROR_MESSAGE);
    
                }
                System.out.println(updatedCity);
                Name.setVisible(false);
                codecity.setText("");
                Region.setVisible(false);
                Name.setVisible(false);
                country.setVisible(false);

            }
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            CityUI CityUI = new CityUI();
            CityUI.startCity();
        }


    }

}
