package com.company.officeresources2.screen.office;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Office;

@UiController("Office.browse")
@UiDescriptor("office-browse.xml")
@LookupComponent("officesTable")
public class OfficeBrowse extends StandardLookup<Office> {
}