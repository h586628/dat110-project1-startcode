package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return
	// values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the
	// RPC message syntax [rpcid,parameter/return value]

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		ByteBuffer b = ByteBuffer.allocate(str.length() + 1);
		b.put(rpcid);
		b.put(str.getBytes());

		encoded = b.array();

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		byte[] stringValue = new byte[data.length - 1];

		for (int i = 0; i < data.length - 1; i++) {
			stringValue[i] = data[i + 1];
		}

		String decoded = new String(stringValue);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] temp = ByteBuffer.allocate(4).putInt(x).array();
		byte[] encoded = new byte[temp.length + 1];

		encoded[0] = rpcid;

		for (int i = 0; i < temp.length; i++) {
			encoded[i + 1] = temp[i];
		}

		return encoded;

	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] intValue = new byte[data.length - 1];

		for (int i = 0; i < data.length - 1; i++) {
			intValue[i] = data[i + 1];
		}

		decoded = ByteBuffer.wrap(intValue).getInt();

		return decoded;

	}
}
