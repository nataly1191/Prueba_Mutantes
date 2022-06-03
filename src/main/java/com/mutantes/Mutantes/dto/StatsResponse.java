package com.mutantes.Mutantes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsResponse {
    
    private long conteoMuntantes;

    private long conteoHumanos;

    private double ratio;
}
