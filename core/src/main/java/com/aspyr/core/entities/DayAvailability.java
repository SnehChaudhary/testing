package com.aspyr.core.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "day_availability")
@Data
public class DayAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Day day;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<AvailableTimeSlots> availableTimeSlots = new ArrayList<AvailableTimeSlots>();
}
