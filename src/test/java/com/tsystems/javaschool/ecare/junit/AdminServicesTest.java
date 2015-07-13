package com.tsystems.javaschool.ecare.junit;

import com.tsystems.javaschool.ecare.entities.Option;
import com.tsystems.javaschool.ecare.entities.Tariff;
import com.tsystems.javaschool.ecare.services.OptionService;
import com.tsystems.javaschool.ecare.services.TariffService;
import org.junit.*;


import java.util.HashSet;
import java.util.List;


public class AdminServicesTest
{

    
    

    private static Tariff TR1, TR2;
    private static Option OP11, OP12, OP21, OP22, OP23;

    private static long tariffsNumber;
    private static long optionsNumber;

    @BeforeClass
    public static void beforeClass() {
        TR1 = new Tariff("Tariff1", 200, new HashSet<Option>());
        OP11 = new Option("Option11", 3, 200);
        OP12 = new Option("Option12", 4, 250);
        TR1.getAvailableOptions().add(OP11);
        TR1.getAvailableOptions().add(OP12);

        TR2 = new Tariff("Tariff2", 300, new HashSet<Option>());
        OP21 = new Option("Option21", 3, 150);
        OP22 = new Option("Option22", 1, 150);
        OP23 = new Option("Option23", 2, 200);
        TR2.getAvailableOptions().add(OP21);
        TR2.getAvailableOptions().add(OP22);
        TR2.getAvailableOptions().add(OP23);
    }

    @Before
    public void before() {
        tariffsNumber = TariffService.getInstance().getNumberOfTariffs();
        optionsNumber = OptionService.getInstance().getNumberOfOptions();
        TR1 = TariffService.getInstance().saveOrUpdateTariff(TR1);
        TR2 = TariffService.getInstance().saveOrUpdateTariff(TR2);
        /*OP11 = TR1.getAvailableOptions().get(0);
        OP12 = TR1.getAvailableOptions().get(1);
        OP21 = TR2.getAvailableOptions().get(0);
        OP22 = TR2.getAvailableOptions().get(1);
        OP23 = TR2.getAvailableOptions().get(2);*/
    }

    @Test
    public void testLoadTariff()  throws Exception  {
        Assert.assertEquals(TR1, TariffService.getInstance().loadTariff(TR1.getTariffId()));
        Assert.assertEquals(TR2, TariffService.getInstance().loadTariff(TR2.getTariffId()));
    }

    @Test
    public void testDeleteTariff() throws Exception {
        TariffService.getInstance().deleteTariff(TR1.getTariffId());
        Assert.assertEquals(tariffsNumber + 1l, TariffService.getInstance().getNumberOfTariffs());
        TariffService.getInstance().deleteTariff(TR2.getTariffId());
        Assert.assertEquals(tariffsNumber, TariffService.getInstance().getNumberOfTariffs());
    }

    @Test(expected = Exception.class)
    public void testLoadMissedTariff() throws Exception {
        TariffService.getInstance().loadTariff(-12);
    }

    @Test(expected = Exception.class)
    public void testDeleteMissedTariff() throws Exception {
        TariffService.getInstance().deleteTariff(-12);
    }

    @Test
    public void testAddNewOptionToTariff() throws Exception {
        Option option = new Option("Temporary Option", 100, 100);
        TR1.getAvailableOptions().add(option);
        TR1 = TariffService.getInstance().saveOrUpdateTariff(TR1);
        Assert.assertEquals(TR1, TariffService.getInstance().loadTariff(TR1.getTariffId()));
        TR1.getAvailableOptions().remove(option);
        TR1 = TariffService.getInstance().saveOrUpdateTariff(TR1);
        Assert.assertEquals(TR1, TariffService.getInstance().loadTariff(TR1.getTariffId()));
    }



    @Test
    public void testUpdateOption() throws Exception {
        OP21.setName("Changed Title");
        OptionService.getInstance().saveOrUpdateOption(OP21);
        Assert.assertEquals(OP21, OptionService.getInstance().loadOption(OP21.getOptionId()));
    }

    @Test
    public void testDeleteOption() throws Exception {
        TR1.getAvailableOptions().remove(OP11);
        TariffService.getInstance().saveOrUpdateTariff(TR1);
        OptionService.getInstance().deleteOption(OP11.getOptionId());
        Assert.assertEquals(optionsNumber + 6l, OptionService.getInstance().getNumberOfOptions());
        TR1.getAvailableOptions().add(OP11);
        TR1 = TariffService.getInstance().saveOrUpdateTariff(TR1);
    }

    @Test
    public void testgetAvailableOptionsForTariff() throws Exception {
        Option[] options2 = new Option[]{OP21, OP22, OP23};
        List<Option> loadedOptions2 = OptionService.getInstance().getAllOptionsForTariff(TR2.getTariffId());
        Assert.assertArrayEquals(options2, loadedOptions2.toArray());
    }





    @Test(expected = Exception.class)
    public void testLoadMissedOption() throws Exception {
        OptionService.getInstance().loadOption(-12);
    }

    @Test(expected = Exception.class)
    public void testDeleteMissedContract() throws Exception {
        OptionService.getInstance().deleteOption(-12);
    }

    @After
    public void after() {
        if(TariffService.getInstance().getNumberOfTariffs() > tariffsNumber) {
            TariffService.getInstance().deleteTariff(TR1.getTariffId());
            TariffService.getInstance().deleteTariff(TR2.getTariffId());
        }
    }
}
