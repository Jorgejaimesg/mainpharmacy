package com.mainpharmacy.city.infraestructure.cityui;

import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mainpharmacy.city.aplication.DeleteCityByNameUseCase;
import com.mainpharmacy.city.aplication.FindCityByRegionUseCase;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;
import com.mainpharmacy.country.aplication.FindAllCountryUseCase;
import com.mainpharmacy.country.aplication.FindCountryByNameUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.region.aplication.DeleteRegionByNameUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCountryUseCase;
import com.mainpharmacy.region.aplication.FindRegionByNameUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;

public class DeleteCityUI extends JFrame implements ActionListener {
    RegionService RegionService = new RegionRepository();
    CountryService countryService = new CountryRepository();
    CityService cityService = new CityRepository();
    FindCityByRegionUseCase findCityByRegionUseCase = new FindCityByRegionUseCase(cityService);
    DeleteCityByNameUseCase deleteCityByNameUseCase = new DeleteCityByNameUseCase(cityService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(countryService);
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(countryService);
    FindRegionByCountryUseCase findRegionByCountryUseCase = new FindRegionByCountryUseCase(RegionService);
    FindRegionByNameUseCase findRegionByNameUseCase = new FindRegionByNameUseCase(RegionService);
    DeleteRegionByNameUseCase deleteRegionByNameUseCase = new DeleteRegionByNameUseCase(RegionService);
    List<Country> cities = findAllCountryUseCase.findAllCountry();

    private JLabel logoImg, title, labelCountry, labelRegion, labelCity;
    private JButton deleteButton, backButton;
    private JComboBox<String> countryBox, regionBox, citybox;
    private String countryID, RegionID;

    public DeleteCityUI() {
    setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Delete City");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(30, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Delete City");
        title.setBounds(200, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 33));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35, 130, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        countryBox = new JComboBox<String>();
        countryBox.setBounds(180, 130, 255, 30);
        countryBox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        countryBox.setForeground(new Color(0, 0, 100));
        add(countryBox);
        countryBox.addItem("");
        for(Country country : cities){
            countryBox.addItem(country.getName());
        };

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(35, 170, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        regionBox = new JComboBox<String>();
        regionBox.setBounds(180, 170, 255, 30);
        regionBox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        regionBox.setForeground(new Color(0, 0, 100));
        add(regionBox);
        countryBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRegion();
            }
        });

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 210, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        citybox = new JComboBox<String>();
        citybox.setBounds(180, 210, 255, 30);
        citybox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        citybox.setForeground(new Color(0, 0, 100));
        add(citybox);
        regionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCity();
            }
        });


        deleteButton = new JButton("Delete");
        deleteButton.setBounds(125, 280, 120, 30);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 280, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        
    }

    private void actualizarRegion() {
        regionBox.removeAllItems(); 
        String countryName = countryBox.getSelectedItem().toString();
        Optional<Country> countryFound = findCountryByNameUseCase.findCountryByName(countryName);
        if (countryFound.isPresent()){
        this.countryID =countryFound.get().getCodeCountry();
        List<Region> Regions = findRegionByCountryUseCase.findAllRegionByCountry(countryID);
        for(Region Regionitem : Regions){
            regionBox.addItem(Regionitem.getNamereg());
        };
    }}

    private void actualizarCity() {
        citybox.removeAllItems();
        String RegionName = regionBox.getSelectedItem().toString();
        Optional<Region> RegionFound = findRegionByNameUseCase.execute(countryID, RegionName);
        if (RegionFound.isPresent()){
        this.RegionID =RegionFound.get().getCodereg();
        List<City> Citys = findCityByRegionUseCase.findAllCityByRegion(RegionID);
        for(City Cityitem : Citys){
            citybox.addItem(Cityitem.getNamecity());
        };
    }}

    
    public void startDeleteCity() {
        DeleteCityUI deleteCityUI = new DeleteCityUI();
        deleteCityUI.setBounds(0, 0, 500, 390);
        deleteCityUI.setVisible(true);
        deleteCityUI.setResizable(false);
        deleteCityUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deleteButton){
            try {
            String CityName = citybox.getSelectedItem().toString();
            if (CityName.length()>0){
            
            
            deleteCityByNameUseCase.execute(RegionID, CityName);


            JOptionPane.showMessageDialog(this, "City added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            countryBox.setSelectedItem("");
            citybox.removeAllItems(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid City.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    if (e.getSource()== backButton){
        this.setVisible(false);
        CityUI CityUI = new CityUI();
        CityUI.startCity();
    }
    }
}
