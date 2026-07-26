package com.liftorium.dto;

import com.liftorium.entity.TrackingType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public final class PlanDtos {

  private PlanDtos() {}

  /**
   * A planned set. Which field is populated depends on the exercise's TrackingType:
   * <ul>
   *   <li>WEIGHT_REPS / REPS_ONLY — {@code reps}</li>
   *   <li>DURATION / CARDIO       — {@code durationSeconds}</li>
   * </ul>
   */
  public record PlanSetRequest(
      @Min(1) @Max(100) Integer reps,
      @Min(1) @Max(86400) Integer durationSeconds
  ) {}

  public record PlanExerciseRequest(
      @NotNull @Size(max = 50) String exerciseId,
      @NotNull @Size(max = 120) String exerciseName,
      @NotNull @Size(min = 1, max = 20) @Valid List<PlanSetRequest> sets,
      @Min(0) @Max(50) int order,
      TrackingType trackingType
  ) {}

  public record PlanDayRequest(
      @Min(0) @Max(6) int dayOfWeek,
      @Size(max = 60) String label,
      @NotNull @Size(max = 10) List<@Size(max = 30) String> muscleGroups,
      @NotNull @Size(max = 20) @Valid List<PlanExerciseRequest> exercises,
      boolean rest
  ) {}

  public record UpsertPlanRequest(
      @NotNull @Size(min = 7, max = 7) @Valid List<PlanDayRequest> days,
      String templateId
  ) {}

  public record PlanSetDto(
      Integer reps,
      Integer durationSeconds
  ) {}

  public record PlanExerciseDto(
      String exerciseId,
      String exerciseName,
      List<PlanSetDto> sets,
      int order,
      TrackingType trackingType
  ) {}

  public record PlanDayDto(
      int dayOfWeek,
      String label,
      List<String> muscleGroups,
      List<PlanExerciseDto> exercises,
      boolean rest
  ) {}

  public record WorkoutPlanDto(
      String id,
      String templateId,
      List<PlanDayDto> days,
      String updatedAt
  ) {}

  public record TemplateDto(
      String id,
      String name,
      String shortName,
      String description,
      List<PlanDayDto> days
  ) {}
}
