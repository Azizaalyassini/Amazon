package com.amazon.web.utils;

import java.util.HashMap;

public class StateHelper {
    private static HashMap<String, Object> CrossStepState = new HashMap<String, Object>();

    public static void setStepState(String key, String value) {
        CrossStepState.put(key, value);
    }

    public static Object getStepState(String key) {
        return CrossStepState.get(key);
    }

    public static void clearStepState() {
        CrossStepState.clear();
    }

    public static int stepStateSize() {
        return CrossStepState.size();
    }
}
