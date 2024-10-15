package tests;

import common.MobileFunctions;
import pages.BasePage;

public class WorkTest extends BasePage {

    public static void main(String[] args)
    {
        MobileFunctions mFunctions = new MobileFunctions();

        try {

            mFunctions.initializeDriver("Android");
            mFunctions.seePage("Number");
            mFunctions.clickElement("Number_5 button", 1);
        } catch(Exception exp) {

            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

}
