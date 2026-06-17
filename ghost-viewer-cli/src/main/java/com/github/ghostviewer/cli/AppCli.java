package com.github.ghostviewer.cli;

import com.github.ghostviewer.cli.command.AppCliCommand;
import picocli.CommandLine;

public class AppCli {
  public static void main(String[] args) {
    int exitCode = new CommandLine(new AppCliCommand()).execute(args);
    System.exit(exitCode);
  }
}
