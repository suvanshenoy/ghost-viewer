export namespace GhostViewerCli {
	type Commands = "search";

	type SearchCommandMethods = {
		searchByUrl: (url: string) => string;
	};

	type CommandMethods = SearchCommandMethods;

	export type CliCommand<
		C extends Commands = Commands,
		CM extends CommandMethods = CommandMethods,
	> = C extends Commands
		? {
				[C in Commands]: CM;
			}
		: never;

	export const cliCommand = {} as CliCommand;

	cliCommand.search = {
		searchByUrl: (url: string) => url,
	};
}
