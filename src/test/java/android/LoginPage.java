package android;

import util.Context;

public class LoginPage {

    public static void loginApp(String phone, String pass) {
        //pop up close
        //Context.clickButton("POPUPCLOSE");
        //enter the login page button xpath, comes through json file
        Context.clickButton("LOGINPAGE");
        //send value to username text area, comes through json file
        Context.inputText("USERNAMETEXT1", phone);
        //send value to password, comes through json file
        Context.inputText("PASSWORDTEXT", pass);
        //click login button xpath, comes through json file
        Context.clickButton("LOGINBUTTON");
    }

    public static void logoutApp() {
        Context.clickButton("USERNAME");
        Context.swipeUp(3);
        Context.clickButton("LOGOUT");
    }
}
