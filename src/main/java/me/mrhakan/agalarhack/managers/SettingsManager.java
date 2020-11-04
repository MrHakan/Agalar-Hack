package me.mrhakan.agalarhack.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.module.Module;
import me.mrhakan.agalarhack.managers.Settings;

public class SettingsManager {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    File configFile = new File("AgalarHack/agalarhack-config.json");

    public Map<String, Settings> readSettings() {
        Map<String, Settings> settingsArray = new HashMap<>();
        if (configFile.exists() && configFile.isFile()) {
            try {
                settingsArray = gson.fromJson(new FileReader(configFile), new TypeToken<Map<String, Settings>>(){}.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                FileWriter fw = new FileWriter(configFile);
                gson.toJson(settingsArray, fw);
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return settingsArray;
    }

    public void writeSettings(Map<String, Settings> settingsArray) {
        try {
            FileWriter fw = new FileWriter(configFile);
            gson.toJson(settingsArray, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSettings() {
        Map<String, Settings> settingsArray = new HashMap<>();
        for (Module module : Main.moduleManager.getModuleList()) {
            settingsArray.put(module.getName(), module.settings);
        }
        writeSettings(settingsArray);
    }

    public void loadSettings() {
        Map<String, Settings> settingsArray = readSettings();
        for (Module module : Main.moduleManager.getModuleList()) {
            String moduleName = module.getName();
            try {
                if (settingsArray.containsKey(moduleName)) {
                    module.setSettings(settingsArray.get(moduleName));
                } else {
                    module.registerSettings();
                }
            } catch (NullPointerException npe) {
                module.registerSettings();
            }
        }
        updateSettings();
    }
}
