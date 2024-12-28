package com.delogic.ticket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferedFlags {

    private Boolean sports;
    private Boolean theatre;
    private Boolean concerts;
    private Boolean jazz;
    private Boolean classical;
    private Boolean opera;
    private Boolean rock;
    private Boolean vegas;
    private Boolean broadway;
    private Boolean musicals;
}
