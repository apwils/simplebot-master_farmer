package masterFarmer.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.robot.api.ClientContext;

public class Bank extends Task {

    private static WorldPoint bankLocation = new WorldPoint(3092, 3244, 0);

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        return ctx.inventory.getFreeSlots() == 0 || ctx.inventory.populate().filter(379).isEmpty();
    }

    @Override
    public void run() {
        if (ctx.players.getLocal().getLocation().distanceTo(bankLocation) > 3) {
            ctx.pathing.step(bankLocation);
        } else {
            ctx.objects.populate().filter(10355).nearest().next().click("Last-preset");
        }
    }

    @Override
    public String status() {
        return "Banking...";
    }
}
