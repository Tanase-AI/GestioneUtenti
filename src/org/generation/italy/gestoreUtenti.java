package org.generation.italy;

import java.util.ArrayList;
import java.util.List;

class gestoreUtenti {
    private List<Account> elencoAccount;

	public gestoreUtenti() {
        this.elencoAccount = new ArrayList<>();
    }

    public void aggiungiUtente(Account account) {
        elencoAccount.add(account);
        System.out.println("Utente aggiunto con successo: " + account.getUsername());
    }

    public void rimuoviUtente(String userName) {
        for (Account account : elencoAccount) {
            if (account.getUsername().equals(userName)) {
                elencoAccount.remove(account);
                System.out.println("Utente rimosso con successo: " + userName);
                return;
            }
        }
        System.out.println("Utente non trovato: " + userName);
    }

    public boolean loginUtente(String userName, String password) {
        for (Account account : elencoAccount) {
            if (account.getUsername().equals(userName) && account.getPassword().equals(password)) {
                System.out.println("Login effettuato con successo per: " + userName);
                return true;
            }
        }
        System.out.println("Credenziali non valide per l'utente: " + userName);
        return false;
    }
    
    public List<Account> getElencoAccount() {
		return elencoAccount;
	}

	public void setElencoAccount(List<Account> elencoAccount) {
		this.elencoAccount = elencoAccount;
	}

    
}