package com.ezjedev.stepitup.models;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "activity_logs")
public class ActivityLog {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ActivityLogStatus status;
	
	private LocalDateTime startedAt;
	private LocalDateTime completedAt;
	private LocalDateTime expectedCompletionAt;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "session_id")	
	private Session session;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "activity_id")
	private Activity activity; 
}
