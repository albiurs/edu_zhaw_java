package com.publicept.edujava.getraenkeautomatloesung;

public class Automat {
	private Fach fach1;
	public Automat() { fach1 = new Fach(100);
	}
	public Getraenk kaufeGetraenkFach1() { return fach1.getGetraenk();
	}
	/**
	 * Fuellt das Fach 1 mit Getraenken.
	 * @param nameGetraenk der Name des Getraenks */
	public void fuelleFach1(String nameGetraenk) { while(!fach1.istFachVoll()) {
		fach1.addGetraenk(new Getraenk(nameGetraenk)); }
	} 
}
