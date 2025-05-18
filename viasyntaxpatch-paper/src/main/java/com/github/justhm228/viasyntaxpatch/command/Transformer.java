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

import java.util.function.Consumer;

/**
 * Used to apply transformations to syntax of Brigadier commands.
 *
 * @param <C> Context type.
 */
@FunctionalInterface()
public interface Transformer<C> extends Consumer<C> {

	/**
	 * Applies transformations to syntax of Brigadier commands.
	 *
	 * @param ctx A context object which provides required parameters.
	 * @return If any transformation was applied.
	 */
	boolean transform(final C ctx);

	/**
	 * Delegates to {@link #transform(Object)}.
	 *
	 * @param ctx A context object which provides required parameters.
	 */
	@Override()
	default void accept(final C ctx) {

		transform(ctx);
	}
}
