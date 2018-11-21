package com.homework.docks;

public class Dock {
	private int cargoSpace = 15;
	private boolean free = true;
	private int dockname;
	private Ship ship;
	
	public Dock(int cargoSpace, boolean free) {
		super();
		this.cargoSpace = cargoSpace;
		this.free = free;
	}
	
	public Dock() {
		super();
	}

	public int getDockname() {
		return dockname;
	}

	public void setDockname(int dockname) {
		this.dockname = dockname;
	}

	public int getCargoSpace() {
		return cargoSpace;
	}
	public void setCargoSpace(int cargoSpace) {
		this.cargoSpace = cargoSpace;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public synchronized void shipCargoLeft(Ship ship) {
		System.out.println(ship + " cargo left-" + ship.getCargo());
				for (;!isFree() && ship.getCargo() > 0;) {
					
					try {
						wait();
					} catch (InterruptedException e) {
						
					}
				}
			if (isFree()) {
				dockBusy(true, ship);
			}
		notifyAll();
	}
	public synchronized void dockStatus(Ship ship) {
		for (;!isFree();) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		notifyAll();
	}
	public boolean dockBusy (boolean free, Ship ship) {
		setFree(false);	
	if (cargoSpace == 0) {return false;}
	else {
		ship.setDocked(true);
		int cargo = ship.getCargo();
		while (ship.getCargo() > 0 && cargoSpace > 0) {
			setFree(false);
			cargo--;
			ship.setCargo(cargo);
			System.out.println("Dock-" + getDockname() + " " + ship + " take 1" + " left " + ship.getCargo());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (cargoSpace > 0) {
				cargoSpace--;
				System.out.println(cargoSpace);
			};
		}
		setFree(true);
		ship.setDocked(false);
			if (ship.getCargo() > 0 && cargoSpace <= 0) {
				shipCargoLeft(ship);
			}	
		return isFree();
		}
	}
}
