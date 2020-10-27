package utils;

public class pageObjects {

    public static String txt_username = "//*[@id='user-name']";
    public static String txt_password = "//*[@id='password']";
    public static String btn_login = "//*[@id='login-button']";

    public static String btn_addprod1 = "//div[@id='inventory_container']/div/div/div[3]/button";
    public static String btn_addprod2 = "//div[@id='inventory_container']/div/div[5]/div[3]/button";
    public static String btn_verifyPro1 = "//a[@id='item_4_title_link']/div";
    public static String btn_verifyPro2 = "//a[@id='item_2_title_link']/div";
    public static String btn_checkoutI = "//*[@id=/'shopping_cart_container/']";
    public static String btn_checkoutII = "//*[@id=/'cart_contents_container/']";
    public static String txt_firstname = "//*[@id=/'first-name/']";
    public static String txt_lastname = "//*[@id=/'last-name/']";
    public static String txt_postalcode = "//*[@id=/'postal-code/']";
    public static String btn_continue = "//*[@id=/'checkout_info_container/']";
    public static String btn_finish = "//*[@id=/'checkout_summary_container/']";

    public static String lbl_assertAmount = "//div[@id='checkout_summary_container']/div/div[2]/div[7]";
    public static String lbl_assertOrder = "//div[@id='checkout_complete_container']/h2";


}
