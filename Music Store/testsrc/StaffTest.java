
import hmalika.MainStoreUpdated;
import hmalika.NewStaff;
import hmalika.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StaffTest {

    public static List<Product> list = new ArrayList<>();

    @Test
    public void testStaffMessages() {

        list = Product.loadProductsJson();

        Assert.assertTrue(NewStaff.getMessageOne().contains("Welcome staff members"));
        Assert.assertTrue(NewStaff.getMessageTwo().contains("Here is the current inventory"));

    }        // prints list

    @Test
    public void testGetStaffMainMenu() {

        //menu
        Assert.assertTrue(NewStaff.getFirstMessageMenu().contains("Please choose an option below"));
        Assert.assertTrue(NewStaff.optionOne().contains("1 - Add a product"));
        Assert.assertTrue(NewStaff.optionTwo().contains("2 - Remove a product"));
        Assert.assertTrue(NewStaff.optionThree().contains("3 - Change stock information of a product"));
        Assert.assertTrue(NewStaff.optionFour().contains("4 - Apply a discount"));
        Assert.assertTrue(NewStaff.optionFive().contains("5 - Save changes"));

        String option = "1";
        int optionInt = NewStaff.returnStringToInteger(option);

        NewStaff.goToSelectedAction(optionInt, list);

        //choice 1

        Assert.assertTrue(NewStaff.getMessageAddProductSong().contains("Enter product song name:"));
        NewStaff.staffAddProductSong("song");

        Assert.assertTrue(NewStaff.getMessageAddProductArtist().contains("Enter artists"));
        NewStaff.staffAddProductArtist("artist");

        Assert.assertTrue(NewStaff.getMessageAddProductPrice().contains("Enter the price"));
        NewStaff.staffAddProductPrice("6.00");

        Assert.assertTrue(NewStaff.getMessageAddProductStock().contains("Enter the stock"));
        NewStaff.staffAddProductStock("3");

        Assert.assertTrue(NewStaff.updatedListMessage().contains("Here is the updated list"));
        NewStaff.showUpdatedList(list);

        Assert.assertTrue(NewStaff.getMessageBackToMenu().contains("Would you like to go back to the main menu (Y/N)?"));

        NewStaff.backToMainMenu(list);
        NewStaff.returnUserToMenuOrExit("N", list);

        Assert.assertTrue(MainStoreUpdated.hasFinished());
    }

}
