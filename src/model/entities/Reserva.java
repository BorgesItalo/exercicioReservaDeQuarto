package model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.Exception.DomainException;

public class Reserva  {

	Calendar calendario = Calendar.getInstance();
	Calendar calendario1 = Calendar.getInstance();

	private Integer numberQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva() {

	}

	public Reserva(Integer numberQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro in reservation: check-out date must be after check-in date");
		}
		this.numberQuarto = numberQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumberQuarto() {
		return numberQuarto;
	}

	public void setNumberQuarto(Integer numberQuarto) {
		this.numberQuarto = numberQuarto;
	}

	public Date getcheckIn() {
		return checkIn;
	}

	public Date getcheckOut() {
		return checkOut;
	}

	public long duracaoDias() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	

	}

	public void updateDates(Date checkIn, Date checkOut) {
		Date date = new Date();
		if (checkIn.before(date) || checkOut.before(date)) {
			throw new DomainException("Erro: As datas tem que ser futuras.");
		}if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro in reservation: check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Numero do quarto: " + numberQuarto);
		sb.append("\nData de entrada: " + sdf.format(checkIn));
		sb.append("\nData de saida: " + sdf.format(checkOut));
		sb.append("\nDuração: " + duracaoDias() + " dia de duração.");

		return sb.toString();
	}
}
