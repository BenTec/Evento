package br.com.startup.fucapi.mb;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.service.CongressoService;
import br.com.startup.fucapi.util.Util;


@ManagedBean
@ViewScoped
public class ResumoCalendarMB {


	private ScheduleEvent event = new DefaultScheduleEvent();
	private ScheduleModel eventModel;
	private CongressoService service;
	private Congresso congresso;
	private List<Congresso> lista;
	private Date hoje;

	@PostConstruct
	public void inicializar(){
		service		 = new CongressoService();
		lista		 = service.listarCongresso(Util.pegarUsuarioSessao());
		eventModel   = new DefaultScheduleModel();
		for (Congresso congresso : lista) {
			eventModel.addEvent(new DefaultScheduleEvent(congresso.getTitulo(), 
					configHoraInicial(congresso), configHoraFinal(congresso)));

		}

	}

	
	@SuppressWarnings("deprecation")
	public Date configHoraInicial(Congresso congresso) {

		Calendar t =  Calendar.getInstance();
		t.setTime(congresso.getDataInicio());
		Date date = congresso.getHoraInicio();

		int tipo = tipoHora(date.getHours());

		t.set(Calendar.AM_PM,  tipo == 'T'?Calendar.PM: Calendar.AM );
		t.set(Calendar.DATE,   t.get(Calendar.DATE)  ); 
		t.set(Calendar.HOUR,   date.getHours() );
		t.set(Calendar.MINUTE, date.getMinutes());

		System.out.println(t.getTime());
		return t.getTime();
	}

	@SuppressWarnings("deprecation")
	public Date configHoraFinal(Congresso congresso) {

		Calendar t =  Calendar.getInstance();
		t.setTime(congresso.getDataFim());
		
		Date date = congresso.getHoraFim();

		int tipo = tipoHora(date.getHours());
		t.set(Calendar.AM_PM,  tipo == 'T'?Calendar.PM: Calendar.AM );
		t.set(Calendar.DATE,   t.get(Calendar.DATE)); 
		t.set(Calendar.HOUR,   date.getHours());
		t.set(Calendar.MINUTE, date.getMinutes());     
		return t.getTime();

	}

	private int tipoHora(int hora){
		if (hora >= 12 && hora <= 23){
			return  -1;
		}else{
			return  +1;
		}
	}


	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}



	public Date getHoje() {
		return hoje;
	}

	public List<Congresso> getLista() {
		return lista;
	}

	public Congresso getCongresso() {
		return congresso;
	}

	public void setCongresso(Congresso congresso) {
		this.congresso = congresso;
	}


	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

}
