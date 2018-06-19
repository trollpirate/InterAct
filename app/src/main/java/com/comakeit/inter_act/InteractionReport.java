package com.comakeit.inter_act;

import android.content.Context;
import android.util.Log;

import java.util.Calendar;

public class InteractionReport {
    private String fromUser, toUser, interactionID, eventName, IAType, description, suggestion;
    private boolean isAnonymous;
    private Calendar eventCalendar, IACalendar;

    InteractionReport(Context context){
        /*TODO Obtain username, hardcoding username for now. PRIORITY: HIGHEST
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccounts();
        List<String> possibleEmails = new LinkedList<>();
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        for(Account account: accounts){
            if(emailPattern.matcher(account.name).matches()){
                possibleEmails.add(account.name);
                Log.i("Report EMAIL: ",account.name);
            }
        }
        if(!possibleEmails.isEmpty() && possibleEmails.get(0)!=null){
            fromUser = possibleEmails.get(0);
            IACalendar = Calendar.getInstance();
            interactionID = fromUser + IACalendar.get(Calendar.DAY_OF_MONTH)+IACalendar.get(Calendar.MONTH) + IACalendar.get(Calendar.YEAR) + IACalendar.getTime();
            Log.i("Reporting Report ID: ", interactionID);
        }else{
            Toast.makeText(context, "USERNAME NOT FOUND", Toast.LENGTH_SHORT).show();
            fromUser = "";
        }
        */

        fromUser = "nalin.1997@gmail.com";
        String[] parts = fromUser.split("@");
        IACalendar = Calendar.getInstance();
        interactionID = parts[0] + IACalendar.get(Calendar.DAY_OF_MONTH)+IACalendar.get(Calendar.MONTH) + IACalendar.get(Calendar.YEAR) + IACalendar.get(Calendar.HOUR)
                + IACalendar.get(Calendar.MINUTE) + IACalendar.get(Calendar.SECOND);
        Log.i("Reporting Report ID: ", interactionID);
    }



    /* All getters and setters */
    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(String interactionID) {
        this.interactionID = interactionID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getIAType() {
        return IAType;
    }

    public void setIAType(String IAType) {
        this.IAType = IAType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    public Calendar getEventCalendar() {
        return eventCalendar;
    }

    public void setEventCalendar(Calendar eventCalendar) {
        this.eventCalendar = eventCalendar;
    }

    public Calendar getIACalendar() {
        return IACalendar;
    }

    public void setIACalendar(Calendar IACalendar) {
        this.IACalendar = IACalendar;
    }
}
