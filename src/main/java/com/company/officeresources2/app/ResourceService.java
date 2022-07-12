package com.company.officeresources2.app;

import com.company.officeresources2.entity.Office;
import com.company.officeresources2.entity.Reservation;
import com.company.officeresources2.entity.Resource;
import com.company.officeresources2.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResourceService {
    @Autowired
    private DataManager dataManager;
    public boolean IsCorrectDates(LocalDateTime dateStart, LocalDateTime dateEnd) {
        return !dateStart.isAfter(dateEnd);
    }
    public boolean IsAlreadyRentedOut(Reservation newReservation) {
        List<Reservation> reservationList = dataManager.load(Reservation.class).all().list();
        Resource  resource = newReservation.getResource();
        LocalDateTime startRes = newReservation.getStartReservation(), endReservation = newReservation.getEndReservation();

        for (Reservation reservation : reservationList) {
            if(!reservation.getResource().equals(resource) ||
                    newReservation.getId().equals(reservation.getId())) // We need to skip old version of entity.
                continue;

            if (DataComparator.isBetween(startRes, endReservation,
                    reservation.getStartReservation(), reservation.getEndReservation())) {
                return true;
            }
        }
        return false;
    }
    public boolean IsAlreadyTaken(Reservation newReservation) {
        Resource  resource = newReservation.getResource();
        User user=newReservation.getEmployee();
            if(resource.getOffice().equals(user.getOffice())){
                return true;
            }
        return false;
    }
}