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

	public  String getPassword() {
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