package com.tsystems.javaschool.ecare;

import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.services.OptionService;
import com.tsystems.javaschool.ecare.services.TariffService;
import org.junit.*;


import java.util.List;


public class AdminServicesTest
{

    private static TariffService tariffService = TariffService.getInstance();
    private static OptionService optionService = OptionService.getInstance();

    private static Tariff TR1, TR2;
    private static Option OP11, OP12, OP21, OP22, OP23;

    private static long tariffsNumber;
    private static long optionsNumber;

    @BeforeClass
    public static void beforeClass() {
        TR1 = new Tariff("Tariff1", 200);
        OP11 = new Option(TR1, "Option11", 3, 200);
        OP12 = new Option(TR1, "Option12", 4, 250);
        TR1.addOption(OP11);
        TR1.addOption(OP12);

        TR2 = new Tariff("Tariff2", 300);
        OP21 = new Option(TR2, "Option21", 3, 150);
        OP22 = new Option(TR2, "Option22", 1, 150);
        OP23 = new Option(TR2, "Option23", 2, 200);
        TR2.addOption(OP21);
        TR2.addOption(OP22);
        TR2.addOption(OP23);
    }

    @Before
    public void before() {
        tariffsNumber = tariffService.getNumberOfTariffs();
        optionsNumber = optionService.getNumberOfOptions();
        TR1 = tariffService.saveOrUpdateTariff(TR1);
        TR2 = tariffService.saveOrUpdateTariff(TR2);
        OP11 = TR1.getAvailableOptions().get(0);
        OP12 = TR1.getAvailableOptions().get(1);
        OP21 = TR2.getAvailableOptions().get(0);
        OP22 = TR2.getAvailableOptions().get(1);
        OP23 = TR2.getAvailableOptions().get(2);
    }

    @Test
    public void testLoadTariff()  throws Exception  {
        Assert.assertEquals(TR1, tariffService.loadTariff(TR1.getTariffId()));
        Assert.assertEquals(TR2, tariffService.loadTariff(TR2.getTariffId()));
    }

    @Test
    public void testDeleteTariff() throws Exception {
        tariffService.deleteTariff(TR1.getTariffId());
        Assert.assertEquals(tariffsNumber + 1l, tariffService.getNumberOfTariffs());
        tariffService.deleteTariff(TR2.getTariffId());
        Assert.assertEquals(tariffsNumber, tariffService.getNumberOfTariffs());
    }

    @Test(expected = Exception.class)
    public void testLoadMissedTariff() throws Exception {
        tariffService.loadTariff(-12);
    }

    @Test(expected = Exception.class)
    public void testDeleteMissedTariff() throws Exception {
        tariffService.deleteTariff(-12);
    }

    @Test
    public void testAddNewOptionToTariff() throws Exception {
        Option option = new Option(TR1, "Temporary Option", 100, 100);
        TR1.addOption(option);
        TR1 = tariffService.saveOrUpdateTariff(TR1);
        Assert.assertEquals(TR1, tariffService.loadTariff(TR1.getTariffId()));
        TR1.getAvailableOptions().remove(option);
        TR1 = tariffService.saveOrUpdateTariff(TR1);
        Assert.assertEquals(TR1, tariffService.loadTariff(TR1.getTariffId()));
    }

    @Test
    public void testLoadOption() throws Exception {
        Assert.assertEquals(OP11, optionService.loadOption(TR1.getAvailableOptions().get(0).getId()));
        Assert.assertEquals(OP12, optionService.loadOption(TR1.getAvailableOptions().get(1).getId()));
        Assert.assertEquals(OP21, optionService.loadOption(TR2.getAvailableOptions().get(0).getId()));
        Assert.assertEquals(OP22, optionService.loadOption(TR2.getAvailableOptions().get(1).getId()));
        Assert.assertEquals(OP23, optionService.loadOption(TR2.getAvailableOptions().get(2).getId()));
    }

    @Test
    public void testUpdateOption() throws Exception {
        OP21.setTitle("Changed Title");
        optionService.saveOrUpdateOption(OP21);
        Assert.assertEquals(OP21, optionService.loadOption(OP21.getOptionId()));
    }

    @Test
    public void testDeleteOption() throws Exception {
        TR1.getAvailableOptions().remove(OP11);
        tariffService.saveOrUpdateTariff(TR1);
        optionService.deleteOption(OP11.getOptionId());
        Assert.assertEquals(optionsNumber + 6l, optionService.getNumberOfOptions());
        TR1.addOption(OP11);
        TR1 = tariffService.saveOrUpdateTariff(TR1);
    }

    @Test
    public void testgetAvailableOptionsForTariff() throws Exception {
        Option[] options2 = new Option[]{OP21, OP22, OP23};
        List<Option> loadedOptions2 = optionService.getAllOptionsForTariff(TR2.getTariffId());
        Assert.assertArrayEquals(options2, loadedOptions2.toArray());
    }





    @Test(expected = Exception.class)
    public void testLoadMissedOption() throws Exception {
        optionService.loadOption(-12);
    }

    @Test(expected = Exception.class)
    public void testDeleteMissedContract() throws Exception {
        optionService.deleteOption(-12);
    }

    @After
    public void after() {
        if(tariffService.getNumberOfTariffs() > tariffsNumber) {
            tariffService.deleteTariff(TR1.getTariffId());
            tariffService.deleteTariff(TR2.getTariffId());
        }
    }
}
