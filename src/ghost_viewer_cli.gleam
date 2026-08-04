import gleam/io

pub type CommandUsage {
  HelpCommandUsage
  SearchCommandUsage
}

pub fn search_command(url: String) -> Nil {
  io.println("searching " <> url)
}

pub fn print_usage(usage_command: CommandUsage) -> Nil {
  case usage_command {
    SearchCommandUsage -> io.println("Usage: ghost-viewer search")
    HelpCommandUsage -> io.println("Usage: ghost-viewer [options] <command>")
  }
}
