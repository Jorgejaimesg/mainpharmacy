package com.mainpharmacy.laboratory.infraestructure.laboratoryui;
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

import com.mainpharmacy.laboratory.domain.entity.LaboratoryShow;
import com.mainpharmacy.Main;
import com.mainpharmacy.laboratory.aplication.FindAllLaboratoryUseCase;
import com.mainpharmacy.laboratory.domain.service.LaboratoryService;
import com.mainpharmacy.laboratory.infraestructure.LaboratoryRepository;

public class LaboratoryUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allLaboratoryButton, backButton;

    public LaboratoryUI(){

        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Laboratory");
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




        allLaboratoryButton = new JButton("All Labs");
        allLaboratoryButton.setBounds(520, 415, 330, 60);
        allLaboratoryButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allLaboratoryButton.setForeground(new Color(0, 0, 100));
        allLaboratoryButton.addActionListener(this);
        add(allLaboratoryButton);
    }

        public void startLaboratory() {
        LaboratoryUI LaboratoryUI = new LaboratoryUI();
        LaboratoryUI.setBounds(0, 0, 1000, 600);
        LaboratoryUI.setVisible(true);
        LaboratoryUI.setResizable(false);
        LaboratoryUI.setLocationRelativeTo(null);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddLaboratoryUI addLaboratoryUI = new AddLaboratoryUI();
            addLaboratoryUI.startAddLaboratory(); 
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteLaboratoryUI deleteLaboratoryUI = new DeleteLaboratoryUI();
            deleteLaboratoryUI.startDeleteLaboratory();
        }

        if (e.getSource()==allLaboratoryButton){
                LaboratoryService LaboratoryService = new LaboratoryRepository();
                FindAllLaboratoryUseCase findAllLaboratoryUseCase = new FindAllLaboratoryUseCase(LaboratoryService);
                List<LaboratoryShow> Cities = findAllLaboratoryUseCase.findAllLaboratory();
        
                String[] columns = {"ID", "Laboratory", "Region", "Country"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Cities.forEach(Laboratory -> {
                    Object[] row = {Laboratory.getId(), Laboratory.getNamelab(),Laboratory.getNamecity(), Laboratory.getNamereg(), Laboratory.getNameCountry() };
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Laboratory List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdateLaboratoryUI UpdateLaboratoryUI = new UpdateLaboratoryUI();
            UpdateLaboratoryUI.startUpdateLaboratory();
        }
        if(e.getSource()==findButton){
            this.setVisible(false);
            FindLaboratoryUI FindLaboratoryUI = new FindLaboratoryUI();
            FindLaboratoryUI.startFindLaboratory();
        }
        if(e.getSource()==backButton){
            this.setVisible(false);
            Main main = new Main();
            main.startMenu();
        }
    }
}
