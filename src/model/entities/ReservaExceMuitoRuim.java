package model.entities;

import java.beans.SimpleBeanInfo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReservaExceMuitoRuim {

	Calendar calendario = Calendar.getInstance();
	Calendar calendario1 = Calendar.getInstance();
	
	private Integer numberQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ReservaExceMuitoRuim() {

	}

	public ReservaExceMuitoRuim(Integer numberQuarto, Date checkIn, Date checkOut) {
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

	public int duracaoDias() {
		this.calendario.setTime(checkIn);
		this.calendario1.setTime(checkOut);
		int duracao = (calendario1.get(calendario1.DAY_OF_MONTH)) - (calendario.get(calendario.DAY_OF_MONTH));
		return duracao;

	}

	public void updateDates(Date checkIn, Date checkOut) {
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
