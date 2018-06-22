package com.tasima.velhobarreiro.velhobarreiro.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import com.tasima.velhobarreiro.velhobarreiro.model.Metrica;
import com.tasima.velhobarreiro.velhobarreiro.service.MetricaService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MetricaController {

    @Resource
    private MetricaService metricaService;

	@RequestMapping(value = "/metrica", method = RequestMethod.POST)
    public List<Metrica> incluirMetrica(@RequestBody List<Metrica> metricas) {
    	System.out.println(metricas);


        return metricas;// metricaService.salvarMetrica(nome);
    }
}