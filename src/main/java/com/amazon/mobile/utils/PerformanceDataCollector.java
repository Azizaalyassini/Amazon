package com.amazon.mobile.utils;

import com.amazon.mobile.controllers.ThreadLocalDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.List;

public class PerformanceDataCollector {

    public double getMemoryInfo() {
        List<List<Object>> data = ((AndroidDriver) ThreadLocalDriver.getTLDriver()).getPerformanceData("com.amazon.mShop.android.shopping", "memoryinfo", 10);
        HashMap<String, Double> readableData = new HashMap<>();
        for (int i = 0; i < data.get(0).size(); i++) {
            double val;
            if (data.get(1).get(i) == null) {
                val = 0;
            } else {
                val = Double.parseDouble((String) data.get(1).get(i));
            }
            readableData.put((String) data.get(0).get(i), val);
        }
        return readableData.get("totalPss");
    }
}
