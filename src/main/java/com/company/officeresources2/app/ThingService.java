package com.company.officeresources2.app;

import com.company.officeresources2.entity.Reservation;
import com.company.officeresources2.entity.Resource;
import com.company.officeresources2.entity.Thing;
import com.company.officeresources2.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.core.usersubstitution.CurrentUserSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ThingService {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentUserSubstitution currentUserSubstitution;
    @Autowired
    CurrentAuthentication currentAuthentication;
    public boolean isWillTaken(Thing newThing) {
        List<Reservation> reservationList = dataManager.load(Reservation.class).all().list();
        LocalDateTime date = LocalDateTime.now();
        for (Reservation reservation : reservationList) {
            if(!reservation.getResource().getName().equals(newThing.getName()))
                continue;
            if (reservation.getStartReservation().isAfter(date))
                return true;
        }
        return false;
    }
    public boolean prohibitionChangingLocation(Thing newThing) {
        List<Reservation> reservationList = dataManager.load(Reservation.class).all().list();
        LocalDateTime date = LocalDateTime.now();
        User substitutedUser = (User) currentAuthentication.getUser();
        for (Reservation reservation : reservationList) {
            if(!reservation.getResource().getName().equals(newThing.getName()))
                continue;
            if (substitutedUser!=null&&substitutedUser.equals(reservation.getEmployee())&&(reservation.getEndReservation().isAfter(date))&&
                    (date.isAfter(reservation.getStartReservation())))
                return true;
        }
        return false;
    }
    public boolean ChangingLocation(Thing newThing){
        List<Thing> thingsList = dataManager.load(Thing.class).all().list();
        for (Thing thing : thingsList) {
            if(thing.getId().equals(newThing.getId()))
                return true;
        }
        return false;
    }
}