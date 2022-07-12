package com.company.officeresources2.app;

import com.company.officeresources2.entity.Reservation;
import com.company.officeresources2.entity.ReservedResources;
import com.company.officeresources2.entity.Resource;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class ReservedResourcesService {
    @Autowired
    private DataManager dataManager;

    public List<ReservedResources> loadShopAreas() {
        List<Resource> resorceList = dataManager.load(Resource.class).all().list();
        List<Reservation> reservationList = dataManager.load(Reservation.class).all().list();
        ReservedResources temp;
        List<ReservedResources> list = new LinkedList<>();
        LocalDateTime date = LocalDateTime.now();
        for(Resource resource:resorceList){
           temp= dataManager.create(ReservedResources.class);
           temp.setId(UUID.randomUUID());
           temp.setResource(resource);
           for(Reservation reservation:reservationList){
               if(reservation.getResource().equals(resource)&&(reservation.getEndReservation().isAfter(date))&&
                       (date.isAfter(reservation.getStartReservation())))
                   temp.setOwner(reservation.getEmployee());
           }
           list.add(temp);
        }
            return list;
    }
}