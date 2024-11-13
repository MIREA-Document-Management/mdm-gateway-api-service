package ru.mdm.gateway.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    ;

    private final String text;

    public String buildErrorText(Object... params) {
        return String.format(this.getText(), params);
    }
}
