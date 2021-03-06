//package com.uwics.uwidiscover.utils;
//
//import android.app.Application;
//import android.provider.Settings;
//
//import com.parse.Parse;
//import com.parse.ParseInstallation;
//import com.parse.ParseObject;
//import com.uwics.uwidiscover.classes.models.Event;
//import com.uwics.uwidiscover.classes.models.Faculty;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Locale;
//
///**
// * Created by Howard on 1/22/2016.
// * @author Javon Davis
// */
//public class ParseController extends Application {
//
//    private List<Event> eventList = new ArrayList<>();
//    //need fi fix
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Parse.enableLocalDatastore(this);
//        //ParseObject.registerSubclass(Event.class);
//        ParseObject.registerSubclass(Faculty.class);
//        Parse.initialize(this);
//        initializeDeviceId();
//    }
//
//    private void initializeDeviceId() {
//        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//        String deviceId = installation.getString("unique_id");
//
//        if ("".equals(deviceId) | deviceId == null) {
//            deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
//
//            installation.put("unique_id", deviceId);
//            installation.saveInBackground();
//        }
//    }
//    //can gwan
//    public List<Event> getEventList() {
//        return eventList;
//    }
//    //can gwan
//    public void setEventList(List<Event> eventList) {
//        this.eventList = eventList;
//
//        for (Event e : eventList) {
//            // Some extra space popping up in the first replace unexpectedly, so I had to remove duplicates in the replaceAll
//            if (e.getStartTime().contains("AM"))
//                e.setStartTime(e.getStartTime().replace("AM", " AM").replaceAll("\\s+", " "));
//            else e.setStartTime(e.getStartTime().replace("PM", " PM").replaceAll("\\s+", " "));
//
//            if (e.getEndTime().contains("AM"))
//                e.setEndTime(e.getEndTime().replace("AM", " AM").replaceAll("\\s+", " "));
//            else e.setEndTime(e.getEndTime().replace("PM", " PM").replaceAll("\\s+", " "));
//        }
//
//        Collections.sort(eventList, new Comparator<Event>() {
//            DateFormat format = new SimpleDateFormat("h:mm a",Locale.US);
//
//            @Override
//            public int compare(Event lhs, Event rhs) {
//                try {
//                    return format.parse(lhs.getStartTime()).compareTo(format.parse(rhs.getStartTime()));
//                } catch (ParseException e) {
//                    return -1;
//                }
//            }
//        });
//    }
//}
