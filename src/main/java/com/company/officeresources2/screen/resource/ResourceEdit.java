package com.company.officeresources2.screen.resource;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Resource;

@UiController("Resource_.edit")
@UiDescriptor("resource-edit.xml")
@EditedEntityContainer("resourceDc")
public class ResourceEdit extends StandardEditor<Resource> {
}