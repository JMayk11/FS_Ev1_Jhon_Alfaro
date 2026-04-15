package com.Alfaro.Jhon.repository;
import com.Alfaro.Jhon.model.Evento;
import com.Alfaro.Jhon.model.EventoDTO;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
@Repository
public class EventoRepository {
    private List<Evento> eventos = new ArrayList<>();
    private Long currentId = 1L;
    public List<Evento> readAll() {
        return eventos;
    }
    public Evento create(Evento evento) {
        evento.setId(currentId++);
        eventos.add(evento);
        return evento;
    }
    public void delete(Long id) {
        eventos.removeIf(e -> e.getId().equals(id));
    }
    public List<EventoDTO> generarReporte() {
        List<EventoDTO> reporte = new ArrayList<>();
        for (Evento e : eventos) {
            reporte.add(new EventoDTO(e.getNombre(), e.getUbicacion()));
        }
        return reporte;
    }
    public void seed() {
        eventos.add(new Evento(currentId++, "Concierto Rock", "Musica", LocalDate.now(), "Estadio", 500));
        eventos.add(new Evento(currentId++, "Feria Libro", "Cultura", LocalDate.now().plusDays(5), "Plaza", 200));
    }
}