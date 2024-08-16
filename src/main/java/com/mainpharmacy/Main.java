package com.mainpharmacy;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mainpharmacy.activeprinciple.infraestructure.activeprincipleui.ActivePrincipleUI;
import com.mainpharmacy.city.infraestructure.cityui.CityUI;
import com.mainpharmacy.country.infraestructure.countryui.CountryUI;
import com.mainpharmacy.laboratory.infraestructure.laboratoryui.LaboratoryUI;
import com.mainpharmacy.modeadministration.infraestructure.modeadministrationui.ModeAdministrationUI;
import com.mainpharmacy.region.infraestructure.regionui.RegionUI;
import com.mainpharmacy.unitmeasurement.infraestructure.unitmeasurementui.UnitMeasurementUI;

public class Main extends JFrame implements ActionListener{
    
    private JButton country, city, region, modeadministration, unitmeasurement, activeprinciple, laboratory;
    private JLabel title, logoImg;
    public Main(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("George's Pharmacy");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/icon.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        ImageIcon imagenOriginalCountry = new ImageIcon(getClass().getClassLoader().getResource("images/countryimg.png"));
        Image imagenRedimensionadaCountry = imagenOriginalCountry.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenCountry = new ImageIcon(imagenRedimensionadaCountry);

        ImageIcon imagenOriginalCity = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionadaCity = imagenOriginalCity.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenCity = new ImageIcon(imagenRedimensionadaCity);

        ImageIcon imagenOriginalRegion = new ImageIcon(getClass().getClassLoader().getResource("images/regions.png"));
        Image imagenRedimensionadaRegion = imagenOriginalRegion.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenRegion = new ImageIcon(imagenRedimensionadaRegion);

        ImageIcon imagenOriginalModeAdministrationId = new ImageIcon(getClass().getClassLoader().getResource("images/ways.png"));
        Image imagenRedimensionadaModeAdministrationId = imagenOriginalModeAdministrationId.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenModeAdministrationId = new ImageIcon(imagenRedimensionadaModeAdministrationId);
        
        ImageIcon imagenOriginalunitmeasurementId = new ImageIcon(getClass().getClassLoader().getResource("images/measurement.png"));
        Image imagenRedimensionadaunitmeasurementId = imagenOriginalunitmeasurementId.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenunitmeasurementId = new ImageIcon(imagenRedimensionadaunitmeasurementId);
        
        ImageIcon imagenOriginalactiveprincipleId = new ImageIcon(getClass().getClassLoader().getResource("images/chemical.png"));
        Image imagenRedimensionadaactiveprincipleId = imagenOriginalactiveprincipleId.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenactiveprincipleId = new ImageIcon(imagenRedimensionadaactiveprincipleId);

        ImageIcon imagenOriginallaboratoryId = new ImageIcon(getClass().getClassLoader().getResource("images/lab.png"));
        Image imagenRedimensionadalaboratoryId = imagenOriginallaboratoryId.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon imagenlaboratoryId = new ImageIcon(imagenRedimensionadalaboratoryId);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(-80, 75, 500, 500);
        add(logoImg);

        title = new JLabel("George's Pharmacy");
        title.setBounds(75, -70, 1000, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 90));
        title.setForeground(new Color(0, 0, 100));
        add(title);

        country = new JButton("Country",imagenCountry);
        country.setBounds(300, 200, 120, 120);
        country.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        country.setHorizontalTextPosition(JButton.CENTER);
        country.setVerticalTextPosition(JButton.BOTTOM);
        country.setForeground(new Color(0, 0, 100));
        country.addActionListener(this);
        add(country);
        
        city = new JButton("City", imagenCity);
        city.setBounds(440, 200, 120, 120);
        city.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        city.setHorizontalTextPosition(JButton.CENTER);
        city.setVerticalTextPosition(JButton.BOTTOM);
        city.setForeground(new Color(0, 0, 100));
        city.addActionListener(this);
        add(city);

        region = new JButton("Region",imagenRegion);
        region.setBounds(580, 200, 120, 120);
        region.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        region.setHorizontalTextPosition(JButton.CENTER);
        region.setVerticalTextPosition(JButton.BOTTOM);
        region.setForeground(new Color(0, 0, 100));
        region.addActionListener(this);
        add(region);

        modeadministration = new JButton("Methods",imagenModeAdministrationId);
        modeadministration.setBounds(720, 200, 120, 120);
        modeadministration.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        modeadministration.setHorizontalTextPosition(JButton.CENTER);
        modeadministration.setVerticalTextPosition(JButton.BOTTOM);
        modeadministration.setForeground(new Color(0, 0, 100));
        modeadministration.addActionListener(this);
        add(modeadministration);

        unitmeasurement = new JButton("Units",imagenunitmeasurementId);
        unitmeasurement.setBounds(300, 340, 120, 120);
        unitmeasurement.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        unitmeasurement.setHorizontalTextPosition(JButton.CENTER);
        unitmeasurement.setVerticalTextPosition(JButton.BOTTOM);
        unitmeasurement.setForeground(new Color(0, 0, 100));
        unitmeasurement.addActionListener(this);
        add(unitmeasurement);

        activeprinciple = new JButton("Actives",imagenactiveprincipleId);
        activeprinciple.setBounds(440, 340, 120, 120);
        activeprinciple.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        activeprinciple.setHorizontalTextPosition(JButton.CENTER);
        activeprinciple.setVerticalTextPosition(JButton.BOTTOM);
        activeprinciple.setForeground(new Color(0, 0, 100));
        activeprinciple.addActionListener(this);
        add(activeprinciple);

        laboratory = new JButton("laboratory",imagenlaboratoryId);
        laboratory.setBounds(580, 340, 120, 120);
        laboratory.setFont(new Font("Andale Mono", Font.PLAIN, 13));
        laboratory.setHorizontalTextPosition(JButton.CENTER);
        laboratory.setVerticalTextPosition(JButton.BOTTOM);
        laboratory.setForeground(new Color(0, 0, 100));
        laboratory.addActionListener(this);
        add(laboratory);


    }

    public static void main(String args[]) {
        Main main = new Main();
        main.startMenu();
    }

    public void startMenu() {
        Main Main = new Main();
        Main.setBounds(0, 0, 1100, 600);
        Main.setVisible(true);
        Main.setResizable(false);
        Main.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==country){
            this.setVisible(false);
            CountryUI countryUI = new CountryUI();
            countryUI.startCountry();
        }
        
        if (e.getSource()==city){
            this.setVisible(false);
            CityUI cityUI = new CityUI();
            cityUI.startCity();
        }

        if (e.getSource()==region){
            this.setVisible(false);
            RegionUI regionUI = new RegionUI();
            regionUI.startRegion();

        }

        if (e.getSource()==modeadministration){
            this.setVisible(false);
            ModeAdministrationUI typeUI = new ModeAdministrationUI();
            typeUI.startModeAdministration();
        }
        if (e.getSource()==unitmeasurement){
            this.setVisible(false);
            UnitMeasurementUI unitmeasurementUI = new UnitMeasurementUI();
            unitmeasurementUI.startUnitMeasurement();
        }
        if (e.getSource()==activeprinciple){
            this.setVisible(false);
            ActivePrincipleUI activeUI = new ActivePrincipleUI();
            activeUI.startActivePrinciple();
        }

        if (e.getSource()==laboratory){
            this.setVisible(false);
            LaboratoryUI laboratoryUI = new LaboratoryUI();
            laboratoryUI.startLaboratory();
        }

    }


}