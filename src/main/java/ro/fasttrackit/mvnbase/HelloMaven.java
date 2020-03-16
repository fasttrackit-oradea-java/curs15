package ro.fasttrackit.mvnbase;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class HelloMaven {

    public static void main(String[] args) throws IOException {
        String asciiArt = FigletFont.convertOneLine("Hello Maven");
        System.out.println(asciiArt);
    }
}
