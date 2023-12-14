package org.generation.italy;

class Account {
    private String username;
    private String password;
    private String nome;
    private String cognome;

    public Account(String username, String password, String nome, String cognome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void cambiaPassword(String vecchiaPassword, String nuovaPassword, String confermaNuovaPassword) {    
        this.password = nuovaPassword;
        System.out.println("Password cambiata con successo per l'utente " + username);
    }
	/*
	 * String provaVecchiaPassword = null; while (true) {
	 * System.out.print("Inserisci la vecchia password: "); provaVecchiaPassword =
	 * scanner.nextLine();
	 * 
	 * if (provaVecchiaPassword.equals(user1.getPassword())) { break; } else {
	 * System.out.println("La vecchia password inserita non è corretta. Riprova.");
	 * } }
	 * 
	 * while (true) { System.out.print("Inserisci la nuova password: "); String
	 * nuovaPassword = scanner.nextLine();
	 * 
	 * if (nuovaPassword.equals(provaVecchiaPassword)) {
	 * System.out.println("La nuova password non può essere uguale alla vecchia");
	 * continue; }
	 * 
	 * System.out.print("Conferma la nuova password: "); String
	 * confermaNuovaPassword = scanner.nextLine();
	 * 
	 * if (!nuovaPassword.equals(confermaNuovaPassword)) {
	 * System.out.println("password non uguali"); continue; }
	 * 
	 * user1.cambiaPassword(provaVecchiaPassword, nuovaPassword,
	 * confermaNuovaPassword); break; }
	 */
       
    @Override
    public String toString() {
        return "Account{" 
        		+"username='"  + username + '\''
        		+", nome='"    + nome     + '\''
        		+", cognome='" + cognome  + '\'' +'}';
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
}