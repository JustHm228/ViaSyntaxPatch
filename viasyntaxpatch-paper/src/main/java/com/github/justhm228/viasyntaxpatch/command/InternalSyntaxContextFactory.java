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

import com.destroystokyo.paper.event.brigadier.AsyncPlayerSendCommandsEvent;
import com.github.justhm228.viasyntaxpatch.internal.SyntaxContextFactory;
import com.github.justhm228.viasyntaxpatch.ViaSyntaxPatch;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.entity.Player;

public final class InternalSyntaxContextFactory implements SyntaxContextFactory {

	private final ViaSyntaxPatch plugin;

	public InternalSyntaxContextFactory(final ViaSyntaxPatch plugin) throws IllegalStateException {

		super();

		if (plugin.getSyntaxContextFactory() != null) {

			throw new IllegalStateException("ViaSyntaxPatch already has its own SyntaxContextFactory");
		}

		this.plugin = plugin;
	}

	@Override()
	@SuppressWarnings("UnstableApiUsage")
	public SyntaxContext<CommandSourceStack> create(final String name, final AsyncPlayerSendCommandsEvent<CommandSourceStack> e) {

		final Player player = e.getPlayer();

		final RootCommandNode<CommandSourceStack> root = e.getCommandNode();

		final CommandNode<CommandSourceStack> head = root.getChild(name);

		return new InternalSyntaxContext<>(plugin, player, root, head, head);
	}
}
