package net.mochinekoserver.unbillie_karotterbot;

import net.mochinekoserver.unbillie_karotterbot.manager.BotManager;
import net.mochinekoserver.unbillie_karotterbot.manager.KarotterManager;
import net.mochinekoserver.unbillie_karotterbot.manager.UnBillieManager;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static final Logger BOT_LOGGER = Logger.getLogger("KarotterBot");

    public static void main(String[] args) {
        BotManager botManager = BotManager.getInstance();
        initialize();

        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        while (scanner.hasNext()) {
            String text = scanner.next();
            if (text.equalsIgnoreCase("stop")) {
                botManager.stopBot();
                scanner.close();
                break;
            }
            else {
                System.out.println("そのコマンドはありません。");
            }

            System.out.print("> ");
        }
    }

    public static void initialize() {
        BotManager.getInstance().startBot();
    }
}
