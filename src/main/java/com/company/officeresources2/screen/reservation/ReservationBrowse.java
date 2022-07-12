package com.company.officeresources2.screen.reservation;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Reservation;

@UiController("Reservation.browse")
@UiDescriptor("reservation-browse.xml")
@LookupComponent("reservationsTable")
public class ReservationBrowse extends StandardLookup<Reservation> {
}