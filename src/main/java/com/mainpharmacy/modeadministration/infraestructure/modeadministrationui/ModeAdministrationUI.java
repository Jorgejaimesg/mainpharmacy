package com.mainpharmacy.modeadministration.infraestructure.modeadministrationui;

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

import com.mainpharmacy.Main;
import com.mainpharmacy.modeadministration.aplication.FindAllModeAdministrationUseCase;
import com.mainpharmacy.modeadministration.domain.entity.ModeAdministration;
import com.mainpharmacy.modeadministration.domain.service.ModeAdministrationService;
import com.mainpharmacy.modeadministration.infraestructure.ModeAdministrationRepository;

public class ModeAdministrationUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allModeAdministrationButton, backButton;

    public ModeAdministrationUI(){


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Methods");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/ways.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Methods");
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




        allModeAdministrationButton = new JButton("All Methods");
        allModeAdministrationButton.setBounds(520, 415, 330, 60);
        allModeAdministrationButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allModeAdministrationButton.setForeground(new Color(0, 0, 100));
        allModeAdministrationButton.addActionListener(this);
        add(allModeAdministrationButton);
    }
    public void startModeAdministration() {
        ModeAdministrationUI modeadministrationUI = new ModeAdministrationUI();
        modeadministrationUI.setBounds(0, 0, 1000, 600);
        modeadministrationUI.setVisible(true);
        modeadministrationUI.setResizable(false);
        modeadministrationUI.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddModeAdministrationUI addModeAdministrationUI = new AddModeAdministrationUI();
            addModeAdministrationUI.startAddModeAdministration();
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteModeAdministrationUI deleteModeAdministrationUI = new DeleteModeAdministrationUI();
            deleteModeAdministrationUI.startDeleteModeAdministration();
        }

        if(e.getSource()==findButton){
            this.setVisible(false);
            FindModeAdministrationUI FindModeAdministrationUI = new FindModeAdministrationUI();
            FindModeAdministrationUI.startFindModeAdministration();
        }
        

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdateModeAdministrationUI updateModeAdministrationUI = new UpdateModeAdministrationUI();
            updateModeAdministrationUI.startUpdateModeAdministration();
        }

        if (e.getSource()==allModeAdministrationButton){
                ModeAdministrationService modeadministrationService = new ModeAdministrationRepository();
                FindAllModeAdministrationUseCase findAllModeAdministrationsUseCase = new FindAllModeAdministrationUseCase(modeadministrationService);
                List<ModeAdministration> Countries = findAllModeAdministrationsUseCase.findAllModeAdministration();
        
                String[] columns = {"ID", "Name"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Countries.forEach(ModeAdministration -> {
                    Object[] row = {ModeAdministration.getId(), ModeAdministration.getDescriptionmode()};
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "ModeAdministration List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            Main main = new Main();
            main.startMenu();
        }

        }
    }

