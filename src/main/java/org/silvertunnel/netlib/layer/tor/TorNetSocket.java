/*
 * silvertunnel.org Netlib - Java library to easily access anonymity networks
 * Copyright (c) 2009-2012 silvertunnel.org
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see <http://www.gnu.org/licenses/>.
 */

package org.silvertunnel.netlib.layer.tor;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.silvertunnel.netlib.api.NetSocket;
import org.silvertunnel.netlib.layer.tor.stream.TCPStream;

/**
 * NetSocket of Layer over Tor network.
 *  
 * @author hapke
 */
public class TorNetSocket implements NetSocket {
    private TCPStream tcpStream;
    private String socketInfoMsg;
    
    
    public TorNetSocket(TCPStream tcpStream, String socketInfoMsg) {
        this.tcpStream = tcpStream;
        this.socketInfoMsg = socketInfoMsg;
    }
    
    public void close() throws IOException {
        tcpStream.close();
    }

    public InputStream getInputStream() throws IOException {
        return tcpStream.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return tcpStream.getOutputStream();
    }
    
    @Override
    public String toString() {
        return "ControlNetSocket("+socketInfoMsg+")";
    }
}
