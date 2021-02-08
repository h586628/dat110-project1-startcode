package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;

	public int read() {

		int temp;
		byte[] rpcReq = RPCUtils.marshallVoid(RPCID);
		byte[] rpcResp = rpcclient.call(rpcReq);
		temp = RPCUtils.unmarshallInteger(rpcResp);

		return temp;
	}

}
