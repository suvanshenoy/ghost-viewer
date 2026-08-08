import argv
import ghost_viewer_cli

pub fn main() -> Nil {
  case argv.load().arguments {
    [command] | [command, "-h"] | [command, "--help"] ->
      case command {
        "search" ->
          ghost_viewer_cli.print_usage(ghost_viewer_cli.SearchCommandUsage)
        _ -> ghost_viewer_cli.print_usage(ghost_viewer_cli.HelpCommandUsage)
      }
    ["search", url] -> ghost_viewer_cli.search_command(url)
    _ -> ghost_viewer_cli.print_usage(ghost_viewer_cli.HelpCommandUsage)
  }
}
