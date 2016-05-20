/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Administrator;
import Entity.BankAccount;
import Entity.Managed;
import Entity.Operation;
import Entity.OperationType;
import Entity.Third;
import Entity.User;
import Service.BankAccountService;
import Service.ManagedService;
import Service.tool.JPA.MetierFactory;
import Service.OperationService;
import Service.ThirdService;
import Service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author romanitox
 */
public class launcher {

    public static Operation o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12, o13, o14, o15, o16, o17, o18, o19;
    public static Third impot, mcdo, ig, materiel, oka, carrefour, entreprise, secu, francis, thchus;
    public static ArrayList<Operation> opesAdmin = new ArrayList<>();
    public static ArrayList<Operation> opesB1 = new ArrayList<>();
    public static ArrayList<Operation> opesB2 = new ArrayList<>();
    public static ArrayList<Operation> opesCom = new ArrayList<>();
    public static Managed mAdmin, m1, m2, mcom;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");

    public static void main(String[] args) throws Exception {

        //**                         Les services               **//
        UserService userSrv = MetierFactory.getUserService();
        ManagedService managedSrv = MetierFactory.getManagedService();
        BankAccountService bankAccountSrv = MetierFactory.getBankAccountService();
        ThirdService thirdSrv = MetierFactory.getThirdService();
        OperationService operationSrv = MetierFactory.getOperationService();

        //**                         Users                      **//
        //** Administrateur **//
        User admin = new Administrator();
        admin.setLogin("RomanitoX");
        admin.setPassword("secret@+");
        admin.setName("Romain");
        admin.setFirstName("Pereira");
        admin.setNationality("FR");
        admin.setIsAdmin(admin.getPassword());
        admin.setEmail("romanito1.rp@gmail.com");
        admin.setImage("images/avatars/avatar3.png");
        userSrv.add(admin);
        //** Les utilisateurs **// 
        User u1 = new User();
        u1.setLogin("Francesco");
        u1.setPassword("secret");
        u1.setName("Francis");
        u1.setFirstName("Labrel");
        u1.setNationality("UK");
        u1.setEmail("francesco.labrel@hotmail.com");
        u1.setImage("images/avatars/avatar2.png");
        userSrv.add(u1);

        User u2 = new User();
        u2.setLogin("wankil");
        u2.setPassword("studio");
        u2.setName("Tchus");
        u2.setFirstName("Dongdaï");
        u2.setNationality("JP");
        u2.setEmail("wankilstudio@gmail.com");
        u2.setImage("images/avatars/avatar1.png");
        userSrv.add(u2);

        //**                                Les tiers                                   **//
        impot = new Third();
        impot.setName("Impôts");
        thirdSrv.add(impot);

        mcdo = new Third();
        mcdo.setName("MacDonald");
        thirdSrv.add(mcdo);

        ig = new Third();
        ig.setName("InstantGaming");
        thirdSrv.add(ig);

        materiel = new Third();
        materiel.setName("Materiel.net");
        thirdSrv.add(materiel);

        oka = new Third();
        oka.setName("O'Kallaghan");
        thirdSrv.add(oka);

        carrefour = new Third();
        carrefour.setName("Carrefour");
        thirdSrv.add(carrefour);

        entreprise = new Third();
        entreprise.setName("Mon entreprise");
        thirdSrv.add(entreprise);

        secu = new Third();
        secu.setName("Securité Social");
        thirdSrv.add(secu);

        francis = new Third();
        francis.setName("Francis");
        thirdSrv.add(francis);

        thchus = new Third();
        thchus.setName("tchous");
        thirdSrv.add(thchus);

        //**                                Les dates                                    **//
        Date d1 = new Date("12/10/2014");
        Date d2 = new Date("08/05/2015");
        Date d3 = new Date("24/12/2014");
        Date d4 = new Date("05/01/2015");
        Date d5 = new Date("06/04/2015");
        Date d6 = new Date("10/11/2015");
        //**                              Les comptes en banques                                 **//
        //** Compte Admin **//
        BankAccount bAdmin = new BankAccount();
        bAdmin.setIBAN(admin.getNationality());
        bAdmin.setName("MasterCard **54");
        bAdmin.setBalance(1458.51d);
        bAdmin.setOperations(opesAdmin);
        bAdmin.setCurrency(admin.getNationality());
        bAdmin.setType("Compte chèque");
        bankAccountSrv.add(bAdmin);
        //** Compte User 1 **//
        BankAccount b1 = new BankAccount();
        b1.setIBAN(u1.getNationality());
        b1.setName("MasterCard **75");
        b1.setBalance(15245.51d);
        b1.setOperations(opesB1);
        b1.setCurrency(u1.getNationality());
        b1.setType("Compte chèque");
        bankAccountSrv.add(b1);
        //** Compte User 2 **//
        BankAccount b2 = new BankAccount();
        b2.setName("VISA Japan **84");
        b2.setIBAN(u2.getNationality());
        b2.setBalance(2015.51d);
        b2.setOperations(opesB2);
        b2.setCurrency(u2.getNationality());
        b2.setType("Compte chèque");
        bankAccountSrv.add(b2);
        //** Compte Commun u1/u2 **//
        BankAccount bCom = new BankAccount();
        bCom.setIBAN(u1.getNationality());
        bCom.setName("LIV IMO");
        bCom.setBalance(32548.51d);
        bCom.setOperations(opesCom);
        bCom.setCurrency(u1.getNationality());
        bCom.setType("Compte Epargne Logement");
        bankAccountSrv.add(bCom);
        //**                             Les manages                                **//
        //** Manage Admin **//
        mAdmin = new Managed();
        mAdmin.setAccount(bAdmin);
        mAdmin.setUser(admin);
        managedSrv.add(mAdmin);
        //** Manage u1 **//
        m1 = new Managed();
        m1.setAccount(b1);
        m1.setUser(u1);
        managedSrv.add(m1);
        //** Manage u2 **//
        m1 = new Managed();
        m1.setAccount(b2);
        m1.setUser(u2);
        managedSrv.add(m1);
        //** Manage mcom **//
        mcom = new Managed();
        mcom.setAccount(bCom);
        mcom.setUser(u1);
        mcom.setUser(u2);
        managedSrv.add(mcom);
        //**                             Les operations                                **//
        //** Operation Admin **//
        o1 = new Operation();
        o1.setType(OperationType.DEBIT);
        o1.setWording("Paiements impots");
        o1.setAccount(bAdmin);
        o1.setAmount(845.16d);
        o1.setDate(d1);
        o1.setThird(impot);
        opesAdmin.add(o1);
        operationSrv.add(o1);

        o2 = new Operation();
        o2.setType(OperationType.DEBIT);
        o2.setWording("McDonald Evreux");
        o2.setAccount(bAdmin);
        o2.setAmount(12.45d);
        o2.setDate(d1);
        o2.setThird(mcdo);
        opesAdmin.add(o2);
        operationSrv.add(o2);

        o3 = new Operation();
        o3.setType(OperationType.DEBIT);
        o3.setWording("Fallout 4");
        o3.setAccount(bAdmin);
        o3.setAmount(49.99d);
        o3.setDate(d6);
        o3.setThird(ig);
        opesAdmin.add(o3);
        operationSrv.add(o3);

        o4 = new Operation();
        o4.setType(OperationType.DEBIT);
        o4.setWording("Boitier PC");
        o4.setAccount(bAdmin);
        o4.setAmount(199.99d);
        o4.setDate(d5);
        o4.setThird(materiel);
        opesAdmin.add(o4);
        operationSrv.add(o4);

        o5 = new Operation();
        o5.setType(OperationType.CREDIT);
        o5.setWording("Remboursement Social");
        o5.setAccount(bAdmin);
        o5.setAmount(347.75d);
        o5.setDate(d4);
        o5.setThird(secu);
        opesAdmin.add(o5);
        operationSrv.add(o5);

        o6 = new Operation();
        o6.setType(OperationType.DEBIT);
        o6.setWording("Paiements impots");
        o6.setAccount(b1);
        o6.setDate(d1);
        o6.setThird(impot);
        opesB1.add(o6);
        operationSrv.add(o6);

        o7 = new Operation();
        o7.setType(OperationType.DEBIT);
        o7.setWording("O'kallaghan");
        o7.setAccount(b1);
        o7.setAmount(12.45d);
        o7.setDate(d1);
        o7.setThird(oka);
        opesB1.add(o7);
        operationSrv.add(o7);

        o8 = new Operation();
        o8.setType(OperationType.DEBIT);
        o8.setWording("Fallout 4");
        o8.setAccount(b1);
        o8.setAmount(49.99d);
        o8.setDate(d6);
        o8.setThird(ig);
        opesB1.add(o8);
        operationSrv.add(o8);

        o9 = new Operation();
        o9.setType(OperationType.DEBIT);
        o9.setWording("Cadeaux de noël");
        o9.setAccount(b1);
        o9.setAmount(24.95d);
        o9.setDate(d3);
        o9.setThird(carrefour);
        opesB1.add(o9);
        operationSrv.add(o9);

        o10 = new Operation();
        o10.setType(OperationType.CREDIT);
        o10.setWording("Paie du mois de Décembre");
        o10.setAccount(b1);
        o10.setAmount(2450.85d);
        o10.setDate(d4);
        o10.setThird(entreprise);
        opesB1.add(o10);
        operationSrv.add(o10);

        o11 = new Operation();
        o11.setType(OperationType.DEBIT);
        o11.setWording("Paiements impots");
        o11.setAccount(b1);
        o11.setAmount(1025.45d);
        o11.setDate(d1);
        o11.setThird(impot);
        opesB2.add(o11);
        operationSrv.add(o11);

        o12 = new Operation();
        o12.setType(OperationType.DEBIT);
        o12.setWording("O'kallaghan");
        o12.setAccount(b1);
        o12.setAmount(12.45d);
        o12.setDate(d1);
        o12.setThird(oka);
        opesB2.add(o12);
        operationSrv.add(o12);

        o13 = new Operation();
        o13.setType(OperationType.DEBIT);
        o13.setWording("Fallout 4");
        o13.setAccount(b1);
        o13.setAmount(49.99d);
        o13.setDate(d6);
        o13.setThird(ig);
        opesB2.add(o13);
        operationSrv.add(o13);

        o14 = new Operation();
        o14.setType(OperationType.DEBIT);
        o14.setWording("Cadeaux de noël");
        o14.setAccount(b1);
        o14.setAmount(102.85d);
        o14.setDate(d3);
        o14.setThird(carrefour);
        opesB2.add(o14);
        operationSrv.add(o14);

        o15 = new Operation();
        o15.setType(OperationType.CREDIT);
        o15.setWording("Paie du mois de Décembre");
        o15.setAccount(b1);
        o15.setAmount(1446.85d);
        o15.setDate(d4);
        o15.setThird(entreprise);
        opesB2.add(o15);
        operationSrv.add(o15);

        o16 = new Operation();
        o16.setType(OperationType.CREDIT);
        o16.setWording("Virement economie");
        o16.setAccount(bCom);
        o16.setAmount(500d);
        o16.setDate(d2);
        o16.setThird(francis);
        opesCom.add(o16);
        operationSrv.add(o16);

        o17 = new Operation();
        o17.setType(OperationType.CREDIT);
        o17.setWording("Virement economie");
        o17.setAccount(bCom);
        o17.setAmount(850d);
        o17.setDate(d6);
        o17.setThird(thchus);
        opesCom.add(o17);
        operationSrv.add(o17);
    }
}
