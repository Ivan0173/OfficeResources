package com.company.officeresources2.screen.user;

import io.jmix.ui.screen.*;
import com.company.officeresources2.entity.User;

@UiController("User.edit")
@UiDescriptor("user-edit.xml")
@EditedEntityContainer("userDc")
public class UserEdit extends StandardEditor<User> {
}