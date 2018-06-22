package com.tasima.velhobarreiro.velhobarreiro.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import com.tasima.velhobarreiro.velhobarreiro.model.Metrica;
import com.tasima.velhobarreiro.velhobarreiro.service.MetricaService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricaController {

    @Resource
    private MetricaService metricaService;

    @RequestMapping("/metrica")
    public Metrica incluirMetrica(@RequestParam(value="nome") String nome) {
        return metricaService.salvarMetrica(nome);
    }
}