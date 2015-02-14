package br.com.fucapi.atividade;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.startup.fucapi.model.Atividade;
import br.com.startup.fucapi.model.Congresso;
import br.com.startup.fucapi.model.Palestrante;
import br.com.startup.fucapi.service.AtividadeService;

public class AtividadeTeste {

	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void salvar(){
		
		Atividade atividade = new Atividade();
		atividade.setTipo("Palestra");
		atividade.setNome("Big data");
		atividade.setCargaHoraria(40);
		atividade.setVagas(50);
		atividade.setDataInicio(new  Date());
		atividade.setDataFim(new  Date());
		atividade.setValor(new BigDecimal(40));
		
		Date date = new Date();
		date.setHours(19);
		date.setMinutes(20);
		
		atividade.setHoraInicio(date);
		atividade.setHoraFim(date);
		
		Palestrante palestrante = new Palestrante();
		palestrante.setId(2);
		atividade.setPalestrante(palestrante);
		
		Congresso congresso = new Congresso();
		congresso.setId(8);
		atividade.setCongresso(congresso);
		
		
		AtividadeService service = new  AtividadeService();
		service.salvarAtividade(atividade);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void editar(){
		
		Atividade atividade = new Atividade();
		atividade.setId(1);
		
		atividade.setNome("Teste Update");
		atividade.setCargaHoraria(40);
		atividade.setTipo("Palestra");
		atividade.setNome("Big data");
		atividade.setCargaHoraria(40);
		atividade.setVagas(50);
		atividade.setDataInicio(new  Date());
		atividade.setDataFim(new  Date());
		atividade.setValor(new BigDecimal(40));
		
		Date date = new Date();
		date.setHours(19);
		date.setMinutes(20);
		
		atividade.setHoraInicio(date);
		atividade.setHoraFim(date);
		
		Palestrante palestrante = new Palestrante();
		palestrante.setId(1);
		atividade.setPalestrante(palestrante);
		
		Congresso congresso = new Congresso();
		congresso.setId(8);
		atividade.setCongresso(congresso);
		atividade.setVagas(50);
		atividade.setDataInicio(new  Date());
		atividade.setDataFim(new  Date());
		atividade.setValor(new BigDecimal(40));
		
		Date dat = new Date();
		dat.setHours(19);
		dat.setMinutes(20);
		
		atividade.setHoraInicio(date);
		atividade.setHoraFim(date);
		
		Palestrante palestrant = new Palestrante();
		palestrant.setId(1);
		atividade.setPalestrante(palestrant);
		
		Congresso congress = new Congresso();
		congress.setId(8);
		atividade.setCongresso(congresso);
		
		AtividadeService service = new AtividadeService();
		service.atualizarAtividade(atividade);
	
		
	}
	
	@Test // lISTAR TRAZER JUNTO  O PALESTRANTE  E CONGRESSO >>  (NOME) OU TITULO
	public void listar(){
		
		

	}
	
	// falta
	public void excluir(){
		
	}
	
}
