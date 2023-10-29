package com.amazon.mobile.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ControllerFactory {
    static Map<String, ControllerInterface> platformMap = new HashMap<>();

    static {
        platformMap.put("Android", new AndroidController());
        platformMap.put("iOS", new IOSController());
        platformMap.put("AndroidParallel", new AndroidParallelController());
        platformMap.put("IOSParallel", new IOSParallelController());

    }

    public static Optional<ControllerInterface> getDriver(String platform) {
        return Optional.ofNullable(platformMap.get(platform));

    }
}
