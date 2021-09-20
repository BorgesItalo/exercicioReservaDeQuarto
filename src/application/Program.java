package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Exception.DomainException;
import model.entities.Reserva;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Digite o numero do quarto");
		int number = sc.nextInt();

		System.out.println("Digite a data do check-In  (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Digite a data do check-Out  (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());

		Reserva reserva = new Reserva(number, checkIn, checkOut);
		System.out.println("Reserva: ");
		System.out.println(reserva.toString());
		System.out.println();
		System.out.println("Entre com as novas datas ");

		System.out.println("Digite a data do check-In  (dd/MM/yyyy)");
		checkIn = sdf.parse(sc.next());
		System.out.println("Digite a data do check-Out  (dd/MM/yyyy)");
		checkOut = sdf.parse(sc.next());

		reserva.updateDates(checkIn, checkOut);
		System.out.println("Reserva: ");
		System.out.println(reserva.toString());
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		} catch (InputMismatchException e ) {
			System.out.println("Unexpected error! ");
		}
	}
}
