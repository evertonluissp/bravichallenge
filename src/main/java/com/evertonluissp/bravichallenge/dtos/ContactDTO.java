package com.evertonluissp.bravichallenge.dtos;

import com.evertonluissp.bravichallenge.entities.Contact;
import com.evertonluissp.bravichallenge.enums.ContactType;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.evertonluissp.bravichallenge.utils.StringUtils.removeAllSignals;

public class ContactDTO {

    @NotBlank
    public String value;
    @NotNull
    public ContactType type;

    public Contact toContact() {
        var thiz = this;
        return new Contact() {{
            value = thiz.value;
            type = thiz.type;
        }};
    }

    @AssertTrue
    public boolean isValid() {
        switch (type) {
            case PHONE:
                value = removeAllSignals(value);
                return value.matches("\\d{10}");
            case EMAIL:
                return value.matches("^(.+)@(.+)$");
            case WHATSAPP:
                value = removeAllSignals(value);
                return value.matches("\\d{11}");
            default:
                return false;
        }
    }

}
