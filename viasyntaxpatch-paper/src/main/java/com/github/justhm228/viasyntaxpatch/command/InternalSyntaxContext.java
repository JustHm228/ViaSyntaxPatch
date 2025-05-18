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
 * An implementation of {@link SyntaxContext} to be constructed by {@link InternalSyntaxContextFactory}.
 *
 * @param <S> The command source type (either {@link io.papermc.paper.command.brigadier.CommandSourceStack} for Paper commands, or {@link net.minecraft.commands.CommandSourceStack} for native Minecraft commands).
 */
class InternalSyntaxContext<S> extends SyntaxContext<S> {

	/**
	 * Used by {@link InternalSyntaxContextFactory} to construct {@link InternalSyntaxContext}.
	 *
	 * @param plugin A plugin instance.
	 * @param player A player to whom your syntax transformations are sent.
	 * @param rootNode Brigadier's root command node of the player.
	 * @param headNode A head node of the transformed command.
	 * @param parentNode A parent node.
	 */
	protected InternalSyntaxContext(final ViaSyntaxPatch plugin, final Player player, final RootCommandNode<S> rootNode, final CommandNode<S> headNode, final CommandNode<S> parentNode) {

		super(plugin, player, rootNode, headNode, parentNode);
	}
}
