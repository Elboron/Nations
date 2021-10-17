package nationsatwar.nationsatwar.events;

import nationsatwar.nationsatwar.Nationsatwar;
import nationsatwar.nationsatwar.guis.EldarionGuiEvent;
import nationsatwar.nationsatwar.guis.InventoryEventContainer;
import org.bukkit.event.inventory.InventoryClickEvent;

public class OnInventoryClick {
    public static void handle(InventoryClickEvent event) {

        for(EldarionGuiEvent event1: InventoryEventContainer.getHandlers()) {
            event1.inventoryClicked(event);
        }
    }
}
