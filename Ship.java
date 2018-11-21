package com.homework.docks;


public class Ship implements Runnable {
	private int cargo;
	private Port port;
	private boolean docked = false;

	public Ship(int cargo, Port port) {
		super();
		this.cargo = cargo;
		this.port = port;
		
	}

	public Ship() {
		super();
	}

	public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	

	private Port getPort() {
		return port;
	}

	@Override
	public void run() {
		getPort().getCargo(this);
	}

}
