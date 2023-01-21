package Game;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Akın'ın Macera Oyununa Hoş Geldiniz");
        System.out.print("Oyuncu Adınızı Giriniz: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Maceraya Hoş Geldin " + player.getName());
        player.selectChar();
        player.selectLocation();

    }
}
