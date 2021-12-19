package zulrah.tasks;

import net.runelite.api.coords.WorldPoint;
import simple.hooks.scripts.task.Task;
import simple.robot.api.ClientContext;

public class Placeholder extends Task {

    public Placeholder(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean condition() {
        return true;
    }

    @Override
    public void run() {
       // do stuff
    }

    @Override
    public String status() {
        return "Placeholder...";
    }
}
