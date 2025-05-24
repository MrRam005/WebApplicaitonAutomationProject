package utils;

import java.util.Date;

import com.github.javafaker.Faker;

public class CommonMethodsUtil {

	public static String generateNewName() {

		Faker fake = new Faker();
		String name = fake.name().fullName();
		String Name = name.replace(" ", "_");
		return Name;
	}

	public static String generateEmail() {

		String Name = generateNewName();
		String email = Name +"@gmail.com";
		return email;
	}

	public static String generateDate() {

		Date d = new Date();
		String date = d.toString().replaceAll(":", "_").replace(" ", "_");
		return date;

	}

	public static String generateEmailWithDate() {

		String Name = generateNewName();
		String date = generateDate();
		String email = Name + date +"@gmail.com";
		return email;
	}

}
