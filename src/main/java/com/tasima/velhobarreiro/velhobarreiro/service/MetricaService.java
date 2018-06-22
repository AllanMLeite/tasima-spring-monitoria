package com.tasima.velhobarreiro.velhobarreiro.service;

import javax.annotation.Resource;

import com.tasima.velhobarreiro.velhobarreiro.model.Metrica;
import com.tasima.velhobarreiro.velhobarreiro.repository.MetricaRepository;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;

@Service
public class MetricaService {

    @Resource
    private MetricaRepository metricaRepository;

    public Metrica salvarMetrica(String nome){
        validarInclusao(nome);
        return metricaRepository.incluir(new Metrica(nome));
    }

    private void validarInclusao(String nome) {
        validaObrigatoriedadeNome(nome);
    }

    private void validaObrigatoriedadeNome(String nome){
        if(StringUtils.isEmpty(nome))
            throw new RestClientException("Informe o nome");
    }

    public void setMetricaRepository(MetricaRepository metricaRepository){
        this.metricaRepository = metricaRepository;
    }
}