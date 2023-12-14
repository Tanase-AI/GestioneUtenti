package org.generation.italy;

class User extends Account {
    private String dataRegistrazione;
    private String nrTelefono;

    public User(String username, String password, String nome, String cognome, String dataRegistrazione, String nrTelefono) {
        super(username, password, nome, cognome);
        this.dataRegistrazione = dataRegistrazione;
        this.nrTelefono = nrTelefono;
    }

	public String getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(String dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getNrTelefono() {
		return nrTelefono;
	}

	public void setNrTelefono(String nrTelefono) {
		this.nrTelefono = nrTelefono;
	}
}