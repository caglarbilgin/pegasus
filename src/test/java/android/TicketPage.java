package android;

import util.Context;

public class TicketPage {

    public static void ticket(String from, String to) {
        //pop up close
        //Context.clickButton("POPUPCLOSE");
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
        Context.swipeUpUntilSeeElement("TICKET");
        //Click ticket at the bottom of the page
        Context.clickButton("TICKET");
        //Click business flex button
        Context.clickButton("BUSINESSFLEX");
        //Click continue
        Context.clickButton("CONTINUE");
    }
}
