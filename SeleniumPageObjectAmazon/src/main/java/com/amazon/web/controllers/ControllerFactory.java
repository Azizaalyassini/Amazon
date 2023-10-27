package com.amazon.web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ControllerFactory {
    // Create a map to associate browser platform names with their respective controllers
    static Map<String, ControllerInterface> browsersMap = new HashMap<>();

    static {
        // Populate the map with supported browser controllers
        browsersMap.put("chrome", new ChromeController());
        browsersMap.put("firefox", new FireFoxController());
        browsersMap.put("edge", new EdgeController());
    }

    // Method to get a driver based on the specified platform
    public static Optional<ControllerInterface> getDriver(String platform) {
        // Return an Optional, allowing for potential absence of the specified platform
        return Optional.ofNullable(browsersMap.get(platform));
    }
}
