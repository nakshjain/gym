package com.liftorium.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanExercise {

  private String exerciseId;

  private String exerciseName;

  @Builder.Default
  private List<PlanSet> sets = new ArrayList<>();

  private int order;

  /**
   * How sets are tracked for this exercise (WEIGHT_REPS, REPS_ONLY, DURATION, CARDIO).
   * Defaults to WEIGHT_REPS to keep existing plan documents working without migration.
   */
  @Builder.Default
  private TrackingType trackingType = TrackingType.WEIGHT_REPS;
}
