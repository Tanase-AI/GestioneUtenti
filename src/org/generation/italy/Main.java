package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String provaVecchiaPassword = null;
	static Scanner scanner = new Scanner(System.in);
	static gestoreUtenti gestoreUtenti = new gestoreUtenti();

	public static void main(String[] args) {

		User user1 = new User("user1", "111", "Claudio", "Di Base", "11-09-2001", "5156008153");
		Administrator user2 = new Administrator("user2", "123", "Enzo", "Colluto", 101);
		gestoreUtenti.aggiungiUtente(user1);
		gestoreUtenti.aggiungiUtente(user2);

		while (true) {
			System.out.println("Login/Sign up");
			String risposta = scanner.nextLine();

			if (risposta.equalsIgnoreCase("sign up")) {
				registrazioneNuovoUtente();
			} else if (risposta.equalsIgnoreCase("login")) {
				loginUtente();
			} else {
				System.out.println("Scelta non valida.");
			}
		}
	}

	public static void registrazioneNuovoUtente() {
		System.out.println("Inserisci username:");
		String username = scanner.nextLine();

		System.out.println("Inserisci password:");
		String password = scanner.nextLine();

		System.out.println("Inserisci nome:");
		String nome = scanner.nextLine();

		System.out.println("Inserisci cognome:");
		String cognome = scanner.nextLine();

		System.out.println("Inseriesci nrTelefono");
		String nrTelefono = scanner.nextLine();

		User newUser = new User(username, password, nome, cognome, getCurrentDate(), nrTelefono);
		gestoreUtenti.aggiungiUtente(newUser);

		System.out.println("Nuovo utente registrato con successo!");
	}

	public static void loginUtente() {
	    System.out.println("Inserisci username:");
	    String username = scanner.nextLine();

	    System.out.println("Inserisci password:");
	    String password = scanner.nextLine();

	    Account account = gestoreUtenti.cercaAccount(username);
	    if (account != null && password.equals(account.getPassword())) {
	        if (account instanceof Administrator) {
	            System.out.println("Benvenuto, amministratore " + account.getUsername());
	            gestisciOperazioniAdministrator((Administrator) account);
	        } else if (account instanceof User) {
	            System.out.println("Ciao, User " + account.getUsername());
	            gestisciOperazioniUtente((User) account);
	        }
	    } else {
	        System.out.println("Credenziali non valide. Riprova.");
	    }
	}

	public static void gestisciOperazioniUtente(User user) {
		while (true) {
			System.out.println("Cosa desideri fare?");
			System.out.println("1. Cambia password");
			System.out.println("2. Esci");

			String scelta = scanner.nextLine();
			switch (scelta) {
			case "1":
				cambiapassword(user.getUsername());
				break;
			case "2":
				return;
			default:
				System.out.println("Scelta non valida.");
			}
		}
	}

	public static void gestisciOperazioniAdministrator(Administrator admin) {
		while (true) {
			System.out.println("Cosa desideri fare?");
			System.out.println("1. Cambia password ad un utente");
			System.out.println("2. Mostra elenco Account");
			System.out.println("3. Esci");

			String scelta = scanner.nextLine();
			switch (scelta) {
			case "1":
				cambiaPasswordUtente();
				break;
			case "2":
				List<Account> accounts = gestoreUtenti.getElencoAccount();
				for (Account account : accounts) {
					System.out.println(account.getUsername());
				}
				break;
			case "3":
				return;
			default:
				System.out.println("Scelta non valida.");
			}
		}
	}

	public static String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		return currentDate.format(formatter);
	}

	public static void cambiapassword(String username) {
	    while (true) {
	        System.out.print("Inserisci la vecchia password: ");
	        provaVecchiaPassword = scanner.nextLine();

	        Account account = gestoreUtenti.cercaAccount(username);
	        if (account != null && provaVecchiaPassword.equals(account.getPassword())) {
	            break;
	        } else {
	            System.out.println("La vecchia password inserita non è corretta. Riprova.");
	        }
	    }

	    while (true) {
	        System.out.print("Inserisci la nuova password: ");
	        String nuovaPassword = scanner.nextLine();

	        if (nuovaPassword.equals(provaVecchiaPassword)) {
	            System.out.println("La nuova password non può essere uguale alla vecchia");
	            continue;
	        }

	        System.out.print("Conferma la nuova password: ");
	        String confermaNuovaPassword = scanner.nextLine();

	        if (!nuovaPassword.equals(confermaNuovaPassword)) {
	            System.out.println("password non uguali");
	            continue;
	        }
	        Account account = gestoreUtenti.cercaAccount(username);
	        account.cambiaPassword(provaVecchiaPassword, nuovaPassword, confermaNuovaPassword);
	        break;
	    }
	}

	public static void cambiaPasswordUtente() {
		System.out.println("Inserisci l'username dell'utente a cui cambiare la password:");
		String username = scanner.nextLine();

		if (gestoreUtenti.cercaAccount(username) != null) {
			System.out.println("Inserisci la nuova password:");
			String nuovaPassword = scanner.nextLine();

			System.out.println("Confermi di cambiare la password per l'utente " + username + " con la nuova password '"
					+ nuovaPassword + "'? (Si/No)");
			String conferma = scanner.nextLine();

			if (conferma.equalsIgnoreCase("si")) {
				gestoreUtenti.cambiaPasswordUtente(username, nuovaPassword);				
			} else {
				System.out.println("Operazione annullata.");
			}
		} else {
			System.out.println("Utente non trovato: " + username);
		}
	}

}