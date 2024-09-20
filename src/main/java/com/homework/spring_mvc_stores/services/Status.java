package com.homework.spring_mvc_stores.services;

// На будущее, для реализации предупреждений при неправильно заполненных полях формы.
public enum Status {

    ALREADY_EXIST,
    PHONE_NUMBER_ALREADY_EXIST,
    EMPTY_FIELDS,
    SQL_EXCEPTION,
    SUCCESS

}
