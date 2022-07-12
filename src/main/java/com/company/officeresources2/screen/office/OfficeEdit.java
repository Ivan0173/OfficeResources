package com.company.officeresources2.screen.office;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Office;

@UiController("Office.edit")
@UiDescriptor("office-edit.xml")
@EditedEntityContainer("officeDc")
public class OfficeEdit extends StandardEditor<Office> {
}