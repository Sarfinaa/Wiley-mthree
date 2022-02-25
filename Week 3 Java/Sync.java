import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Shakespeare {
    public synchronized void writeEpicStuff(String str) {
        try (FileWriter fw = new FileWriter("play.txt");) {
            for (char c : str.toCharArray()) {
                fw.write(c + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

class MyThread1 extends Thread {
    private String content;
    private Shakespeare shakespeare;

    MyThread1(String content, Shakespeare shakespeare) {
        this.content = content;
        this.shakespeare = shakespeare;
    }

    public void run() {
        shakespeare.writeEpicStuff(content);
    }
}

public class Sync {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Shakespeare shakespeare = new Shakespeare();
        MyThread1 t1 = new MyThread1("Hello there", shakespeare);
        MyThread1 t2 = new MyThread1("Hi there", shakespeare);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Scanner s = new Scanner(new File("play.txt"));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
        s.close();
    }
}
