package opensource.shop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;

    private String name; //상품 이름
    private int price; //상품 가격
    private int stockQuantity; //상품 수량

    private String author; //저자
    private String isbn;
}
