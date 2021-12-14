package masterFarmer.tasks;

import simple.hooks.filters.SimpleInventory;
import simple.hooks.scripts.task.Task;
import simple.hooks.wrappers.SimpleLocalPlayer;
import simple.hooks.wrappers.SimpleNpc;
import simple.robot.api.ClientContext;

public class Eat extends Task {

    public Eat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        return ctx.players.getLocal().getHealth() < 20;
    }

    @Override
    public void run() {
        ctx.inventory.populate().filter(379).next().click(0);
    }

    @Override
    public String status() {
        return "Eating...";
    }
}
