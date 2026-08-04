import argv
import ghost_viewer_cli
import gleam/io

pub fn main() -> Nil {
  case argv.load().arguments {
    [command] | [command, "-h"] | [command, "--help"] ->
      case command {
        "search" ->
          ghost_viewer_cli.print_usage(ghost_viewer_cli.SearchCommandUsage)
        _ -> io.println("error: " <> command <> "command not implemented")
      }
    ["search", url] -> ghost_viewer_cli.search_command(url)
    _ -> ghost_viewer_cli.print_usage(ghost_viewer_cli.HelpCommandUsage)
  }
}
