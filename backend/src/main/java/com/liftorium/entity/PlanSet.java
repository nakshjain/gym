package com.liftorium.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A planned set within a {@link PlanExercise}.
 *
 * <p>Which field is populated depends on the parent exercise's {@link TrackingType}:
 * <ul>
 *   <li>WEIGHT_REPS / REPS_ONLY — {@code reps} is used</li>
 *   <li>DURATION / CARDIO       — {@code durationSeconds} is used</li>
 * </ul>
 *
 * <p>Both fields default to null so absent values are stored as MongoDB {@code null}
 * rather than 0, keeping queries unambiguous.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanSet {

  /** Number of planned reps. Used for WEIGHT_REPS and REPS_ONLY. */
  private Integer reps;

  /** Planned duration in seconds. Used for DURATION and CARDIO. */
  private Integer durationSeconds;
}
