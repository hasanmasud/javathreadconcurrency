package com.hcl.ingbootcamp.javatc.executorfm;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

class LifecycleWebServer {

	private final ExecutorService exec = null;

	private static class ServerSocket {
		public ServerSocket(int port) {
		}

		public Socket accept() {
			return null;
		}
	}

	private static class Request {

	}

	public void start() throws IOException {
		ServerSocket socket = new ServerSocket(80);
		while (!exec.isShutdown()) {
			try {
				final Socket conn = socket.accept();
				exec.execute(new Runnable() {
					public void run() {
						handleRequest(conn);
					}
				});
			} catch (RejectedExecutionException e) {
				if (!exec.isShutdown())
					System.err.println("task submission rejected");
			}
		}
	}

	public void stop() {
		exec.shutdown();
	}

	void handleRequest(Socket connection) {
		Request req = readRequest(connection);
		if (isShutdownRequest(req))
			stop();
		else
			dispatchRequest(req);
	}

	private boolean isShutdownRequest(Request req) {
		// TODO Auto-generated method stub
		return false;
	}

	private Request readRequest(Socket connection) {
		// TODO Auto-generated method stub
		return null;
	}

	private void dispatchRequest(Request req) {
		// TODO Auto-generated method stub

	}
}
