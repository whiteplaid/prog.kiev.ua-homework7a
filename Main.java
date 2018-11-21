package com.homework.docks;

public class Main {

	public static void main(String[] args) {
		Ship[] ship = new Ship[3];
		Dock[] dock = new Dock[2];
		Thread[] thr = new Thread[3];
		

		for (int i = 0; i < dock.length;i++) {
			dock[i] = new Dock();
			
		}
		
		Port port = new Port(dock);
		for (int i = 0; i < thr.length;i++) {
		
			ship[i] = new Ship(10,port);
			
			thr[i] = new Thread(ship[i]);
		}
		for (int i = 0; i < thr.length; i++) {
			thr[i].start();
		}
	}

}
