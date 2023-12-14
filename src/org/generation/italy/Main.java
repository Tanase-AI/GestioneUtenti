package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static gestoreUtenti gestoreUtenti = new gestoreUtenti();

	public static void main(String[] args) {

		User user1 = new User("user1", "password123", "Mario", "Rossi", "01-01-2023", "1234567890");

		gestoreUtenti.aggiungiUtente(user1);

		creazioneUtente();
		// login
		while (true) {

			System.out.println("Inserisci username:");
			String username = scanner.nextLine();

			System.out.println("Inserisci password:");
			String password = scanner.nextLine();

			if (gestoreUtenti.loginUtente(username, password)) {
				Account account = gestoreUtenti.cercaAccount(username);
				if (account instanceof Administrator) {
					// qui fa admin cose
				} else if (account instanceof User) {
					// qui fa user cose
				}
				break;

			} else {
				System.out.println("Password o/e username errato/i");
			}

		}

		scanner.close();
	}

	public static void creazioneUtente() {
		while (true) {
			System.out.println("Login/Sign up");
			String risposta = scanner.nextLine();

			if (risposta.equalsIgnoreCase("sign up")) {

				boolean usernameValido = false;
				String username = "";

				while (!usernameValido) {
					System.out.println("Inserisci username:");
					username = scanner.nextLine();

					// Verifica se l'username è già stato utilizzato
					usernameValido = true;
					for (Account account : gestoreUtenti.getElencoAccount()) {
						if (account.getUsername().equals(username)) {
							usernameValido = false;
							System.out.println("Username già in uso. Scegli un altro username.");
							break;
						}
					}
				}

				System.out.println("Inserisci password:");
				String password = scanner.nextLine();

				System.out.println("Inserisci nome:");
				String nome = scanner.nextLine();

				System.out.println("Inserisci cognome:");
				String cognome = scanner.nextLine();

				LocalDate dataOdierna = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String dataRegistrazione = dataOdierna.format(formatter);

				System.out.println("Inserisci numero di telefono:");
				String nrTelefono = scanner.nextLine();

				User newUser = new User(username, password, nome, cognome, dataRegistrazione, nrTelefono);
				gestoreUtenti.aggiungiUtente(newUser);

			} else if (risposta.equalsIgnoreCase("login")) {
				break;
			} else {
				System.out.println("Errore scelta sbagliata");
			}
		}
	}

	String provaVecchiapassword = null;
	while (true) {
		  System.out.print("Inserisci la vecchia password: "); 
		  provaVecchiaPassword =scanner.nextLine();
		  
		  if (provaVecchiaPassword.equals(Account.getPassword()))  
			  break;  
		  else {
			  System.out.println("La vecchia password inserita non è corretta. Riprova.");
		  }
		  } 
		  
		 while (true) { 
			System.out.print("Inserisci la nuova password: "); 
		 	String nuovaPassword = scanner.nextLine();
		  
		  if (nuovaPassword.equals(provaVecchiaPassword)) {
			  System.out.println("La nuova password non può essere uguale alla vecchia");
			  continue; }
		  
		  System.out.print("Conferma la nuova password: "); 
		  String confermaNuovaPassword = scanner.nextLine();
		  
		  if (!nuovaPassword.equals(confermaNuovaPassword)) {
		  System.out.println("password non uguali"); 
		  continue; 
		  }
		  
		 Account.cambiaPassword(provaVecchiaPassword, nuovaPassword, confermaNuovaPassword); 
		  break; 
		  }
		 }
}