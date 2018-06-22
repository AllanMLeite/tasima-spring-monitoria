package com.tasima.velhobarreiro.velhobarreiro.repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.tasima.velhobarreiro.velhobarreiro.model.Metrica;

import org.springframework.stereotype.Repository;

@Repository
public class MetricaRepository {

    private List<Metrica> metricas;
    private final AtomicLong idSequence = new AtomicLong();

    public Metrica incluir(Metrica metrica){
        metrica.setId(idSequence.incrementAndGet());
        metricas.add(metrica);
        return metrica;
    }    
}