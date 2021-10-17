package nationsatwar.nationsatwar.guis.screens;

import nationsatwar.nationsatwar.Nationsatwar;
import nationsatwar.nationsatwar.factions.Faction;
import nationsatwar.nationsatwar.factions.FactionsContainer;
import nationsatwar.nationsatwar.guis.EldarionGui;
import nationsatwar.nationsatwar.guis.EldarionGuiEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class FactionlessScreen extends EldarionGuiEvent {
    public FactionlessScreen(Player player) {
        screenOwner = player;
        createGui();
    }

    private void createGui() {
        gui = new EldarionGui(9, "Factionless GUI", this);
        gui.addItem(Material.CYAN_BANNER, "List factions");
        gui.addItem(Material.DARK_OAK_DOOR, "Join a faction");
        gui.addItem(Material.NETHER_STAR, "Create a faction");
        gui.openInventory(screenOwner);
    }

    @Override
    public void inventoryClicked(InventoryClickEvent event) {
        if (!event.getInventory().equals(gui.getMinecraftInventory())) return;
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        this.processClick(item, event.getWhoClicked());
        event.getWhoClicked().closeInventory();
    }

    private void processClick(ItemStack item, HumanEntity player) {
        String itemDisplayName = Objects.requireNonNull(item.getItemMeta()).getDisplayName();
        switch (itemDisplayName) {
            case "List factions":
                player.sendMessage(ChatColor.AQUA + "Listing of factions");
                for (Faction f : FactionsContainer.getFactions()) {
                    player.sendMessage(f.getFactionName());
                }
                break;
            case "Join a faction":
                player.sendMessage(ChatColor.DARK_GREEN + "Please write the faction you want to join in the chat.");
                break;
            case "Create a faction":
                player.sendMessage(ChatColor.DARK_GREEN + "Please write the name of your faction in the chat.");
                break;
        }
    }

    private Player screenOwner;
    private EldarionGui gui;
}
