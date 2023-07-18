package com.codeclub;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

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

        if (items.length == 1) {
        String item1 = items[0];

        System.out.printf("You are bringing %s\n", item1);

        } else {

            if (sort) {
                Arrays.sort(items);
            }

            String lastItem = items[items.length - 1];
            StringBuilder concat = new StringBuilder(items[0]);
            for (int i = 1; i < items.length - 1; i++) {
                concat.append(", ").append(items[i]);
            }

            System.out.printf("You are bringing %s and %s\n", concat, lastItem);
        }

    }
}
