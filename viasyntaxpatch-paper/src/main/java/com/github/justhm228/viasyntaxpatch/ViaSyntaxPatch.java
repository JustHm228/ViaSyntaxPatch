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

package com.github.justhm228.viasyntaxpatch;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.justhm228.viasyntaxpatch.internal.SyntaxContextFactory;
import com.github.justhm228.viasyntaxpatch.internal.CommandContextFactory;
import com.github.justhm228.viasyntaxpatch.command.InternalSyntaxContextFactory;
import com.github.justhm228.viasyntaxpatch.command.InternalCommandContextFactory;

public final class ViaSyntaxPatch extends JavaPlugin {

    private SyntaxContextFactory syntaxContextFactory;

    private CommandContextFactory<?> commandContextFactory;

    public ViaSyntaxPatch() {

        super();
    }

    public CommandContextFactory<?> getCommandContextFactory() {

        return commandContextFactory;
    }

    public SyntaxContextFactory getSyntaxContextFactory() {

        return syntaxContextFactory;
    }

    @Override()
    public void onLoad() {

        super.onLoad();
    }

    @Override()
    public void onEnable() {

        super.onEnable();
        syntaxContextFactory = new InternalSyntaxContextFactory(this);
        commandContextFactory = new InternalCommandContextFactory(this);
    }

    @Override()
    public void onDisable() {

        super.onDisable();
        syntaxContextFactory = null;
        commandContextFactory = null;
    }
}
