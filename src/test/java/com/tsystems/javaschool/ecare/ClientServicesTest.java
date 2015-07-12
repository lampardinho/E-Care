package com.tsystems.javaschool.ecare;

import com.tsystems.javaschool.ecare.entities.Contract;
import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.entities.User;
import com.tsystems.javaschool.ecare.services.ContractService;
import com.tsystems.javaschool.ecare.services.OptionService;
import com.tsystems.javaschool.ecare.services.TariffService;
import com.tsystems.javaschool.ecare.services.UserService;
import com.tsystems.javaschool.ecare.util.ECareException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.Date;
import java.util.HashSet;


public class ClientServicesTest
{
    private static UserService clientService = UserService.getInstance();
    private static ContractService contractService = ContractService.getInstance();
    private static TariffService tariffService = TariffService.getInstance();
    private static OptionService optionService = OptionService.getInstance();

    private static User CL1, CL2, CL3;
    private static Contract CN21, CN31;
    private static Tariff TR1;
    private static Option OP11, OP12, OP13, OP14, OP15;

    private static long clientsNumber;
    private static long contractsNumber;

    @Before
    public void before() {
        clientsNumber = clientService.getNumberOfClients();
        contractsNumber = contractService.getNumberOfContracts();

        TR1 = new Tariff("tTariff1", 300, new HashSet<Option>());
        TR1 = tariffService.saveOrUpdateTariff(TR1);

        OP11 = new Option("tOption11", 5, 120);
        OP11 = optionService.saveOrUpdateOption(OP11);

        OP12 = new Option("tOption12", 4, 100);
        OP12 = optionService.saveOrUpdateOption(OP12);

        OP13 = new Option("tOption13", 5, 50);
        OP13 = optionService.saveOrUpdateOption(OP13);

        OP14 = new Option("tOption14", 10, 100);
        OP14 = optionService.saveOrUpdateOption(OP14);

        OP15 = new Option("tOption15", 2, 110);
        OP15 = optionService.saveOrUpdateOption(OP15);

        TR1.getAvailableOptions().add(OP11);
        TR1.getAvailableOptions().add(OP12);
        TR1.getAvailableOptions().add(OP13);
        TR1.getAvailableOptions().add(OP14);
        TR1.getAvailableOptions().add(OP15);

        TR1 = tariffService.saveOrUpdateTariff(TR1);

        CL1 = new User("Ivan", "Semenov",  new Date(), "9234132", "SPB", "ivanov@mail.ru", "password", (byte)1);
        CL1 = clientService.saveOrUpdateClient(CL1);

        CL2 = new User("Semen", "Semenov", new Date(), "98274560923l", "Moscow", "semenov@mail.ru", "Qwerty123", (byte)1);
        CL2 = clientService.saveOrUpdateClient(CL2);

        CN21 = new Contract(CL2, null, 14557643, 300);

        CL3 = new User("Petr", "Petrov", new Date(), "9582450345l", "Sankt-Peterburg", "petrov@mail.ru", "petrov51spb", (byte)0);
        CL3 = clientService.saveOrUpdateClient(CL3);

        CN31 = new Contract(CL3, TR1, 896523450, 234);
        CN31 = contractService.saveOrUpdateContract(CN31);
        CN31 = contractService.enableOption(CN31, OP11);
        CN31 = contractService.enableOption(CN31, OP13);
        CL3.addContract(CN31);
        CL3 = clientService.saveOrUpdateClient(CL3);
    }

    @Test
    public void testLoginUser() throws Exception {
        User client = clientService.findUser(CL2.getEmail(), CL2.getPassword());
        Assert.assertEquals(CL2, client);
    }

    @Test
    public void testFindUserByNumber() throws Exception {
        User client = clientService.findUserByNumber(CN31.getNumber());
        Assert.assertEquals(CL3, client);
    }

    @Test
    public void testLoadUser()  throws Exception  {
        Assert.assertEquals(CL1, clientService.loadUser(CL1.getId()));
        Assert.assertEquals(CL2, clientService.loadUser(CL2.getId()));
        Assert.assertEquals(CL3, clientService.loadUser(CL3.getId()));
    }

    @Test
    public void testUpdateUser() throws Exception {
        CL1 = clientService.loadUser(CL1.getId());
        CL1.setLastname("Ivanov");
        CL1.setBirthDate(new Date());
        CL1 = clientService.saveOrUpdateUser(CL1);
        Assert.assertEquals(CL1, clientService.loadUser(CL1.getId()));
    }

    @Test
    public void testDeleteUser() throws Exception {
        clientService.deleteUser(CL1.getId());
        Assert.assertEquals(clientsNumber + 2l, clientService.getNumberOfUsers());
        clientService.deleteUser(CL2.getId());
        Assert.assertEquals(clientsNumber + 1l, clientService.getNumberOfUsers());
        clientService.deleteUser(CL3.getId());
        Assert.assertEquals(clientsNumber, clientService.getNumberOfUsers());
        tariffService.deleteTariff(TR1.getId());
    }

    @Test(expected = ECareException.class)
    public void testLoadMissedUser() throws Exception {
        clientService.loadUser(-12l);
    }

    @Test(expected = ECareException.class)
    public void testDeleteMissedUser() throws Exception {
        clientService.deleteUser(-12l);
    }

    @Test
    public void testAddNewContractToUser() throws Exception {
        CN21 = new Contract(CL2, 12345643l, null, false, false);
        CL2.addContract(CN21);
        CL2 = clientService.saveOrUpdateUser(CL2);
        CN21 = CL2.getContracts().get(0);
        Assert.assertEquals(CL2, clientService.loadUser(CL2.getId()));
    }

    @Test
    public void testLoadContract() throws Exception {
        Assert.assertEquals(CN31, contractService.loadContract(CN31.getId()));
    }

    @Test
    public void testDeleteContract() throws Exception {
        contractService.deleteContract(CN31.getId());
        Assert.assertEquals(contractsNumber + 1l, contractService.getNumberOfContracts());
    }

    @Test(expected = ECareException.class)
    public void testLoadMissedContract() throws Exception {
        contractService.loadContract(-12l);
    }

    @Test(expected = ECareException.class)
    public void testDeleteMissedContract() throws Exception {
        contractService.deleteContract(-12l);
    }

    @After
    public void after() {
        if(clientService.getNumberOfClients() > clientsNumber) {
            if(clientService.existLogin(CL1.getEmail())) clientService.deleteUser(CL1.getId());
            if(clientService.existLogin(CL2.getEmail())) clientService.deleteUser(CL2.getId());
            if(clientService.existLogin(CL3.getEmail())) clientService.deleteUser(CL3.getId());
            tariffService.deleteTariff(TR1.getTariffId());
        }
    }
}
