/*
 * conveyor
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.0.1-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import org.threeten.bp.LocalDate;

/**
 * ������ ������
 */
@ApiModel(description = "������ ������")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-03T20:08:34.729728400+03:00[Europe/Moscow]")
public class LoanApplicationRequestDTO {
  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private BigDecimal amount;

  public static final String SERIALIZED_NAME_TERM = "term";
  @SerializedName(SERIALIZED_NAME_TERM)
  private Integer term;

  public static final String SERIALIZED_NAME_FIRST_NAME = "firstName";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_LAST_NAME = "lastName";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_MIDDLE_NAME = "middleName";
  @SerializedName(SERIALIZED_NAME_MIDDLE_NAME)
  private String middleName;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_BIRTHDATE = "birthdate";
  @SerializedName(SERIALIZED_NAME_BIRTHDATE)
  private LocalDate birthdate;

  public static final String SERIALIZED_NAME_PASSPORT_SERIES = "passportSeries";
  @SerializedName(SERIALIZED_NAME_PASSPORT_SERIES)
  private String passportSeries;

  public static final String SERIALIZED_NAME_PASSPORT_NUMBER = "passportNumber";
  @SerializedName(SERIALIZED_NAME_PASSPORT_NUMBER)
  private String passportNumber;


  public LoanApplicationRequestDTO amount(BigDecimal amount) {
    
    this.amount = amount;
    return this;
  }

   /**
   * Zaprashivaemaya summa
   * minimum: 10000
   * @return amount
  **/
  @ApiModelProperty(example = "1000000", required = true, value = "Zaprashivaemaya summa")

  public BigDecimal getAmount() {
    return amount;
  }


  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  public LoanApplicationRequestDTO term(Integer term) {
    
    this.term = term;
    return this;
  }

   /**
   * ���� ������� � �������
   * minimum: 6
   * @return term
  **/
  @ApiModelProperty(example = "12", required = true, value = "���� ������� � �������")

  public Integer getTerm() {
    return term;
  }


  public void setTerm(Integer term) {
    this.term = term;
  }


  public LoanApplicationRequestDTO firstName(String firstName) {
    
    this.firstName = firstName;
    return this;
  }

   /**
   * ���
   * @return firstName
  **/
  @ApiModelProperty(example = "����", required = true, value = "���")

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public LoanApplicationRequestDTO lastName(String lastName) {
    
    this.lastName = lastName;
    return this;
  }

   /**
   * �������
   * @return lastName
  **/
  @ApiModelProperty(example = "������", required = true, value = "�������")

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public LoanApplicationRequestDTO middleName(String middleName) {
    
    this.middleName = middleName;
    return this;
  }

   /**
   * ��������
   * @return middleName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "��������", value = "��������")

  public String getMiddleName() {
    return middleName;
  }


  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }


  public LoanApplicationRequestDTO email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * ����������� �����
   * @return email
  **/
  @ApiModelProperty(example = "test@mail.ru", required = true, value = "����������� �����")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public LoanApplicationRequestDTO birthdate(LocalDate birthdate) {
    
    this.birthdate = birthdate;
    return this;
  }

   /**
   * ���� ��������
   * @return birthdate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Sun Dec 31 03:00:00 MSK 2000", value = "���� ��������")

  public LocalDate getBirthdate() {
    return birthdate;
  }


  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }


  public LoanApplicationRequestDTO passportSeries(String passportSeries) {
    
    this.passportSeries = passportSeries;
    return this;
  }

   /**
   * ����� ��������
   * @return passportSeries
  **/
  @ApiModelProperty(example = "1234", required = true, value = "����� ��������")

  public String getPassportSeries() {
    return passportSeries;
  }


  public void setPassportSeries(String passportSeries) {
    this.passportSeries = passportSeries;
  }


  public LoanApplicationRequestDTO passportNumber(String passportNumber) {
    
    this.passportNumber = passportNumber;
    return this;
  }

   /**
   * ����� ��������
   * @return passportNumber
  **/
  @ApiModelProperty(example = "123456", required = true, value = "����� ��������")

  public String getPassportNumber() {
    return passportNumber;
  }


  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoanApplicationRequestDTO loanApplicationRequestDTO = (LoanApplicationRequestDTO) o;
    return Objects.equals(this.amount, loanApplicationRequestDTO.amount) &&
        Objects.equals(this.term, loanApplicationRequestDTO.term) &&
        Objects.equals(this.firstName, loanApplicationRequestDTO.firstName) &&
        Objects.equals(this.lastName, loanApplicationRequestDTO.lastName) &&
        Objects.equals(this.middleName, loanApplicationRequestDTO.middleName) &&
        Objects.equals(this.email, loanApplicationRequestDTO.email) &&
        Objects.equals(this.birthdate, loanApplicationRequestDTO.birthdate) &&
        Objects.equals(this.passportSeries, loanApplicationRequestDTO.passportSeries) &&
        Objects.equals(this.passportNumber, loanApplicationRequestDTO.passportNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, term, firstName, lastName, middleName, email, birthdate, passportSeries, passportNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoanApplicationRequestDTO {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    passportSeries: ").append(toIndentedString(passportSeries)).append("\n");
    sb.append("    passportNumber: ").append(toIndentedString(passportNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

