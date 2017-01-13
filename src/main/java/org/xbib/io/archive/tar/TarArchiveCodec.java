/*
 * Copyright (C) 2014 Jörg Prante
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbib.io.archive.tar;

import org.xbib.io.BytesProgressWatcher;
import org.xbib.io.archive.ArchiveCodec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TarArchiveCodec implements ArchiveCodec<TarSession, TarArchiveInputStream, TarArchiveOutputStream> {

    protected final static String NAME = "tar";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public TarSession newSession(BytesProgressWatcher watcher) {
        return new TarSession(watcher);
    }

    @Override
    public TarArchiveInputStream createArchiveInputStream(InputStream in) throws IOException {
        return new TarArchiveInputStream(in);
    }

    @Override
    public TarArchiveOutputStream createArchiveOutputStream(OutputStream out) throws IOException {
        return new TarArchiveOutputStream(out);
    }

}