package com.codeclub;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.ArrayList;
import java.util.Arrays;


@Command(name = "Picnic", description = "A handy, dandy app for doing whatever you like")
public class Picnic
{

    @Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Option(names= {"-s", "-sorted"}, description = "Sort strings")
    boolean sort;

    @Parameters(index = "0..*", paramLabel = "items", description = "A list of items to bring")
    private String[] items;


    public static void main( String[] args )
    {
        Picnic init_app = new Picnic();

        new CommandLine(init_app).parseArgs(args);

        if (init_app.helpRequested | args.length == 0) {
            CommandLine.usage(new Picnic(), System.out);
            return;
        }
        init_app.run();
    }

    public void run() {

        StringBuilder sentence = new StringBuilder("You are bringing ");

        if (sort) {
            Arrays.sort(items);
        }

        ArrayList<String> words = new ArrayList<String>(Arrays.asList(items));

        String lastItem = words.remove(words.size() - 1);


        if (words.size() > 0) {

            sentence.append(String.join(", ", words));

            sentence.append(" and ");
        }

        sentence.append(lastItem);

        System.out.println(sentence);

    }
}
