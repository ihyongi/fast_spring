package com.fastcampus.jpa.bookmanager.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
            //여기서 현재시간을 추가해준다
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        if (o instanceof Auditable) {
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
