package org.generation.italy;

class Account {
    private static String username;
    private static String password;
    private String nome;
    private String cognome;

    public Account(String username, String password, String nome, String cognome) {

        this.nome = nome;
        this.cognome = cognome;
    }

    public static void cambiaPassword(String vecchiaPassword, String nuovaPassword, String confermaNuovaPassword) {    
        password = nuovaPassword;
        System.out.println("Password cambiata con successo per l'utente " + username);
    }
	       
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

	public static String getPassword() {
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