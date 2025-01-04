package com.delogic.ticket.dto;

import com.delogic.ticket.entity.PreferedFlags;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    Long id;
    String username;
    String firstName;
    String lastName;
    PreferedFlags preferedFlags;
}
