package com.delogic.ticket.dto;

import com.delogic.ticket.entity.Address;
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

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Address address;
    private PreferedFlags preferedFlags;
}
