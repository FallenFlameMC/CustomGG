package com.fallenflame.core.customgg.gg;


import com.fallenflame.core.customgg.CustomGG;
import com.fallenflame.core.customgg.util.ChatUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class GGHandler {

    private HashMap<UUID, GG> uuidggHashMap = new HashMap<>();

    public boolean hasGG(Player player) {
        return uuidggHashMap.containsKey(player.getUniqueId());
    }
    public GG register(Player player) {
        uuidggHashMap.put(player.getUniqueId(), new GG(player.getUniqueId()));
        return uuidggHashMap.get(player.getUniqueId());
    }
    public GG getGG(Player player) {
        return uuidggHashMap.get(player.getUniqueId());
    }

    public void updateGG(Player player, GG gg) {
        uuidggHashMap.put(player.getUniqueId(), gg);
    }

    public String genGG(Player player) {
        if(uuidggHashMap.containsKey(player.getUniqueId())) {
            GG gg = uuidggHashMap.get(player.getUniqueId());

            String pregg = "";
            String postgg = "";
            pregg += ChatUtil.replaceColorChars("&" + gg.getColor());
            if(gg.isBold()) pregg += ChatColor.BOLD;
            if(gg.isUnderline()) pregg += ChatColor.UNDERLINE;
            if(gg.isItalic()) pregg += ChatColor.ITALIC;
            if(gg.isStrike()) pregg += ChatColor.STRIKETHROUGH;
            if(gg.isHasBars()) {
                pregg += ChatColor.MAGIC + "!" + ChatColor.RESET;
                pregg += ChatUtil.replaceColorChars("&" + gg.getColor());
                if(gg.isBold()) pregg += ChatColor.BOLD;
                if(gg.isUnderline()) pregg += ChatColor.UNDERLINE;
                if(gg.isItalic()) pregg += ChatColor.ITALIC;
                if(gg.isStrike()) pregg += ChatColor.STRIKETHROUGH;

                if(gg.isBold()) postgg += ChatColor.BOLD;
                if(gg.isUnderline()) postgg += ChatColor.UNDERLINE;
                if(gg.isItalic()) postgg += ChatColor.ITALIC;
                if(gg.isStrike()) postgg += ChatColor.STRIKETHROUGH;
                postgg += ChatColor.MAGIC + "!" + ChatColor.RESET;
            }
            return ChatColor.RESET + pregg + "GG" + postgg;
        }
        return "GG";
    }

    public void initGG() {
        CustomGG.instance.getLogger().info("Loading existing users from database.");
        try {
            ResultSet resultSet = CustomGG.connection.createStatement().executeQuery("SELECT * FROM CustomGG");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                String[] values = new String[columnCount];
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    values[i - 1] = resultSet.getString(i);
                }
                uuidggHashMap.put(UUID.fromString(values[0]), new GG(UUID.fromString(values[0]), values[6].charAt(0), Boolean.getBoolean(values[1]), Boolean.getBoolean(values[2]), Boolean.getBoolean(values[3]), Boolean.getBoolean(values[4]), Boolean.getBoolean(values[5])));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        CustomGG.instance.getLogger().info("Saving CustomGG data for all users.");
        for(int i = 0; i < uuidggHashMap.size(); i++) {
            uuidggHashMap.forEach((uuid, gg) -> {
                try {
                    CustomGG.connection.createStatement().execute(String.format("INSERT INTO CustomGG (UUID, Bold, Underline, Italic, Strike, Bars, Color) VALUES ('%s', %s, %s, %s, %s, %s, %s))", uuid.toString(), gg.isBold() ? 1 : 0, gg.isUnderline() ? 1 : 0, gg.isItalic() ? 1 : 0, gg.isStrike() ? 1 : 0, gg.isHasBars() ? 1 : 0, gg.getColor()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
