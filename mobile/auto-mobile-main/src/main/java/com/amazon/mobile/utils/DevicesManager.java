package com.amazon.mobile.utils;

import lombok.Getter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

@Getter
public class DevicesManager {
    String udid, deviceName, platformVersion;
    int systemPort;

    public void prepareDeviceInfo(String device) throws IOException, ParseException {
        String platformFolder;
        if (System.getProperty("platform").contains("droid")) {
            platformFolder = "Android";
        } else {
            platformFolder = "iOS";
        }
        device = device.toLowerCase();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/Devices/" + platformFolder + "/" + device + ".json");
        Object obj = jsonParser.parse(reader);
        JSONObject deviceInfo = (JSONObject) obj;
        udid = deviceInfo.get("udid").toString();
        deviceName = deviceInfo.get("deviceName").toString();
        platformVersion = deviceInfo.get("platformVersion").toString();
        try {
            systemPort = Integer.parseInt(deviceInfo.get("systemPort").toString());
        } catch (Exception e) {

        }

    }
}
