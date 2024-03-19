package com.gal.gavrik.shu_book.chapter_06;

import org.junit.Test;

import java.util.Optional;

import static com.gal.gavrik.shu_book.chapter_06.FollowStatus.*;
import static org.junit.Assert.*;

public class TwootrTest {

    private final Twootr twootr = new Twootr();
    private SenderEndPoint endPoint;

    @Test
    public void shouldBeAbleToAuthenticateUser() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                "User", "good password", new ReceiverEndPoint());
        assertTrue(endPoint.isPresent());
    }

    @Test
    public void shouldNotAuthenticateUnknownUser() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                "User", "good password", new ReceiverEndPoint());
        assertFalse(endPoint.isPresent());
    }

    @Test
    public void shouldNotAuthenticateUserWithWrongPassword() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                "User", "bad password", new ReceiverEndPoint());
        assertFalse(endPoint.isPresent());
    }

    @Test
    public void shouldFollowValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow("Other User");
        assertEquals(SUCCESS, followStatus);
    }

    @Test
    public void shouldNotDuplicateFollowValidUser() {
        logon();
        endPoint.onFollow("Other User");

        final FollowStatus followStatus = endPoint.onFollow("Other User");
        assertEquals(ALREADY_FOLLOWING, followStatus);
    }

    @Test
    public void shouldNotFollowInValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow("Unknown User");
        assertEquals(INVALID_USER, followStatus);
    }

    private void logon() {
        endPoint = twootr.onLogon(
                "User",
                "good password",
                new ReceiverEndPoint()).orElseThrow();
    }

}
