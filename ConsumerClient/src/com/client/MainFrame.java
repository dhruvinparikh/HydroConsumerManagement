/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author imsil
 */
public class MainFrame extends JFrame {

    private JMenu menuFilter, menuSearch, menuFile, menuEdit;
    private JMenuItem menuItemDueDate, menuItemBillAmount, menuItemFirstName,
            menuItemLastName, menuItemCity, menuItemConsumerID, menuItemExit,
            menuItemNew,menuItemReplace, menuItemDelete;
    private JMenuBar mb;
    private NewGUI newGUI;
    private DueDateGUI dueDateGUI;
    private BillAmountGUI billAmountGUI;
    private ConsumerIDGUI consumerIDGUI;
    private FirstNameGUI firstNameGUI;
    private LastNameGUI lastNameGUI;
    private CityGUI cityGUI;
    private DeleteGUI deleteGUI;
    private ReplaceGUI replaceGUI;

    public MainFrame() {
        newGUI = new NewGUI();
        dueDateGUI = new DueDateGUI();
        billAmountGUI = new BillAmountGUI();
        consumerIDGUI = new ConsumerIDGUI();
        firstNameGUI = new FirstNameGUI();
        lastNameGUI = new LastNameGUI();
        cityGUI = new CityGUI();
        deleteGUI = new DeleteGUI();
        replaceGUI = new ReplaceGUI();
        menuFilter = new JMenu("Filter");
        menuSearch = new JMenu("Search");
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuItemNew = new JMenuItem("New");
        menuItemExit = new JMenuItem("Exit");
        menuItemDueDate = new JMenuItem("Due Date");
        menuItemBillAmount = new JMenuItem("Bill Amount");
        menuItemFirstName = new JMenuItem("First Name");
        menuItemLastName = new JMenuItem("Last Name");
        menuItemCity = new JMenuItem("City");
        menuItemConsumerID = new JMenuItem("Consumer ID");
        menuItemReplace = new JMenuItem("Replace");
        menuItemDelete = new JMenuItem("Delete");
        mb = new JMenuBar();
        menuFile.add(menuItemNew);
        menuFile.add(menuItemExit);
        menuFilter.add(menuItemDueDate);
        menuFilter.add(menuItemBillAmount);
        menuSearch.add(menuItemConsumerID);
        menuSearch.add(menuItemFirstName);
        menuSearch.add(menuItemLastName);
        menuSearch.add(menuItemCity);
        menuEdit.add(menuItemReplace);
        menuEdit.add(menuItemDelete);
        mb.add(menuFile);
        mb.add(menuFilter);
        mb.add(menuSearch);
        mb.add(menuEdit);
        this.setLocation(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new CardLayout());
        this.setJMenuBar(mb);
        this.add(newGUI);
        this.add(dueDateGUI);
        this.add(billAmountGUI);
        this.add(consumerIDGUI);
        this.add(firstNameGUI);
        this.add(lastNameGUI);
        this.add(cityGUI);
        this.add(deleteGUI);
        this.add(replaceGUI);
        newGUI.setVisible(true);

        menuItemDueDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dueDateGUI.InitTable();
                DateFormat shortDf = DateFormat.getDateInstance(DateFormat.SHORT);
                dueDateGUI.setTxtDate(shortDf.format(new Date()));
                dueDateGUI.setVisible(true);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemBillAmount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                billAmountGUI.InitTable();
                billAmountGUI.setTxtBillAmount("");
                billAmountGUI.setVisible(true);
                dueDateGUI.setVisible(false);
                newGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                newGUI.setTxtBillAmount("");
                newGUI.setTxtCity("");
                newGUI.setTxtConsumerID("");
                newGUI.setTxtDueDate("");
                newGUI.setTxtFirstName("");
                newGUI.setTxtLastName("");
                newGUI.setVisible(true);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }

        });

        menuItemConsumerID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                consumerIDGUI.InitTable();
                consumerIDGUI.setTxtConsumerID("");
                consumerIDGUI.setVisible(true);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemFirstName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                firstNameGUI.InitTable();
                firstNameGUI.setTxtFirstName("");
                firstNameGUI.setVisible(true);
                consumerIDGUI.setVisible(false);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemLastName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                lastNameGUI.InitTable();
                lastNameGUI.setTxtLastName("");
                lastNameGUI.setVisible(true);
                firstNameGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                cityGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cityGUI.setTxtCity("");
                cityGUI.InitTable();
                cityGUI.setVisible(true);
                lastNameGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                deleteGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteGUI.setTxtConsumerID("");
                deleteGUI.InitTable();
                deleteGUI.setVisible(true);
                cityGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);
                replaceGUI.setVisible(false);
            }

        });

        menuItemReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                replaceGUI.setTxtConsumerID("");
                replaceGUI.setTxtName("");
                replaceGUI.InitTable();
                replaceGUI.setBtnDisplay(true);
                replaceGUI.setBtnReplace(false);
                replaceGUI.setTxtConsumerIDEditable(true);
                replaceGUI.setVisible(true);
                deleteGUI.setVisible(false);
                cityGUI.setVisible(false);
                lastNameGUI.setVisible(false);
                firstNameGUI.setVisible(false);
                consumerIDGUI.setVisible(false);
                newGUI.setVisible(false);
                billAmountGUI.setVisible(false);
                dueDateGUI.setVisible(false);

            }

        });

    }

}
