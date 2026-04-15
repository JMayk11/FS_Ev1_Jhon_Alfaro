package com.Alfaro.Jhon.service;
import com.Alfaro.Jhon.model.Evento;
import com.Alfaro.Jhon.model.EventoDTO;
import com.Alfaro.Jhon.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;
    public List<Evento> readAll() { return repository.readAll(); }
    public Evento create(Evento e) { return repository.create(e); }
    public void delete(Long id) { repository.delete(id); }
    public List<EventoDTO> reporte() { return repository.generarReporte(); }
    public void seed() { repository.seed(); }
}