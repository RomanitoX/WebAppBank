/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.tool.JPA;

import Service.BankAccountService;
import Service.BankAccountServiceJPAImpl;
import Service.ManagedService;
import Service.ManagedServiceJPAImpl;
import Service.OperationService;
import Service.OperationServiceJPAImpl;
import Service.ThirdService;
import Service.ThirdServiceJPAImpl;
import Service.UserService;
import Service.UserServiceJPAImpl;

/**
 *
 * @author romanitox
 */
public class MetierFactory {

    private static UserService userSrv = null;

    private static BankAccountService bankAccountSrv = null;

    private static ManagedService managedSrv = null;

    private static OperationService operationSrv = null;

    private static ThirdService thirdSrv = null;

    public static UserService getUserService() {
        if (userSrv == null) {
            userSrv = new UserServiceJPAImpl();
        }
        return userSrv;
    }

    public static BankAccountService getBankAccountService() {
        if (bankAccountSrv == null) {
            bankAccountSrv = new BankAccountServiceJPAImpl();
        }
        return bankAccountSrv;
    }

    public static ManagedService getManagedService() {
        if (managedSrv == null) {
            managedSrv = new ManagedServiceJPAImpl();
        }
        return managedSrv;
    }

    public static OperationService getOperationService() {
        if (operationSrv == null) {
            operationSrv = new OperationServiceJPAImpl();
        }
        return operationSrv;
    }

    public static ThirdService getThirdService() {
        if (thirdSrv == null) {
            thirdSrv = new ThirdServiceJPAImpl();
        }
        return thirdSrv;
    }
}
