package utils;

public class pageObjects {

    public static String txt_username = "//*[@id='user-name']";
    public static String txt_password = "//*[@id='password']";
    public static String btn_login = "//*[@id='login-button']";

    public static String btn_addprod1 = "//div[@id='inventory_container']/div/div/div[3]/button";
    public static String btn_addprod2 = "//div[@id='inventory_container']/div/div[5]/div[3]/button";
    public static String btn_verifyPro1 = "//a[@id='item_4_title_link']/div";
    public static String btn_verifyPro2 = "//a[@id='item_2_title_link']/div";
    public static String btn_checkoutI = "path";
    public static String btn_checkoutII = "CHECKOUT";
    public static String txt_firstname = "first-name";
    public static String txt_lastname = "last-name";
    public static String txt_postalcode = "postal-code";
    public static String btn_continue = "//input[@value='CONTINUE']"; //*[@id="checkout_info_container"]/div/form/div[2]/input
    public static String btn_finish = "FINISH"; //*[@id="checkout_summary_container"]/div/div[2]/div[8]/a[2]

    public static String lbl_assertAmount = "//div[@id='checkout_summary_container']/div/div[2]/div[7]";
    public static String lbl_assertOrder = "//div[@id='checkout_complete_container']/h2";


}
