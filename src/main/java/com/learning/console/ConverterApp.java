package com.learning.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learning.measurement.ConverMeasurement;

public class ConverterApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***************************************");
		System.out.println("* Bienvenido Al conversor de medidadas *");
		System.out.println("***************************************");
		System.out.println("ingrese su valor en metros");
		try {
		double meter = scanner.nextDouble();
		System.out.println("selecione una opcion");
		System.out.printf("%n %s %n %s %n %s %n %s %n %s %n %s %n %s","1-Centimetros",
				"2-Milimetros", "3-Pies","4-Pulgadas","5-Yardas"
				,"6-Años Luz","7-Angstroms");
		int selecion = scanner.nextInt();
		scanner.close();
		calculateConversion(meter, selecion);
		}catch (InputMismatchException | NumberFormatException e) {
			System.out.println("solo se permiten numeros");
			System.exit(0);
		}
	}

	public static void calculateConversion(double meters, int unitOfMeasurement) throws NumberFormatException {
		ConverMeasurement convermeasurement = new ConverMeasurement();
		
		switch (unitOfMeasurement) {
		case 1:
			System.out.println(convermeasurement.toCentimeter(meters) + " cms");
			break;
		case 2:
			System.out.println(convermeasurement.toMillimeter(meters) + " mm");
			break;

		case 3:
			System.out.println(convermeasurement.toFoot(meters) + " ft");
			break;
		case 4:
			System.out.println(convermeasurement.toInches(meters) + " inch");
			break;
		case 5:
			System.out.println(convermeasurement.toYard(meters) + " yd");

			break;
		case 6:

			System.out.println(convermeasurement.toligthYear(meters) + "  X  " + "10e-16  ly");
			break;
		case 7:
			System.out.println(convermeasurement.toAngstrom(meters) + " X " + "10e10  A°");

			break;
			default:System.out.println("opcion no valida");

		}
	}

}
