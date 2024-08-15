package com.mainpharmacy.activeprinciple.infraestructure.activeprincipleui;

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
import com.mainpharmacy.activeprinciple.aplication.FindAllActivePrincipleUseCase;
import com.mainpharmacy.activeprinciple.domain.entity.ActivePrinciple;
import com.mainpharmacy.activeprinciple.domain.service.ActivePrincipleService;
import com.mainpharmacy.activeprinciple.infraestructure.ActivePrincipleRepository;

public class ActivePrincipleUI extends JFrame implements ActionListener{
    private JLabel title, logoImg;
    private JButton addButton, deleteButton, updateButton, findButton, allActivePrincipleButton, backButton;

    public ActivePrincipleUI(){


        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Actives");
        getContentPane().setBackground(new Color(200, 200, 200));
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());

        ImageIcon imagenOriginal = new ImageIcon(getClass().getClassLoader().getResource("images/chemical.png"));
        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(imagenRedimensionada);

        logoImg = new JLabel(imagen);
        logoImg.setBounds(10, 40, 500, 500);
        add(logoImg);

        title = new JLabel("Actives");
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




        allActivePrincipleButton = new JButton("All Actives");
        allActivePrincipleButton.setBounds(520, 415, 330, 60);
        allActivePrincipleButton.setFont(new Font("Andale Mono", Font.PLAIN, 25));
        allActivePrincipleButton.setForeground(new Color(0, 0, 100));
        allActivePrincipleButton.addActionListener(this);
        add(allActivePrincipleButton);
    }
    public void startActivePrinciple() {
        ActivePrincipleUI activeprincipleUI = new ActivePrincipleUI();
        activeprincipleUI.setBounds(0, 0, 1000, 600);
        activeprincipleUI.setVisible(true);
        activeprincipleUI.setResizable(false);
        activeprincipleUI.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addButton){
            this.setVisible(false);
            AddActivePrincipleUI addActivePrincipleUI = new AddActivePrincipleUI();
            addActivePrincipleUI.startAddActivePrinciple();
        }
        
        if(e.getSource()==deleteButton){
            this.setVisible(false);
            DeleteActivePrincipleUI deleteActivePrincipleUI = new DeleteActivePrincipleUI();
            deleteActivePrincipleUI.startDeleteActivePrinciple();
        }

        if(e.getSource()==findButton){
            this.setVisible(false);
            FindActivePrincipleUI FindActivePrincipleUI = new FindActivePrincipleUI();
            FindActivePrincipleUI.startFindActivePrinciple();
        }
        

        if(e.getSource()==updateButton){
            this.setVisible(false);
            UpdateActivePrincipleUI updateActivePrincipleUI = new UpdateActivePrincipleUI();
            updateActivePrincipleUI.startUpdateActivePrinciple();
        }

        if (e.getSource()==allActivePrincipleButton){
                ActivePrincipleService activeprincipleService = new ActivePrincipleRepository();
                FindAllActivePrincipleUseCase findAllActivePrinciplesUseCase = new FindAllActivePrincipleUseCase(activeprincipleService);
                List<ActivePrinciple> Countries = findAllActivePrinciplesUseCase.findAllActivePrinciple();
        
                String[] columns = {"ID", "Name"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

                Countries.forEach(ActivePrinciple -> {
                    Object[] row = {ActivePrinciple.getId(), ActivePrinciple.getDescriptionmode()};
                    defaultTableModel.addRow(row);
                });

        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JOptionPane.showMessageDialog(null, scrollPane, "ActivePrinciple List", JOptionPane.PLAIN_MESSAGE);
        }

        if(e.getSource()==backButton){
            this.setVisible(false);
            Main main = new Main();
            main.startMenu();
        }

        }
    }

