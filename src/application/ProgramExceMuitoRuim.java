package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class ProgramExceMuitoRuim {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero do quarto");
		int number = sc.nextInt();

		System.out.println("Digite a data do check-In  (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Digite a data do check-Out  (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro in reservation: check-out date must be after check-in date");

		} else {

			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva: ");
			System.out.println(reserva.toString());
			System.out.println();
			System.out.println("Entre com as novas datas ");
			
			System.out.println("Digite o numero do quarto");
			number = sc.nextInt();
			System.out.println("Digite a data do check-In  (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Digite a data do check-Out  (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			
			Date date = new Date();
			if (checkIn.before(date) || checkOut.before(date)) {
				System.out.println("Erro: As datas tem que ser futuras.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro in reservation: check-out date must be after check-in date");
			} else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reserva: ");
				System.out.println(reserva.toString());
			}

		}

	}
}
