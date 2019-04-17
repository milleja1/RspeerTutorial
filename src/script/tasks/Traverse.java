package script.tasks;

import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.movement.position.Area;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.script.task.Task;
import script.FirstScript;

public class Traverse extends Task {

    @Override
    public boolean validate() {
        return !FirstScript.locations.getTreeArea().contains(Players.getLocal());
    }

    @Override
    public int execute() {
        Movement.walkTo(FirstScript.locations.getTreeArea().getCenter());
        return 1000;
    }
}
