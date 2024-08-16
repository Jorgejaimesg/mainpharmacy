package com.mainpharmacy.pharmacy.infraestructure.pharmacyui;
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

import com.mainpharmacy.pharmacy.domain.entity.PharmacyShow;
import com.mainpharmacy.Main;
import com.mainpharmacy.pharmacy.aplication.FindAllPharmacyUseCase;
import com.mainpharmacy.pharmacy.domain.service.PharmacyService;
import com.mainpharmacy.pharmacy.infraestructure.PharmacyRepository;

public class PharmacyUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allPharmacyButton, backButton;

    public PharmacyUI(){

        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pharmacy");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/lab.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Labs");
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




        allPharmacyButton = new JButton("All Labs");
        allPharmacyButton.setBounds(520, 415, 330, 60);
        allPharmacyButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allPharmacyButton.setForeground(new Color(0, 0, 100));
        allPharmacyButton.addActionListener(this);
        add(allPharmacyButton);
    }

        public void startPharmacy() {
        PharmacyUI PharmacyUI = new PharmacyUI();
        PharmacyUI.setBounds(0, 0, 1000, 600);
        PharmacyUI.setVisible(true);
        PharmacyUI.setResizable(false);
        PharmacyUI.setLocationRelativeTo(null);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddPharmacyUI addPharmacyUI = new AddPharmacyUI();
            addPharmacyUI.startAddPharmacy(); 
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeletePharmacyUI deletePharmacyUI = new DeletePharmacyUI();
            deletePharmacyUI.startDeletePharmacy();
        }

        if (e.getSource()==allPharmacyButton){
                PharmacyService PharmacyService = new PharmacyRepository();
                FindAllPharmacyUseCase findAllPharmacyUseCase = new FindAllPharmacyUseCase(PharmacyService);
                List<PharmacyShow> Cities = findAllPharmacyUseCase.findAllPharmacy();
        
                String[] columns = {"ID", "Pharmacy", "Region", "Country"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Cities.forEach(Pharmacy -> {
                    Object[] row = {Pharmacy.getId(), Pharmacy.getNamelab(),Pharmacy.getNamecity(), Pharmacy.getNamereg(), Pharmacy.getNameCountry() };
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Pharmacy List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdatePharmacyUI UpdatePharmacyUI = new UpdatePharmacyUI();
            UpdatePharmacyUI.startUpdatePharmacy();
        }
        if(e.getSource()==findButton){
            this.setVisible(false);
            FindPharmacyyUI FindPharmacyUI = new FindPharmacyyUI();
            FindPharmacyUI.startFindPharmacy();
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            Main main = new Main();
            main.startMenu();
        }
    }
}
