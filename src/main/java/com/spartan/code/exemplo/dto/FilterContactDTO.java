package com.spartan.code.exemplo.dto;

import com.spartan.code.exemplo.domain.ContactType;

import lombok.Data;

@Data
public class FilterContactDTO {

    private ContactType type;

}
