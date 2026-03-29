package net.mochinekoserver.unbillie_karotterbot.manager;

import net.mochinekoserver.unbillie_karotterbot.Main;

import java.util.Timer;
import java.util.TimerTask;

public class BotManager {

    private static BotManager instance;
    private static int TASK_DURATION = 60*60;

    private Timer timer = new Timer();
    private TimerTask botTask;

    private BotManager() {}

    public static BotManager getInstance() {
        if (instance == null) {
            instance = new BotManager();
        }
        return instance;
    }

    public void startBot() {
        if (botTask != null) return;
        botTask = new TimerTask() {
            @Override
            public void run() {
                String randomText = UnBillieManager.getRandomText();
                KarotterManager.sendKarotter(randomText);
            }
        };
        timer.schedule(botTask, 0L, 1000L * TASK_DURATION);
        Main.BOT_LOGGER.info("Botが起動しました。");
    }

    public void stopBot() {
        if (botTask == null) return;
        botTask.cancel();
        botTask = null;
        timer.cancel();
    }
}
