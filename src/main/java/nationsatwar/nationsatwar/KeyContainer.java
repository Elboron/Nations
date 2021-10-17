package nationsatwar.nationsatwar;

import org.bukkit.NamespacedKey;

public class KeyContainer {
    public static void initKeys() {
        factionKey = new NamespacedKey(Nationsatwar.getPluginInstance(), "faction");
        playerTypeKey = new NamespacedKey(Nationsatwar.getPluginInstance(), "playerType");
    }

    public static NamespacedKey getFactionKey() {
        return factionKey;
    }

    public static NamespacedKey getPlayerTypeKey() {
        return playerTypeKey;
    }

    private static NamespacedKey factionKey;
    private static NamespacedKey playerTypeKey;
}
