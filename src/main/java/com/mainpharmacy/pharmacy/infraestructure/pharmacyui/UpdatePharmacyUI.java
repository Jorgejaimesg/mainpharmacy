package com.mainpharmacy.pharmacy.infraestructure.pharmacyui;

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
import com.mainpharmacy.city.aplication.FindCityByNameUseCase;
import com.mainpharmacy.city.aplication.FindCityByRegionUseCase;
import com.mainpharmacy.city.domain.entity.City;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;
import com.mainpharmacy.country.aplication.FindAllCountryUseCase;
import com.mainpharmacy.country.aplication.FindCountryByCodeUseCase;
import com.mainpharmacy.country.aplication.FindCountryByNameUseCase;
import com.mainpharmacy.country.domain.entity.Country;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.pharmacy.aplication.FindPharmacyByCityUseCase;
import com.mainpharmacy.pharmacy.aplication.FindPharmacyByCodeUseCase;
import com.mainpharmacy.pharmacy.aplication.UpdatePharmacyUseCase;
import com.mainpharmacy.pharmacy.domain.entity.Pharmacy;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;
import com.mainpharmacy.pharmacy.infraestructure.PharmacyRepository;
import com.mainpharmacy.region.aplication.FindAllregionUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCodeUseCase;
import com.mainpharmacy.region.aplication.FindRegionByCountryUseCase;
import com.mainpharmacy.region.aplication.FindRegionByNameUseCase;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;


public class UpdatePharmacyUI extends JFrame implements ActionListener{
    private JLabel  labelCode, title, logoImg, labelName, labelRegion, labelCountry, labelCity;
    private JButton updateButton, findButton, backButton;
    private JTextField Name, Code;
    private JComboBox<String> Regionlist, Countrylist, Citylist;
    private String countryID, RegionID;

