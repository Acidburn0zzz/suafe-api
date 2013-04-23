package net.lmxm.suafe.api;

import org.junit.Test;

import static net.lmxm.suafe.api.CustomMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public final class UserGroupTest {
    @Test
    public void testUserGroup() {
        assertThat(UserGroup.class, is(protectedConstructor()));

        assertThat(new UserGroup("userGroupName").getName(), is(equalTo("userGroupName")));

        assertThat(new UserGroup("userGroupName").getUsers(), is(emptySet()));
        assertThat(new UserGroup("userGroupName").getUsers(), is(immutableSet()));
    }

    @Test
    public void testAddUser() {
        assertThat(UserGroup.class, is(protectedMethod("addUser")));

        final User user = new User("userName", null);
        final UserGroup userGroup = new UserGroup("userGroupName");
        assertThat(userGroup.getUsers(), is(emptySet()));

        userGroup.addUser(user);
        assertThat(userGroup.getUsers(), is(not(emptySet())));
        assertThat(userGroup.getUsers().iterator().next(), is(sameInstance(user)));
    }

    @Test
    public void testGetUsers() {
        final UserGroup userGroup = new UserGroup("userGroupName");
        assertThat(userGroup.getUsers(), is(immutableSet()));
        assertThat(userGroup.getUsers(), is(notNullValue()));
    }

    @Test
    public void testSetName() {
        assertThat(UserGroup.class, is(protectedMethod("setName")));

        final UserGroup userGroup = new UserGroup("userGroupName");
        assertThat(userGroup.getName(), is(equalTo("userGroupName")));

        userGroup.setName("newUserGroupName");
        assertThat(userGroup.getName(), is(equalTo("newUserGroupName")));
    }
}