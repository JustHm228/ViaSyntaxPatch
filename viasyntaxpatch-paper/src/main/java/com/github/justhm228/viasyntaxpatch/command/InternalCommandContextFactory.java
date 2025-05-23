/*
 * The MIT License
 *
 * Copyright (c) 2025 Chirkunov Egor
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.justhm228.viasyntaxpatch.command;

import com.github.justhm228.viasyntaxpatch.internal.CommandContextFactory;
import com.github.justhm228.viasyntaxpatch.ViaSyntaxPatch;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.List;

@SuppressWarnings("rawtypes")
public final class InternalCommandContextFactory implements CommandContextFactory {

	private final ViaSyntaxPatch plugin;

	public InternalCommandContextFactory(final ViaSyntaxPatch plugin) throws IllegalStateException {

		super();

		if (plugin.getCommandContextFactory() != null) {

			throw new IllegalStateException("ViaSyntaxPatch already has its own CommandContextFactory");
		}

		this.plugin = plugin;
	}

	@Override()
	public CommandContext<?> create(final PlayerCommandPreprocessEvent e) {

		final String separator = CommandDispatcher.ARGUMENT_SEPARATOR;

		final Player player = e.getPlayer();

		final String line = e.getMessage().substring(1);

		final List<String> arguments = List.of(line.split(separator));

		assert !arguments.isEmpty();

		final CommandDispatcher<?> dispatcher = ((CraftServer) plugin.getServer()).getServer().getCommands().getDispatcher();

		final RootCommandNode<?> root = dispatcher.getRoot();

		final CommandNode<?> head = root.getChild(arguments.getFirst());

		@SuppressWarnings({ "unchecked", "rawtypes" })
		final CommandContext<?> context = new InternalCommandContext<>(plugin, player, root, (CommandNode) head, arguments);

		return context;
	}
}
