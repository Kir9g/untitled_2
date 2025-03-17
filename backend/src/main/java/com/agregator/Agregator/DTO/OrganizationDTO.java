package com.agregator.Agregator.DTO;

import lombok.Getter;
import lombok.Setter;


public class OrganizationDTO {
    private String organizationFullName;
    private String organizationShortName;
    private String inn;
    private String kpp;
    private String ogrn;
    private String responsiblePersonSurname;
    private String responsiblePersonName;
    private String responsiblePersonPatronymic;
    private String responsiblePersonEmail;
    private String responsiblePersonPhoneNumber;
    private String addInfo;

    public String getOrganizationFullName() {
        return organizationFullName;
    }

    public void setOrganizationFullName(String organizationFullName) {
        this.organizationFullName = organizationFullName;
    }

    public String getOrganizationShortName() {
        return organizationShortName;
    }

    public void setOrganizationShortName(String organizationShortName) {
        this.organizationShortName = organizationShortName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getResponsiblePersonSurname() {
        return responsiblePersonSurname;
    }

    public void setResponsiblePersonSurname(String responsiblePersonSurname) {
        this.responsiblePersonSurname = responsiblePersonSurname;
    }

    public String getResponsiblePersonName() {
        return responsiblePersonName;
    }

    public void setResponsiblePersonName(String responsiblePersonName) {
        this.responsiblePersonName = responsiblePersonName;
    }

    public String getResponsiblePersonPatronymic() {
        return responsiblePersonPatronymic;
    }

    public void setResponsiblePersonPatronymic(String responsiblePersonPatronymic) {
        this.responsiblePersonPatronymic = responsiblePersonPatronymic;
    }

    public String getResponsiblePersonEmail() {
        return responsiblePersonEmail;
    }

    public void setResponsiblePersonEmail(String responsiblePersonEmail) {
        this.responsiblePersonEmail = responsiblePersonEmail;
    }

    public String getResponsiblePersonPhoneNumber() {
        return responsiblePersonPhoneNumber;
    }

    public void setResponsiblePersonPhoneNumber(String responsiblePersonPhoneNumber) {
        this.responsiblePersonPhoneNumber = responsiblePersonPhoneNumber;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}

