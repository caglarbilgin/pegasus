package android;

import util.Context;

public class TicketPage {

    public static void ticket(String from, String to) {
        //pop up close, if it exist
        Context.popUpControl("POPUPCLOSE");
        //pop up close, if it exist
        Context.popUpControl("POPUP2");
        //click search cheap flight, comes through json file
        Context.clickButton("SEARCHCHEAPFLIGHT");
        //send value to 'FROM' text area, comes through json file
        Context.inputText("FROM", "istanbul");
        //check text of incoming element from json data, is it equal to expectedElement control
        Context.checkElementsTextEquals("ISTANBULTUMU", from);
        //select istanbul, comes through json file
        Context.clickButton("ISTANBULTUMU");
        //send value to 'TO' from text area, comes through json file
        Context.inputText("TO", "adana");
        //check text of incoming element from json data, is it equal to expectedElement control
        Context.checkElementsTextEquals("ADANA", to);
        //select adana, comes through json file
        Context.clickButton("ADANA");
        //click one-way button, comes through json file
        Context.clickButton("ONEWAY");
        //click calendar button, comes through json file
        Context.clickButton("CALENDAR");
        //select flight date from calendar
        Context.clickButton("FLIGHTDATE");
        //click OK button
        Context.clickButton("OKBUTTON");
        //click search flight button
        Context.clickButton("SEARCHFLIGHT");
        //Swipe ticket at the bottom of the page
        Context.swipeUpUntilSeeElement("TICKET", "23:50");
        //click ticket at the bottom of the page
        Context.clickButton("TICKET");
        //click business flex button
        Context.clickButton("BUSINESSFLEX");
        //pop up close, if it exist
        Context.popUpControl("POPUP2");
        //click continue
        Context.clickButton("CONTINUE");
        //click bol bol arrow button to close
        Context.clickButton("BOLBOLARROWCLOSE");
        //send value to 'NAMEFORTICKET' from text area, comes through json file
        Context.inputText("NAMEFORTICKET", "caglar");
        //send value to 'SURNAMEFORTICKET' from text area, comes through json file
        Context.inputText("SURNAMEFORTICKET","bilgin");
        //one time swipe
        Context.swipeUp(1);
        //click birtdate button
        Context.clickButton("BIRTHDATE");
        //select birtdate and ok button
        Context.clickButton("BIRTHDATEOKBUTTON");
        //click gender
        Context.clickButton("ERKEKBUTTON");
        //one time swipe
        Context.swipeUp(1);
        //send value to 'TC' from text ares
        Context.inputText("TC","17356856236");
        //click continue button
        Context.clickButton("CONTINUE");
    }
}
