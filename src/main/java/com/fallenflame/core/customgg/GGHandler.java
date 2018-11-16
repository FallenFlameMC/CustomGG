package com.fallenflame.core.customgg;

import org.bukkit.ChatColor;
import org.json.JSONObject;

public class GGHandler {

    public static String styleGG(JSONObject raw) {
        String ggMSG = "GG";
        String tempgg = ggMSG;
        if(raw.getBoolean("bold")) {
            ggMSG = String.format("%s%s", ChatColor.BOLD, ggMSG);
        }
        if(raw.getBoolean("underline")) {
            ggMSG = String.format("%s%s", ChatColor.UNDERLINE, ggMSG);
        }
        return null;
    }

}
