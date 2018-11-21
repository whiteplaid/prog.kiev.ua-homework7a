package com.homework.docks;


public class Port {
	private Dock[] dock;
	private Ship ship;
	private int cargo;

	public Port(Dock[] dock) {
		super();
		this.dock = dock;
		
	}

	public Port() {
		super();
	}


	public Dock[] getDock() {
		return dock;
	}

	public void setDock(Dock[] dock) {
		this.dock = dock;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public void dockTake (Dock[] dock) {
		
	}
	public void dockStatus (Ship ship, Dock[] one) {
		if (one[0].isFree() && one[1].isFree()) {
			one[0].dockBusy(true, ship);
			one[1].dockBusy(true, ship);
		} else {
			synchronized (one) {
				for (;!one[0].isFree() && !one[1].isFree();) {
					try {
						wait();
					} catch (InterruptedException e) {
			
					}
				}
				if (one[0].isFree()) {
					one[0].dockBusy(true, ship);
				}
				if (one[1].isFree()) {
					one[1].dockBusy(true, ship);
				}
			}
		}
	}


	public void getCargo (Ship ship) {
		for (int i = 0; i < dock.length;i++) {
			dock[i].setDockname(i);
		}
				dockStatus(ship,dock);
				
	}
	
}
