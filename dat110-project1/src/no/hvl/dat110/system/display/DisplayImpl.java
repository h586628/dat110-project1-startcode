package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	public byte[] invoke(byte[] request) {

		byte[] reply;
		byte rpcid;

		String temp = RPCUtils.unmarshallString(request);

		write(temp);

		rpcid = request[0];

		reply = RPCUtils.marshallVoid(rpcid);

		return reply;
	}
}
