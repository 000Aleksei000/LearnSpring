package org.example;

import org.springframework.stereotype.Component;

@Component
@RockMusicQual
public class RockMusic implements Music{
    @Override
    public String getSong() {
        return "Do HAST!!!!";
    }
}
