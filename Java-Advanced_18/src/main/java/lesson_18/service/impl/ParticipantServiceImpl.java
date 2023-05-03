package lesson_18.service.impl;

import lesson_18.repository.ParticipantRepository;
import lesson_18.entity.Participant;
import org.springframework.stereotype.Service;
import lesson_18.service.ParticipantService;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    public ParticipantServiceImpl(ParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Participant> findAll() {
        return repository.findAll();
    }

    @Override
    public Participant get(int id) {
        return repository.get(id);
    }

    @Override
    public void save(Participant participant) {
        repository.save(participant);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
