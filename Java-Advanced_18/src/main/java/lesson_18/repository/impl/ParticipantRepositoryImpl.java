package lesson_18.repository.impl;

import lesson_18.repository.ParticipantRepository;
import lesson_18.entity.Level;
import lesson_18.entity.Participant;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ParticipantRepositoryImpl implements ParticipantRepository {
    private final List<Participant> participants = new ArrayList<>();

    @PostConstruct
    public void init() {
        Participant p1 = new Participant(1, "Mark", "mark@mail.com",
                Level.L1, "Engineer");

        Participant p2 = new Participant(2, "Andrew", "andrew@mail.com",
                Level.L2, "Officer");

        Participant p3 = new Participant(3, "Kate", "kate@mail.com",
                Level.L3, "Intern");

        participants.add(p1);
        participants.add(p2);
        participants.add(p3);
    }

    @Override
    public List<Participant> findAll() {
        return participants;
    }

    @Override
    public Participant get(int id) {
        return participants.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Participant participant) {
        //update
        Participant participantToUpdate;

        if (participant.getId() != null) {
            participantToUpdate = get(participant.getId());
            int participantIndex = participants.indexOf(participantToUpdate);

            participantToUpdate.setName(participant.getName());
            participantToUpdate.setEmail(participant.getEmail());
            participantToUpdate.setLevel(participant.getLevel());
            participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
            participants.set(participantIndex, participantToUpdate);
        } else {
            // create
            participant.setId(participants.size() + 1);
            participants.add(participant);
        }
    }

    @Override
    public void delete(int id) {
        participants.removeIf(participant -> participant.getId() == id);
    }
}
