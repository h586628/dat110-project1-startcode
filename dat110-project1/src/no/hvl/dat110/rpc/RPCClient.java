package no.hvl.dat110.rpc;

import java.io.IOException;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;

	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server, port);
	}

	public void register(RPCStub remote) {
		remote.register(this);
	}

	public void connect() {
		try {
			connection = msgclient.connect();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void disconnect() {

		connection.close();
	}

	public byte[] call(byte[] rpcrequest) {
		byte[] rpcreply;

		Message reqMessage = new Message(rpcrequest);
		Message respMessage;
		connection.send(reqMessage);

		respMessage = connection.receive();

		rpcreply = respMessage.getData();

		return rpcreply;

	}

}
