package com.mainpharmacy.laboratory.infraestructure.laboratoryui;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.mainpharmacy.laboratory.aplication.FindLaboratoryByCodeUseCase;
import com.mainpharmacy.laboratory.domain.entity.Laboratory;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;
import com.mainpharmacy.laboratory.infraestructure.LaboratoryRepository;
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
    private JLabel  labelCode, title, logoImg, labelName, labelRegion, CityName, Name, Region, labelCity, labelCountry, country, CountryName, RegionName;
    private JButton NewButton, findButton, backButton;
    private JTextField Code;

    LaboratoryService laboratoryService = new LaboratoryRepository();
    FindLaboratoryByCodeUseCase findLaboratoryByCodeUseCase = new FindLaboratoryByCodeUseCase(laboratoryService);
    CityService CityService = new CityRepository();
    FindCityByCodeUseCase findCityByCodeUseCase = new FindCityByCodeUseCase(CityService);
    RegionService RegionService = new RegionRepository();
    FindRegionByCodeUseCase findRegionByCodeUseCase = new FindRegionByCodeUseCase(RegionService);
    CountryService countryService = new CountryRepository();
    FindCountryByCodeUseCase findCountryByCodeUseCase = new FindCountryByCodeUseCase(countryService);

    public FindLaboratoryUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Update Laboratory");
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

        Name = new JLabel();
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

        CountryName = new JLabel();
        CountryName.setBounds(190, 170, 255, 30);
        CountryName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        CountryName.setForeground(new Color(0, 0, 100));
        CountryName.setVisible(false);
        add(CountryName);

        labelRegion = new JLabel("Region : ");
        labelRegion.setBounds(35, 210, 150, 30);
        labelRegion.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelRegion.setForeground(new Color(0, 0, 100));
        add(labelRegion);

        RegionName = new JLabel();
        RegionName.setBounds(190, 210, 255, 30);
        RegionName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        RegionName.setForeground(new Color(0, 0, 100));
        RegionName.setVisible(false);
        add(RegionName);
    

        labelCity = new JLabel("City : ");
        labelCity.setBounds(35, 250, 150, 30);
        labelCity.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        labelCity.setForeground(new Color(0, 0, 100));
        add(labelCity);

        CityName = new JLabel();
        CityName.setBounds(190, 250, 255, 30);
        CityName.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        CityName.setForeground(new Color(0, 0, 100));
        CityName.setVisible(false);
        add(CityName);


        NewButton = new JButton("New");
        NewButton.setBounds(125, 350, 120, 30);
        NewButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        NewButton.setForeground(new Color(0, 0, 100));
        NewButton.addActionListener(this);
        add(NewButton);

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


    public void startFindLaboratory() {
        FindLaboratoryUI FindUI = new FindLaboratoryUI();
        FindUI.setBounds(0, 0, 520, 450);
        FindUI.setVisible(true);
        FindUI.setResizable(false);
        FindUI.setLocationRelativeTo(null);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==findButton){
            try {
                int LabCode = Integer.parseInt(Code.getText().trim().toUpperCase());
                if (LabCode>0){
                    Optional<Laboratory> foundLab = findLaboratoryByCodeUseCase.findLaboratoryByCode(LabCode);
                    if (foundLab.isPresent()){
                        Name.setVisible(true);
                        Name.setText(foundLab.get().getNamelab());
                        Optional<City> foundCity= findCityByCodeUseCase.findCityByCode(foundLab.get().getCodecity());
                        Optional<Region> foundRegion = findRegionByCodeUseCase.findRegionByCode(foundCity.get().getCodereg());
                        Optional<Country> foundCountry = findCountryByCodeUseCase.findCountryByCode(foundRegion.get().getCodeCountry());
                        RegionName.setVisible(true);
                        RegionName.setText(foundRegion.get().getNamereg());
                        CountryName.setVisible(true);
                        CountryName.setText(foundCountry.get().getName());
                        CityName.setVisible(true);
                        CityName.setText(foundCity.get().getNamecity());
                    } else {
                        JOptionPane.showMessageDialog(this, "The Lab doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Name.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }  

        if(e.getSource()==NewButton){
            Code.setText("");
            Name.setVisible(false);
            Name.setText("");
            RegionName.setText("");
            RegionName.setVisible(false);
            CountryName.setText("");
            CountryName.setVisible(false);
            CityName.setText("");
            CityName.setVisible(false);
        
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            LaboratoryUI LaboratoryUI = new LaboratoryUI();
            LaboratoryUI.startLaboratory();
        }
    }

}
