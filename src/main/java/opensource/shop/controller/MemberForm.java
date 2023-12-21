package opensource.shop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수입니다!")
    private String name; //이름

    private String city; //도시
    private String street; //번지수
    private String zipcode; //우편번호
}
