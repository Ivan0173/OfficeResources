package com.company.officeresources2.screen.reservedresources;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.ReservedResources;

@UiController("ReservedResources.edit")
@UiDescriptor("reserved-resources-edit.xml")
@EditedEntityContainer("reservedResourcesDc")
public class ReservedResourcesEdit extends StandardEditor<ReservedResources> {
}