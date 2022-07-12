package com.company.officeresources2.screen.reservation;

import com.company.officeresources2.app.ResourceService;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Reservation.edit")
@UiDescriptor("reservation-edit.xml")
@EditedEntityContainer("reservationDc")
public class ReservationEdit extends StandardEditor<Reservation> {

    private static String officeExceptionMessage = "The resource is not located in the employee's office";
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private Notifications notifications;
    @Autowired
    private MessageBundle messageBundle;
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Reservation rs = getEditedEntity();
        if(!resourceService.IsCorrectDates(rs.getStartReservation(), rs.getEndReservation())) {
            event.preventCommit();
            notifications.create().withCaption(messageBundle.getMessage("reservationEdit.dateExceptionMessage")).show();
        }
        if(resourceService.IsAlreadyRentedOut(rs)) {
            event.preventCommit();
            notifications.create().withCaption(messageBundle.getMessage("reservationEdit.reservExceptionMessage")).show();
        }
        if (!resourceService.IsAlreadyTaken(rs)) {
            event.preventCommit();
            notifications.create().withCaption(messageBundle.getMessage("reservationEdit.officeExceptionMessage")).show();
        }
    }
}
