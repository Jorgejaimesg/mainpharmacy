package com.mainpharmacy.region.infraestructure.regionui;
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

import com.mainpharmacy.region.domain.entity.Region;
import com.mainpharmacy.region.domain.service.RegionService;
import com.mainpharmacy.region.infraestructure.RegionRepository;
import com.mainpharmacy.region.aplication.FindAllregionUseCase;

public class RegionUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allRegionButton, backButton;

    public RegionUI(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Regions");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/regions.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Regions");
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




        allRegionButton = new JButton("All Regions");
        allRegionButton.setBounds(520, 415, 330, 60);
        allRegionButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allRegionButton.setForeground(new Color(0, 0, 100));
        allRegionButton.addActionListener(this);
        add(allRegionButton);
    }

        public void startRegion() {
        RegionUI RegionUI = new RegionUI();
        RegionUI.setBounds(0, 0, 1000, 600);
        RegionUI.setVisible(true);
        RegionUI.setResizable(false);
        RegionUI.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddRegionUI addRegionUI = new AddRegionUI();
            addRegionUI.startAddRegion(); 
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteRegionUI deleteRegionUI = new DeleteRegionUI();
            deleteRegionUI.startDeleteRegion();
        }

        if (e.getSource()==allRegionButton){
                RegionService RegionService = new RegionRepository();
                FindAllregionUseCase findAllRegionUseCase = new FindAllregionUseCase(RegionService);
                List<Region> Regions = findAllRegionUseCase.findAllRegion();
        
                String[] columns = {"ID", "Region", "City"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Regions.forEach(Region -> {
                    Object[] row = {Region.getCodereg(), Region.getNamereg(), Region.getCodeCountry() };
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "Region List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdateRegionUI UpdateRegionUI = new UpdateRegionUI();
            UpdateRegionUI.startUpdateRegion();
        }
        if(e.getSource()==findButton){
            this.setVisible(false);
            FindRegionUI FindRegionUI = new FindRegionUI();
            FindRegionUI.startFindRegion();
        }
        // if(e.getSource()==backButton){
        //     this.setVisible(false);
        //     Main main = new Main();
        //     main.startMenu();
        // }
}
}
