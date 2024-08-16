package com.mainpharmacy.laboratory.infraestructure.laboratoryui;

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

import com.mainpharmacy.city.aplication.FindCityByNameUseCase;
import com.mainpharmacy.city.aplication.FindCityByRegionUseCase;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;
import com.mainpharmacy.country.aplication.FindAllCountryUseCase;
import com.mainpharmacy.country.aplication.FindCountryByNameUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.laboratory.aplication.DeleteLaboratoryByNameUseCase;
import com.mainpharmacy.laboratory.aplication.FindLaboratoryByCityUseCase;
import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;
import com.mainpharmacy.laboratory.infraestructure.LaboratoryRepository;
import com.mainpharmacy.region.aplication.FindAllregionUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCountryUseCase;
import com.mainpharmacy.region.aplication.FindRegionByNameUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;



public class DeleteLaboratoryUI extends JFrame implements ActionListener {

    RegionService RegionService = new RegionRepository();
    CountryService CountryService = new CountryRepository();
    CityService cityService = new CityRepository();
    LaboratoryService laboratoryService = new LaboratoryRepository();
    FindLaboratoryByCityUseCase findLaboratoryByCityUseCase = new FindLaboratoryByCityUseCase(laboratoryService);
    DeleteLaboratoryByNameUseCase deleteLaboratoryByNameUseCase = new DeleteLaboratoryByNameUseCase(laboratoryService);
    FindCityByRegionUseCase findCityByRegionUseCase = new FindCityByRegionUseCase(cityService);
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(CountryService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(CountryService);
    List<Country> countries = findAllCountryUseCase.findAllCountry();
    FindAllregionUseCase findAllregionUseCase = new FindAllregionUseCase(RegionService);
    FindRegionByNameUseCase findRegionByNameUseCase = new FindRegionByNameUseCase(RegionService);
    FindRegionByCountryUseCase findRegionByCountryUseCase = new FindRegionByCountryUseCase(RegionService);

    private JLabel logoImg, title, labelRegion, labelCity, labelLaboratory, labelCountry;
    private JButton deleteButton, backButton;
    private JComboBox<String> countryBox, regionBox, cityBox, laboratoryBox;
    private String countryID, RegionID, CityID;

    public DeleteLaboratoryUI() {
    setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Delete lab");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/lab.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(60, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Delete lab");
        title.setBounds(250, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 30));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35, 130, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        countryBox = new JComboBox<String>();
        countryBox.setBounds(190, 130, 255, 30);
        countryBox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        countryBox.setForeground(new Color(0, 0, 100));
        add(countryBox);
        countryBox.addItem("");
        for(Country Countryitem : countries){
            countryBox.addItem(Countryitem.getName());
        };

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(35, 170, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        regionBox = new JComboBox<String>();
        regionBox.setBounds(190, 170, 255, 30);
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

        cityBox = new JComboBox<String>();
        cityBox.setBounds(190, 210, 255, 30);
        cityBox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        cityBox.setForeground(new Color(0, 0, 100));
        add(cityBox);
        regionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCity();
            }
        });

        labelLaboratory = new JLabel("Laboratory : ");
        labelLaboratory.setBounds(35, 250, 150, 30);
        labelLaboratory.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelLaboratory.setForeground(new Color(0, 0, 100));
        add(labelLaboratory);

        laboratoryBox = new JComboBox<String>();
        laboratoryBox.setBounds(190, 250, 255, 30);
        laboratoryBox.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        laboratoryBox.setForeground(new Color(0, 0, 100));
        add(laboratoryBox);
        cityBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLaboratory();
            }
        });


        

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(125, 310, 120, 30);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 310, 120, 30);
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
        cityBox.removeAllItems(); 
        String RegionName = regionBox.getSelectedItem().toString();
        Optional<Region> RegionFound = findRegionByNameUseCase.execute(countryID, RegionName);
        if (RegionFound.isPresent()){
        this.RegionID =RegionFound.get().getCodereg();
        List<City> Citys = findCityByRegionUseCase.findAllCityByRegion(RegionID);
        for(City Cityitem : Citys){
            cityBox.addItem(Cityitem.getNamecity());
        };
    }}

    private void actualizarLaboratory() {
        laboratoryBox.removeAllItems(); 
        String CityName = cityBox.getSelectedItem().toString();
        Optional<City> CityFound = findCityByNameUseCase.execute(RegionID,CityName);
        if (CityFound.isPresent()){
        this.CityID =CityFound.get().getCodecity();
        List<Laboratory> Laboratorys = findLaboratoryByCityUseCase.findAllLaboratoryByCity(CityID);
        for(Laboratory Laboratoryitem : Laboratorys){
            laboratoryBox.addItem(Laboratoryitem.getNamelab());
        };
    }}

    

    
    public void startDeleteLaboratory() {
        DeleteLaboratoryUI deleteLaboratoryUI = new DeleteLaboratoryUI();
        deleteLaboratoryUI.setBounds(0, 0, 500, 390);
        deleteLaboratoryUI.setVisible(true);
        deleteLaboratoryUI.setResizable(false);
        deleteLaboratoryUI.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deleteButton){
            try {
            String LaboratoryName = laboratoryBox.getSelectedItem().toString();
            if (LaboratoryName.length()>0){
            
            
            deleteLaboratoryByNameUseCase.execute(CityID, LaboratoryName);


            JOptionPane.showMessageDialog(this, "Laboratory deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            countryBox.setSelectedItem("");
            cityBox.setSelectedItem("");
            cityBox.setSelectedItem("");
            laboratoryBox.setSelectedItem("");

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Laboratory.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    if (e.getSource()== backButton){
        this.setVisible(false);
        LaboratoryUI LaboratoryUI = new LaboratoryUI();
        LaboratoryUI.startLaboratory();
    }
    }
}
