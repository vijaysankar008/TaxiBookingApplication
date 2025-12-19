package app.online.ola;

import java.util.List;

public class Taxi {
	private int id;
	private char intialPoint = 'A';
	private double totalEarnings;
	private List<Booking> bookingList;

	public Taxi(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getIntialPoint() {
		return intialPoint;
	}

	public void setIntialPoint(char intialPoint) {
		this.intialPoint = intialPoint;
	}

	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

}
