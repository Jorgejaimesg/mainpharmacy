package com.mainpharmacy.city.infraestructure.cityui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mainpharmacy.city.domain.entity.CityShow;
import com.mainpharmacy.city.aplication.FindAllCityUseCase;
import com.mainpharmacy.city.domain.service.CityService;
import com.mainpharmacy.city.infraestructure.CityRepository;

public class CityUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allCityButton, backButton;

    public CityUI(){

        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cities");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/CityImg.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Cities");
        title.setBounds(480, 10, 500, 300);
        title.setFont(new Font("Andale Mono", Font.BOLD, 90));
        title.setForeground(new Color(0, 0, 100));
        add(title);
        
        addButton = new JButton("Add");
        addButton.setBounds(520, 255, 150, 60);
        addButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        addButton.setForeground(new Color(0, 0, 100));
        addButton.addActionListener(this);
        add(addButton);

        backButton = new JButton("🔙");
        backButton.setBounds(0, 0, 60, 30);
        backButton.setFont(new Font("Andale Mono", Font.PLAIN, 20));
        backButton.setForeground(new Color(0, 0, 100));
        backButton.addActionListener(this);
        add(backButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(700, 255, 150, 60);
        deleteButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        deleteButton.setForeground(new Color(0, 0, 100));
        deleteButton.addActionListener(this);
        add(deleteButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(520, 335, 150, 60);
        updateButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        updateButton.setForeground(new Color(0, 0, 100));
        updateButton.addActionListener(this);
        add(updateButton);

        findButton = new JButton("Find");
        findButton.setBounds(700, 335, 150, 60);
        findButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        findButton.setForeground(new Color(0, 0, 100));
        findButton.addActionListener(this);
        add(findButton);




        allCityButton = new JButton("All Cities");
        allCityButton.setBounds(520, 415, 330, 60);
        allCityButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allCityButton.setForeground(new Color(0, 0, 100));
        allCityButton.addActionListener(this);
        add(allCityButton);
    }

        public void startCity() {
        CityUI CityUI = new CityUI();
        CityUI.setBounds(0, 0, 1000, 600);
        CityUI.setVisible(true);
        CityUI.setResizable(false);
        CityUI.setLocationRelativeTo(null);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            // this.setVisible(false);
            // AddCityUI addCityUI = new AddCityUI();
            // addCityUI.startAddCity(); 
        }
        
        if(e.getSource()==deleteButton){
            // this.setVisible(false);
            // DeleteCityUI deleteCityUI = new DeleteCityUI();
            // deleteCityUI.startDeleteCity();
        }

        if (e.getSource()==allCityButton){
                CityService CityService = new CityRepository();
                FindAllCityUseCase findAllCityUseCase = new FindAllCityUseCase(CityService);
                List<CityShow> Cities = findAllCityUseCase.findAllCity();
        
                String[] columns = {"ID", "City", "Region", "Country"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Cities.forEach(City -> {
                    Object[] row = {City.getCodecity(), City.getNamecity(), City.getNamereg(), City.getNameCountry() };
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "City List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==updateButton){
        //     this.setVisible(false);
        //     UpdateCityUI UpdateCityUI = new UpdateCityUI();
        //     UpdateCityUI.startUpdateCity();
        }
        if(e.getSource()==findButton){
            // this.setVisible(false);
            // FindCityUI FindCityUI = new FindCityUI();
            // FindCityUI.startFindCity();
        }
        // if(e.getSource()==backButton){
        //     this.setVisible(false);
        //     Main main = new Main();
        //     main.startMenu();
        // }
    }
}
