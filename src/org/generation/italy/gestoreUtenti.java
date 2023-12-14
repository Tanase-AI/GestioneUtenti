package org.generation.italy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class gestoreUtenti {
    private List<Account> elencoAccount;

	public gestoreUtenti() {
        this.elencoAccount = new ArrayList<>();
    }

	public void aggiungiUtente(Account account) {
	    if (account instanceof Administrator) {
	        elencoAccount.add((Administrator)account);
	        System.out.println("Amministratore aggiunto con successo: " + account.getUsername());
	    } else if (account instanceof User) {
	        elencoAccount.add((User)account);
	        System.out.println("Utente aggiunto con successo: " + account.getUsername());
	    }
	}

    public void rimuoviUtente(String userName) {
        Iterator<Account> iterator = elencoAccount.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getUsername().equals(userName)) {
                iterator.remove();
                System.out.println("Utente rimosso con successo: " + userName);
                return;
            }
        }
        System.out.println("Utente non trovato: " + userName);
    }

    public boolean loginUtente(String userName, String password) {
        return elencoAccount.stream()
                .anyMatch(account -> account.getUsername().equals(userName) && account.getPassword().equals(password));
    }
    
    
    public Account cercaAccount(String username) {
        return elencoAccount.stream()
                .filter(account -> account.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
    
    public boolean cambiaPasswordUtente(String username, String nuovaPassword) {
        for (Account account : elencoAccount) {
            if (account.getUsername().equals(username)) {
                account.setPassword(nuovaPassword);
                System.out.println("Password cambiata con successo per l'utente " + username);
                return true;
            }
        }
        System.out.println("Utente non trovato: " + username);
        return false;
    }
    
    
    public List<Account> getElencoAccount() {
		return elencoAccount;
	}

	
	
    
}