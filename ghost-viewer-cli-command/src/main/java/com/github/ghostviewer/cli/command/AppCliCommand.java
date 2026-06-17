package com.github.ghostviewer.cli.command;

import picocli.CommandLine.Command;

@Command(name = "hello", description = "Says hello")
public class AppCliCommand implements Runnable {

  @Override
  public void run() {
    System.out.print("hello");
  }
}
