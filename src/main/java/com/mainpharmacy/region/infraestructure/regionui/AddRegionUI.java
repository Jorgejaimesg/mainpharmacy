package com.mainpharmacy.region.infraestructure.regionui;

import com.mainpharmacy.country.aplication.FindCountryByNameUseCase;
import com.mainpharmacy.country.aplication.FindAllCountryUseCase;
import com.mainpharmacy.country.infraestructure.CountryRepository;
import com.mainpharmacy.country.domain.service.CountryService;
import com.mainpharmacy.country.domain.entity.Country;

import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;
import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.aplication.CreateRegionUseCase;

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



public class AddRegionUI extends JFrame implements ActionListener {
    private JLabel logoImg, title, labelName, labelCountry;
    private JButton addButton, backButton;
    private JTextField Name;
    private JComboBox<String> Country;

    RegionService RegionService = new RegionRepository();
    CountryService CountryService = new CountryRepository();
    FindAllCountryUseCase findAllCountryUseCase = new FindAllCountryUseCase(CountryService);
    FindCountryByNameUseCase findCountryByNameUseCase = new FindCountryByNameUseCase(CountryService);
    CreateRegionUseCase createRegionUseCase = new CreateRegionUseCase(RegionService);
    List<Country> cities = findAllCountryUseCase.findAllCountry();
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
