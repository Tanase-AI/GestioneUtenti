package org.generation.italy;

class Administrator extends Account {
    private int codiceBadge;

    public Administrator(String username, String password, String nome, String cognome, int codiceBadge) {
        super(username, password, nome, cognome);
        this.codiceBadge = codiceBadge;
    }

    public void resettaPassword(String username) {
    	
    }

	public int getCodiceBadge() {
		return codiceBadge;
	}

	public void setCodiceBadge(int codiceBadge) {
		this.codiceBadge = codiceBadge;
	}
    
}
