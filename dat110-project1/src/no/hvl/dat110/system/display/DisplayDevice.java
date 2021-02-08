package no.hvl.dat110.system.display;

import java.io.IOException;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

public class DisplayDevice {

	public static void main(String[] args) {

		System.out.println("Display server starting ...");

		DisplayImpl display = new DisplayImpl();

		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);

		displayserver.register(1, display);

		try {
			displayserver.run();
		} catch (IOException e) {
			e.printStackTrace();
		}

		displayserver.stop();

		System.out.println("Display server stopping ...");

	}
}
