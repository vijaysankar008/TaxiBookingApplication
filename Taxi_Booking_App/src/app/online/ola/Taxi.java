package app.online.ola;

import java.util.List;

public class Taxi {
	int id;
	char intialPoint = 'A';
	double totalEarnings;
	List<Booking> bookingList;

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
