package com.mainpharmacy.unitmeasurement.infraestructure.unitmeasurementui;

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

import com.mainpharmacy.unitmeasurement.aplication.FindAllUnitMeasurementUseCase;
import com.mainpharmacy.unitmeasurement.domain.entity.UnitMeasurement;
import com.mainpharmacy.unitmeasurement.domain.service.UnitMeasurementService;
import com.mainpharmacy.unitmeasurement.infraestructure.UnitMeasurementRepository;

public class UnitMeasurementUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allUnitMeasurementButton, backButton;

    public UnitMeasurementUI(){


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Units");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/measurement.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Units");
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




        allUnitMeasurementButton = new JButton("All Units");
        allUnitMeasurementButton.setBounds(520, 415, 330, 60);
        allUnitMeasurementButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allUnitMeasurementButton.setForeground(new Color(0, 0, 100));
        allUnitMeasurementButton.addActionListener(this);
        add(allUnitMeasurementButton);
    }
    public void startUnitMeasurement() {
        UnitMeasurementUI unitmeasurementUI = new UnitMeasurementUI();
        unitmeasurementUI.setBounds(0, 0, 1000, 600);
        unitmeasurementUI.setVisible(true);
        unitmeasurementUI.setResizable(false);
        unitmeasurementUI.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddUnitMeasurementUI addUnitMeasurementUI = new AddUnitMeasurementUI();
            addUnitMeasurementUI.startAddUnitMeasurement();
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteUnitMeasurementUI deleteUnitMeasurementUI = new DeleteUnitMeasurementUI();
            deleteUnitMeasurementUI.startDeleteUnitMeasurement();
        }

        if(e.getSource()==findButton){
            this.setVisible(false);
            FindUnitMeasurementUI FindUnitMeasurementUI = new FindUnitMeasurementUI();
            FindUnitMeasurementUI.startFindUnitMeasurement();
        }
        

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdateUnitMeasurementUI updateUnitMeasurementUI = new UpdateUnitMeasurementUI();
            updateUnitMeasurementUI.startUpdateUnitMeasurement();
        }

        if (e.getSource()==allUnitMeasurementButton){
                UnitMeasurementService unitmeasurementService = new UnitMeasurementRepository();
                FindAllUnitMeasurementUseCase findAllUnitMeasurementsUseCase = new FindAllUnitMeasurementUseCase(unitmeasurementService);
                List<UnitMeasurement> Countries = findAllUnitMeasurementsUseCase.findAllUnitMeasurement();
        
                String[] columns = {"ID", "Name"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Countries.forEach(UnitMeasurement -> {
                    Object[] row = {UnitMeasurement.getId(), UnitMeasurement.getDescriptionmode()};
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "UnitMeasurement List", JOptionPane.PLAIN_MESSAGE);
        }

        // if(e.getSource()==backButton){
        //     this.setVisible(false);
        //     Main main = new Main();
        //     main.startMenu();
        // }

        }
    }

