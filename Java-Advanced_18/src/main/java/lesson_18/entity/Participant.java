package lesson_18.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Participant {
    private Integer id;
    private String name;
    private String email;
    private Level level;
    private String primarySkill;
}

