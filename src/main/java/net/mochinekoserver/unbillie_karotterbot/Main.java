package net.mochinekoserver.unbillie_karotterbot;

import net.mochinekoserver.unbillie_karotterbot.manager.BotManager;
import net.mochinekoserver.unbillie_karotterbot.manager.KarotterManager;
import net.mochinekoserver.unbillie_karotterbot.manager.UnBillieManager;

import java.util.logging.Logger;

public class Main {

    public static final Logger BOT_LOGGER = Logger.getLogger("KarotterBot");

    public static void main(String[] args) {
        BotManager.getInstance().startBot();
    }
}
