class TV {
    public void turnOn() {
        System.out.println("Телевизор включен.");
    }

    public void turnOff() {
        System.out.println("Телевизор выключен.");
    }

    public void setChannel(int channel) {
        System.out.println("Канал установлен на " + channel + ".");
    }

    public void setAudioInput() {
        System.out.println("Аудиовход установлен на ТВ.");
    }
}

class AudioSystem {
    public void turnOn() {
        System.out.println("Аудиосистема включена.");
    }

    public void turnOff() {
        System.out.println("Аудиосистема выключена.");
    }

    public void setVolume(int level) {
        System.out.println("Громкость установлена на уровень " + level + ".");
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD воспроизводится.");
    }

    public void pause() {
        System.out.println("DVD на паузе.");
    }

    public void stop() {
        System.out.println("DVD остановлен.");
    }
}

class GameConsole {
    public void turnOn() {
        System.out.println("Игровая консоль включена.");
    }

    public void startGame(String game) {
        System.out.println("Запуск игры: " + game);
    }
}

class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void watchMovie() {
        System.out.println("\nПодготовка к просмотру фильма...");
        tv.turnOn();
        audioSystem.turnOn();
        tv.setChannel(1);
        audioSystem.setVolume(5);
        dvdPlayer.play();
        System.out.println("Наслаждайтесь фильмом!\n");
    }

    public void endMovie() {
        System.out.println("\nВыключение системы после фильма...");
        dvdPlayer.stop();
        tv.turnOff();
        audioSystem.turnOff();
        System.out.println("Система выключена.\n");
    }

    public void playGame(String game) {
        System.out.println("\nПодготовка к запуску игры...");
        tv.turnOn();
        audioSystem.turnOn();
        gameConsole.turnOn();
        audioSystem.setVolume(7);
        gameConsole.startGame(game);
        System.out.println("Игра запущена! Удачи!\n");
    }

    public void listenToMusic() {
        System.out.println("\nПодготовка к прослушиванию музыки...");
        tv.turnOn();
        audioSystem.turnOn();
        tv.setAudioInput();
        audioSystem.setVolume(10);
        System.out.println("Музыка включена. Приятного прослушивания!\n");
    }

    public void setVolume(int level) {
        audioSystem.setVolume(level);
    }
}

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        homeTheater.watchMovie();
        homeTheater.endMovie();

        homeTheater.playGame("Super Mario");

        homeTheater.listenToMusic();

        homeTheater.setVolume(8);
    }
}
