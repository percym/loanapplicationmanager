package com.loanscompany.lam.service.storage;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private Path location = Paths.get(System.getProperty("user.home")+"/loanLogos") ;

    public Path getLocation() {
        return location;
    }

    public void setLocation(Path location) {
        this.location = location;
    }

}
