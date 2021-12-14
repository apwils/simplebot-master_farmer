package masterFarmer.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class Thieve extends Task {

    private static WorldPoint thieveLocation = new WorldPoint(3077, 3251, 0);

    public Thieve(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        return ctx.inventory.getFreeSlots() != 0;
    }

    @Override
    public void run() {
        if (ctx.players.getLocal().getLocation().distanceTo(thieveLocation) > 13) {
            ctx.pathing.step(thieveLocation);
        } else {
            final SimpleNpc farmer = (SimpleNpc) ctx.npcs.populate().filter(5730).nearest().next();
            if(farmer.click("Pickpocket")){
                ctx.sleep(300);
            }
        }
    }

    @Override
    public String status() {
        return "Thieving...";
    }
}
