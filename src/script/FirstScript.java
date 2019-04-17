package script;

import org.rspeer.runetek.api.commons.StopWatch;
import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.types.RenderEvent;
import org.rspeer.script.ScriptMeta;
import org.rspeer.script.task.TaskScript;
import org.rspeer.ui.Log;
import script.data.Location;
import script.data.Tree;
import script.tasks.*;
import script.ui.Gui;

import java.awt.*;

@ScriptMeta(name = "RspeerTutorial", desc = "Tutorial script", developer = "buracc")
public class FirstScript extends TaskScript implements RenderListener {

    public static boolean powercutting = false;
    public static Tree tree;
    public static Location locations;
    private StopWatch runtime;
    private int startExp;

    @Override
    public void onStart() {
        Log.fine("Script started.");
        runtime = StopWatch.start();
        startExp = Skills.getExperience(Skill.WOODCUTTING);

        submit(new Gui(),
                new ToggleRun(),
                new Banking(),
                new Drop(),
                new Traverse(),
                new Woodcut());
    }

    @Override
    public void onStop() {
        Log.severe("Stopped script.");
    }

    @Override
    public void notify(RenderEvent e) {
        Graphics g = e.getSource();

        int gainedExperience = Skills.getExperience(Skill.WOODCUTTING) - startExp;

        g.drawString("Runtime: " + runtime.toElapsedString(), 20, 20);
        g.drawString("Exp gained: " + gainedExperience, 20, 40);
        g.drawString("Exp /h: " + runtime.getHourlyRate(gainedExperience), 20, 60);

    }
}
