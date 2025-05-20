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

/**
 * Dedicated to construct {@link SyntaxContext} objects used by internals.
 *
 * @param <S> The command source type (either {@link io.papermc.paper.command.brigadier.CommandSourceStack} for Paper commands, or {@link net.minecraft.commands.CommandSourceStack} for native Minecraft commands).
 */
final class DirectSyntaxContext<S> extends InternalSyntaxContext<S> {

	private DirectSyntaxContext(final ViaSyntaxPatch plugin, final Player player, final RootCommandNode<S> rootNode, final CommandNode<S> headNode, final CommandNode<S> parentNode) {

		super(plugin, player, rootNode, headNode, parentNode);
	}

	/**
	 * Constructs a {@link SyntaxContext} object to be used by internals.
	 *
	 * @param plugin A plugin instance.
	 * @param player A player.
	 * @param root Brigadier's root command node.
	 * @param head The head node of a command.
	 * @param parent A parent node.
	 * @return A {@link SyntaxContext} instance constructed with the provided arguments.
	 * @param <S> The command source type (either {@link io.papermc.paper.command.brigadier.CommandSourceStack} for Paper commands, or {@link net.minecraft.commands.CommandSourceStack} for native Minecraft commands).
	 */
	static <S> SyntaxContext<S> createNewContext(final ViaSyntaxPatch plugin, final Player player, final RootCommandNode<S> root, final CommandNode<S> head, final CommandNode<S> parent) {

		return new DirectSyntaxContext<>(plugin, player, root, head, parent);
	}

	/**
	 * Constructs a new {@link SyntaxContext} object from an old one with a new parent node to be used by internals.
	 *
	 * @param ctx Old {@link SyntaxContext} instance used to construct a new one.
	 * @param newParent New parent node to be set in a new {@link SyntaxContext}.
	 * @return A new {@link SyntaxContext} instance constructed from an old one but with a new parent node.
	 * @param <S> The command source type (either {@link io.papermc.paper.command.brigadier.CommandSourceStack} for Paper commands, or {@link net.minecraft.commands.CommandSourceStack} for native Minecraft commands).
	 */
	static <S> SyntaxContext<S> createNewContext(final SyntaxContext<S> ctx, final CommandNode<S> newParent) {

		return createNewContext(ctx.getPlugin(), ctx.getPlayer(), ctx.getRootNode(), ctx.getHeadNode(), newParent);
	}
}
