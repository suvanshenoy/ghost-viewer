import process from "node:process";
import { GhostViewerCli } from "./ghost-viewer-cli.mts";

const cliArgs = process.argv.slice(2);

if (!cliArgs.length || cliArgs.includes("--help") || cliArgs.includes("-h")) {
	console.log("Usage: ghost-viewer [options] <command>");
	console.log();
	console.log("Commands:");
	console.log("  search");
	console.log();
	console.log("Options:");
	console.log("  -h, --help");
	process.exit(0);
}

if (cliArgs.includes("search") && cliArgs.includes("--url")) {
	const url = cliArgs.slice(2).join("");
	const res = GhostViewerCli.cliCommand.search.searchByUrl(url);
	console.log(res);
} else {
	console.error("wrong command or options passed");
	process.exit(0);
}
