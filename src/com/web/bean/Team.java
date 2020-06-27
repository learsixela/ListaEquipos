package com.web.bean;

import java.util.ArrayList;

public class Team {

	//atributos
	String sNombre = "";
	Integer iNumeroJugadores= 0;
	ArrayList<Player> arrayListPlayer = new ArrayList<Player>();

	public Team() {
		super();
	}
	public Team(String sNombre, Integer iNumeroJugadores) {
		super();
		this.sNombre = sNombre;
		this.iNumeroJugadores = iNumeroJugadores;
	}
	public String getsNombre() {
		return sNombre;
	}
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	public Integer getiNumeroJugadores() {
		return iNumeroJugadores;
	}
	public void setiNumeroJugadores(Integer iNumeroJugadores) {
		this.iNumeroJugadores = iNumeroJugadores;
	}
	public ArrayList<Player> getArrayListPlayer() {
		return arrayListPlayer;
	}
	public void setArrayListPlayer(ArrayList<Player> arrayListPlayer) {
		this.arrayListPlayer = arrayListPlayer;
	}
	
	@Override
	public String toString() {
		return "Team [sNombre=" + sNombre + ", iNumeroJugadores=" + iNumeroJugadores + "]";
	}
	
	public void agregarPlayer(Player player) {
		this.arrayListPlayer.add(player);
	}
	
	public void eliminarPlayer(Player player) {
		this.arrayListPlayer.remove(player);
		
	}
}
