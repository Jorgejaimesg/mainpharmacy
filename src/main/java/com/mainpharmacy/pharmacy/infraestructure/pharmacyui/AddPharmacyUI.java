package com.mainpharmacy.pharmacy.infraestructure.pharmacyui;

import java.util.List;

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
import com.mainpharmacy.pharmacy.aplication.CreatePharmacyUseCase;
import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;
import com.mainpharmacy.pharmacy.infraestructure.PharmacyRepository;
import com.mainpharmacy.region.aplication.FindAllregionUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCountryUseCase;
import com.mainpharmacy.region.aplication.FindRegionByNameUseCase;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddPharmacyUI extends JFrame implements ActionListener {
    private JLabel logoImg, title, labelName, labelCountry, labelRegion, labelCity;
    private JButton addButton, backButton;
    private JTextField Name;
    private JComboBox<String> Countrylist, Regionlist, Citylist;
    private String countryID, RegionID;

    RegionService RegionService = new RegionRepository();
    CountryService CountryService = new CountryRepository();
    CityService cityService = new CityRepository();
    PharmacyService pharmacyService = new PharmacyRepository();
    CreatePharmacyUseCase createPharmacyUseCase = new CreatePharmacyUseCase(pharmacyService);
    FindCityByRegionUseCase findCityByRegionUseCase = new FindCityByRegionUseCase(cityService);
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(CountryService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(CountryService);
    List<Country> countries = findAllCountryUseCase.findAllCountry();
    FindAllregionUseCase findAllregionUseCase = new FindAllregionUseCase(RegionService);
    FindRegionByNameUseCase findRegionByNameUseCase = new FindRegionByNameUseCase(RegionService);
    FindRegionByCountryUseCase findRegionByCountryUseCase = new FindRegionByCountryUseCase(RegionService);

    public AddPharmacyUI(){

    setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Lab");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/lab.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(60, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Add Lab");
        title.setBounds(250, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 30));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelName = new JLabel("Name : ");
        labelName.setBounds(35, 250, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(190, 250, 255, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        add(Name);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35, 130, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        Countrylist = new JComboBox<String>();
        Countrylist.setBounds(190, 130, 255, 30);
        Countrylist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Countrylist.setForeground(new Color(0, 0, 100));
        add(Countrylist);
        Countrylist.addItem("");
        for(Country Countryitem : countries){
            Countrylist.addItem(Countryitem.getName());
        };

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(35, 170, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        Regionlist = new JComboBox<String>();
        Regionlist.setBounds(190, 170, 255, 30);
        Regionlist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Regionlist.setForeground(new Color(0, 0, 100));
        add(Regionlist);
        Countrylist.addActionListener(new ActionListener() {
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

        Citylist = new JComboBox<String>();
        Citylist.setBounds(190, 210, 255, 30);
        Citylist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Citylist.setForeground(new Color(0, 0, 100));
        add(Citylist);
        Regionlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCity();
            }
        });


        

        addButton = new JButton("Add");
        addButton.setBounds(125, 310, 120, 30);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 310, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);
    }
    public void startAddPharmacy() {
        AddPharmacyUI addPharmacyUI = new AddPharmacyUI();
        addPharmacyUI.setBounds(0, 0, 500, 400);
        addPharmacyUI.setVisible(true);
        addPharmacyUI.setResizable(false);
        addPharmacyUI.setLocationRelativeTo(null);
    }

    private void actualizarRegion() {
        Regionlist.removeAllItems(); 
        String countryName = Countrylist.getSelectedItem().toString();
        Optional<Country> countryFound = findCountryByNameUseCase.findCountryByName(countryName);
        if (countryFound.isPresent()){
        this.countryID =countryFound.get().getCodeCountry();
        List<Region> Regions = findRegionByCountryUseCase.findAllRegionByCountry(countryID);
        for(Region Regionitem : Regions){
            Regionlist.addItem(Regionitem.getNamereg());
        };
    }}

    private void actualizarCity() {
        Citylist.removeAllItems(); 
        String RegionName = Regionlist.getSelectedItem().toString();
        Optional<Region> RegionFound = findRegionByNameUseCase.execute(countryID, RegionName);
        if (RegionFound.isPresent()){
        this.RegionID =RegionFound.get().getCodereg();
        List<City> Citys = findCityByRegionUseCase.findAllCityByRegion(RegionID);
        for(City Cityitem : Citys){
            Citylist.addItem(Cityitem.getNamecity());
        };
    }}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            try {
                String cityName = Citylist.getSelectedItem().toString();
                String LabName = Name.getText().trim();
                System.out.println(this.RegionID);
                System.out.println(cityName);
                Optional<City> cityFound = findCityByNameUseCase.execute(RegionID, cityName);
                if(cityFound.isPresent()){
                    String cityCode = cityFound.get().getCodecity();
                    if (LabName.length()>0){
                        Pharmacy newPharmacy = new Pharmacy();
                        newPharmacy.setNamelab(LabName);
                        newPharmacy.setCodecity(cityCode);
                        
                        createPharmacyUseCase.execute(newPharmacy);
                        JOptionPane.showMessageDialog(this, "Pharmacy added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid City", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                Name.setText("");
                Countrylist.setSelectedItem("");
                Citylist.removeAll();
                Regionlist.removeAllItems(); 
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    if(e.getSource()==backButton){
        this.setVisible(false);
        PharmacyUI PharmacyUI = new PharmacyUI();
        PharmacyUI.startPharmacy();
    }
    }

}
