package org.example;

import org.springframework.stereotype.Component;

@Component
@ClassicalMusicQual
public class ClassicalMusic implements Music {

    private void init() {
        System.out.println("init Method");
    }

    private void destroy() {
        System.out.println("destroy method");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
