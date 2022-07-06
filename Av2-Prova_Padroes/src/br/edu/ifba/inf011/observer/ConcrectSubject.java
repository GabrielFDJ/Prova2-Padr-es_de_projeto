package br.edu.ifba.inf011.observer;

public class ConcrectSubject extends Subject {

	private Boolean status = false;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(boolean newstatus) {
		if (newstatus != status) {			
			this.status = newstatus;			
			notifyObservers(newstatus);
		}
	}

}
