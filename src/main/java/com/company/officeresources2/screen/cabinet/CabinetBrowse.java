package com.company.officeresources2.screen.cabinet;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Cabinet;

@UiController("Cabinet.browse")
@UiDescriptor("cabinet-browse.xml")
@LookupComponent("cabinetsTable")
public class CabinetBrowse extends StandardLookup<Cabinet> {
}