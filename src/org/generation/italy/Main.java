package org.generation.italy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		User user1 = new User("user1", "password123", "Mario", "Rossi", "01-01-2023", "1234567890");

		gestoreUtenti gestoreUtenti = new gestoreUtenti();
		gestoreUtenti.aggiungiUtente(user1);
		
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


		scanner.close();
	}
}
	