package com.company.officeresources2.screen.thing;

import com.company.officeresources2.app.ResourceService;
import com.company.officeresources2.app.ThingService;
import com.company.officeresources2.entity.Reservation;
import com.company.officeresources2.screen.reservation.ReservationEdit;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Thing;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Thing.edit")
@UiDescriptor("thing-edit.xml")
@EditedEntityContainer("thingDc")
public class ThingEdit extends StandardEditor<Thing> {
    @Autowired
    private Notifications notifications;
    @Autowired
    private MessageBundle messageBundle;
    @Autowired
    private ThingService thingService;
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Thing th = getEditedEntity();
        if(thingService.ChangingLocation(th)) {
            if (thingService.isWillTaken(th)) {
                event.preventCommit();
                notifications.create().withCaption(messageBundle.getMessage("thingEdit.willTakenExceptionMessage")).show();
            }
            if (!thingService.prohibitionChangingLocation(th)) {
                event.preventCommit();
                notifications.create().withCaption(messageBundle.getMessage("thingEdit.changingLocation")).show();
            }
        }
    }
}