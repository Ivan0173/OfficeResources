package com.company.officeresources2.screen.resource;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Resource;

@UiController("Resource_.browse")
@UiDescriptor("resource-browse.xml")
@LookupComponent("resourcesTable")
public class ResourceBrowse extends StandardLookup<Resource> {
}