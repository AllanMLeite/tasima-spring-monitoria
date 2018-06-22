package com.tasima.velhobarreiro.velhobarreiro.cucumber;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import com.tasima.velhobarreiro.velhobarreiro.repository.MetricaRepository;
import com.tasima.velhobarreiro.velhobarreiro.service.MetricaService;

import org.junit.Before;
import org.springframework.web.client.RestClientException;

import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaIncluirMetricaTest {

    private String mensagemErro;
    private String nome;

    private MetricaService service;

    @Before
    public void prepararCenario(){
        service = new MetricaService();
        service.setMetricaRepository(new MetricaRepository());
    }

    @Entao("^que informei o nome \"([^\"]*)\"$")
	public void que_informei_o_nome(String nome) throws Throwable {
        this.nome = nome;
    }
  
    @Quando("^incluir$")
	public void clico_em_Salvar() throws Throwable {
        try {
            service.salvarMetrica(nome);
        } catch (RestClientException e) {
            mensagemErro = e.getMessage();
        }
    }
    
    @Entao("^o sistema exibe a mensagem \"([^\"]*)\"$")
	public void o_sistema_exibe_a_mensagem(String mensagemEsperada) throws Throwable {
		assertEquals(mensagemEsperada, mensagemErro);
	}

}