    RegionService RegionService = new RegionRepository();
    CountryService CountryService = new CountryRepository();
    CityService cityService = new CityRepository();
    PharmacyService pharmacyService = new PharmacyRepository();
    FindPharmacyByCityUseCase findPharmacyByCityUseCase = new FindPharmacyByCityUseCase(pharmacyService);
    FindPharmacyByCodeUseCase findPharmacyByCodeUseCase = new FindPharmacyByCodeUseCase(pharmacyService);
    UpdatePharmacyUseCase updatePharmacyUseCase = new UpdatePharmacyUseCase(pharmacyService);
    FindCityByRegionUseCase findCityByRegionUseCase = new FindCityByRegionUseCase(cityService);
    FindCityByCodeUseCase findCityByCodeUseCase = new FindCityByCodeUseCase(cityService);
    FindCityByNameUseCase findCityByNameUseCase = new FindCityByNameUseCase(cityService);
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(CountryService);
    FindCountryByCodeUseCase findCountryByCodeUseCase = new FindCountryByCodeUseCase(CountryService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(CountryService);
    List<Country> countries = findAllCountryUseCase.findAllCountry();
    FindAllregionUseCase findAllregionUseCase = new FindAllregionUseCase(RegionService);
    FindRegionByNameUseCase findRegionByNameUseCase = new FindRegionByNameUseCase(RegionService);
    FindRegionByCodeUseCase findRegionByCodeUseCase = new FindRegionByCodeUseCase(RegionService);
    FindRegionByCountryUseCase findRegionByCountryUseCase = new FindRegionByCountryUseCase(RegionService);


    public UpdatePharmacyUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update Pharmacy");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/lab.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(60, 20, 90, 90);
        add(logoImg);

        title = new JLabel("Update Lab");
        title.setBounds(250, 20, 400, 90);
        title.setFont(new Font("Andale Mono", Font.BOLD, 30));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        labelCode = new JLabel("Code : ");
        labelCode.setBounds(35, 130, 150, 30);
        labelCode.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCode.setForeground(new Color(0, 0, 100));
        add(labelCode);

        Code = new JTextField();
        Code.setBounds(190, 130, 180, 30);
        Code.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Code.setForeground(new Color(0, 0, 100));
        add(Code);

        labelName = new JLabel("Name : ");
        labelName.setBounds(35, 290, 150, 30);
        labelName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelName.setForeground(new Color(0, 0, 100));
        add(labelName);

        Name = new JTextField();
        Name.setBounds(190, 290, 255, 30);
        Name.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Name.setForeground(new Color(0, 0, 100));
        Name.setVisible(false);
        add(Name);

        labelCountry = new JLabel("Country : ");
        labelCountry.setBounds(35, 170, 150, 30);
        labelCountry.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCountry.setForeground(new Color(0, 0, 100));
        add(labelCountry);

        Countrylist = new JComboBox<String>();
        Countrylist.setBounds(190, 170, 255, 30);
        Countrylist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Countrylist.setForeground(new Color(0, 0, 100));
        Countrylist.setVisible(false);
        add(Countrylist);
        Countrylist.addItem("");
        for(Country Countryitem : countries){
            Countrylist.addItem(Countryitem.getName());
        };

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(35, 210, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        Regionlist = new JComboBox<String>();
        Regionlist.setBounds(190, 210, 255, 30);
        Regionlist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Regionlist.setForeground(new Color(0, 0, 100));
        Regionlist.setVisible(false);
        add(Regionlist);
        Countrylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRegion();
            }
        });

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 250, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        Citylist = new JComboBox<String>();
        Citylist.setBounds(190, 250, 255, 30);
        Citylist.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        Citylist.setForeground(new Color(0, 0, 100));
        Citylist.setVisible(false);
        add(Citylist);
        Regionlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCity();
            }
        });


        

        updateButton = new JButton("Update");
        updateButton.setBounds(125, 350, 120, 30);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        backButton = new JButton("Go Back");
        backButton.setBounds(275, 350, 120, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        findButton = new JButton("🔍");
        findButton.setBounds(380, 130, 60, 30);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);
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


    public void startUpdatePharmacy() {
        UpdatePharmacyUI UpdateUI = new UpdatePharmacyUI();
        UpdateUI.setBounds(0, 0, 520, 450);
        UpdateUI.setVisible(true);
        UpdateUI.setResizable(false);
        UpdateUI.setLocationRelativeTo(null);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                int PharmacyCode = Integer.parseInt(Code.getText().trim().toUpperCase());
                if (PharmacyCode>0){
                    Optional<Pharmacy> foundPharmacy = findPharmacyByCodeUseCase.findPharmacyByCode(PharmacyCode);
                    if (foundPharmacy.isPresent()){
                        Name.setVisible(true);
                        Name.setText(foundPharmacy.get().getNamelab());
                        Optional<City> foundCity = findCityByCodeUseCase.findCityByCode(foundPharmacy.get().getCodecity());
                        Optional<Region> foundRegion = findRegionByCodeUseCase.findRegionByCode(foundCity.get().getCodereg());
                        Optional<Country> foundCountry = findCountryByCodeUseCase.findCountryByCode(foundRegion.get().getCodeCountry());
                        Countrylist.setVisible(true);
                        Countrylist.setSelectedItem(foundCountry.get().getName());
                        Regionlist.setVisible(true);
                        Regionlist.setSelectedItem(foundRegion.get().getNamereg());
                        Citylist.setVisible(true);
                        Citylist.setSelectedItem(foundCity.get().getNamecity());
                    } else {
                        JOptionPane.showMessageDialog(this, "The Pharmacy doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  

        if(e.getSource()==updateButton){

            String PharmacyName = Name.getText().trim();
            int Pharmacycode = Integer.parseInt(Code.getText().trim().toUpperCase());
            String CityName = Citylist.getSelectedItem().toString();
            Optional<City> foundCity = findCityByNameUseCase.execute(RegionID, CityName);
            if(foundCity.isPresent()){
                Pharmacy updatedPharmacy = new Pharmacy();
                updatedPharmacy.setCodecity(foundCity.get().getCodecity());
                updatedPharmacy.setNamelab(PharmacyName);
                updatedPharmacy.setId(Pharmacycode);
                if (PharmacyName.length()>0){
                    updatePharmacyUseCase.execute(updatedPharmacy);
                    JOptionPane.showMessageDialog(this, "Updated succesfully", "succes", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "Error to update", "Error", JOptionPane.ERROR_MESSAGE);
    
                }
                System.out.println(updatedPharmacy);
                Name.setVisible(false);
                Code.setText("");
                Regionlist.setVisible(false);
                Name.setVisible(false);
                Countrylist.setVisible(false);
                Citylist.setVisible(false);

            }
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            PharmacyUI PharmacyUI = new PharmacyUI();
            PharmacyUI.startPharmacy();
        }


    }

}
