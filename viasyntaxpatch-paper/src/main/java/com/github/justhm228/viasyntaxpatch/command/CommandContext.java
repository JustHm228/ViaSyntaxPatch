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

import com.github.justhm228.viasyntaxpatch.ViaSyntaxPatch;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import org.bukkit.entity.Player;
import java.util.List;

public abstract class CommandContext<S> {

	private final ViaSyntaxPatch plugin;

	private final Player player;

	private final RootCommandNode<S> rootNode;

	private final CommandNode<S> headNode;

	private final List<String> arguments;

	protected CommandContext(final ViaSyntaxPatch plugin, final Player player, final RootCommandNode<S> rootNode, final CommandNode<S> headNode, final List<String> arguments) {

		super();
		this.plugin = plugin;
		this.player = player;
		this.rootNode = rootNode;
		this.headNode = headNode;
		this.arguments = arguments;
	}

	public final ViaSyntaxPatch getPlugin() {

		return plugin;
	}

	public final Player getPlayer() {

		return player;
	}

	public final RootCommandNode<S> getRootNode() {

		return rootNode;
	}

	public final CommandNode<S> getHeadNode() {

		return headNode;
	}

	public final List<String> getArguments() {

		return arguments;
	}
}
