package test.prog.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
public class ProfileRequest {

    @NotNull(message="Имя дожно быть задано")
    @Size(min=2, max=30)
    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,10}$)|(^[А-Я]{1}[а-я]{1,10}$)",
            message = "Поле имя заполненно неверно")
    private String firstName;

    @NotNull(message="Фамилия должна быть задана")
    @Size(min=2, max=30)
    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,10}$)|(^[А-Я]{1}[а-я]{1,10}$)",
            message = "Поле фамилия заполненно неверно")
    private String lastName;

    @NotNull(message="Адрес должен быть задан")
    @Size(min=2, max=50)
    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,10} [0-9]{1}[a-z0-9]{1,5}$)|(^[А-Я]{1}[а-я]{1,10} [0-9]{1}[a-z0-9]{1,5}$)",
            message = "Поле адрес заполненно неверно")
    private String address;

    @NotNull(message="Возраст должен быть задан")
    @Min(0)
    private Integer age;

    @NotNull(message="Имэйл должен быть задан")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"@"
            +"[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"\\.[a-zA-Z]{2,}$",
            message = "заданный имэйл не может существовать")
    private String email;


    @NotNull(message="Страна должена быть задана")
    @Pattern(regexp = "(^[A-Z]{1}[a-z]{1,10}$)|(^[А-Я]{1}[а-я]{1,10}$)",
            message = "Поле страна заполненно неверно")
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}