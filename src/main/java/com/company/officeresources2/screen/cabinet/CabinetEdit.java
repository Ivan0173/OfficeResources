package com.company.officeresources2.screen.cabinet;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Cabinet;

@UiController("Cabinet.edit")
@UiDescriptor("cabinet-edit.xml")
@EditedEntityContainer("cabinetDc")
public class CabinetEdit extends StandardEditor<Cabinet> {
}