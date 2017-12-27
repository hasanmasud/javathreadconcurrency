package com.hcl.ingbootcamp.javatc.simpleserver;

import java.net.Socket;

public interface ConnectionHanlder {
	boolean handleConnection(Socket client);

}
