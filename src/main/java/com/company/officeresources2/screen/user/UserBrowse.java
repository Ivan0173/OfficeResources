package com.company.officeresources2.screen.user;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.User;

@UiController("User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
public class UserBrowse extends StandardLookup<User> {
}