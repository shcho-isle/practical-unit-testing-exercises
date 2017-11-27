package com.practicalunittesting.c5.c7.c1;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private static final String SIMPLE_PASSWORD = "simplePassword";
    private static final String MD5_PASSWORD = "md5Password";

    @Test
    public void assignPasswordTest() throws Exception {
        User user = mock(User.class);
        SecurityService securityService = mock(SecurityService.class);
        UserDAO userDAO = mock(UserDAO.class);

        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);

        when(user.getPassword()).thenReturn(SIMPLE_PASSWORD);
        when(securityService.md5(SIMPLE_PASSWORD)).thenReturn(MD5_PASSWORD);

        sut.assignPassword(user);

        verify(user).setPassword(MD5_PASSWORD);
        verify(userDAO).updateUser(user);
    }
}
