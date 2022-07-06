package br.edu.ifba.inf011.observer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public interface Observer {
	public String dateNow();
	public void update(boolean status);
}
