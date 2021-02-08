package no.hvl.dat110.messaging;

import java.util.Arrays;
import java.util.Iterator;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < 128) {
			this.payload = payload; 
		} else {
			System.out.println("The payload message is to long. 127 + 1 bytes max");
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[128];

		encoded[0] = (byte) payload.length;

		for (int i = 0; i < payload.length; i++) {
			encoded[i + 1] = payload[i];
		}
		return encoded;

	}

	public void decapsulate(byte[] received) {

		int size = received[0];
		payload = new byte[size];
		for (int i = 0; i < size; i++) {
			payload[i] = received[i + 1];

		}
	}
}
