package com.company.officeresources2.screen.thing;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.Thing;

@UiController("Thing.browse")
@UiDescriptor("thing-browse.xml")
@LookupComponent("thingsTable")
public class ThingBrowse extends StandardLookup<Thing> {
}