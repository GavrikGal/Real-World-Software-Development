package com.gal.gavrik.shu_book.chapter_06;

import java.util.Optional;

public class Twootr {

    public Optional<SenderEndPoint> onLogon(String userId,
                                     String password,
                                     ReceiverEndPoint receiver) {
        return Optional.of(new SenderEndPoint());
    }

}
