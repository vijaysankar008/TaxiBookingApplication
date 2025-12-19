package app.online.ola;

public class Booking {

	int bookingId, customerId;
	double pickupTime, dropTime, bookingAmount;
	char pickupPoint, dropPoint;

	public Booking(int bookingId, int customerId, double pickupTime, double dropTime, double bookingAmount,
			char pickupPoint, char dropPoint) {
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.bookingAmount = bookingAmount;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(double pickupTime) {
		this.pickupTime = pickupTime;
	}

	public double getDropTime() {
		return dropTime;
	}

	public void setDropTime(double dropTime) {
		this.dropTime = dropTime;
	}

	public double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public char getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public char getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}

}
