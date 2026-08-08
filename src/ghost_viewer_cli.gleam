import gleam/io
import gleam/list
import gleam/string

pub type CommandUsage {
  HelpCommandUsage
  SearchCommandUsage
}

pub fn search_command(url: String) -> Nil {
  io.println("searching " <> url)
}

pub fn usage_to_string(usage_list: List(String)) -> String {
  let usage_list = {
    use usage <- list.map(usage_list)
    usage <> "\n"
  }
  string.join(usage_list, "")
}

pub fn print_usage(usage: CommandUsage) -> Nil {
  case usage {
    SearchCommandUsage -> {
      usage_to_string([
        "Usage: ghost-viewer search [options]",
        "",
      ])
      |> io.println
    }
    HelpCommandUsage -> {
      usage_to_string([
        "Usage: ghost-viewer [options] <command>",
        "",
        "Commands:",
        "  " <> "search",
      ])
      |> io.println
    }
  }
}
