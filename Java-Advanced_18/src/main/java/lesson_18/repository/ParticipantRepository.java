package lesson_18.repository;

import lesson_18.entity.Participant;

import java.util.List;


public interface ParticipantRepository {
    List<Participant> findAll();

    Participant get(int id);

    void save(Participant participant);

    void delete(int id);
}
