import java.util.Scanner;

public class Q3B_music {
    public static void main(String[] args) {
        MusicPlayer mp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the music player type (local or online):");
        String musicPlayerType = sc.nextLine();

        if (musicPlayerType.equalsIgnoreCase("local")) {
            MusicSource localFileSource = new LocalFileMusicSource();
            mp = new ConcreteMusicPlayer(localFileSource);
        } else if (musicPlayerType.equalsIgnoreCase("online")) {
            MusicSource onlineStreamingSource = new OnlineStreamingMusicSource();
            mp = new ConcreteMusicPlayer(onlineStreamingSource);
        } else {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }

        String str = "hi";
        while (!str.equalsIgnoreCase("exit")) {
            System.out.println("To play press p, to stop press s, to set volume press v and level, press exit to exit player.");
            str = sc.nextLine();
            if (str.equalsIgnoreCase("p")) {
                mp.play();
            } else if (str.equalsIgnoreCase("v")) {
                int level = sc.nextInt();
                sc.nextLine(); // consume newline
                mp.setVolume(level);
            } else {
                mp.stop();
            }
        }
        sc.close();
    }
}
// Abstraction
interface MusicPlayer {
    void play();
    void stop();
    void setVolume(int level);  // Added method for volume control
}
// Implementor
interface MusicSource {
    void play();
    void stop();
}
// Concrete Implementor for Local Files
class LocalFileMusicSource implements MusicSource {
    @Override
    public void play() {
        System.out.println("Playing music from local file...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping music from local file...");
    }
}

// Concrete Implementor for Online Streaming
class OnlineStreamingMusicSource implements MusicSource {
    @Override
    public void play() {
        System.out.println("Playing online streaming music...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping online streaming music...");
    }
}
// Refined Abstraction and decorator
abstract class AbstractMusicPlayer implements MusicPlayer {
    protected MusicSource musicSource;

    public AbstractMusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }
}
//conceretAbstraction and conceret decerator
class ConcreteMusicPlayer extends AbstractMusicPlayer {
    public ConcreteMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void play() {
        musicSource.play();
    }

    @Override
    public void stop() {
        musicSource.stop();
    }

 
    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }
}
