package org.jsp.ems.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jsp.ems.util.EventStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  private String organiser;
  private String cheifguest;
  private LocalDateTime fromDateTime;
  private LocalDateTime toDateTime;
  @Enumerated(EnumType.STRING)
  private EventStatus status;
}
