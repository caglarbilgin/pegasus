package android;

import util.Context;

public class LoginPage {

    public static void loginApp(String phone, String pass) {
        //pop up close
        Context.clickButton("POPUPCLOSE");
        //enter the login page button xpath, comes through json file
        Context.clickButton("LOGINPAGE");
        //send value to username text area, comes through json file
        Context.inputText("USERNAMETEXT1", "554");
        Context.inputText("USERNAMETEXT2", "2330602");
        //send value to password, comes through json file
        Context.inputText("PASSWORDTEXT", "120304");
        //click login button xpath, comes through json file
        Context.clickButton("LOGINBUTTON");
    }

    public static void logoutApp(){

    }
}
